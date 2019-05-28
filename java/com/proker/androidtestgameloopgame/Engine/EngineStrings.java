package com.proker.androidtestgameloopgame.Engine;

import com.proker.androidtestgameloopgame.Objects.Player.PlayerManager;
import com.proker.androidtestgameloopgame.Scenes.GameScene.WorldMap.WorldMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public abstract class EngineStrings {
    public static String engineText() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
            return "[BOYAREngine : " + dateFormat.format(new Date()) + " ] - "; // Find todays date and print engine text
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public static void save() {
        // Save Players
        for (int i = 0; i < Constants.PLAYERS_COUNT; ++i) {
            try {
                PlayerManager.getPlayers().get(i).savePlayer();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        // Save World map
        WorldMap.save();
    }

    public static void load() {
        // Load Players
        for (int i = 0; i < Constants.PLAYERS_COUNT; ++i) {
            try {
                PlayerManager.getPlayers().get(i).loadPlayer();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        // Load World map
        WorldMap.load();

    }

}
