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
                Main.messages.add(m);
            }catch (Exception e) {
                continue;
            }
        }
    }
}
