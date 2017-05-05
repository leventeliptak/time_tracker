package com.example.levi.time_tracker.ui.processcreator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import javax.inject.Inject;

import com.example.levi.time_tracker.R;
import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.model.Process;
import com.example.levi.time_tracker.ui.statictics.StaticticsActivity;
import com.example.levi.time_tracker.ui.main.MainActivity;
/**
 * Created by Levi on 2017.04.07..
 */

public class ProcessCreatorActivity extends AppCompatActivity implements ProcessCreatorScreen {

    @Inject
    ProcessCreatorPresenter processCreatorPresenter;

    EditText edittext;

    String nameToSet=null;
    Boolean nameset =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processcreator);
        TimeTrackerApplication.injector.inject(this);

        Button leftB = (Button) findViewById(R.id.processcreator_left_button);
        leftB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processCreatorPresenter.changeToMain();
            }
        });

        Button rightB = (Button) findViewById(R.id.processcreator_right_button);
        rightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processCreatorPresenter.DeleteProcess();
            }
        });

        edittext = (EditText) findViewById(R.id.processcreator_name_edittext);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    processCreatorPresenter.SetName(edittext.getText().toString());
                    return true;
                }
                return false;
            }
        });

        Button saveB = (Button) findViewById(R.id.processcreator_save_button);
        saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processCreatorPresenter.SaveProcess();
            }
        });

        nameToSet = getIntent().getStringExtra("process_name");
    }

    @Override
    protected void onStart() {
        super.onStart();
        processCreatorPresenter.attachScreen(this);
        if(!nameset){
         processCreatorPresenter.EditOrCreateProcess(nameToSet);
            nameset=true;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        processCreatorPresenter.detachScreen();
    }

    @Override
    public void RefreshName(String name) {
        edittext.setText(name);
    }


    @Override
    public void RefreshColor(Color color) {
    }

    @Override
    public void startStatictics()
    {
        Intent intent = new Intent(this, StaticticsActivity.class);
        startActivity(intent);
    }

    @Override
    public void startMain()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
