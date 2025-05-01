import java.net.*;

public class UDPServer{
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(8888);
        InetAddress address = InetAddress.getByName("localhost");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            DatagramPacket recvPacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(recvPacket);
            String receivedData = new String(recvPacket.getData());
            System.out.println("Received: "+receivedData);
            InetAddress ip = recvPacket.getAddress();
            int port = recvPacket.getPort();
            sendData = receivedData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
            socket.send(sendPacket);
        }
    }
}