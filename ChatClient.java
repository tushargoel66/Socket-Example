package javaapplication1;
import java.net.*;
import java.io.*;
import static java.lang.Thread.sleep;
public class ChatClient implements Runnable{
    static private Socket s;
    
    public static void main(String [] args)throws Exception{
        ChatClient c=new ChatClient();
       s=new Socket("192.168.10.4",8000);
        DataInputStream d=new DataInputStream(s.getInputStream());
        Thread t=new Thread(c);
        t.start();
        while(true){
            System.out.println("Srever Says: "+d.readUTF());
        }
    }
    public void run(){
        while(true){
            try{
                DataOutputStream d=new DataOutputStream(s.getOutputStream());
                BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
                String s=b.readLine();
                d.writeUTF(s);
            }
            catch(Exception e){}
        }
    }
}