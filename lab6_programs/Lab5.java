//WAP to implement simple log

import java.net.*;
import java.util.*;
import java.util.logging.*;
import java.io.*;

public class Lab5{
    private final static Logger errorLogger = Logger.getLogger("errors");
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
            errorLogger.log(Level.SEVERE, "Port already in use...");
        }
    }
}