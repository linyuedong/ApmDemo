package com.sf.apmdemo;

import android.app.Application;

import com.sf.apmdemo.BuildConfig;

import starter.dga.Config;
import starter.dga.DGAppStartup;
import starter.dga.OnProjectListener;
import starter.test.MainTaskA;
import starter.test.MainTaskB;
import starter.test.MainTaskC;
import starter.test.MonitorTaskListener;
import starter.test.Tag;
import starter.test.TaskD;
import starter.test.TaskE;
import starter.test.ThreadManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Config config = new Config();
        config.isStrictMode = BuildConfig.DEBUG;
        new DGAppStartup.Builder()
                .add(new MainTaskA())
                .add(new MainTaskB())
                .add(new MainTaskC())
                .add(new TaskD())
                .add(new TaskE())
                .setConfig(config)
                .addTaskListener(new MonitorTaskListener(Tag.TAG, true))
                .setExecutorService(ThreadManager.getInstance().WORK_EXECUTOR)
                .addOnProjectExecuteListener(new OnProjectListener() {
                    @Override
                    public void onProjectStart() {

                    }

                    @Override
                    public void onProjectFinish() {

                    }

                    @Override
                    public void onStageFinish() {

                    }
                })
                .create()
                .start()
                .await();
    }
}
