package com.example.nuuneoi_39_checkbox_radiobutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomView extends View {

    private boolean isBlue = false;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @RequiresApi(21) // สำหรับ กำหนดว่าให้ func นี้ใช้ได้ ตั้งแต 21 เป็นต้นไป
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void init() {

    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        TypedArray a = getContext().getTheme().obtainStyledAttributes( // เปิด Attributes
                attrs, // ตัวแปร  attr ที่จะหา แต่มี ตัวแหร ย่อย หลายตัว มาด้วย
                R.styleable.CustomView,   // ต้องการหา ตัวแปร จาก เฉพาะ CustomView
                defStyleAttr, defStyleRes);  // ตัวแปร ประกอบ
        try {
            isBlue = a.getBoolean(R.styleable.CustomView_isBlue, false);
        } finally {
            a.recycle();  //TypedArray ต้องคืน Memory เอง
        }

    }


    // สำหรับ วาด
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        if (isBlue)
            p.setColor(0xFF0000FF);  //#AA RRGGBB
        else
            p.setColor(0xFFFF0000);  //#AA RRGGBB

        canvas.drawLine(0, 0, getMeasuredWidth(), getMeasuredHeight(), p);
        //ใช้ getWidth(),getHeight() ไม่ได้ เพราะ จะเอา ค่า ที่กำหนดไว้ ก่อน ที่จะจัดหน้าตา
        //ต้องใช้ getMeasured จึงจะได้ค่า ที่ ทำการ จัดหน้าตาา เสร็จแล้ว

    }
}

