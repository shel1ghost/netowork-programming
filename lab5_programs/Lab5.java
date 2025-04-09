//WAP to get a socket's information

import java.net.*;
import java.io.*;

public class Lab5{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("127.0.0.1", 80);
            System.out.println("Socket Address: "+socket.getInetAddress());
            System.out.println("Socket Port: "+socket.getPort());
            System.out.println("Local Address: "+socket.getLocalAddress());
            System.out.println("Local Port: "+socket.getLocalPort());
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}