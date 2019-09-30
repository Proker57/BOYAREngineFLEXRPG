package com.proker.androidtestgameloopgame.Engine.Hud;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Objects.Player.Player;
import com.proker.androidtestgameloopgame.Scenes.Scene;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class HudMovement implements Scene {
    private int xCenter, yCenter;
    private float baseRadius, hatRadius, xHat, yHat;

    private boolean isActive = true;

    private Paint paint, basePaint, hatPaint;
    private BitmapFactory bf;
    private Bitmap bitmap;
    private DecimalFormat df = new DecimalFormat("#.##");


    public HudMovement(int x, int y) {
        this.xCenter = x;
        this.yCenter = y;
        // Set rounding mode for percent float
        df.setRoundingMode(RoundingMode.CEILING);

        xHat = x;
        yHat = y;

        baseRadius = Constants.SCREEN_HEIGHT / 6;
        hatRadius = Constants.SCREEN_HEIGHT / 12;

        paint = new Paint();        // Paint
        paint.setColor(Color.argb(168, 0, 234, 113));
        basePaint = new Paint();    // Base Paint
        basePaint.setColor(Color.argb(255, 255, 0, 0));
        hatPaint = new Paint();     // Hat Paint
        hatPaint.setColor(Color.argb(255, 0, 0, 255));
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        // Draw Joystick, base
        canvas.drawCircle(xCenter, yCenter, baseRadius, basePaint);
        // Draw Joystick, hat
        canvas.drawCircle(xHat, yHat, hatRadius, hatPaint);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_UP:
                xHat = xCenter;
                yHat = yCenter;

                // Stop player movement
                Player.dx = 0;
                Player.dy = 0;

                // Remove joystick form hashMap
                HudManager.huds.remove("joystick");
                break;
            case MotionEvent.ACTION_MOVE:
                float displacement = (float) Math.sqrt(Math.pow(event.getX() - xCenter, 2) + Math.pow(event.getY() - yCenter, 2));
                float xPercent = (event.getX() - xCenter) / baseRadius;
                float yPercent = (event.getY() - yCenter) / baseRadius;

                if (displacement < baseRadius) {
                    xHat = event.getX();
                    yHat = event.getY();
                } else {
                    float ratio = baseRadius / displacement;
                    float xDis = xCenter + (event.getX() - xCenter) * ratio;
                    float yDis = yCenter + (event.getY() - yCenter) * ratio;

                    xPercent = Float.valueOf(df.format((xDis - xCenter) / baseRadius));
                    yPercent = Float.valueOf(df.format((yDis - yCenter) / baseRadius));

                    xHat = xDis;
                    yHat = yDis;
                }

                // Player movement
                Player.dx = xPercent * 10;
                Player.dy = yPercent * 10;
                break;
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getxCenter() {
        return xCenter;
    }

    public void setxCenter(int xCenter) {
        this.xCenter = xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public void setyCenter(int yCenter) {
        this.yCenter = yCenter;
    }
}
