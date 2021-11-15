package starter.test;



import android.os.Process;
import android.util.Log;

import androidx.core.os.TraceCompat;

import starter.dga.Task;
import starter.dga.TaskListener;

public class MonitorTaskListener implements TaskListener {

    private String tag;
    private boolean isLog;

    public MonitorTaskListener(String tag, boolean isLog) {
        this.tag = tag;
        this.isLog = isLog;
    }

    @Override
    public void onWaitRunning(Task task) {
    }

    @Override
    public void onStart(Task task) {
        if (isLog) {
            Log.d(tag + "-START", "task start :" + task.getTaskName());
        }
        TraceCompat.beginSection(task.getTaskName());
        if (task.isWaitOnMainThread()) {
            Process.setThreadPriority(Process.THREAD_PRIORITY_URGENT_AUDIO);
        }
    }

    @Override
    public void onFinish(Task task, long dw, long df) {
        if (task.isWaitOnMainThread()) {
            Process.setThreadPriority(ThreadManager.DEFAULT_PRIORITY);
        }
        TraceCompat.endSection();
        if (isLog) {
            Log.d(tag + "-END", "task end :" + task.getTaskName() + " wait " + dw + " cost " + df);
        }
    }

}
