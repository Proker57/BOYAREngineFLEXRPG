package com.proker.androidtestgameloopgame.Engine;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;

import com.proker.androidtestgameloopgame.R;

public abstract class FontManager {
    // TextPaint for about
    static TextPaint textPaint = new TextPaint();
    static Typeface pressstart2p = Typeface.createFromAsset(Constants.CURRENT_CONTEXT.getAssets(), "font/pressstart2p.ttf");

    public static TextPaint PressStart2P() {
        textPaint.setAntiAlias(false);
        textPaint.setTypeface(pressstart2p);
        //textPaint.setTextSize(14 * Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics().density);
        textPaint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.mainmenu_about_text));
        textPaint.setColor(Color.WHITE);
        return textPaint;
    }

    public static TextPaint FreeStatsCoumnMainFrameStats() {
        textPaint.setAntiAlias(true);
        textPaint.setTypeface(pressstart2p);
        //textPaint.setTextSize(14 * Constants.CURRENT_CONTEXT.getResources().getDisplayMetrics().density);
        textPaint.setTextSize(Constants.CURRENT_CONTEXT.getResources().getDimension(R.dimen.freeStatsColumnMainFrame_stats_text));
        textPaint.setColor(Color.WHITE);
        return textPaint;
    }
}
