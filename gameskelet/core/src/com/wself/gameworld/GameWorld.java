package com.wself.gameworld;

import com.wself.objects.Character;

public class GameWorld {

    private Character character;

    public GameWorld() {
        character = new Character(0f,0f,100,100);
    }

    public void update(float delta) {
        character.update(delta);
    }

    public Character getCharacter() {
        return character;
    }
}