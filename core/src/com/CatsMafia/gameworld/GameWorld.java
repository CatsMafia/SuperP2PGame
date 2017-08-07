package com.CatsMafia.gameworld;

import com.CatsMafia.objects.Character;
import com.CatsMafia.objects.GameObject;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class GameWorld {

    private Character character;
    private ArrayList<Ground> ground;
    public static final int g = 10;
    public static final int GROUND_LEVEL = 320;

    public GameWorld() {
        ground = new ArrayList<Ground>();
        for (int i = 0; i < GameRenderer.WIDTH_GAME/64; i++) {
            ground.add(new Ground(i*64,GameWorld.GROUND_LEVEL,64,64,this));
        }
        character = new Character(0f,0f,100,100,this);
    }

    public void update(float delta) {
        character.update(delta);
    }

    public Character getCharacter() {
        return character;
    }

    public ArrayList<Ground> getGround() {
        return ground;
    } 

}

