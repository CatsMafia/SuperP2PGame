package com.CatsMafia.gameskelet;

import com.badlogic.gdx.Game;
import com.CatsMafia.helpers.AssetsLoader;
import com.CatsMafia.screens.GameScreen;

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
