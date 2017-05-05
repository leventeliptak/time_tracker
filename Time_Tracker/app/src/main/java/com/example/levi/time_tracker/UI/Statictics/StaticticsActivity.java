package com.example.levi.time_tracker.ui.statictics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import java.sql.Date;
import java.util.ArrayList;

import com.example.levi.time_tracker.R;
import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.ui.main.MainActivity;
import com.example.levi.time_tracker.ui.processcreator.ProcessCreatorActivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


/**
 * Created by Levi on 2017.04.07..
 */

public class StaticticsActivity extends AppCompatActivity implements StaticticsScreen{

    @Inject
    StaticticsPresenter staticticsPresenter;

    EditText datePicker;

    boolean dateset=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statictics);
        TimeTrackerApplication.injector.inject(this);

        Button leftB = (Button) findViewById(R.id.statictics_left_button);
        leftB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                staticticsPresenter.changeToProcessCreator();
            }
        });

        Button rightB = (Button) findViewById(R.id.statictics_right_button);
        rightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                staticticsPresenter.changeToMain();
            }
        });

        datePicker = (EditText) findViewById(R.id.statictics_datepicker);
        datePicker.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    staticticsPresenter.setDate(Date.valueOf(datePicker.getText().toString()));
                    staticticsPresenter.getStatictics();
                    return true;
                }
                dateset=true;
                return false;
            }
        });

        datePicker.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //no need
            }

            public void onTextChanged(CharSequence c, int start, int before, int count) {
                try {
                    staticticsPresenter.setDate(Date.valueOf(datePicker.getText().toString()));
                    staticticsPresenter.getStatictics();
                }catch(Exception e){}
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        staticticsPresenter.attachScreen(this);
        if(!dateset) {
            CharSequence text = "Set date!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
        }else{
            staticticsPresenter.getStatictics();
            }
    }

    @Override
    protected void onStop() {
        super.onStop();
        staticticsPresenter.detachScreen();
    }

    @Override
    public void startMain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void startProcessCreator()
    {
        Intent intent = new Intent(this, ProcessCreatorActivity.class);
        startActivity(intent);
    }

    @Override
    public void refreshData(ArrayList<String> processes, ArrayList<Integer> SumHours) {
        TextView tw;
        if(processes.size()<1) return;
        tw = (TextView) findViewById(R.id.statictics_left_1);
        tw.setText(processes.get(0));
        tw = (TextView) findViewById(R.id.statictics_right_1);
        tw.setText(SumHours.get(0));
        if(processes.size()<2) return;
        tw = (TextView) findViewById(R.id.statictics_left_2);
        tw.setText(processes.get(1));
        tw = (TextView) findViewById(R.id.statictics_right_2);
        tw.setText(SumHours.get(2));
        if(processes.size()<3) return;
        tw = (TextView) findViewById(R.id.statictics_left_3);
        tw.setText(processes.get(2));
        tw = (TextView) findViewById(R.id.statictics_right_3);
        tw.setText(SumHours.get(3));
    }
}
