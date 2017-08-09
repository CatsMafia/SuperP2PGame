package com.CatsMafia.objects;

import com.CatsMafia.gameworld.GameWorld;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameObject {

    private Vector2 velocity; // скорость объекта
    private Rectangle rect; // квадрат вокруг обьекта
    private GameWorld world; // Окружающий мир
    private TextureRegion textureRegion;
    private Animation animation;

    public GameObject(float x, float y, float width, float height, GameWorld world, TextureRegion textureRegion) {
        this.world = world;
        rect = new Rectangle(x,y,width,height);
        velocity = new Vector2(0,0);
        this.textureRegion = textureRegion;
    }

    public GameObject(float x, float y, float width, float height, GameWorld world, Animation animation) {
        this.world = world;
        rect = new Rectangle(x,y,width,height);
        velocity = new Vector2(0,0);
        this.animation = animation;
    }

    public void draw(SpriteBatch batch) {
        if(textureRegion != null) {
            batch.draw(textureRegion,getX(),getY(),getWidth(),getHeight());
        }
    }

    public void draw(SpriteBatch batch, TextureRegion textureRegion) {
        batch.draw(textureRegion,getX(),getY(),getWidth(),getHeight());
    }

    public boolean checkCollision(Rectangle obj) {
        return rect.overlaps(obj);
    } // проверяет соприкосновение с другим объектом

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
        rect = rect.setPosition(x,y);
    }
}
