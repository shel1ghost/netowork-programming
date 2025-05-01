import java.net.*;
import java.io.*;

public class OddEvenClient{
    public static void main(String[] args) throws Exception{
        System.out.print("Enter a number: ");
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        byte[] sendData = new byte[1024];
        byte[] recvData = new byte[1024];
        String numberToBeSent = reader.readLine();
        sendData = numberToBeSent.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 8888);
        socket.send(sendPacket);
        DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
        socket.receive(recvPacket);
        String serverResponse = new String(recvPacket.getData());
        System.out.println("Server response: "+serverResponse);
        socket.close();
    }
}