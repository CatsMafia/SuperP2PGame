package com.wself.objects;

import com.badlogic.gdx.math.Vector2;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

public class Character {

    private final int g = 10;
    private final int GROUND_LEVEL = 320;

    private Vector2 position;
    private Vector2 velocity;
    private float width,height;
    private boolean isRightDirection;
    private boolean isMove;
    private boolean onGround;


    public Character(float x, float y, float width, float height){
        position = new Vector2(x,y);
        velocity = new Vector2(0,0);
        this.width = width;
        this.height= height;
        isRightDirection = true;
        onGround= true;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
        if(position.y < GROUND_LEVEL) {
            velocity.y += g;
        }else {
            onGround=true;
            velocity.y=0;
        }
    }

    public void move(boolean isRight) {
        if(onGround) {
            isMove = true;
            isRightDirection = isRight;
            if (isRight) {
                velocity.x = 30;
            }else {
                velocity.x = -30;
            }
        }
    }
    public void stop(boolean isRight) {
        isMove = false;
        isRightDirection = isRight;
        velocity.x = 0;
    }

    public void jump() {
        if (onGround) {
            onGround = false;
            isMove = false;
            velocity.y -= 300;
        }
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

    public boolean isRightDirection() {
        return isRightDirection;
    }

    public boolean isMove() {
        return isMove;
    }

    public boolean isOnGround() {
        return onGround;
    }
}
