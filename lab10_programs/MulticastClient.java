import java.net.*;
import java.io.*;

public class MulticastClient{
    public static void main(String[] args) throws UnknownHostException{
        InetAddress addr = InetAddress.getByName("224.0.0.3");
        byte[] buffer = new byte[256];
        try(MulticastSocket ms = new MulticastSocket(8888)){
            ms.joinGroup(addr);
            while(true){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                ms.receive(packet);
                String message = new String(buffer, 0, buffer.length);
                System.out.println("Socket client 1 received message: "+message);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}