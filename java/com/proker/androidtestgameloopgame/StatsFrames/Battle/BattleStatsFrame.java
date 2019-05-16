package com.proker.androidtestgameloopgame.StatsFrames.Battle;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.StatsFrames.StatsFrame;

public class BattleStatsFrame implements StatsFrame {
    private Paint paint;

    public BattleStatsFrame() {
        paint = new Paint();
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        paint.setColor(Color.rgb(130, 130, 130));
        canvas.drawRect(0, (int) (Constants.SCREEN_HEIGHT * 0.7), Constants.SCREEN_WIDTH, (int) (Constants.SCREEN_HEIGHT), paint);
    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
