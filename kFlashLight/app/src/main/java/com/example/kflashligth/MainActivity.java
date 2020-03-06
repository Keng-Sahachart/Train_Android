package com.example.kflashligth;

import androidx.appcompat.app.AppCompatActivity;

//import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.hardware.Camera;

public class MainActivity extends AppCompatActivity {

    ImageButton switchOn, switchOff;

    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchOn = (ImageButton) findViewById(R.id.switch_on);
        switchOff = (ImageButton) findViewById(R.id.switch_off);

        camera = Camera.open();


//        switchOff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switchOn.setVisibility(View.GONE);
//                switchOff.setVisibility(View.VISIBLE);
//
////                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
////                camera.setParameters(parameters);
////                camera.startPreview();
//            }
//        });

//        switchOn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switchOff.setVisibility(View.GONE);
//                switchOn.setVisibility(View.VISIBLE);
//
////                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
////                camera.setParameters(parameters);
////                camera.stopPreview();
//            }
//        });

    }

    public void ev_switchOn(View view) {
        switchOff.setVisibility(View.GONE);
        switchOn.setVisibility(View.VISIBLE);

        final Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);
        camera.startPreview();
    }

    public void ev_switchOff(View view) {
        switchOn.setVisibility(View.GONE);
        switchOff.setVisibility(View.VISIBLE);

        final Camera.Parameters parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);
        camera.stopPreview();
    }


}
