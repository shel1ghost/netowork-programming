import java.net.*;
import java.io.*;

public class Server{
    public static void main(String[] args){
        try(DatagramSocket socket = new DatagramSocket(8888)){
            while(true){
                byte[] send_bytes = new byte[1024];
                DatagramPacket recv_packet = new DatagramPacket(send_bytes, 0, send_bytes.length);
                socket.receive(recv_packet);
                System.out.println("Client: "+new String(recv_packet.getData(), 0, recv_packet.getData().length));
                System.out.print("You: ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String send_msg = br.readLine();
                InetAddress ip = recv_packet.getAddress();
                int port = recv_packet.getPort();
                DatagramPacket send_packet = new DatagramPacket(send_msg.getBytes(), 0, send_msg.getBytes().length, ip, port);
                socket.send(send_packet);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}