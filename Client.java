import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args){
        try(DatagramSocket socket = new DatagramSocket()){
            while(true){
                byte[] recv_bytes = new byte[1024];
                System.out.print("You: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String send_msg = br.readLine();
                InetAddress ip = InetAddress.getByName("127.0.0.1");
                DatagramPacket send_packet = new DatagramPacket(send_msg.getBytes(), 0, send_msg.getBytes().length, ip, 8888);
                socket.send(send_packet);
                DatagramPacket recv_packet = new DatagramPacket(recv_bytes, 0, recv_bytes.length);
                socket.receive(recv_packet);
                System.out.println("Server: "+new String(recv_packet.getData(), 0, recv_packet.getData().length));            
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}