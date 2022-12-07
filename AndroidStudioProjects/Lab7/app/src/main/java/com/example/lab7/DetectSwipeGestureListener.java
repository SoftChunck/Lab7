package com.example.lab7;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class DetectSwipeGestureListener extends GestureDetector.SimpleOnGestureListener
{
    private SecondScreen activity = null;
    DetectSwipeGestureListener(SecondScreen activity){
        this.activity = activity;
    }
    public SecondScreen getActivity() {
        return activity;
    }
    public void setActivity(SecondScreen activity) {
        this.activity = activity; }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float deltaX = e1.getX() - e2.getX();
        float deltaXAbs = Math.abs(deltaX);
        if ((deltaXAbs >= 100) && (deltaXAbs <= 1000)) {
            if (deltaX >= 0) {
                this.activity.displayMessage("Swipe to Left");
                Log.d("Swipe","Swipe Left");

            } else {
                this.activity.displayMessage("Swipe to Right");
                Log.d("Swipe","Swipe Right");
            }
        }
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return true;
    }
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return true;
    }

}