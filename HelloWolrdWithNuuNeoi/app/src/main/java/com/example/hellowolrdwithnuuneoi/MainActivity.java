package com.example.hellowolrdwithnuuneoi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // inflate from XML // เหมือนอ่าน obj ใน XML

        TextView tvHello = (TextView)findViewById(R.id.tvHello);  // Access XML element
//        tvHello.setText("Yeah!");
    }
}
