package com.CatsMafia.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.CatsMafia.objects.Character;

public class InputHandler implements InputProcessor {
    private Character character;

    public InputHandler(Character character){
        this.character = character;
    }

    @Override
    public boolean keyDown(int keycode) {
        Gdx.app.log("InputHandler", "" + keycode);
        switch (keycode) {
            case 29:
                character.hit();
                break;
            case 21:
                character.move(false);
                break;
            case 22:
                character.move(true);
                break;
            case 62:
                character.jump();
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case 21:
                character.stop(false);
                break;
            case 22:
                character.stop(true);
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
