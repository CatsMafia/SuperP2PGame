import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class Peer{

    private ServerSocket peerSocket;
    private Socket[] sockets;
    private ArrayList<Socket> clients;
    private ArrayList<Handler> handlers;
    private PrintWriter[] outs;

    Peer(int port, String[] ips, int[] ports, int countOfPlayers, int id){
        countOfPlayers--;
        id--;
        try {
            peerSocket = new ServerSocket(port);
            clients = new ArrayList<>();
            handlers = new ArrayList<>();
            outs = new PrintWriter[countOfPlayers];
            sockets = new Socket[countOfPlayers];
            acceptClient(countOfPlayers,id);
            createConnection(ips,ports,countOfPlayers);
            acceptClient(countOfPlayers, countOfPlayers - id);
            System.out.println("Connection is created");
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    private void acceptClient(int countOfPlayers, int shift) throws Exception{
        System.out.println("Accepting clients");
        for(int i = 0; i < countOfPlayers - shift;i++) {
            clients.add(peerSocket.accept());
            handlers.add(new Handler(new BufferedReader(new InputStreamReader(clients.get(i).getInputStream()))));
            System.out.println("Client is connected");
        }
    }
    private void createConnection(String[] ips,int[] ports, int countOfPlayers) throws Exception{
        System.out.println("Creating connections");
        for(int i = 0; i < countOfPlayers; i++){
            sockets[i] = new Socket(ips[i],ports[i]);
            outs[i] = new PrintWriter(sockets[i].getOutputStream());
        }
    }

    public void sendMessage(String typeObj,int idObj,int opCode,int posX, int posY, float direction){
        for (PrintWriter out: outs) {
            System.out.println("Sending " + new Message().getMessage(peerSocket.getInetAddress().toString(),typeObj,idObj,opCode,posX,posY,direction));
            out.println(new Message().getMessage(peerSocket.getInetAddress().toString(),typeObj,idObj,opCode,posX,posY,direction));
            out.flush();
        }
    }

    public ArrayList<Handler> getHandlers() {
        return handlers;
    }
}