package com.example.levi.time_tracker.ui.statictics;

import com.example.levi.time_tracker.model.Process;
import java.util.ArrayList;

/**
 * Created by Levi on 2017.04.07..
 */

public interface StaticticsScreen {

    void refreshData(ArrayList<Process> processes, ArrayList<Integer> SumHours);
}
