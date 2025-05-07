import java.net.*;
import java.io.*;

public class MulticastServer{
    public static void main(String[] args) throws UnknownHostException, InterruptedException{
        InetAddress addr = InetAddress.getByName("224.0.0.3");
        try(DatagramSocket socket = new DatagramSocket()){
            for(int i=0; i<5; i++){
                String message = "Send message number "+i;
                DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, addr, 8888);
                socket.send(packet);
                System.out.println("Socket server send message: "+message);
                Thread.sleep(500);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}