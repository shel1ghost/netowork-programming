//WAP for a multithreaded daytime server

import java.net.*;
import java.io.*;
import java.util.Date;

public class Lab3{
    public final static int PORT = 8888;
    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(PORT);
            while(true){
                try{
                    Socket connection = server.accept();
                    Thread task = new DayTimeThread(connection);
                    task.start();
                }catch(IOException ex){
                    System.err.println(ex);
                }
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }

    private static class DayTimeThread extends Thread{
        private Socket connection;
        DayTimeThread(Socket connection){
            this.connection = connection;
        }
        @Override
        public void run(){
            try{
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                Date date = new Date();
                out.write(date.toString()+"\n");
                out.flush();
            }catch(IOException ex){
                System.err.println(ex);
            }finally{
                try{
                    connection.close();
                }catch(IOException ex){
                    System.err.println(ex);
                }
            }
        }
    }
}