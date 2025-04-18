//WAP to socket a server

import java.net.*;
import java.io.*;

public class Lab1{
    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(8888);
            while(true){
                try{
                    Socket connection = server.accept();
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    out.write("Hello client! It's me server :)\n");
                    out.flush();
                }catch(IOException ex){
                    System.err.println(ex);
                }
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}