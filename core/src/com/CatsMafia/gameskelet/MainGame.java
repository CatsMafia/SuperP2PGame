package com.CatsMafia.gameskelet;

import com.CatsMafia.screens.MainMenu;
import com.badlogic.gdx.Game;
import com.CatsMafia.helpers.AssetsLoader;
import com.CatsMafia.screens.GameScreen;
import com.CatsMafia.net.Peer;

public class MainGame extends Game {

    Peer peer;

	@Override
	public void create() {
		AssetsLoader.load();
		setScreen(new MainMenu(this));
	}

	@Override
	public void dispose(){
		super.dispose();
		AssetsLoader.dispose();
    }

    public void createPeer(String ip,int id) {

	    peer = new Peer(9090,new String[]{ip},new int[]{9090},2,id);
    }
}
