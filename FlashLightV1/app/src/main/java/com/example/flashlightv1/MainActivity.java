package com.example.flashlightv1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import static java.lang.Thread.*;
import android.content.Intent;

import android.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {

    public RelativeLayout Rl;

    private boolean on = false;
    private boolean noFlash = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rl = (RelativeLayout) findViewById(R.id.RelativeLayout);
    }

    public void onClick1(View v) {
        switch (v.getId()) {
            case R.id.button1:
                Rl.setBackgroundColor(Color.BLUE);
                break;
            case R.id.button2:
                Rl.setBackgroundColor(Color.RED);
                break;
            case R.id.button3:
                Rl.setBackgroundColor(Color.WHITE);
                break;
            case R.id.button4:
                Rl.setBackgroundColor(Color.GRAY);
                break;
            case R.id.button5:
                Rl.setBackgroundColor(Color.YELLOW);
                break;
        }
    }

    public void onClick2(View v) {

        long mSec = 1000;
        Rl.setBackgroundColor(Color.BLUE);
        Delay(mSec);
        Rl.setBackgroundColor(Color.RED);
        Delay(mSec);
        Rl.setBackgroundColor(Color.WHITE);
        Delay(mSec);
        Rl.setBackgroundColor(Color.GRAY);
        Delay(mSec);
        Rl.setBackgroundColor(Color.YELLOW);
        Delay(mSec);

    }

    void Delay(long milsec){
        try {
            sleep(milsec);

        } catch (InterruptedException e) {
           //e.printStackTrace();
        }
    }

    private void updateStatus() {
        on = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean(LightService.SERVICE_RUNNING, false);
    }

    private void updateBackground() {
        if (on) {
            mImageButton.setBackgroundResource(R.drawable.img_background_on);
        } else {
            mImageButton.setBackgroundResource(R.drawable.img_background_off);
        }
    }
}
