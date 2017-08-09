package com.CatsMafia.gameworld;


import com.CatsMafia.objects.Bullet;
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
            grounds.get(i).draw(batcher);
        }

        if (character.isRightDirection()) {
            if (character.isHit()) {
                character.draw(batcher, (TextureRegion) AssetsLoader.hitAnimR.getKeyFrame(runTime));
            }else if (!character.isMove()) {
                if (character.isOnGround()) {
                    character.draw(batcher,(TextureRegion) AssetsLoader.idleAnimR.getKeyFrame(runTime));
                }else {
                    character.draw(batcher,(TextureRegion) AssetsLoader.jumpAnimR.getKeyFrame(runTime));
                }
            }else {
                if (!character.isOnGround()) {
                    character.draw(batcher,(TextureRegion) AssetsLoader.jumpAnimR.getKeyFrame(runTime));
                }else {
                    character.draw(batcher, (TextureRegion) AssetsLoader.walkAnimR.getKeyFrame(runTime));
                }
            }
        }else {
            if (character.isHit()) {
                character.draw(batcher, (TextureRegion) AssetsLoader.hitAnimL.getKeyFrame(runTime));
            }else if (!character.isMove()) {
                if(character.isOnGround()) {
                    character.draw(batcher,(TextureRegion) AssetsLoader.idleAnimL.getKeyFrame(runTime));
                }else {
                    character.draw(batcher,(TextureRegion) AssetsLoader.jumpAnimL.getKeyFrame(runTime));
                }
            }else {
                if (!character.isOnGround()) {
                    character.draw(batcher,(TextureRegion) AssetsLoader.jumpAnimL.getKeyFrame(runTime));
                }else {
                    character.draw(batcher, (TextureRegion) AssetsLoader.walkAnimL.getKeyFrame(runTime));
                }
            }
        }

        for (Bullet b: myWorld.getBullets()) {
            b.draw(batcher);
        }

        batcher.end();
    }
}