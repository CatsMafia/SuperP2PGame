package com.CatsMafia.gameskelet;

import com.CatsMafia.gameworld.GameRenderer;
import com.CatsMafia.gameworld.GameWorld;
import com.CatsMafia.screens.MainMenu;
import com.badlogic.gdx.Game;
import com.CatsMafia.helpers.AssetsLoader;
import com.CatsMafia.screens.GameScreen;
import com.CatsMafia.net.Peer;
import com.badlogic.gdx.math.Vector2;

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

    public void changeGameStage(int id) {
        Vector2 initPos;
        if (id == 1) {
            initPos = new Vector2(10,0);
        }else {
            initPos = new Vector2(GameRenderer.WIDTH_GAME,0);
        }
		setScreen(new GameScreen(peer,initPos,id));
	}
}
