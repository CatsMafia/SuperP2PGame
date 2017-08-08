package com.CatsMafia.objects;

import com.CatsMafia.gameworld.GameWorld;
import com.CatsMafia.gameworld.Ground;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Character extends GameObject {

    private boolean isRightDirection;
    private boolean isMove;
    private boolean onGround;

    public Character(float x, float y, float width, float height,GameWorld world){
        super(x,y,width,height,world);
        isRightDirection = true;
    }

    public void update(float delta) {
        Vector2 pos = new Vector2();
        getRect().getPosition(pos);
        pos.add( getVelocity().cpy().scl(delta));

        if (!onGround) {
            Gdx.app.log("Coll","no coll ground " + getVelocity().y);
            setVelocity(getVelocity().x,getVelocity().y + GameWorld.g*delta);
        }else {
            setVelocity(getVelocity().x,0);
        }


        for (Ground gr: getWorld().getGround()) {
            if (checkCollision(gr.getRect())) {
                if(gr.getY()+1 <= getY()+getHeight()) {
                    Gdx.app.log("coll", "" + (getHeight()));
                    setPos(getX(),gr.getY()- getHeight());
                    onGround = true;
                }
                break;
            }
        }
         /*if(pos.y + getHeight()< GameWorld.GROUND_LEVEL) {
            setVelocity(getVelocity().x,getVelocity().y + GameWorld.g);
        }else {
            onGround=true;
            setVelocity(getVelocity().x,0);
        }*/
        getRect().setPosition(pos);
    }

    public void move(boolean isRight) {
        if(onGround) {
            isMove = true;
            isRightDirection = isRight;
            if (isRight) {
                setVelocity(75,getVelocity().y);
            }else {
                setVelocity(-75,getVelocity().y);
            }
        }
    }

    public void stop(boolean isRight) {
        isMove = false;
        isRightDirection = isRight;
        setVelocity(0,getVelocity().y);
    }

    public void jump() {
        if (onGround) {
            onGround = false;
            isMove = false;
            setVelocity(getVelocity().x,-300);
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
