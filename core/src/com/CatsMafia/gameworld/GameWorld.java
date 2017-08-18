package com.CatsMafia.gameworld;

import com.CatsMafia.helpers.AssetsLoader;
import com.CatsMafia.helpers.ParsGson;
import com.CatsMafia.net.Message;
import com.CatsMafia.net.Peer;
import com.CatsMafia.objects.Bullet;
import com.CatsMafia.objects.Character;
import com.CatsMafia.objects.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class GameWorld {

    private Character character; // персонаж , главный герой
    //private ArrayList<Ground> ground; // земля матушка
    private ArrayList<Bullet> bullets;
    public static final int g = 300; // ускорение свободного падения
    public static final int GROUND_LEVEL = 320; // уровень земди
    public static ArrayList<Message> messages = new ArrayList<Message>();
    private ArrayList<Character> characters = new ArrayList<Character>();
    private Peer peer;
    private Map map;

    public GameWorld(Peer peer, Vector2 initPos,int id) {
        ParsGson parsGson = new ParsGson();
        this.peer = peer;
        map = parsGson.parsMap(this);
        if (id == 1) {
            character = new Character(initPos.x,initPos.y,100,100,this,peer,id,true);
        }else {
            character = new Character(initPos.x,initPos.y,100,100,this,peer,id,false);
        }
        bullets = new ArrayList<Bullet>();
    }

    public void update(float delta) {
        checkMessages();
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
    }

    private void checkMessages() {
        if (!messages.isEmpty()) {
            Message m = messages.get(0);
            if (m.getOpCode() == peer.INIT_CHARACTER) {
                characters.add(new Character(m.getPosX(),m.getPosY(),100,100, this,peer,m.getIdObj(),m.isDirection()));
            }
        }
    }

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

