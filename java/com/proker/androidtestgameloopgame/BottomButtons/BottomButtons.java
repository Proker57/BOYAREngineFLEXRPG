package com.proker.androidtestgameloopgame.BottomButtons;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Buttons.ButtonManager;
import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.R;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class BottomButtons implements Scene {

    private ButtonManager buttonsManager;

    private int xpos;
    private int numOfButtons;

    public BottomButtons() {
        buttonsManager = new ButtonManager();
        numOfButtons = 4;
        for (int i = 0; i <= numOfButtons; ++i) {
            xpos = (int) (Constants.SCREEN_WIDTH / numOfButtons * i);
            buttonsManager.add(xpos, Constants.BOTTOM_BUTTONS_Y, (int) (Constants.SCREEN_WIDTH / numOfButtons), (int) (Constants.SCREEN_HEIGHT * 0.05f), "BUTTON", Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.freeStatsColumn_spellButtonManager_button), Color.WHITE);
        }
    }

    @Override
    public void update() {
        buttonsManager.update();
    }

    @Override
    public void draw(Canvas canvas) {
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
                for (int i = 0; i <= numOfButtons; ++i) {
                    if (buttonsManager.buttons.get(i).getRect().contains((int) event.getX(), (int) event.getY())) {
                        System.out.println(EngineStrings.engineText() + " Bottom button " + (i + 1) + " pressed");
                    }
                }

        }
    }
}
