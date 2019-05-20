package com.proker.androidtestgameloopgame.Objects.Enemies;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Objects.GameObject;

import java.util.ArrayList;

public class EnemyManager implements GameObject {
    private int count, index;

    private ArrayList<Enemy> enemies = new ArrayList<>();

    public EnemyManager(int count) {
        this.count = count;
        for (int i = 0; i <= 4; ++i) {
            enemies.add(new Enemy(index));
        }
    }


    @Override
    public void draw(Canvas canvas) {
        for (Enemy enemy : enemies) {
            enemy.draw(canvas);
        }
    }

    @Override
    public void update() {
        for (Enemy enemy : enemies) {
            enemy.update();
        }
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        for (Enemy enemy : enemies) {
            enemy.recieveTouch(event);
        }
    }
}
