//WAP for a time server

import java.net.*;
import java.io.*;
import java.util.*;

public class Lab2{
    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(8888);
            while(true){
                try{
                    Socket connection = server.accept();
                    Writer out = new OutputStreamWriter(connection.getOutputStream());
                    Date date = new Date();
                    out.write(date.toString()+"\n");
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