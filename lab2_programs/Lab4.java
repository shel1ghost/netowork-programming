//4. WAP for resolving relatives URI

import java.net.*;
import java.io.*;

public class Lab4{
    public static void main(String[] args) throws MalformedURLException, IOException{
        URL u1 = new URL("http://127.0.0.1/");
        URL u2 = new URL(u1, "goat.html");
        InputStream in = u2.openStream();
        int c;
        while((c = in.read()) != -1){
            System.out.print(Character.toString(c));
        }
        in.close();
    }
}