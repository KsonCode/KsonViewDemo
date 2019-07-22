package com.bwie.ksonview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.bwie.ksonview.R;

public class DotView extends View {
    private Paint paint;
    private float x,y;
    public DotView(Context context) {
        this(context,null);
    }

    public DotView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attributeSet){
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setDither(true);
        paint.setColor(ContextCompat.getColor(getContext(),R.color.colorAccent));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x+100,y+100,100,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX()-100;
                y = event.getY()-100;

                break;
                case MotionEvent.ACTION_MOVE:

                    x = event.getX()-100;
                    y = event.getY()-100;

                break;
                case MotionEvent.ACTION_UP:
                    x = 0;
                    y = 0;
                break;

        }
        postInvalidate();

        return true;

    }
}
