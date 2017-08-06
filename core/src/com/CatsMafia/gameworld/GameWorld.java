package com.CatsMafia.gameworld;

import com.CatsMafia.objects.Character;
import com.CatsMafia.objects.GameObject;

import java.util.ArrayList;

public class GameWorld {

    private Character character;
    private ArrayList<Ground> ground;
    public static final int g = 10;
    public static final int GROUND_LEVEL = 320;

    public GameWorld() {
        character = new Character(0f,0f,100,100);
        ground = new ArrayList<Ground>();
        for (int i = 0; i < GameRenderer.WIDTH_GAME/64; i++) {
            ground.add(new Ground(i*64,GameWorld.GROUND_LEVEL,64,64));
        }
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

class Ground extends GameObject{

    Ground(float x,float y,float width,float height) {
        super(x,y,width,height);
    }

}