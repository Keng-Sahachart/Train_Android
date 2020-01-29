package com.example.nuuneoi_37_codestructurerefactoring;

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

public class MainActivity extends AppCompatActivity
//  implements View.OnClickListener, TextView.OnEditorActionListener //implements <== วิธี 1
{

    // Variable ประกาศตัวแปร ก่อน เรีกใช้อีกที จะได้ไม่ต้องใช้ final
    TextView tvHello;
    EditText editText1;
    EditText editText2;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitInstances();
    }

    private void InitInstances() {
        tvHello = (TextView) findViewById(R.id.tvHello);
        String HtmlCd = "";
        HtmlCd = "<b>He<u>ll</u>o</b> <i>World</i> <br>";
        HtmlCd += "<font color=\"#fa0000\">La la la</font> <br>";
        HtmlCd += "<a href=\"https://www.google.com\">Link google</a> <br>";
        tvHello.setMovementMethod(LinkMovementMethod.getInstance());
        tvHello.setText(Html.fromHtml(HtmlCd));

        // ถึง view ที่อยู่ใน XML มาใช้งาน เป็นตัวแปร ด้วย final เพราะ ต้องเรียกใช้ใน handle
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        btnOk = (Button) findViewById(R.id.btnOk);

        // handle ของ editText2 เอาไปแสดงใน  editText1
//        editText2.setOnEditorActionListener(this);// วิธีที่ 1
        editText2.setOnEditorActionListener(listener1);


        // handle ของ btnOk เอา editText2 ไปแสดงใน  editText1
//        btnOk.setOnClickListener(this); // วิธีที่ 1
        btnOk.setOnClickListener(listener); // วิธีที่ 2
    }


    //******************************************************
    // วิธีทำ Handle ที่ไม่ใช้วิธี Annonymost
    //******************************************************
    /*วิธี 1 ใช้ MainActivity ทำ Implement ในการรับ Listener
    มันจะ implement listener ที่ class ให้เอง  ตรงนี้มีหน้าที่ รอรับ*/
//    @Override
//    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//        if (actionId == EditorInfo.IME_ACTION_DONE) {
//            editText1.setText(editText2.getText());
//        }
//        return false;
//    }
//    @Override
//    public void onClick(View v) {  // event ของทุกๆ ปุ่ม
//        if(v==btnOk){  // ต้องตรวจสอบ ว่ามาจากปุ่มไหน
//            editText1.setText(editText2.getText());
//        }
//    }

    //******************************************************
    /* วิธี 2 ไม่ใช้ Activity ฬนการรับ Listener --> ประกาศ Listener เป็น Object ประกาศ เป็น Member Variable */
    TextView.OnEditorActionListener listener1 = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                editText1.setText(editText2.getText()+"8888");
            }
            return false;
        }
    };// <--- ต้องมี comma ด้วย

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v==btnOk){
                editText1.setText(editText2.getText()+"9999");
            }
        }
    }; // <--- ต้องมี comma ด้วย


}
