package com.proker.androidtestgameloopgame.Engine.Main;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.Scenes.SceneManager;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread thread = null;

    private SceneManager manager;

    public GamePanel(Context context) {
        super(context);

        getHolder().addCallback(this);

        Constants.CURRENT_CONTEXT = context;

        manager = new SceneManager();

        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        Constants.INIT_TIME = System.currentTimeMillis();
        thread.setRunning(true);
        thread.start();
        System.out.println(EngineStrings.engineText() + " new Thread");
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        manager.recieveTouch(event);
        return true;
        //return super.onTouchEvent(event);
    }

    public void update() {
        manager.update();


    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        manager.draw(canvas);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {
                thread.setRunning(false);
                thread.join();
                System.out.println(EngineStrings.engineText() + " Thread joined");
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
}
