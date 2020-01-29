package com.example.nuuneoi_39_checkbox_radiobutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // ประกาศ ตรงนี้ เพื่อ เรียกใช้ได้ทุก  Function
    // กำหนดค่าให้ตัวแปร ตอน OnCreate ครั้งเดียว ใช้ได้ทุกที่
    EditText etvNum1, etvNum2;
    TextView tvRes;
    Button btnCal, btnCal_Mul;

    RadioGroup rbgOperator;
    RadioButton rbPlus, rbMinus, rbMultiply, rbDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // กำหนดค่า ให้ตัวแปร ใช้ได้ทุกที่
        etvNum1 = (EditText) findViewById(R.id.etvNum1);
        etvNum2 = (EditText) findViewById(R.id.etvNum2);
        tvRes = (TextView) findViewById(R.id.tvRes);
        btnCal = (Button) findViewById(R.id.btnCal);


        rbgOperator = (RadioGroup) findViewById(R.id.rbgOperator);
//        rbPlus = (RadioButton) findViewById(R.id.rbPlus);
//        rbMinus = (RadioButton) findViewById(R.id.rbMinus);
//        rbMultiply = (RadioButton) findViewById(R.id.rbMultiply);
//        rbDivide = (RadioButton) findViewById(R.id.rbDivide);


        // กำหนด Listener Event Handle ให้ Function
        btnCal.setOnClickListener(LstrbtnCal_Add);

    }

    // Even Handle
    Button.OnClickListener LstrbtnCal_Add = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int n1 = 0, n2 = 0; // ต้องกำหนด ค่าเริ่มต้นให้ ไม่งั้น ไม่ได้ Compile
            int Res = 0;//= "";

            try { // ป้องกัน Error เนื่องจาก บางที ไม่ได้ใส่ ข้อมูลอะไรเลย
                n1 = Integer.parseInt(etvNum1.getText().toString());  // ต้อง toString ด้วย เพราะ
            } catch (NumberFormatException e) {
            }
            try {
                n2 = Integer.parseInt(etvNum2.getText().toString()); // getText จะได้ Style มาด้วย
            } catch (NumberFormatException e) {
            }

            /* วิธี Get จาก RadGroup ว่า Rad อันไหนที่ถูกเลือก  */
//            int rbId = rbgOperator.getCheckedRadioButtonId();
//            View radBtn = rbgOperator.findViewById(rbId);
//            int idx = rbgOperator.indexOfChild(radBtn);
//            RadioButton RbSlt = (RadioButton) rbgOperator.getChildAt(idx);
//            String RadSltStr = RbSlt.getText().toString();

//            RadioButton radBtn1 = (RadioButton) rbgOperator.findViewById(rbId);
//            String RadSltStr1 = radBtn1.getText().toString();

            /* วิธี get checked rad ที่ น่าจะดีที่สุด */
            RadioButton RadSlt = rbgOperator.findViewById(rbgOperator.getCheckedRadioButtonId());

            switch (RadSlt.getId()) {
                case R.id.rbPlus:
                    Res = n1 + n2;
                    break;
                case R.id.rbMinus:
                    Res = n1 - n2;
                    break;
                case R.id.rbMultiply:
                    Res = n1 * n2;
                    break;
                case R.id.rbDivide:
                    Res = n1 / n2;
                    break;
            }
            tvRes.setText("= " + Res + "");  // join "" เข้าไปด้วย เพื่อให้มันแปลง เป็น Text

            //Logcat Debug
            Log.d("Calculation => ", "Result = " + Res);

            //Logcat ออก Assert
            Log.wtf("Calculation wtf => ", "What a terrible failure ,Huhhh");

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int Height = size.y;


            // จะมี Popup เล็กขึ้นมา
            Toast.makeText(MainActivity.this,
                    "width => " + width + " / height =>" + Height ,
                    Toast.LENGTH_LONG) //Short  3 sec , Long 5 Sec
                    .show(); // ต้อง .Show ด้วย

        }
    };

    //    ใส่ menu_main.xml ใน แอพ
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    //    handle การกดปุ่ม ของ item ที่ถูกเลือก
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this,"This Handle Active",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
