package com.example.flashlightv1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import static java.lang.Thread.*;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    public RelativeLayout Rl;

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

        Intent refresh = new Intent(this, Main.class);
        startActivity(refresh);//Start the same Activity
        finish(); //finish Activity.

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
}
