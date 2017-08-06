package com.wself.gameskelet;

import com.badlogic.gdx.Game;
import com.wself.helpers.AssetsLoader;
import com.wself.screens.GameScreen;

public class MainGame extends Game {

	@Override
	public void create() {
		AssetsLoader.load();
		setScreen(new GameScreen());
	}

	@Override
	public void dispose(){
		super.dispose();
		AssetsLoader.dispose();
	}
}
