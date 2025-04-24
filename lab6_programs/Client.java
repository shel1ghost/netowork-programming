import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("127.0.0.1", 8888);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write("11\n");
            writer.flush();
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String result = reader.readLine();
            System.out.println(result);
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}