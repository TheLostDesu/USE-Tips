package com.example.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.view.GestureDetectorCompat;


public class SubActivity extends Activity {
    private static final int SWIPE_MIN_DISTANCE = 130;
    private static final int SWIPE_MAX_DISTANCE = 300;
    private static final int SWIPE_MIN_VELOCITY = 200;
    private GestureDetectorCompat lSwipeDetector;
    int count;
    RelativeLayout main_layout = (RelativeLayout) findViewById(R.id.constLayout);
    main_layout.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return lSwipeDetector.onTouchEvent(event);
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_opis);
        count = getIntent().getIntExtra("key", 0);
        TextView textView = findViewById(R.id.textView2);
        lSwipeDetector = new GestureDetectorCompat(this, new MyGestureListener());
        textView.setMovementMethod(new ScrollingMovementMethod());
        switch (count) {
            case 1:
                textView.setText(getResources().getString(R.string.Task1_3txtRU));
                break;
            case 2:
                textView.setText(getResources().getString(R.string.Task4txtRU));
                break;
            /*case 3:
                textView.setText(getResources().getString(R.string.Task5txtRU));
                break;
            case 4:
                textView.setText(getResources().getString(R.string.Task6txtRU));
                break;
            case 5:
                textView.setText(getResources().getString(R.string.Task7txtRU));
                break;
            case 6:
                textView.setText(getResources().getString(R.string.Task8txtRU));
                break;
            case 7:
                textView.setText(getResources().getString(R.string.Task9txtRU));
                break;
            case 8:
                textView.setText(getResources().getString(R.string.Task10txtRU));
                break;
            case 9:
                textView.setText(getResources().getString(R.string.Task11txtRU));
                break;
            case 10:
                textView.setText(getResources().getString(R.string.Task12txtRU));
                break;
            case 11:
                textView.setText(getResources().getString(R.string.Task13txtRU));
                break;
            case 12:
                textView.setText(getResources().getString(R.string.Task14txtRU));
                break;
            case 13:
                textView.setText(getResources().getString(R.string.Task15txtRU));
                break;
            case 14:
                textView.setText(getResources().getString(R.string.Task16txtRU));
                break;
            case 15:
                textView.setText(getResources().getString(R.string.Task17txtRU));
                break;
            case 16:
                textView.setText(getResources().getString(R.string.Task18txtRU));
                break;
            case 17:
                textView.setText(getResources().getString(R.string.Task19txtRU));
                break;
            case 18:
                textView.setText(getResources().getString(R.string.Task20txtRU));
                break;
            case 19:
                textView.setText(getResources().getString(R.string.Task21txtRU));
                break;
            case 20:
                textView.setText(getResources().getString(R.string.Task22txtRU));
                break;*/
        }
    }
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_DISTANCE)
                return false;
            if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                if(count == 1)
                    return false;
                Intent intent = new Intent(SubActivity.this, SubActivity.class);
                intent.putExtra("key", count - 1);
                startActivity(intent);
            }
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                if(count == 24)
                    return false;
                Intent intent = new Intent(SubActivity.this, SubActivity.class);
                intent.putExtra("key", count + 1);
                startActivity(intent);
            }
            return false;
        }
    }
}
