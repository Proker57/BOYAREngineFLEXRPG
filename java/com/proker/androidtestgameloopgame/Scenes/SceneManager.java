package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Scenes.GameScene.GameScene;

import java.util.ArrayList;

public class SceneManager {
    public ArrayList<Scene> scenes = new ArrayList<>();
    public static int ACTIVE_SCENE;

    public SceneManager() {
        ACTIVE_SCENE = 3;
        scenes.add(new GameplayScene());    // 0
        scenes.add(new MainmenuScene());    // 1
        scenes.add(new GameScene());        // 2
        scenes.add(new TestMapScene());     // 3
    }

    public void recieveTouch(MotionEvent event) {
        scenes.get(ACTIVE_SCENE).recieveTouch(event);
    }

    public void update() {
        scenes.get(ACTIVE_SCENE).update();
    }

    public void draw(Canvas canvas) {
        scenes.get(ACTIVE_SCENE).draw(canvas);
    }
}
