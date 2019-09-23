package com.proker.androidtestgameloopgame.Scenes.BoardParts.StatsFrames.HelpFrame;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.FontManager;
import com.proker.androidtestgameloopgame.R;
import com.proker.androidtestgameloopgame.Scenes.Scene;

public class HelpFrame implements Scene {

    private Rect rect;
    private Paint paint;
    private StaticLayout staticLayout;
    private String text;

    public HelpFrame(String text) {
        Constants.HELP_FRAME_Y = (int) ((Constants.SCREEN_HEIGHT * 0.65f) - Constants.SCREEN_HEIGHT * 0.2f);
        Constants.HELP_FRAME_HEIGHT = (int) (Constants.SCREEN_HEIGHT * 0.65f);

        this.text = text;

        rect = new Rect(0, Constants.HELP_FRAME_Y, Constants.SCREEN_WIDTH, Constants.HELP_FRAME_HEIGHT);
        paint = new Paint();
        staticLayout = new StaticLayout(text, FontManager.FreeStatsCoumnMainFrameStats(), rect.width(), Layout.Alignment.ALIGN_NORMAL, 1.4f, 0, false);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Canvas canvas) {
        // Fill background with solid color
        //paint.setColor(Color.argb(85,0, 5, 176));
        paint.setColor(Color.argb(150,40, 0, 40));
        canvas.drawRect(rect, paint);
        // Draw Static Layout
        canvas.save();
        canvas.translate(rect.left + Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f, rect.top + Constants.CURRENT_CONTEXT.getResources().getDimensionPixelSize(R.dimen.freeStatsColumnMainFrame_stats_text) * 1.2f);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }

    public void setText(String text) {
        this.text = text;
    }
}
