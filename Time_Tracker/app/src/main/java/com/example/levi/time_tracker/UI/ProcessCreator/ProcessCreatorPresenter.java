package com.example.levi.time_tracker.ui.processcreator;

import com.example.levi.time_tracker.TimeTrackerApplication;
import com.example.levi.time_tracker.interactor.ProcessCreatorInteractor;
import com.example.levi.time_tracker.interactor.events.DeleteProcessEvent;
import com.example.levi.time_tracker.interactor.events.GetProcessEvent;
import com.example.levi.time_tracker.interactor.events.SaveProcessEvent;
import com.example.levi.time_tracker.ui.Presenter;
import com.example.levi.time_tracker.model.Process;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;

import static com.example.levi.time_tracker.TimeTrackerApplication.injector;

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

    String searched;
    @Override


    public void attachScreen(ProcessCreatorScreen screen) {

        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }


    public void EditOrCreateProcess( String process)
    {
        if (process == null){
            edited = new Process("");
        }else{
            searched =process;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    processCreatorInteractor.GetProcess(searched);
                }
            });
            screen.RefreshName(process);
        }
    }

    public Process GetEdited()
    {
        return edited;
    }

    public void SetName(String name){
        edited.setName(name);
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
        changeToMain();
    }

    public void DeleteProcess() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                processCreatorInteractor.DeleteProcess(edited);
            }
        });
        changeToMain();
    }

    public void onEventMainThread(SaveProcessEvent event) {

    }

    public void onEventMainThread(DeleteProcessEvent event) {

    }
    public void onEventMainThread(GetProcessEvent event)
    {
        edited = event.getProcess();
    }

    public void changeToMain(){
        screen.startMain();
    }

}
