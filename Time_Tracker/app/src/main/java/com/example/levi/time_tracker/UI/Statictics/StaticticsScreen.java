package com.example.levi.time_tracker.UI.Statictics;

import com.example.levi.time_tracker.Model.Process;
import java.util.ArrayList;

/**
 * Created by Levi on 2017.04.07..
 */

public interface StaticticsScreen {

    void refreshData(ArrayList<Process> processes, ArrayList<Integer> SumHours);
}
