package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;


public class SubActivity extends AppCompatActivity {

    private GestureDetectorCompat lSwipeDetector;

    RelativeLayout main_layout;
    TextView textView ;
    private static final int SWIPE_MIN_DISTANCE = 130;
    private static final int SWIPE_MAX_DISTANCE = 300;
    private static final int SWIPE_MIN_VELOCITY = 200;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_opis);

        count = getIntent().getIntExtra("key", 0);
        lSwipeDetector = new GestureDetectorCompat(this, new MyGestureListener());
        main_layout = (RelativeLayout) findViewById(R.id.main_layout);
        textView  = (TextView) findViewById(R.id.tvTxt);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Button back = (Button) findViewById(R.id.GoBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        switch (count) {
            case 1:
                textView.setText(getResources().getString(R.string.Task1_3txtRU));
                break;
            case 2:
                textView.setText(getResources().getString(R.string.Task4txtRU));
                break;
            case 3:
                textView.setText(getResources().getString(R.string.Task5txtRU));
                break;
            case 4:
                textView.setText(getResources().getString(R.string.Task6txtRU));
                break;
            case 5:
                textView.setText(getResources().getString(R.string.Task7txtRU));
                break;
            case 6:
                textView.setText(getResources().getString(R.string.Task8txtRu));
                break;
            case 7:
                textView.setText(getResources().getString(R.string.Task9txtRu));
                break;
            case 8:
                textView.setText(getResources().getString(R.string.Task10txtRu));
                break;
            case 9:
                textView.setText(getResources().getString(R.string.Task11txtRu));
                break;
            case 10:
                textView.setText(getResources().getString(R.string.Task12txtRu));
                break;
            case 11:
                textView.setText(getResources().getString(R.string.Task13txtRu));
                break;
            case 12:
                textView.setText(getResources().getString(R.string.Task14txtRu));
                break;
            case 13:
                textView.setText(getResources().getString(R.string.Task15txtRu));
                break;
            case 14:
                textView.setText(getResources().getString(R.string.Task16txtRu));
                break;
            case 15:
                textView.setText(getResources().getString(R.string.Task17txtRu));
                break;
            case 16:
                textView.setText(getResources().getString(R.string.Task18txtRu));
                break;
            case 17:
                textView.setText(getResources().getString(R.string.Task19txtRu));
                break;
            case 18:
                textView.setText(getResources().getString(R.string.Task20txtRu));
                break;
            case 19:
                textView.setText(getResources().getString(R.string.Task21txtRu));
                break;
            case 20:
                textView.setText(getResources().getString(R.string.Task22txtRu));
                break;
            case 21:
                textView.setText(getResources().getString(R.string.Task23txtRu));
                break;
            case 22:
                textView.setText(getResources().getString(R.string.Task24txtRu));
                break;
            case 23:
                textView.setText(getResources().getString(R.string.Task25txtRu));
                break;
            case 24:
                textView.setText(getResources().getString(R.string.Task26txtRu));
                break;
        }
        main_layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return lSwipeDetector.onTouchEvent(event);
            }
        });
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
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                if(count == 24)
                    return false;
                Intent intent = new Intent(SubActivity.this, SubActivity.class);
                intent.putExtra("key", count + 1);
                startActivity(intent);
            }
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_MIN_VELOCITY) {
                if(count == 1)
                    return false;
                Intent intent = new Intent(SubActivity.this, SubActivity.class);
                intent.putExtra("key", count - 1);
                startActivity(intent);
            }
            return false;
        }
    }
}