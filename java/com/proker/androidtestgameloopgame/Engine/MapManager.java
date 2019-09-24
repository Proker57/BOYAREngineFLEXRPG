package com.proker.androidtestgameloopgame.Engine;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.proker.androidtestgameloopgame.Engine.Maps.Tile;
import com.proker.androidtestgameloopgame.Scenes.Scene;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MapManager implements Scene {
    private String filename;
    public static String[] mapSheet, blockSheet;

    public static int WIDTH, HEIGHT, TILESIZE;

    private JSONObject mapFile;

    private BitmapFactory bf;
    private Paint paint;

    private ArrayList<String> tilesetNames = new ArrayList<>();
    private ArrayList<Tile> tiles = new ArrayList<>();

    public MapManager() {
        // Set current map
        Constants.ACTIVE_MAP = 1;

        bf = new BitmapFactory();
        paint = new Paint();

        init();

        // TEST OUTPUT
        for (int i = 0; i < mapSheet.length; i++) {
            System.out.print(mapSheet[i]);
        }
    }

    private void init() {
        tiles.clear();
        tilesetNames.clear();

        switch (Constants.ACTIVE_MAP) {
            case 0:
                this.filename = "tilemaps/testmapxml.json";
                break;
            case 1:
                this.filename = "tilemaps/test.json";
                break;
            case 2:
                this.filename = "tilemaps/test2.json";
                break;
            case 3:
                this.filename = "tilemaps/test3.json";
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
        // Make new mapSheet
        try {
            for (int i = 0; i < mapFile.getJSONArray("layers").length(); i++) {
                
            }
            mapSheet = mapFile.getJSONArray("layers").getJSONObject(0).getJSONArray("data").join(",").split(",");
            blockSheet = mapFile.getJSONArray("layers").getJSONObject(1).getJSONArray("data").join(",").split(",");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // k is a index for each var of mapSheet
        int k = 0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                switch (mapSheet[k]) {
                    case "1":
                        tiles.add(new Tile(j * (TILESIZE * 2), i * (TILESIZE * 2), TILESIZE, bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(0), "drawable", Constants.CURRENT_CONTEXT.getPackageName())), paint));
                        break;
                    case "2":
                        tiles.add(new Tile(j * (TILESIZE * 2), i * (TILESIZE * 2), TILESIZE, bf.decodeResource(Constants.CURRENT_CONTEXT.getResources(), Constants.CURRENT_CONTEXT.getResources().getIdentifier(tilesetNames.get(1), "drawable", Constants.CURRENT_CONTEXT.getPackageName())), paint));
                        break;
                }
                k++;
            }
        }
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

    public void changeMap(int index) {
        Constants.ACTIVE_MAP = index;
        init();
    }

    @Override
    public void update() {
        // Making camera move
        for (int i = 0; i < tiles.size(); i++) {
            //tiles.get(i).setX(tiles.get(i).getX() + 1);
        }

    }

    @Override
    public void draw(Canvas canvas) {
        for (int i = 0; i < WIDTH * HEIGHT; i++) {
            // Draw only visible tiles on screen
            if (tiles.get(i).getX() >= -TILESIZE && tiles.get(i).getX() <= Constants.SCREEN_WIDTH + TILESIZE && tiles.get(i).getY() >=  - TILESIZE && tiles.get(i).getY() <= Constants.SCREEN_HEIGHT + TILESIZE) {
                tiles.get(i).draw(canvas);
            }
        }
    }

    @Override
    public void terminate() {

    }

    @Override
    public void recieveTouch(MotionEvent event) {

    }
}
