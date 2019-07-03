package com.bytedance.clockapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bytedance.clockapplication.widget.Clock;

public class MainActivity extends AppCompatActivity {

    private View mRootView;
    private Clock mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootView = findViewById(R.id.root);
        mClockView = findViewById(R.id.clock);

        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClockView.setShowAnalog(!mClockView.isShowAnalog());
            }
        });

        /*final Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mClockView.postInvalidate();
            }
        },1000);*/
        final Handler mHandler = new Handler();

        Runnable updateTime =new Runnable() {
            @Override
            public void run() {
                mClockView.postInvalidate();
                mHandler.postDelayed(this,1000);
            }
        };
        mHandler.post(updateTime);
    }
}
