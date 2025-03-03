//3. WAP to download a web page of a given web address
import java.net.*;
import java.io.*;

public class Lab3{
    public static void main(String[] args) throws MalformedURLException, IOException{
        URL u = new URL("http://127.0.0.1/");
        InputStream in = u.openStream();
        int c;
        while((c = in.read()) != -1){
            System.out.print(Character.toString(c));
        }
        in.close();
    }
}