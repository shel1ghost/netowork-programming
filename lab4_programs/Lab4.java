//WAP for HTTP request methods
import java.net.*;
import java.io.*;
import java.util.*;

public class Lab4{
    public static void main(String[] args){
        try{
            //HEAD method
            URL u = new URL("http://127.0.0.1/");
            HttpURLConnection http = (HttpURLConnection)u.openConnection();
            http.setRequestMethod("HEAD");
            System.out.println(u+" was last modified at "+new Date(http.getLastModified()));
            //GET method
            URL u2 = new URL("http://127.0.0.1/");
            HttpURLConnection http2 = (HttpURLConnection)u.openConnection();
            http2.setRequestMethod("GET");
            System.out.println("The GET method response code is "+http2.getResponseCode());
            //OPTIONS method
            URL u3 = new URL("http://127.0.0.1/");
            HttpURLConnection http3 = (HttpURLConnection)u.openConnection();
            http3.setRequestMethod("OPTIONS");
            System.out.println("The OPTIONS method response message is "+http3.getResponseMessage());
        }catch(MalformedURLException ex){
            System.err.println(ex);
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}