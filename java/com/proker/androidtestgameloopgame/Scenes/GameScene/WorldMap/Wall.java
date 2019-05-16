package com.proker.androidtestgameloopgame.Scenes.GameScene.WorldMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.R;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class Wall implements Scene {
    private Rect rect;

    private Bitmap bitmap;
    private Paint paint;
    private int xpos, ypos, width;
    public boolean isMovable = true;

    public Wall(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
        paint = new Paint();
        width = Constants.WALL_WIDTH;
        rect = new Rect(xpos, ypos, xpos + width, ypos + width);
        BitmapFactory bf = new BitmapFactory();
        bitmap = bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), R.drawable.world_map_wall);
    }

    @Override
    public void update() {
        if (WorldMap.isMoveLeft && WorldMap.isMovable) {
            xpos += WorldMap.dx;
        }
        if (WorldMap.isMoveRight && WorldMap.isMovable) {
            xpos -= WorldMap.dx;
        }
        if (WorldMap.isMoveUp && WorldMap.isMovable) {
            ypos += WorldMap.dy;
        }
        if (WorldMap.isMoveDown && WorldMap.isMovable) {
            ypos -= WorldMap.dy;
        }

        rect.set(xpos, ypos, xpos + width, ypos + width);
    }

    public void checkCollision() {
        if (rect.intersect(WorldMap.checkLeftRect)) WorldMap.isMoveLeft = false;
        if (rect.intersect(WorldMap.checkRightRect)) WorldMap.isMoveRight = false;
        if (rect.intersect(WorldMap.checkUpRect)) WorldMap.isMoveUp = false;
        if (rect.intersect(WorldMap.checkDownRect)) WorldMap.isMoveDown = false;

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, xpos, ypos, null);
        //paint.setColor(Color.WHITE);
        //canvas.drawRect(rect, paint);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }

    public Rect getRect() {
        return rect;
    }
}
