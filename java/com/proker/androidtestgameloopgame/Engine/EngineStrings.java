package com.proker.androidtestgameloopgame.Engine;

import com.proker.androidtestgameloopgame.Objects.Player.PlayerManager;

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
        for (int i = 0; i <= 4; ++i) {
            try {
                PlayerManager.getPlayers().get(i).savePlayer();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

    public static void load() {
        for (int i = 0; i <= 4; ++i) {
            try {
                PlayerManager.getPlayers().get(i).loadPlayer();
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
    }

}
