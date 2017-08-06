package com.wself.objects;

import com.badlogic.gdx.math.Vector2;

public class GameObject {

    public Vector2 position;
    public Vector2 velocity;
    public float width,height;


    public GameObject(float x, float y, float width, float height) {
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        this.width = width;
        this.height= height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return position.x;
    }

    public float getY(){
        return position.y;
    }

}
