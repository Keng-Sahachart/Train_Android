package com.example.nuuneoi_34_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello2 = (TextView)findViewById(R.id.tvHello2);
        //*** แสดงผลได้ แต่ คลิกไม่ได้ ต้องใส่ คำสั่ง setMovementMethod
        tvHello2.setMovementMethod(LinkMovementMethod.getInstance());
        String HtmlCd="";
        HtmlCd = "<b>He<u>ll</u>o</b> <i>World</i> <br>";
        HtmlCd+= "<font color=\"#fa0000\">La la la</font> <br>";
        HtmlCd+= "<a href=\"https://www.google.com\">Link google</a> <br>";
        tvHello2.setText(Html.fromHtml(HtmlCd));
    }
}
