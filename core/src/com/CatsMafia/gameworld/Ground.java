package com.CatsMafia.gameworld;

import com.CatsMafia.helpers.AssetsLoader;
import com.CatsMafia.objects.GameObject;
import com.badlogic.gdx.math.Rectangle;

public class Ground extends GameObject {

    Ground(float x,float y,float width,float height,GameWorld world) {
        super(x,y,width,height,world, AssetsLoader.ground);
    }

}
