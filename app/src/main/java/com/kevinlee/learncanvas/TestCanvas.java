package com.kevinlee.learncanvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
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

//        testClipMethod(canvas);
//        testArc(canvas);
//        testARGB(canvas);
//        testCircle(canvas);
//        drawLineAndLines(canvas);
//        testOval(canvas);
//        testPath(canvas);
//        testPoint(canvas);
//        testPosText(canvas);
//        TestRoundRect(canvas);
//        testDrawText(canvas);

        /**
         * 测试drawTextOnPath
         */
        Path path = new Path();
        path.addRect(50, 50, 350, 350, Path.Direction.CW);// 添加一个矩形，并设置矩形的方向为顺时针方向
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawPath(path,paint);// 先绘制出矩形，便于观察

        String text = "canvas.drawTextOnPath";
        paint.setTextSize(50);
        paint.setColor(Color.RED);

        canvas.drawTextOnPath(text,path,50,10,paint);

    }

    private void testDrawText(Canvas canvas) {
        /**
         * 测试drawText
         */
        String text = "12345678";
        Rect bound = new Rect();
        paint.getTextBounds(text, 0, text.length(), bound);// 获取到text的区域范围，从而可以获取到text的宽高
        paint.setTextSize(30);
        paint.setColor(Color.RED);
        canvas.drawText(text, 50, 50 + bound.height(), paint);// y指的是text的baseLine的偏移量
    }

    private void TestRoundRect(Canvas canvas) {
        /**
         * 测试drawRoundRect
         */
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.FILL);// 设置画笔的风格

        RectF rectF = new RectF(50, 50, 200, 200);// 绘制区域
        canvas.drawRoundRect(rectF, 10, 40, paint);
    }

    private void testPosText(Canvas canvas) {
        /**
         * 测试drawPosText
         */
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.STROKE);// 设置画笔的风格
        paint.setStrokeWidth(2);
        paint.setTextSize(50);

        String text = "Test";
        float[] pos = {50, 50, 100, 100, 150, 50, 200, 100};
        canvas.drawPosText(text, pos, paint);
    }

    private void testPoint(Canvas canvas) {
        /**
         * 测试drawPoint，绘制出一个点
         */
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.STROKE);// 设置画笔的风格
        paint.setStrokeWidth(20);

        paint.setStrokeCap(Paint.Cap.ROUND);// 设置画笔的形状
        canvas.drawPoint(50, 50, paint);

        paint.setColor(Color.GREEN);
        paint.setStrokeCap(Paint.Cap.BUTT);// 设置画笔的形状
        canvas.drawPoint(80, 50, paint);

        paint.setColor(Color.BLUE);
        paint.setStrokeCap(Paint.Cap.SQUARE);// 设置画笔的形状
        canvas.drawPoint(120, 50, paint);
    }

    private void testPath(Canvas canvas) {
        /**
         * 测试drawPath，绘制出一个三角形
         */
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.FILL);// 设置画笔的风格
        Path path = new Path();
        path.moveTo(50, 50);
        path.lineTo(100, 50);
        path.lineTo(75, 100);
        path.close();
        canvas.drawPath(path, paint);
    }

    private void testOval(Canvas canvas) {
        /**
         * 测试drawOval方法
         */
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.STROKE);// 设置画笔的风格
        paint.setStrokeWidth(5);

        // 设置绘制区域
        RectF rect = new RectF(50, 50, 200, 100);

        canvas.drawOval(rect, paint);
    }

    private void drawLineAndLines(Canvas canvas) {
        /**
         * 测试drawLine
         */
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
//        canvas.drawLine(50, 50, 150, 250, paint);
        /**
         * 测试drawLines
         */
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        float[] pts = {20, 30, 100, 50, 50, 30, 90, 150, 45, 80, 120, 30};
        canvas.drawLines(pts, paint);
    }

    private void testCircle(Canvas canvas) {
        /**
         * 测试drawCircle方法
         */
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.STROKE);// 设置画笔的风格
        paint.setStrokeWidth(5);
        // 绘制圆形
        canvas.drawCircle(100, 100, 50, paint);
    }

    private void testARGB(Canvas canvas) {
        /**
         * 测试drawARGB
         */
        canvas.clipRect(50, 50, 250, 250);
        canvas.drawARGB(200, 150, 60, 120);
    }

    private void testArc(Canvas canvas) {
        /**
         * 测试drawArc方法
         */
        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);//消除锯齿，但是会减慢绘制速度
        paint.setStyle(Paint.Style.FILL);// 设置画笔的风格

        // 设置绘制区域
        RectF rect = new RectF(50, 50, 200, 200);
        // 先绘制黑色背景
        canvas.drawRect(rect, paint);
        // 绘制扇形
        paint.setStyle(Paint.Style.STROKE);// 设置画笔的风格
        paint.setStrokeWidth(5);
        paint.setColor(Color.RED);
        canvas.drawArc(rect, 0, 90, false, paint);// 设置不使用中心
    }

    /**
     * 测试clip方法，以Rect为例
     */
    private void testClipMethod(Canvas canvas) {

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
    }
}
