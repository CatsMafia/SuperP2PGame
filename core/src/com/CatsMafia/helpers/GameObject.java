package com.CatsMafia.helpers;

import com.badlogic.gdx.math.Rectangle;

public class GameObject {

    private float x;
    private float y;
    private float w;
    private float h;
    private String nameImage;

    public GameObject(float x,float y,float w,float h,String nameImage) {
        this.x = x;
        this.y = y+h;
        this.w = w;
        this.h = h;
        this.nameImage = nameImage;
    }

    public Rectangle getRectangle () {
        return new Rectangle(x,y+h/2,w/2,h/2);
    }

    public String getNameImage() {
        return nameImage;
    }
}
