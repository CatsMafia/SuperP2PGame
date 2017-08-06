public class Message {

    String ip;
    String typeObj;
    int idObj;
    int opCode;
    int posX;
    int posY;
    float direction;

    public void createMessage(String message){
        String[] mes = message.split(",");
        this.ip = mes[0];
        this.direction= Float.parseFloat(mes[6]);
        this.idObj=Integer.parseInt(mes[2]);
        this.opCode=Integer.parseInt(mes[3]);
        this.posX = Integer.parseInt(mes[4]);
        this.posY=Integer.parseInt(mes[5]);
        this.typeObj=mes[1];
    }

    public void createMessage(String ip,String typeObj,int idObj,int opCode,int posX, int posY, float direction){
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
    public String getMessage(String ip,String typeObj,int idObj,int opCode,int posX, int posY, float direction){
        return ip+","+typeObj+","+idObj+","+opCode+","+posX+","+posY+","+direction;
    }
}
