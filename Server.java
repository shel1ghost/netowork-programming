import java.net.*;
import java.io.*;

public class Server{
    public static void main(String[] args){
        try(ServerSocket server = new ServerSocket(9999)){
            Socket client = server.accept();
            InputStream in = client.getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String message_recv;
            while((message_recv = br.readLine()) != null){
                System.out.println("Client: "+message_recv);
                OutputStream out = client.getOutputStream();
                Writer writer = new OutputStreamWriter(out, "UTF-8");
                System.out.print("You: ");
                BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
                String message = br2.readLine();
                writer.write(message+"\n");
                writer.flush();
            }
        }catch(SocketException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}