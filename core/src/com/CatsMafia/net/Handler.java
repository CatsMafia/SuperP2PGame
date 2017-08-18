package com.CatsMafia.net;

import com.CatsMafia.gameworld.GameWorld;

import java.io.BufferedReader;

public class Handler implements Runnable {
    private BufferedReader in;

    private String inp;
    Handler(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run() {
        System.out.println("Start handling");
        while(true){
            try {
                inp = in.readLine();
                Message m = new Message();
                m.createMessage(inp);
                GameWorld.messages.add(m);
            }catch (Exception e) {
                continue;
            }
        }
    }
}
