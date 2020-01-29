package com.example.nuuneoi_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv01 = findViewById(R.id.tv01);
        tv01.setText("This is tv01");
        tv01.setText(tv01.getText()+ ", Hello" + R.string.app_name);
    }
}
