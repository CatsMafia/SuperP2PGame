package com.CatsMafia.screens;

import com.CatsMafia.gameskelet.MainGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

public class MainMenu implements Screen {

    final MainGame game;
    SpriteBatch batch;
    BitmapFont font;
    String ip = "";
    String ipEnemy = "";
    final int port = 9090;
    Stage stage;
    Skin skin;
    TextField ipPlayers;
    TextField idPlayers;
    TextButton submit;
    Label label;
    int id;


    public MainMenu(final MainGame gam) {

        try {
            ip = getIp();
        }catch (Exception e) {
            e.printStackTrace();
        }

        stage = new Stage();
        skin = new Skin(Gdx.files.internal("skins/uiskin.json"));
        ipPlayers = new TextField("ip",skin);
        ipPlayers.setPosition(1280/2,720/2+100);
        idPlayers = new TextField("id",skin);
        idPlayers.setPosition(1280/2,720/2+200);
        label = new Label("Your ip : " + ip,skin);
        label.setPosition(1280/2,720/2-100);
        submit = new TextButton("Submit",skin);
        submit.setBounds(1280/2,720/2,256,50);
        submit.addListener(new ClickListener() {
            @Override
            public void clicked (InputEvent event, float x, float y) {
                ipEnemy = ipPlayers.getText();
                id = Integer.valueOf(idPlayers.getText());
                gam.createPeer(ipEnemy,id);
                gam.changeGameStage(id);
                
            }
        });
        stage.addActor(label);
        stage.addActor(ipPlayers);
        stage.addActor(submit);
        stage.addActor(idPlayers);
        game = gam;
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
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

    public String getIp() throws Exception{
        ArrayList<String> ips = new ArrayList<String>();
        Enumeration e = NetworkInterface.getNetworkInterfaces();
        while(e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();

                ips.add(i.getHostAddress());
            }
        }
        for (String ip:ips) {
            try {
                if (ip.split("\\.")[0].equals("10") || ip.split("\\.")[0].equals("192")) {
                    return ip;
                }
            }catch (Exception ex) {
                continue;
            }
        }
        return ips.get(1);
    }
}
