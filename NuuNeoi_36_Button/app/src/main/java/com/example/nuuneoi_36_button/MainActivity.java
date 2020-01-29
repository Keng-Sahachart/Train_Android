package com.example.nuuneoi_36_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvHello = (TextView)findViewById(R.id.tvHello);
        String HtmlCd = "";
        HtmlCd = "<b>He<u>ll</u>o</b> <i>World</i> <br>";
        HtmlCd += "<font color=\"#fa0000\">La la la</font> <br>";
        HtmlCd += "<a href=\"https://www.google.com\">Link google</a> <br>";
        tvHello.setMovementMethod(LinkMovementMethod.getInstance());
        tvHello.setText(Html.fromHtml(HtmlCd));

        // ถึง view ที่อยู่ใน XML มาใช้งาน เป็นตัวแปร ด้วย final เพราะ ต้องเรียกใช้ใน handle
        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final Button btnOk = (Button)findViewById(R.id.btnOk);

        // handle ของ editText2 เอาไปแสดงใน  editText1
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    editText1.setText(editText2.getText());
                }
                return false;
            }
        });

        // handle ของ btnOk เอา editText2 ไปแสดงใน  editText1
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setText(editText2.getText());
            }
        });

    }
}
