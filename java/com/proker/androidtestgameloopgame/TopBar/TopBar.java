package com.proker.androidtestgameloopgame.TopBar;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Buttons.ButtonManager;
import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class TopBar implements Scene {

    private Rect rect;
    private Paint paint;
    private ButtonManager buttonsManager;

    public TopBar() {
        rect = new Rect(0, 0, Constants.TOP_BAR_WIDTH, Constants.TOP_BAR_HEIGHT);
        Constants.TOP_BAR_HEIGHT_RECT = rect.left;
        paint = new Paint();
        buttonsManager = new ButtonManager();

        buttonsManager.add(0 + Constants.SCREEN_WIDTH * 0.03f, 0 + Constants.SCREEN_HEIGHT * 0.01f, Constants.SCREEN_WIDTH * 0.1f, Constants.SCREEN_HEIGHT * 0.06f, paint);
    }

    @Override
    public void update() {
        buttonsManager.update();
    }

    @Override
    public void draw(Canvas canvas) {
        // Fill background with solid color
        paint.setColor(Color.rgb(200, 0, 30));
        canvas.drawRect(rect, paint);

        paint.setColor(Color.rgb(150, 150, 66));
        buttonsManager.draw(canvas);
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // VK button
                if (buttonsManager.buttons.get(0).getRect().contains((int) event.getX(), (int) event.getY())) {
                    System.out.println(EngineStrings.engineText() + " Top Bar options button pressed");
                }
        }
    }
}
