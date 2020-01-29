package com.example.nuuneoi_38_mashup_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // ประกาศ ตรงนี้ เพื่อ เรียกใช้ได้ทุก  Function
    // กำหนดค่าให้ตัวแปร ตอน OnCreate ครั้งเดียว ใช้ได้ทุกที่
    EditText etvNum1, etvNum2;
    TextView tvRes;
    Button btnCal_Add, btnCal_Mul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // กำหนดค่า ให้ตัวแปร ใช้ได้ทุกที่
        etvNum1 = (EditText) findViewById(R.id.etvNum1);
        etvNum2 = (EditText) findViewById(R.id.etvNum2);
        tvRes = (TextView) findViewById(R.id.tvRes);
        btnCal_Add = (Button) findViewById(R.id.btnCal_Add);
        btnCal_Mul = (Button) findViewById(R.id.btnCal_Mul);

        // กำหนด Listener Event Handle ให้ Function
        btnCal_Add.setOnClickListener(LstrbtnCal_Add);
        btnCal_Mul.setOnClickListener(LstrbtnCal_Mul);
    }

    // Even Handle
    Button.OnClickListener LstrbtnCal_Add = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int n1=0, n2=0; // ต้องกำหนด ค่าเริ่มต้นให้ ไม่งั้น ไม่ได้ Compile
            int Res;//= "";
            try { // ป้องกัน Error เนื่องจาก บางที ไม่ได้ใส่ ข้อมูลอะไรเลย
                n1 = Integer.parseInt(etvNum1.getText().toString());  // ต้อง toString ด้วย เพราะ
            }catch (NumberFormatException e){

            }
            try {
                n2 = Integer.parseInt(etvNum2.getText().toString()); // getText จะได้ Style มาด้วย
            }catch (NumberFormatException e){

            }
            Res = n1 + n2;
            tvRes.setText(Res+"");  // join "" เข้าไปด้วย เพื่อให้มันแปลง เป็น Text

        }
    };

    Button.OnClickListener LstrbtnCal_Mul = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int n1=0, n2=0;
            int Res;//= "";
            try {
                n1 = Integer.parseInt(etvNum1.getText().toString());
            }catch (NumberFormatException e){}
            try {
                n2 = Integer.parseInt(etvNum2.getText().toString());
            }catch (NumberFormatException e){}

            Res = n1 * n2;
            tvRes.setText(Res+"");

        }
    };
}
