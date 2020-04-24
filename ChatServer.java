package chat;
import java.io.*;
import java.net.*;
public class ChatServer implements Runnable {
    static private ServerSocket server;
    static private Socket s;
    static private BufferedReader b;
    static private DataOutputStream d;
    static private DataInputStream d1;
    public static void main(String[] ar){
        ChatServer r=new ChatServer();
        try{
            server=new ServerSocket(8000, 0, InetAddress.getByName("192.168.10.7"));
            s=server.accept();
            b=new BufferedReader(new InputStreamReader(System.in));
            d=new DataOutputStream(s.getOutputStream());
            Thread t=new Thread(r);
            t.start();
            while(true){
                d1=new DataInputStream(s.getInputStream());
                System.out.println("Client Says: "+d1.readUTF());
            }
        }
        catch(Exception e){
            System.out.println("Client Disconnected!!");
        }
    }
    public void run() {
        while(true){
            try{
                String mess=b.readLine();
                d.writeUTF(mess);
            }
            catch(Exception e){}
        }
    }
}