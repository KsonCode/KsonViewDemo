package com.bwie.ksonview.widget;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class LineView extends View {
    private Paint xTextPaint;
    private Paint yTextPaint;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        invalidate();

    }

    private void initPaint(){

    }
}
