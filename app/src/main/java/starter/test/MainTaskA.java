package starter.test;

import android.util.Log;

import java.util.List;

import starter.dga.Task;

public class MainTaskA extends Task {

    @Override
    public void run() {
        Log.d(Tag.TAG, "run a");
    }

    @Override
    protected List<Class<? extends Task>> dependencies() {
        return null;
    }

    @Override
    public String getTaskName() {
        return "TaskA";
    }

    @Override
    public boolean isWaitOnMainThread() {
        return true;
    }
}
