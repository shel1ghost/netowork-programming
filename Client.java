import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args){
        try(Socket socket = new Socket("127.0.0.1", 9999)){
            while(true){
                OutputStream out = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(out, "UTF-8");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String message;
                while(true){
                    System.out.print("You: ");
                    message = br.readLine();
                    writer.write(message+"\n");
                    writer.flush();
                    InputStream in = socket.getInputStream();
                    InputStreamReader reader = new InputStreamReader(in, "UTF-8");
                    BufferedReader br2 = new BufferedReader(reader);
                    String message_recv = br2.readLine();
                    System.out.println("Server: "+message_recv);
                }
            }
        }catch(SocketException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}