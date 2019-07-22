package com.bwie.ksonview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.bwie.ksonview.R;

public class TimeView extends View {
    private Paint allLinePaint;//整条线
    private Paint progressPaint;//刻度线
    private Paint textPaint;//刻度线
    private Paint imgPaint;//图片绘制
    private Bitmap bitmap;
    Rect rect = new Rect();
    public TimeView(Context context) {
        super(context);
        init(context);
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context){
        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        allLinePaint = new Paint();
        allLinePaint.setAntiAlias(true);
        allLinePaint.setStrokeWidth(10);
        allLinePaint.setColor(getResources().getColor(R.color.colorPrimary));


        progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setStrokeWidth(10);
        progressPaint.setColor(getResources().getColor(R.color.colorPrimary));
        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStrokeWidth(10);
        textPaint.setTextSize(60);
        textPaint.setColor(getResources().getColor(R.color.colorPrimary));


        imgPaint = new Paint();
        imgPaint.setAntiAlias(true);
        imgPaint.setStrokeWidth(10);
        imgPaint.setColor(getResources().getColor(R.color.colorPrimary));


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(10,90,getScreenWidthOrHeight(true)-10,90,allLinePaint);
        canvas.drawLine(200,40,200,90,progressPaint);

        canvas.drawText("中奖",200,30,textPaint);


        canvas.drawBitmap(bitmap,200-bitmap.getWidth()/2,100,imgPaint);
    }

    public int getScreenWidthOrHeight(boolean width){
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        if (width){
            return dm.widthPixels;
        }else{
            return dm.heightPixels;
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_UP:

                if (event.getX()>200-bitmap.getWidth()/2&&event.getX()<200-bitmap.getWidth()/2+bitmap.getWidth()){


                    click.onClick();
                }
                break;
        }

        return true;
    }

    Click click;

    public void setClick(Click click) {
        this.click = click;
    }

    public interface Click{
        void onClick();
    }

}
