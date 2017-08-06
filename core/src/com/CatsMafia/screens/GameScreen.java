package com.CatsMafia.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.CatsMafia.gameworld.GameRenderer;
import com.CatsMafia.gameworld.GameWorld;
import com.CatsMafia.helpers.InputHandler;

public class GameScreen implements Screen {

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;
    public GameScreen(){
        world = new GameWorld();
        renderer = new GameRenderer(world);
        Gdx.input.setInputProcessor(new InputHandler(world.getCharacter()));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}