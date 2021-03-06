package com.proker.androidtestgameloopgame.Scenes.BoardParts.StatsFrames.Free;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Scenes.BoardParts.StatsFrames.StatsFrame;

import java.util.ArrayList;

public class FreeStatsFrame implements StatsFrame {

    public static ArrayList<FreeStatsColumn> freeStatsColumns = new ArrayList<>();

    public FreeStatsFrame() {
        Constants.FREE_STATS_COLUMN_WIDTH = (int) (Constants.SCREEN_WIDTH / 4);

        for (int i = 0; i < Constants.PLAYERS_COUNT; i++) {
            if (freeStatsColumns.isEmpty() || freeStatsColumns.size() != Constants.PLAYERS_COUNT) {
                freeStatsColumns.add(new FreeStatsColumn(i, Constants.FREE_STATS_COLUMN_WIDTH * i));
            }

        }
    }

    @Override
    public void update() {
        for (FreeStatsColumn column : freeStatsColumns) {
            column.update();
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for (FreeStatsColumn column : freeStatsColumns) {
            column.draw(canvas);
        }
    }

    @Override
    public void recieveTouch(MotionEvent event) {
        for (FreeStatsColumn column : freeStatsColumns) {
            column.recieveTouch(event);
        }
    }
}
