package com.CatsMafia.objects;

import com.CatsMafia.gameworld.GameWorld;

public class Character extends GameObject {

    private boolean isRightDirection;
    private boolean isMove;
    private boolean onGround;

    public Character(float x, float y, float width, float height){
        super(x,y,width,height);
        isRightDirection = true;
        onGround= true;
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
        if(position.y + height< GameWorld.GROUND_LEVEL) {
            velocity.y += GameWorld.g;
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
