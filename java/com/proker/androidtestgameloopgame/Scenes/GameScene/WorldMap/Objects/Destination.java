package com.proker.androidtestgameloopgame.Scenes.GameScene.WorldMap.Objects;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.R;
import com.proker.androidtestgameloopgame.Scenes.GameScene.WorldMap.WorldMap;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class Destination implements Scene {

    private Rect rect;
    private Paint paint;
    private int index;
    private Bitmap bitmap;

    private int x;
    private int y;

    private int width, height;

    public Destination(int index, int xpos, int ypos) {
        this.index = index;
        this.x = xpos;
        this.y = ypos;

        BitmapFactory bf = new BitmapFactory();
        bitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.world_map_destination);

        width = bitmap.getWidth();
        height = bitmap.getHeight();

        rect = new Rect(x, y, x + width, y + height);
        paint = new Paint();

        init();
    }

    private void init() {
        // See - https://docs.google.com/spreadsheets/d/16RLMkHWKIw9BD2zPvZC6E-cyYK9KS9SudGFklWm15OU/edit#gid=1692590841
        switch(index) {
            case 0:         // Camp

                break;
            case 1:         // Village

                break;
        }
    }

    @Override
    public void update() {
        if (WorldMap.isMoveLeft && WorldMap.isMovable) {
            x += WorldMap.dx;
        }
        if (WorldMap.isMoveRight && WorldMap.isMovable) {
            x -= WorldMap.dx;
        }
        if (WorldMap.isMoveUp) {
            y += WorldMap.dy;
        }
        if (WorldMap.isMoveDown) {
            y -= WorldMap.dy;
        }

        rect.set(x, y, x + width, y + height);
    }

    public void checkCollision() {
        // Check collision
        if (rect.intersect(WorldMap.rectPlayer)) {
            System.out.println(EngineStrings.engineText() + "Destination " + index + " intersects");
            switch (index) {
                case 0:

                    break;
                case 1:

                    break;
            }
        }

    }

    @Override
    public void draw(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawBitmap(bitmap, x, y, null);
        //canvas.drawRect(rect, paint);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Rect getRect() {
        return rect;
    }
}
