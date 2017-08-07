package com.CatsMafia.objects;

import com.CatsMafia.gameworld.GameWorld;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {

    private Vector2 velocity;
    private Rectangle rect;
    private GameWorld world;
    public GameObject(float x, float y, float width, float height, GameWorld world) {
        this.world = world;
        rect = new Rectangle(x,y,width,height);
        velocity = new Vector2(0,0);
    }

    public boolean checkCollision(Rectangle obj) {
        return rect.overlaps(obj);
    }

    public float getWidth() {
        return rect.getWidth();
    }

    public float getHeight() {
        return rect.getHeight();
    }

    public float getX() {
        return rect.getX();
    }

    public float getY(){
        return rect.getY();
    }

    public GameWorld getWorld() {
        return world;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(float x,float y) {
        this.velocity = new Vector2(x,y);
    }

    public void setPos(float x,float y) {
        this.rect = new Rectangle(x,y,rect.getWidth(),rect.getHeight());
    }
}
