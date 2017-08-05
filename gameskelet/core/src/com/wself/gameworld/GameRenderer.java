package com.wself.gameworld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.wself.helpers.AssetsLoader;
import com.wself.objects.Character;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private SpriteBatch batcher;
    private Character character;

    public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 1280, 720);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);

        initGameObjects();
    }

    private void initGameObjects(){
        character = myWorld.getCharacter();
    }

    public void render(float runTime) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        if (character.isRightDirection()) {
            if (!character.isMove()) {
                if (character.isOnGround()) {
                    batcher.draw((TextureRegion) AssetsLoader.idleAnimR.getKeyFrame(runTime), character.getX(), character.getY(), character.getWidth(), character.getHeight());
                }else {
                    batcher.draw((TextureRegion) AssetsLoader.jumpAnimR.getKeyFrame(runTime), character.getX(), character.getY(), character.getWidth(), character.getHeight());
                }
            }else {
                batcher.draw((TextureRegion) AssetsLoader.walkAnimR.getKeyFrame(runTime), character.getX(), character.getY(), character.getWidth(), character.getHeight());
            }
        }else {
            if (!character.isMove()) {
                if(character.isOnGround()) {
                    batcher.draw((TextureRegion) AssetsLoader.idleAnimL.getKeyFrame(runTime), character.getX(), character.getY(), character.getWidth(), character.getHeight());
                }else {
                    batcher.draw((TextureRegion) AssetsLoader.jumpAnimL.getKeyFrame(runTime), character.getX(), character.getY(), character.getWidth(), character.getHeight());
                }
            }else {
                batcher.draw((TextureRegion) AssetsLoader.walkAnimL.getKeyFrame(runTime), character.getX(), character.getY(), character.getWidth(), character.getHeight());
            }
        }
        batcher.end();
    }
}