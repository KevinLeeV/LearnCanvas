package com.kevinlee.learncanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/**
 * ClassName:
 * Description:
 * Author:KevinLee
 * Date:2016/11/25 0025
 * Time:下午 2:03
 * Email:KevinLeeV@163.com
 */
public class TestCanvas extends View {

    private Paint paint;

    public TestCanvas(Context context) {
        this(context, null);
    }

    public TestCanvas(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestCanvas(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 测试clip方法，以Rect为例
         */
        Rect rect = new Rect(0, 0, 600, 600);
        paint.setColor(Color.BLACK);
        canvas.clipRect(0, 0, 300, 300);
        canvas.drawRect(rect, paint);

        Path path = new Path();
        path.addRect(0, 0, 200, 200, Path.Direction.CCW);
        paint.setColor(Color.RED);
        canvas.drawPath(path, paint);

        canvas.clipRect(150, 150, 450, 450, Region.Op.XOR);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(50, 50, 350, 350, paint);

//        canvas.save();
//
//        Rect rect = new Rect(20, 20, 500, 500);
//        //canvas.clipRect(rect);
//        paint.setColor(0x44FF0000);
//
//        canvas.clipRect(50, 50, 600, 600);
//
//        canvas.drawRect(rect, paint);
//
//        Rect clip = new Rect(100, 100, 300, 300);
//        canvas.clipRect(clip);
////        canvas.clipRect(clip, Region.Op.DIFFERENCE);
////        paint.setColor(0x4400FF00);
////        canvas.drawRect(clip, paint);
//
//        canvas.restore();


    }
}
