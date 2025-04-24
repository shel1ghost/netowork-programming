//WAP for creating secure server sockets and client sockets.

import java.net.*;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class Lab2_Client{
    public static void main(String[] args){
        try{
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
            Socket socket = factory.createSocket("127.0.0.1", 8888);
            System.out.println("Connected to server...\n");
            socket.close();
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}