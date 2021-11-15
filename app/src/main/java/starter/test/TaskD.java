package starter.test;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import starter.dga.Task;

public class TaskD extends Task {

    @Override
    public void run() {
        Log.d(Tag.TAG, "run d");
    }

    @Override
    protected List<Class<? extends Task>> dependencies() {
        return Arrays.asList(MainTaskC.class);
    }

    @Override
    public String getTaskName() {
        return "TaskD";
    }
}
