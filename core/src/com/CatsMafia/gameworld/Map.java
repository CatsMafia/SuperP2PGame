package com.CatsMafia.gameworld;

import com.CatsMafia.objects.GameObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Map {

    ArrayList<GameObject> gameObjects;

    public void draw(SpriteBatch batch) {
        for (GameObject go: gameObjects) {
            go.draw(batch);
        }
    }

    public void createFrom(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    }
}
