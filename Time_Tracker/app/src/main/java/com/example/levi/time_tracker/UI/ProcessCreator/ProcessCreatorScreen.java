package com.example.levi.time_tracker.ui.processcreator;

import android.graphics.Color;
import com.example.levi.time_tracker.model.Process;
/**
 * Created by Levi on 2017.04.07..
 */

public interface ProcessCreatorScreen {
    void ShowProcess(Process process);
    void RefreshColor(Color color);
}
