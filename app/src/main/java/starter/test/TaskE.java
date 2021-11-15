package starter.test;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import starter.dga.Task;

public class TaskE extends Task {

    @Override
    public void run() {
        Log.d(Tag.TAG, "run e");
    }

    @Override
    protected List<Class<? extends Task>> dependencies() {
        return Arrays.asList(MainTaskB.class, TaskD.class);
    }

    @Override
    public String getTaskName() {
        return "TaskE";
    }
}
