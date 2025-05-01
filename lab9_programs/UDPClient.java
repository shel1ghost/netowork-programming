import java.net.*;
import java.io.*;

public class UDPClient{
    public static void main(String[] args) throws Exception{
        System.out.print("Enter a text: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        byte[] recvData = new byte[1024];
        byte[] sendData = new byte[1024];
        String dataToBeSent = br.readLine();
        sendData = dataToBeSent.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 8888);
        socket.send(sendPacket);
        DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
        socket.receive(recvPacket);
        String serverResponse = new String(recvPacket.getData());
        System.out.println("Server response: "+serverResponse);
        socket.close();


    }
}