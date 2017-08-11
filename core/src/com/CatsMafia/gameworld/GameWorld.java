package com.CatsMafia.gameworld;

import com.CatsMafia.helpers.AssetsLoader;
import com.CatsMafia.helpers.ParsGson;
import com.CatsMafia.objects.Bullet;
import com.CatsMafia.objects.Character;
import com.CatsMafia.objects.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;

public class GameWorld {

    private Character character; // персонаж , главный герой
    //private ArrayList<Ground> ground; // земля матушка
    private ArrayList<Bullet> bullets;
    public static final int g = 300; // ускорение свободного падения
    public static final int GROUND_LEVEL = 320; // уровень земди
    private Map map;

    public GameWorld() {
        ParsGson parsGson = new ParsGson();
        map = parsGson.parsMap(this);
        character = new Character(0f,0f,100,100,this);
        bullets = new ArrayList<Bullet>();
    }

    public void update(float delta) {
        character.update(delta);
        ArrayList<Bullet> removes = new ArrayList<Bullet>();
        for (Bullet b: getBullets()) {
            b.update(delta);
            Gdx.app.log("Fire", "" + b.getDist());
            if (!b.isExist()) {
                Gdx.app.log("Fire","Remove bullet");
                removes.add(b);
            }
        }
        bullets.removeAll(removes);
    } // delta время между update

    public Character getCharacter() {
        return character;
    }

    public Map getMap() {
        return map;
    }

    public void addBullet(Bullet bullet) {
        this.bullets.add(bullet);
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

}

