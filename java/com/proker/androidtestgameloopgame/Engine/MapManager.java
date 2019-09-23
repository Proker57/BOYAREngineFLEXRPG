package com.proker.androidtestgameloopgame.Engine;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Maps.Tile;
import com.proker.androidtestgameloopgame.Engine.Maps.Tiles;
import com.proker.androidtestgameloopgame.Scenes.Scene;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MapManager implements Scene {
    // ACTIVE MAP
    public static int ACTIVE_MAP = 2;

    // *********************************************************************************************
    private String filename;
    public static String[] mapsheet;

    private boolean isMapChanged = false;
    public static int WIDTH, HEIGHT, TILESIZE;

    private JSONObject mapFile;

    private BitmapFactory bf;
    private Paint paint;

    private ArrayList<String> tilesetNames = new ArrayList<>();
    private ArrayList<Tiles> tiles = new ArrayList<>();

    public MapManager() {
        bf = new BitmapFactory();
        paint = new Paint();

        switch (ACTIVE_MAP) {
            case 0:
                this.filename = "tilemaps/testmapxml.json";
                break;
            case 1:
                this.filename = "tilemaps/test.json";
                break;
            case 2:
                this.filename = "tilemaps/test2.json";
                break;
        }
        try {
            // Load tile map file
            mapFile = new JSONObject(loadJSONFromAsset(filename));
            // Get TILESIZE
            TILESIZE = mapFile.getInt("tilewidth");
            // Get WIDTH of map
            WIDTH = mapFile.getInt("width");
            // Get HEIGHT of map
            HEIGHT = mapFile.getInt("height");
            // Get tilesets array and source links
            for (int i = 0; i < mapFile.getJSONArray("tilesets").length(); i++) {
                tilesetNames.add(mapFile.getJSONArray("tilesets").getJSONObject(i).getString("name"));

            }
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        try {
            mapsheet = mapFile.getJSONArray("layers").getJSONObject(0).getJSONArray("data").join(",").split(",");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // TEST OUTPUT
        for (int i = 0; i < mapsheet.length; i++) {
            System.out.print(mapsheet[i]);
        }

        buildMap();

    }

    private String loadJSONFromAsset(String filename) {
        String json = null;

        try {
            InputStream is = Constants.CURRENT_CONTEXT.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void buildMap() {
        // Make new mapsheet
        try {
            mapsheet = mapFile.getJSONArray("layers").getJSONObject(0).getJSONArray("data").join(",").split(",");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // k is a index for each var of mapsheet
        int k = 0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                switch (mapsheet[k]) {
                    case "1":
                        tiles.add(new Tile(j * (TILESIZE * 2), i * (TILESIZE * 2), bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(0), "drawable", Constants.CURRENT_CONTEXT.getPackageName())), paint));
                        break;
                    case "2":
                        tiles.add(new Tile(j * (TILESIZE * 2), i * (TILESIZE * 2), bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(1), "drawable", Constants.CURRENT_CONTEXT.getPackageName())), paint));
                        break;
                }
                k++;
            }
        }
    }

    @Override
    public void update() {
        if (isMapChanged) {
            // Do clears
            tiles.clear();
            tilesetNames.clear();
            buildMap();
            isMapChanged = false;
        }

    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < WIDTH * HEIGHT; i++) {
            tiles.get(i).draw(canvas);
        }
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
