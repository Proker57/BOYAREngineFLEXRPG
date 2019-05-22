package com.proker.androidtestgameloopgame.Engine.Main;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.proker.androidtestgameloopgame.Engine.Constants;
import com.proker.androidtestgameloopgame.Engine.EngineStrings;
import com.proker.androidtestgameloopgame.Engine.NavigationBar;

public class MainActivity extends Activity {
    private View decorView;
    public SharedPreferences s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        //decorView = getWindow().getDecorView();
        //decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().getDecorView().setSystemUiVisibility(
                          View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        System.out.println(EngineStrings.engineText() + "Size of screen loaded");
        Constants.SCREEN_WIDTH = NavigationBar.getRealScreenSize(this).x;
        Constants.SCREEN_HEIGHT = NavigationBar.getRealScreenSize(this).y;

        // Create saveFile
        createSaveFile();

        setContentView(new GamePanel(this));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    protected void onPause() {
        System.out.println(EngineStrings.engineText() + " Pause");
        EngineStrings.save();

        super.onPause();
    }

    @Override
    protected void onResume() {
        System.out.println(EngineStrings.engineText() + " Resume");

        super.onResume();
    }

    private void createSaveFile() {
        s = getSharedPreferences("saveFile", MODE_PRIVATE);
        SharedPreferences.Editor e = s.edit();
        // Player 1 ********************************************************************************
        e.putString("isFirstTime", "false");
        e.putString("player_1_HPC", "11");
        e.putString("player_1_HPMAX", "111");
        e.putString("player_1_APC", "12");
        e.putString("player_1_APMAX", "112");
        e.putString("player_1_WPNC", "VODKA");
        e.putString("player_1_VDKC", "11");
        e.putString("player_1_BEERC", "12");
        e.putString("player_1_CTLC", "13");
        e.putString("player_1_DEFC", "14");
        e.putString("player_1_LVLC", "15");
        e.putString("player_1_EXPMIN", "106");
        e.putString("player_1_EXPMAX", "1007");
        e.putString("player_1_EVDC", "18");
        e.putString("player_1_CRTC", "19");
        e.putString("player_1_STRC", "110");
        e.putString("player_1_DEXC", "111");
        e.putString("player_1_CONC", "112");
        // Player 2 *********************************************************************************
        e.putString("player_2_HPC", "21");
        e.putString("player_2_HPMAX", "211");
        e.putString("player_2_APC", "22");
        e.putString("player_2_APMAX", "212");
        e.putString("player_2_WPNC", "COCKTAIL");
        e.putString("player_2_VDKC", "21");
        e.putString("player_2_BEERC", "22");
        e.putString("player_2_CTLC", "23");
        e.putString("player_2_DEFC", "24");
        e.putString("player_2_LVLC", "25");
        e.putString("player_2_EXPMIN", "206");
        e.putString("player_2_EXPMAX", "2007");
        e.putString("player_2_EVDC", "28");
        e.putString("player_2_CRTC", "29");
        e.putString("player_2_STRC", "210");
        e.putString("player_2_DEXC", "211");
        e.putString("player_2_CONC", "212");
        // Player 3 ********************************************************************************
        e.putString("player_3_HPC", "31");
        e.putString("player_3_HPMAX", "311");
        e.putString("player_3_APC", "32");
        e.putString("player_3_APMAX", "312");
        e.putString("player_3_WPNC", "BEER");
        e.putString("player_3_VDKC", "31");
        e.putString("player_3_BEERC", "32");
        e.putString("player_3_CTLC", "33");
        e.putString("player_3_DEFC", "34");
        e.putString("player_3_LVLC", "35");
        e.putString("player_3_EXPMIN", "306");
        e.putString("player_3_EXPMAX", "3007");
        e.putString("player_3_EVDC", "38");
        e.putString("player_3_CRTC", "39");
        e.putString("player_3_STRC", "310");
        e.putString("player_3_DEXC", "311");
        e.putString("player_3_CONC", "312");
        // Player 4 ********************************************************************************
        e.putString("player_4_HPC", "41");
        e.putString("player_4_HPMAX", "411");
        e.putString("player_4_APC", "42");
        e.putString("player_4_APMAX", "412");
        e.putString("player_4_WPNC", "VODKA");
        e.putString("player_4_VDKC", "41");
        e.putString("player_4_BEERC", "42");
        e.putString("player_4_CTLC", "43");
        e.putString("player_4_DEFC", "44");
        e.putString("player_4_LVLC", "45");
        e.putString("player_4_EXPMIN", "406");
        e.putString("player_4_EXPMAX", "4007");
        e.putString("player_4_EVDC", "48");
        e.putString("player_4_CRTC", "49");
        e.putString("player_4_STRC", "410");
        e.putString("player_4_DEXC", "411");
        e.putString("player_4_CONC", "412");
        e.commit();
        System.out.println(EngineStrings.engineText() + "Save file was created");
    }
}
