//package com.example.flashlightv1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.RelativeLayout;
//
//import static java.lang.Thread.*;
//import android.content.Intent;
//
//import android.preference.PreferenceManager;
//import android.widget.ToggleButton;
//import android.hardware.Camera;
//
//
//public class MainActivity extends AppCompatActivity {
//
//    public RelativeLayout Rl;
//
//    private boolean on = false;
//    private boolean noFlash = false;
//
//    ToggleButton thSwitch;
//    boolean hasFlash;
//    boolean isFlashOn;
//    private Camera camera;
//    Camera.Parameters params;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Rl = (RelativeLayout) findViewById(R.id.RelativeLayout);
//
//        thSwitch = (ToggleButton) findViewById(R.id.button7);
//    }
//
//    public void onClick1(View v) {
//        switch (v.getId()) {
//            case R.id.button1:
//                Rl.setBackgroundColor(Color.BLUE);
//                break;
//            case R.id.button2:
//                Rl.setBackgroundColor(Color.RED);
//                break;
//            case R.id.button3:
//                Rl.setBackgroundColor(Color.WHITE);
//                break;
//            case R.id.button4:
//                Rl.setBackgroundColor(Color.GRAY);
//                break;
//            case R.id.button5:
//                Rl.setBackgroundColor(Color.YELLOW);
//                break;
//        }
//    }
//
//    public void onClick2(View v) {
//
//        long mSec = 1000;
//        Rl.setBackgroundColor(Color.BLUE);
//        Delay(mSec);
//        Rl.setBackgroundColor(Color.RED);
//        Delay(mSec);
//        Rl.setBackgroundColor(Color.WHITE);
//        Delay(mSec);
//        Rl.setBackgroundColor(Color.GRAY);
//        Delay(mSec);
//        Rl.setBackgroundColor(Color.YELLOW);
//        Delay(mSec);
//
//    }
//
//
//    public void onFlash(View v) {
//
//        turnOnFlash();
//
//    }
//
//    void Delay(long milsec){
//        try {
//            sleep(milsec);
//
//        } catch (InterruptedException e) {
//           //e.printStackTrace();
//        }
//    }
//
//    void turnOnFlash()
//    {
//        if(!isFlashOn)
//        {
//            params = camera.getParameters();
//            params.setFlashMode(params.FLASH_MODE_TORCH);
//            camera.setParameters(params);
//            camera.startPreview();
//            isFlashOn = true;
//        }//end of if
//    }//end of turnOnFlash
//
//    void turnOffFlash()
//    {
//        if(isFlashOn)
//        {
//            params = camera.getParameters();
//            params.setFlashMode(params.FLASH_MODE_OFF);
//            camera.setParameters(params);
//            camera.startPreview();
//            isFlashOn = false;
//        }//end of if
//    }//end of turnOffFlash
//
////    private void updateStatus() {
////        on = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getBoolean(LightService.SERVICE_RUNNING, false);
////    }
////
////    private void updateBackground() {
////        if (on) {
////            mImageButton.setBackgroundResource(R.drawable.img_background_on);
////        } else {
////            mImageButton.setBackgroundResource(R.drawable.img_background_off);
////        }
////    }
//}
////////////////////////////////////////////////////////////////////////////////

package com.example.flashlightv1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.PackageManager;
import android.hardware.Camera;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    ToggleButton thSwitch;
    boolean hasFlash;
    boolean isFlashOn;
    private Camera camera;
    Camera.Parameters params;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Stage","We are in onCreate");

        thSwitch = (ToggleButton) findViewById(R.id.button7);

        PackageManager pm = getApplicationContext().getPackageManager();
        hasFlash = pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if(!hasFlash)
        {
            Toast.makeText(this,"No Flash",Toast.LENGTH_LONG).show();
            return;
        }//end of if

        thSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFlashOn)
                    turnOffFlash();
                else
                    turnOnFlash();

            }//end of onClick
        });//end of thSwitch

    }//end of onCreate

    void turnOnFlash()
    {
        if(!isFlashOn)
        {
            params = camera.getParameters();
            params.setFlashMode(params.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = true;
        }//end of if
    }//end of turnOnFlash

    void turnOffFlash()
    {
        if(isFlashOn)
        {
            params = camera.getParameters();
            params.setFlashMode(params.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.startPreview();
            isFlashOn = false;
        }//end of if
    }//end of turnOffFlash

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Stage","We are in onStart");
        if(camera == null)
        {
            try {
                camera = Camera.open();
                turnOnFlash();
            }
            catch (RuntimeException e)
            {
                Toast.makeText(getApplicationContext(),"Camera Not Found",Toast.LENGTH_LONG).show();
            }
        }//end of if
    }//end of onStart

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Stage","We are in onResume");
        if(isFlashOn)
            turnOnFlash();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Stage","We are in onPause");
        if(isFlashOn)
            turnOnFlash();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Stage","We are in onStop");
        if(isFlashOn) {
            turnOnFlash();
        }
        //camera.release();
        //camera = null;
    }//end of onStop

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Stage","We are in onDestroy");
        camera.release();
        camera = null;
    }
}//end of class
