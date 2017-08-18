package com.CatsMafia.net;

public class Message {

    String ip;
    String typeObj;
    int idObj;
    int opCode;
    float posX;
    float posY;
    boolean direction;

    public void createMessage(String message){
        String[] mes = message.split(",");
        this.ip = mes[0];
        this.direction= Boolean.parseBoolean(mes[6]);
        this.idObj=Integer.parseInt(mes[2]);
        this.opCode=Integer.parseInt(mes[3]);
        this.posX = Integer.parseInt(mes[4]);
        this.posY=Integer.parseInt(mes[5]);
        this.typeObj=mes[1];
    }

    public void createMessage(String ip,String typeObj,int idObj,int opCode,float posX, float posY, boolean direction){
        this.ip=ip;
        this.direction=direction;
        this.idObj=idObj;
        this.opCode=opCode;
        this.posX = posX;
        this.posY=posY;
        this.typeObj=typeObj;
    }

    public String getMessage(){
        return ip+","+typeObj+","+idObj+","+opCode+","+posX+","+posY+","+direction;
    }
    public String getMessage(String ip, String typeObj, int idObj, int opCode, float posX, float posY, boolean direction){
        return ip+","+typeObj+","+idObj+","+opCode+","+posX+","+posY+","+direction;
    }

    public int getOpCode() {
        return opCode;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public boolean isDirection() {
        return direction;
    }

    public int getIdObj() {
        return idObj;
    }
}
