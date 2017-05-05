package com.example.levi.time_tracker.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import javax.inject.Inject;
import com.example.levi.time_tracker.R;
import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.ui.processcreator.ProcessCreatorActivity;
import com.example.levi.time_tracker.ui.statictics.StaticticsActivity;
import com.example.levi.time_tracker.utils.CustomGridViewAdapter;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import io.fabric.sdk.android.Fabric;
import com.crashlytics.android.Crashlytics;
import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static com.example.levi.time_tracker.R.layout.row_grid;

public class MainActivity extends AppCompatActivity implements MainScreen{

    @Inject
    MainPresenter mainPresenter;
    GridView gridView;

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        TimeTrackerApplication.injector.inject(this);

        Button leftB = (Button) findViewById(R.id.main_left_button);
        leftB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mainPresenter.changeToProcessCreator(null);
            }
        });

        Button rightB = (Button) findViewById(R.id.main_right_button);
        rightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.changeToStatictics();
            }
        });

        gridView = (GridView) findViewById(R.id.gridView1);

        TimeTrackerApplication application = (TimeTrackerApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
        mainPresenter.GetProcesses();
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());

    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void SetProcess(String id) {
        //TODO: implement
    }

    @Override
    public void UnsetProcess(String id) {
        //TODO: implement
    }

    @Override
    public void startProcessCreator(String processname)
    {
        Intent intent = new Intent(this, ProcessCreatorActivity.class);
       if(processname != null) {
           intent.putExtra("process_name", processname);
       }
        startActivity(intent);
    }

    @Override
    public void startStatictics()
    {
        Intent intent = new Intent(this, StaticticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void refreshGridview(List<Process> processes, String measured)
    {
       ArrayList<String> tmp = new ArrayList<String>();
        for(Process p : processes) {
            if(p.getName().equals(measured)) {
              tmp.add(p.getName().toUpperCase());
            }  else {
              tmp.add(p.getName());
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tmp);

        gridView.setAdapter(adapter);
      //   gridView.setBackgroundColor(processes.get(0).getColor());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                TextView tv=(TextView) v;
                mainPresenter.ChangeToProcess(tv.getText().toString());
            }

        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {
              //  Toast.makeText(getApplicationContext(), ((TextView) v).getText()+"_long", Toast.LENGTH_SHORT).show();
                TextView tv=(TextView) v;
                mainPresenter.changeToProcessCreator(tv.getText().toString());
                return true;
            }
        });
  }

}
