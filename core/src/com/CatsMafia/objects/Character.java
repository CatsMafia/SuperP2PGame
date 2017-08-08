package com.CatsMafia.objects;

import com.CatsMafia.gameworld.GameWorld;
import com.CatsMafia.gameworld.Ground;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Character extends GameObject {

    private boolean isRightDirection; // направлен влево или вправо
    private boolean isMove; // движется ли персонаж или нет
    private boolean onGround; // находится на земле или нет

    public Character(float x, float y, float width, float height,GameWorld world){
        super(x,y,width,height,world);
        isRightDirection = true;
    }

    public void update(float delta) {
        Vector2 pos = new Vector2(); //
        getRect().getPosition(pos);  // нахождения позиции у персонажа
        pos.add( getVelocity().cpy().scl(delta));  // добавляем к посиции корость умноженую на delta

        for (Ground gr: getWorld().getGround()) { // проверям коллизию со всей землей
            if (checkCollision(gr.getRect())) {
                if(gr.getY()-gr.getHeight()*1.5 <= pos.y) {
                    pos.y = (float) (gr.getY()-gr.getHeight()*1.5);
                    setVelocity(getVelocity().x,0); // при падении на земль скорость установить в 0
                    onGround = true;
                    break;
                }
            }
        }

        if (!onGround) {
            Gdx.app.log("Coll","no coll ground " + getVelocity().y);
            setVelocity(getVelocity().x,getVelocity().y + GameWorld.g*delta); //  установить обновленую скорость при падении
        }

        getRect().setPosition(pos);
    }

    public void move(boolean isRight) { // движение вызов из Input Handler
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

    public void stop(boolean isRight) { // остановка персонажа
        isMove = false;
        isRightDirection = isRight;
        setVelocity(0,getVelocity().y);
    }

    public void jump() { // прыжок
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
