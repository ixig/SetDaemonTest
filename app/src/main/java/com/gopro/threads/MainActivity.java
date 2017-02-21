package com.gopro.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import junit.framework.Assert;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "~MainAct";
    private Thread t1;
    //private Singleton s = Singleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = new Thread(new Runnable() {
            private static final String TAG = "~T1";

            @Override
            public void run() {
                int i = 0;
                try {
                    while (true) {
                        Log.i(TAG, "" + i++);
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    Log.i(TAG, "run(): INTERRUPTED!!");
                    Log.i(TAG, "run(): " + Thread.interrupted() + Thread.interrupted());
                    return;
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy(): ");
        //t1.interrupt();     // with this commented out, t1 thread continues to live!
    }
}
