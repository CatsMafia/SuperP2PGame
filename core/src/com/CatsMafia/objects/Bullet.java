package com.CatsMafia.objects;

import com.CatsMafia.gameworld.GameWorld;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends GameObject{

    private float maxDist;
    private float dist;
    private boolean isExist;

    public Bullet(float x, float y, float width, float height, GameWorld world, TextureRegion textureRegion,float maxDist,boolean isRightDirection) {
        super(x, y, width, height, world, textureRegion);
        Gdx.app.log("Fire","fire");
        this.maxDist = maxDist;
        isExist = true;
        dist = 0;
        if (isRightDirection) {
            setVelocity(75,0);
        }else {
            setVelocity(-75,0);
        }
    }

    public void update(float delta) {
        Vector2 pos = new Vector2(); //
        getRect().getPosition(pos);  // нахождения позиции у персонажа
        pos.add( getVelocity().cpy().scl(delta));  // добавляем к посиции корость умноженую на delta
        dist += Math.abs(getX() - pos.x);
        if(dist >= maxDist) {
            isExist = false;
        }
        getRect().setPosition(pos);
    }

    public boolean isExist() {
        return isExist;
    }

    public float getDist() {
        return dist;
    }
}
