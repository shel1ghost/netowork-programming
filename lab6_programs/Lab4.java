//WAP for s daytime server using a thread pool

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.concurrent.*;

public class Lab4{
    private final static int PORT = 8888;
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try{
            ServerSocket server = new ServerSocket(PORT);
            while(true){
                try{
                    Socket connection = server.accept();
                    Callable<Void> task = new DayTimeTask(connection);
                    pool.submit(task);
                }catch(IOException ex){
                    System.err.println(ex);
                }
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }

    private static class DayTimeTask implements Callable<Void>{
        private Socket connection;
        DayTimeTask(Socket connection){
            this.connection = connection;
        }
        @Override
        public Void call(){
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
            return null;
        }
    }
}