package com.example.lab7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class SecondScreen extends AppCompatActivity {

    DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener(this);
    private GestureDetectorCompat gestureDetectorCompat = null;

    ImageView MapC,CallC,WebC;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);
        View l1 = findViewById(R.id.scroll);
        MapC = (ImageView) findViewById(R.id.mapC) ;
        CallC = (ImageView) findViewById(R.id.CallC);
        WebC = (ImageView) findViewById(R.id.WebC);

        MapC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll=46.414382,10.013988"));
                    startActivity(i);
                }
                catch (Exception e)
                {

                }
            }
        });
        WebC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                    startActivity(i);
                }
                catch (Exception e)
                {

                }
            }
        });
        CallC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("0444444444"));
                    startActivity(i);
                }
                catch (Exception e)
                {

                }
            }
        });
        l1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                gestureDetectorCompat.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

    public void displayMessage(String swipe) {
        if(swipe.equals("Swipe to Left"))
        {
            Intent i = new Intent(SecondScreen.this,MainActivity3.class);
            startActivity(i);
        }
        else if(swipe.equals("Swipe to Right")){
            Intent i = new Intent(SecondScreen.this,MainActivity.class);
            startActivity(i);
        }
    }
}