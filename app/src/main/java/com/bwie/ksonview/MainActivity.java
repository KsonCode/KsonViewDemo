package com.bwie.ksonview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bwie.ksonview.widget.TimeView;

public class MainActivity extends AppCompatActivity {
//    TimeView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        myView = findViewById(R.id.myview);
//        myView.setClick(new TimeView.Click() {
//            @Override
//            public void onClick() {
//                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
//            }
//        });
    }




    /**
     * 手指滑动小球
     * @param view
     */
    public void ball(View view) {
    }

    /**
     * 圆形圆角图
     * @param view
     */
    public void circle(View view) {

    }

    /**
     * 流式布局
     * @param view
     */
    public void flowLayout(View view) {

    }
}
