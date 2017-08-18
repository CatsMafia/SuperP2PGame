package com.CatsMafia.objects;

import com.CatsMafia.gameworld.GameWorld;
import com.CatsMafia.net.Peer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Character extends GameObject {

    private boolean isRightDirection; // направлен влево или вправо
    private boolean isMove; // движется ли персонаж или нет
    private boolean onGround; // находится на земле или нет
    private boolean isHit;
    private float hitTime;
    private boolean Lives = true;
    private Peer peer;
    public Character(float x, float y, float width, float height,GameWorld world,Peer peer,int id,boolean isRightDirection){
        super(x,y,width,height,world, (TextureRegion) null);
        this.peer = peer;
        this.peer.sendMessage("CHARACTER"+id,id,peer.INIT_CHARACTER,x,y,isRightDirection);
        this.isRightDirection = isRightDirection;
        isHit = false;
        hitTime = 0;
    }

    public void update(float delta) {
        Vector2 pos = new Vector2(); //
        getRect().getPosition(pos);  // нахождения позиции у персонажа
        pos.add( getVelocity().cpy().scl(delta));  // добавляем к посиции корость умноженую на delta

        if (isHit) {
            hitTime += delta;
            if(hitTime >= 0.5) {
                isHit = false;
            }
        }
        onGround = false;
        for (GameObject go: getWorld().getMap().getGameObjects()) { // проверям коллизию со всей землей
            if (go.getY() - go.getHeight()*1.5 <= pos.y && pos.y <= go.getY() && pos.x+getWidth()/2 >= go.getX() && pos.x + getWidth()/2 <= go.getX()+go.getWidth()) {
                pos.y = (float) (go.getY()-go.getHeight()*1.5);
                setVelocity(getVelocity().x,0); // при падении на земль скорость установить в 0
                onGround = true;
                break;
            }
        }
        if (!onGround) {
            Gdx.app.log("Coll","no coll ground " + getVelocity().y);
            setVelocity(getVelocity().x,getVelocity().y + GameWorld.g*delta); //  установить обновленую скорость при падении
        }

        getRect().setPosition(pos);
    }

    public void move(boolean isRight) { // движение вызов из Input Handler
            isMove = true;
            isRightDirection = isRight;
            if (isRight) {
                setVelocity(175,getVelocity().y);
            }else {
                setVelocity(-175,getVelocity().y);
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

    public void hit() {
        Vector2 startPos = new Vector2();
        startPos = getRect().getCenter(startPos);
        startPos.x = getX()+getWidth();
        getWorld().addBullet(new Bullet(startPos.x,startPos.y,16,16,getWorld(),null,64,isRightDirection));
        isHit = true;
        hitTime = 0;
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

    public boolean isHit() {
        return isHit;
    }
}
