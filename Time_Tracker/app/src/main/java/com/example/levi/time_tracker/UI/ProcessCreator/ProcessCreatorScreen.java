package com.example.levi.time_tracker.UI.ProcessCreator;

import android.graphics.Color;
import com.example.levi.time_tracker.Model.Process;
/**
 * Created by Levi on 2017.04.07..
 */

public interface ProcessCreatorScreen {
    void ShowProcess(Process process);
    void RefreshColor(Color color);
}
