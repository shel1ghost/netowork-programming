import java.net.*;

public class OddEvenServer{
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] recvData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
            socket.receive(recvPacket);
            int number = Integer.parseInt(new String(recvPacket.getData(), 0, recvPacket.getLength()));
            InetAddress ip = recvPacket.getAddress();
            int port = recvPacket.getPort();
            String result = "";
            if(number % 2 == 0){
                result = number+" is even number";
            }else{
                result = number+" is odd number";
            }
            sendData = result.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
            socket.send(sendPacket);
        }
    }
}