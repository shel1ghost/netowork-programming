//WAP to download a webpage using URLConnection
import java.io.*;
import java.net.*;

public class Lab1{
    public static void main(String[] args){
        try{
            URL u = new URL("http://127.0.0.1/");
            HttpURLConnection uc = (HttpURLConnection)u.openConnection();
            try(InputStream raw = uc.getInputStream()){
                printFromStream(raw);
            }catch(IOException ex){
                System.err.println(ex);
            }
        }catch(Exception ex){
            System.err.println(ex);
        }
    }

    private static void printFromStream(InputStream raw) throws IOException{
        try(InputStream buffer = new BufferedInputStream(raw)){
            Reader reader = new InputStreamReader(buffer);
            int c;
            while((c = reader.read()) != -1){
                System.out.print((char)c);
            }
        }
    }
}