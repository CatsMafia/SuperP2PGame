package com.CatsMafia.helpers;

import com.CatsMafia.gameworld.GameWorld;
import com.CatsMafia.gameworld.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

public class SimpleMap {

    ArrayList<GameObject> gameObjects;

    public Map convertToMap(GameWorld world) {
        Map map = new Map();
        ArrayList<com.CatsMafia.objects.GameObject> gameObjectsWithImage= new ArrayList<com.CatsMafia.objects.GameObject>();
        for (GameObject go: gameObjects) {
            Texture texture = new Texture(Gdx.files.internal(go.getNameImage()));
            TextureRegion textureRegion = new TextureRegion(texture);
            textureRegion.flip(false,true);
            gameObjectsWithImage.add(new com.CatsMafia.objects.GameObject(go.getRectangle(),world,textureRegion));
        }
        map.createFrom(gameObjectsWithImage);
        return map;
    }

}
