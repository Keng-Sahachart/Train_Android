package com.example.nuuneoi_35_edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tvHello = (TextView) findViewById(R.id.tvHello);
        tvHello.setMovementMethod(LinkMovementMethod.getInstance());
        String HtmlCd = "";
        HtmlCd = "<b>He<u>ll</u>o</b> <i>World</i> <br>";
        HtmlCd += "<font color=\"#fa0000\">La la la</font> <br>";
        HtmlCd += "<a href=\"https://www.google.com\">Link google</a> <br>";
        tvHello.setText(Html.fromHtml(HtmlCd));

        // ต้องประกาศ เป็น Final ด้วย ถึงจะเรียกใช้ ใน function handle ได้
        // หรือ ไปประกาศ ใน handle เลย
        //final EditText editText1 = (EditText)findViewById(R.id.editText1);

        final EditText editTextHello = (EditText) findViewById(R.id.editTextHello);

        // ดับจับ การกด done
        editTextHello.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    //editText1.setText(editTextHello.getText());
                    EditText editText1 = (EditText)findViewById(R.id.editText1);
                    editText1.setText(v.getText());
                    return true;
                }
                return false;
            }
        });
    }
}
