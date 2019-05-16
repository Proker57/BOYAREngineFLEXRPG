package com.proker.androidtestgameloopgame.GameBoard;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Scenes.GameScene.WorldMap.WorldMap;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class GameBoard implements Scene {

    private Rect rect;
    private Paint paint;

    // Add World Map
    private WorldMap worldMap;

    public GameBoard() {
        rect = new Rect(0, Constants.GAME_BOARD_Y, Constants.GAME_BOARD_WIDTH, Constants.GAME_BOARD_HEIGHT);
        Constants.GAME_BOARD_WIDTH_RECT = rect.width();
        Constants.GAME_BOARD_HEIGHT_RECT = rect.height();
        paint = new Paint();

        // Add Game World
        worldMap = new WorldMap();
    }

    @Override
    public void update() {
        if (Constants.GAME_SCENE_ACTIVE_SCENE == 3) {
            worldMap.update();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        // Fill background with solid color
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
        // Draw middle line
        paint.setColor(Color.WHITE);
        // DELETE
        paint.setStrokeWidth(2);
        canvas.drawLine(rect.left, (((rect.top + rect.bottom) / 2f) + rect.top) / 2f, rect.right, (((rect.top + rect.bottom) / 2f) + rect.top) / 2f, paint);
        canvas.drawLine(rect.left, (rect.top + rect.bottom) / 2f, rect.right, (rect.top + rect.bottom) / 2f, paint);
        canvas.drawLine(rect.left, (((rect.bottom + rect.top) / 2f) + rect.bottom) / 2f, rect.right, (((rect.bottom + rect.top) / 2f) + rect.bottom) / 2f, paint);


        if (Constants.GAME_SCENE_ACTIVE_SCENE == 3) {
            worldMap.draw(canvas);
        }
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        // World map
        if (Constants.GAME_SCENE_ACTIVE_SCENE == 3) {
            worldMap.recieveTouch(event);
        }
    }

    public Rect getRect() {
        return rect;
    }
}
