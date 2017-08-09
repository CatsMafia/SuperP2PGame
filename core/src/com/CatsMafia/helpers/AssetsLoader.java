package com.CatsMafia.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class AssetsLoader {

    public static TextureRegion ground;

    public static Texture idleTexture;
    public static Texture walkTexture;
    public static Texture jumpTexture;
    public static Texture hitTexture;

    public static Animation idleAnimR;
    public static Animation walkAnimR;
    public static Animation jumpAnimR;
    public static Animation hitAnimR;
    public static Animation idleAnimL;
    public static Animation walkAnimL;
    public static Animation jumpAnimL;
    public static Animation hitAnimL;

    public static void load() {

        ground = new TextureRegion(new Texture(Gdx.files.internal("Ground.png")));
        ground.flip(false,true);

        idleTexture = new Texture(Gdx.files.internal("idle_Sheet.png"));
        walkTexture = new Texture(Gdx.files.internal("walk_Sheet.png"));
        jumpTexture = new Texture(Gdx.files.internal("jumpfall_Sheet.png"));
        hitTexture = new Texture(Gdx.files.internal("hit_Sheet.png"));

        idleAnimR = loadAnim(idleTexture,36,false, 0.3f);
        walkAnimR = loadAnim(walkTexture,47,false, 0.3f);
        jumpAnimR = loadAnim(jumpTexture,36,false, 0.3f);
        hitAnimR = loadAnim(hitTexture,216/6,false, 0.09f);
        idleAnimL = loadAnim(idleTexture,36,true, 0.3f);
        walkAnimL = loadAnim(walkTexture,47,true, 0.3f);
        jumpAnimL = loadAnim(jumpTexture,36,true, 0.3f);
        hitAnimL = loadAnim(hitTexture,216/6,true, 0.09f);

    }


    private static Animation loadAnim(Texture texture, int widthOnePicture,boolean isLeft,float speed) {
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        Animation anim;
        int width = texture.getWidth();
        int countP = (int) (width/widthOnePicture);
        TextureRegion[] regions = new TextureRegion[countP];
        for (int i = 0; i < countP; i++) {
            regions[i] = new TextureRegion(texture,widthOnePicture*i,0,widthOnePicture,28);
            regions[i].flip(isLeft,true);
        }
        anim = new Animation(speed,regions);
        anim.setPlayMode(Animation.PlayMode.LOOP);
        return anim;
    }

    public static void dispose() {
        idleTexture.dispose();
        jumpTexture.dispose();
        walkTexture.dispose();

    }
}
