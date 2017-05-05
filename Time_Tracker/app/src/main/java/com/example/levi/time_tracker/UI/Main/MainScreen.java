package com.example.levi.time_tracker.ui.main;

import com.example.levi.time_tracker.model.Process;

import java.util.List;

/**
 * Created by Levi on 2017.04.07..
 */

public interface MainScreen {

    void SetProcess(String id);

    void UnsetProcess(String id);

    void startProcessCreator(String processName);

    void startStatictics();

    public void refreshGridview(List<Process> processes,String measured);
}
