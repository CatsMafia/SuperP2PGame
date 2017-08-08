package com.CatsMafia.gameworld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.CatsMafia.helpers.AssetsLoader;
import com.CatsMafia.objects.Character;

import java.util.ArrayList;

public class GameRenderer {

    public static final int WIDTH_GAME = 1280;
    public static final int HEIGHT_GAME = 720;

    private GameWorld myWorld;
    private OrthographicCamera cam; // камера через которую смотрит пользователь
    private SpriteBatch batcher; // холст

    private Character character;
    private ArrayList<Ground> grounds;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1280, 720);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        initGameObjects();
    }

    private void initGameObjects(){ // инициализация объектов
        character = myWorld.getCharacter();
        grounds = myWorld.getGround();
    }

    public void render(float runTime) { // метод для отрисовки
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();

        for (int i = 0; i < grounds.size(); i++) {
            batcher.draw(AssetsLoader.ground,grounds.get(i).getX(),grounds.get(i).getY(),grounds.get(i).getWidth(),grounds.get(i).getHeight());
        }

        if (character.isRightDirection()) {
            if (!character.isMove()) {
                if (character.isOnGround()) {
                    batcher.draw((TextureRegion) AssetsLoader.idleAnimR.getKeyFrame(runTime), character.getX(), character.getY(),character.getWidth(),character.getHeight());
                }else {
                    batcher.draw((TextureRegion) AssetsLoader.jumpAnimR.getKeyFrame(runTime), character.getX(), character.getY(),character.getWidth(),character.getWidth());
                }
            }else {
                batcher.draw((TextureRegion) AssetsLoader.walkAnimR.getKeyFrame(runTime), character.getX(), character.getY(),character.getWidth(),character.getHeight());
            }
        }else {
            if (!character.isMove()) {
                if(character.isOnGround()) {
                    batcher.draw((TextureRegion) AssetsLoader.idleAnimL.getKeyFrame(runTime), character.getX(), character.getY(),character.getWidth(),character.getHeight());
                }else {
                    batcher.draw((TextureRegion) AssetsLoader.jumpAnimL.getKeyFrame(runTime), character.getX(), character.getY(),character.getWidth(),character.getHeight());
                }
            }else {
                batcher.draw((TextureRegion) AssetsLoader.walkAnimL.getKeyFrame(runTime), character.getX(), character.getY(),character.getWidth(),character.getHeight());
            }
        }

        batcher.end();
    }
}