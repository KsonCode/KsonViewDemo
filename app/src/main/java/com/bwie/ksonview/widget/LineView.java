package com.bwie.ksonview.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.bwie.ksonview.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineView extends View {
    private Rect mSrcRect,mDestRect;
    private Paint xTextPaint;
    private Paint yTextPaint;
    private Paint xLinePaint;
    private Paint yLinePaint;
    private Paint bgPaint;
    private Paint dotPaint;
    private List<String> xList;
    private List<Point> pointList = new ArrayList<>();

    public LineView(Context context) {
        this(context,null);
        initPaint();
    }

    public LineView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
        initPaint();
    }

    public LineView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 添加数据
     * @param xList
     * @param yList
     */
    public void setData(List<String> xList,List<String> yList){

        if (xList.size()!=yList.size()){
            throw new RuntimeException("横坐标要和纵坐标的值一样多");
        }
        this.xList = xList;
        invalidate();

    }

    private Bitmap bitmap;
    private void initPaint(){
        xLinePaint = new Paint();
        xLinePaint.setAntiAlias(true);
        xLinePaint.setStyle(Paint.Style.FILL);
        xLinePaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        xTextPaint = new Paint();
        xTextPaint.setAntiAlias(true);
        xTextPaint.setStyle(Paint.Style.FILL);
        xTextPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        xTextPaint.setTextSize(30);
        xTextPaint.setTextAlign(Paint.Align.CENTER);


        dotPaint = new Paint();
        dotPaint.setAntiAlias(true);
        dotPaint.setStyle(Paint.Style.FILL);
        dotPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));


        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        xList = new ArrayList<>();
        xList.add("7-22");
        xList.add("7-23");
        xList.add("7-24");
        xList.add("7-25");
        xList.add("7-26");
        xList.add("7-27");


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,600,1000,600,xLinePaint);

        canvas.drawLine(50,600,50,50,xLinePaint);

        int x = 950/7;

        pointList.clear();

        for (String s : xList) {

            Point point = new Point();
            point.x = 50+x;
            point.y = new Random().nextInt(600);
            pointList.add(point);

            canvas.drawText(s,50+x,640,xTextPaint);

            x+=950/7;
        }
        for (int i = 0; i < pointList.size(); i++) {
            canvas.drawCircle(pointList.get(i).x,pointList.get(i).y,20,dotPaint);

            if (i<pointList.size()-1)
            canvas.drawLine(pointList.get(i).x,pointList.get(i).y,pointList.get(i+1).x,pointList.get(i+1).y,xLinePaint);
        }



    }
}
