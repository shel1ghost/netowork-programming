//8. WAP that communicating with server-side programs through GET 
import java.net.*;
import java.io.*;

public class Lab8{
    public static void main(String[] args){
        // String target = "";
        // QueryString query = new QueryString();
        // query.add("q", target);
        try{
            URL u = new URL("http://127.0.0.1:8000/test.php?q=Goat");
            try{
                InputStream in = new BufferedInputStream(u.openStream());
                InputStreamReader html_data = new InputStreamReader(in);
                int c;
                while((c = html_data.read()) != -1){
                    System.out.print(Character.toString(c));
                }
                in.close();
            }catch(IOException ex){
                System.err.println(ex);
            }
        }catch(MalformedURLException ex){
            System.err.println(ex);
        }
    }
}