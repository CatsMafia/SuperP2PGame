import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayDeque<Message> messages;
    Peer peer;
    Scanner scanner;
    Main(){
        messages = new ArrayDeque<>();
        scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Port: ");
        int port = scanner.nextInt();
        System.out.print("Count of player: ");
        int c = scanner.nextInt();
        String[] ips = new String[c];
        int[] ports = new int[c];
        for (int i = 0; i < c-1; i++) {
            System.out.print("IP: ");
            ips[i] = scanner.next();
            System.out.print("Port: ");
            ports[i] = scanner.nextInt();
        }
        peer = new Peer(port, ips,ports,c,id);
        ArrayList<Handler> handlers;
        handlers = peer.getHandlers();
        Thread[] threads = new Thread[c-1];
        for (int i = 0; i < c-1; i++) {
            threads[i] = new Thread(handlers.get(i));
            threads[i].start();
        }

        if(id == c) {
            peer.sendMessage("",1,1,122,122,50.1f);
        }else {
            while (true) {
                try {
                    System.out.println("Message coming: " + messages.pop().getMessage());
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}
