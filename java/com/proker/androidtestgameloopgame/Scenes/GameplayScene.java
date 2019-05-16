package com.proker.androidtestgameloopgame.Scenes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.CenterText;
import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Objects.ObstacleManager;
import com.proker.androidtestgameloopgame.Objects.PlayerTest;

public class GameplayScene implements Scene {
    private PlayerTest playerTest;
    private Point playerPoint;

    private Rect r = new Rect();

    private boolean movingPlayer = false;
    private boolean gameOver = false;
    public static boolean isActiveScene = false;

    private long gameOverTime;

    private ObstacleManager obstacleManager;

    public GameplayScene() {
        playerTest = new PlayerTest(new Rect(100, 100, 200, 200), Color.rgb(255, 0 ,0));
        playerPoint = new Point(Constants.SCREEN_WIDTH / 2, 3 * Constants.SCREEN_HEIGHT / 4);
        playerTest.update(playerPoint);

        obstacleManager = new ObstacleManager(200, 350, 75, Color.BLACK);
    }

    public void reset() {
        playerPoint = new Point(Constants.SCREEN_WIDTH / 2, 3 * Constants.SCREEN_HEIGHT / 4);
        playerTest.update(playerPoint);
        obstacleManager = new ObstacleManager(200, 350, 75, Color.BLACK);
        movingPlayer = false;
    }

    @Override
    public void update() {
        if (SceneManager.ACTIVE_SCENE == 0) {
            isActiveScene = true;
        } else {
            isActiveScene = false;
        }

        if (isActiveScene) {
            if (!gameOver) {
                playerTest.update(playerPoint);
                obstacleManager.update();
                if (obstacleManager.playerCollide(playerTest)) {
                    gameOver = true;
                    gameOverTime = System.currentTimeMillis();
                }
            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if (isActiveScene) {
            canvas.drawColor(Color.WHITE);

            playerTest.draw(canvas);
            obstacleManager.draw(canvas);

            if (gameOver) {
                Paint paint = new Paint();
                paint.setTextSize(100);
                paint.setColor(Color.MAGENTA);
                CenterText.drawCenterText(canvas, paint,"Game Over");
            }
        }
    }

    @Override
    public void terminate() {
        SceneManager.ACTIVE_SCENE = 0;
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        if (isActiveScene) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    if (!gameOver && playerTest.getRect().contains((int) event.getX(), (int) event.getY())) {
                        movingPlayer = true;
                    }
                    if (gameOver && System.currentTimeMillis() - gameOverTime >= 2000) {
                        reset();
                        gameOver = false;
                    }
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (movingPlayer && !gameOver) {
                        playerPoint.set((int) event.getX(), (int) event.getY());
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    movingPlayer = false;
                    break;
            }
        }
    }

    public void setIsActiveScene(boolean isActiveScene) {
        isActiveScene = isActiveScene;
    }
}
