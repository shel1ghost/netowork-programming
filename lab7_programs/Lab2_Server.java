//WAP for creating secure server sockets and client sockets.

import java.net.*;
import javax.net.ssl.SSLServerSocketFactory;

public class Lab2_Server{
    public static void main(String[] args){
        try{
            SSLServerSocketFactory factory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            ServerSocket server = factory.createServerSocket(8888);
            Socket client = server.accept();
            System.out.println("Client connected...\n");
            client.close();
        }catch(Exception ex){
            System.err.println(ex);
        }
    }
}