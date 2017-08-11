package com.CatsMafia.helpers;

import com.CatsMafia.gameworld.GameWorld;
import com.CatsMafia.gameworld.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ParsGson {

    public Map parsMap(GameWorld world) {
        try{
            Reader reader = new InputStreamReader(new FileInputStream("Stage1.json"),"UTF-8");
            Gson gson = new GsonBuilder().create();
            SimpleMap map = (SimpleMap) gson.fromJson(reader, SimpleMap.class);
            return map.convertToMap(world);
        }catch(Exception e) {
            System.out.println("otheun");
            e.printStackTrace();
        }
        return null;
    }

}
