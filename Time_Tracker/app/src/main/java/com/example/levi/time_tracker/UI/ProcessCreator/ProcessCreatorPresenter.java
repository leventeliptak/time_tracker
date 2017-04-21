package com.example.levi.time_tracker.ui.processcreator;

import com.example.levi.time_tracker.interactor.ProcessCreatorInteractor;
import com.example.levi.time_tracker.interactor.events.DeleteProcessEvent;
import com.example.levi.time_tracker.interactor.events.SaveProcessEvent;
import com.example.levi.time_tracker.ui.Presenter;
import com.example.levi.time_tracker.model.Process;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

/**
 * Created by Levi on 2017.04.07..
 */

public class ProcessCreatorPresenter extends Presenter<ProcessCreatorScreen> {


    @Inject
    ProcessCreatorInteractor processCreatorInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    Process edited;

    public ProcessCreatorPresenter() {
    }

    @Override
    public void attachScreen(ProcessCreatorScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }


    public void EditOrCreateProcess(Process process)
    {
        if (process == null){
            edited = new Process("");
        }else{
            edited= process;
        }
    }
     public Process GetEdited()
    {
        return edited;
    }
    public void OnRedValueChanged(int value) {
        edited.setColor(edited.getColor() | 256*256*value);
    }

    public void OnGreenValueChanged(int value) {
        edited.setColor(edited.getColor() | 256*value);
    }

    public void OnBlueValueChanged(int value) {
        edited.setColor(edited.getColor() | value);
    }

    public int GetOnRedValue() {
        return edited.getColor() & 255*256*256;
    }

    public int GetGreenValue() {
        return edited.getColor()& 255*256*256;
    }

    public int GetBlueValue() {
        return edited.getColor()& 256;
    }

    public void OnNameChanged(String name) {
        edited.setName(name);
    }

    public void SaveProcess() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                processCreatorInteractor.SaveProcess(edited);
            }
        });
    }

    public void DeleteProcess() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                processCreatorInteractor.DeleteProcess(edited);
            }
        });
    }

    public void onEventMainThread(SaveProcessEvent event) {

    }

    public void onEventMainThread(DeleteProcessEvent event) {

    }
}
