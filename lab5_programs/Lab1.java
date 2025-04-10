//WAP to socket a client.

import java.net.*;
import java.io.*;

public class Lab1{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write("Hello server! I'm Client :)\n");
            writer.flush();
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}