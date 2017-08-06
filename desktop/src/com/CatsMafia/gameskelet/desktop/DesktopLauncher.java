package com.CatsMafia.gameskelet.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.CatsMafia.gameskelet.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Game";
		config.height = 720;
		config.width = 1280;
		new LwjglApplication(new MainGame(), config);
	}
}
