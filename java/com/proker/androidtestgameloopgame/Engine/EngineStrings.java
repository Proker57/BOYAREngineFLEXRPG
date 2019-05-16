package com.proker.androidtestgameloopgame.Engine;

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

}
