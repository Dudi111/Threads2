package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mbtn1;
    private Button mbtn2;
    private WorkerThread workerThread;
    private static final String TAG=MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtn1=findViewById(R.id.btn1);
        mbtn2=findViewById(R.id.btn2);
        workerThread=new WorkerThread();
        workerThread.start();
        mbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addtasktoqueue(taskone);
            }
        });
        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    workerThread.addtasktoqueue(tasktwo);
            }
        });
    }


    private Runnable taskone=new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "taskone"+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable tasktwo=new Runnable() {
        @Override
        public void run() {
            Log.d(TAG, "tasktwo"+Thread.currentThread().getName());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}