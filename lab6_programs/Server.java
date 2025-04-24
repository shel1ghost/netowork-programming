import java.net.*;
import java.io.*;

public class Server{
    public final static int PORT = 8888;
    public static void main(String[] args){
        try{
            ServerSocket server = new ServerSocket(PORT);
            while(true){
                try{
                    Socket connection = server.accept();
                    // Get input stream to receive messages from the client
                    InputStream input = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    int number = Integer.parseInt(reader.readLine());
                    Thread task = new OddEvenThread(connection, number);
                    task.start();
                }catch(IOException ex){
                    System.err.println(ex);
                }
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }

    private static class OddEvenThread extends Thread{
        private Socket connection;
        public int number;
        OddEvenThread(Socket connection, int number){
            this.connection = connection;
            this.number = number;
        }
        @Override
        public void run(){
            try{
                Writer out = new OutputStreamWriter(connection.getOutputStream());
                if(number%2 == 0){
                    out.write("It is even number \n");
                    out.flush();
                }else{
                    out.write("It is odd number\n");
                    out.flush();
                }
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