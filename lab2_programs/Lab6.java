//6. WAP to download an object
import java.net.*;
import java.io.*;

public class Lab6{
    public static void main(String[] args) throws MalformedURLException, IOException{
        URL u = new URL("http://127.0.0.1:5000/static/images/notebook2.jpg");
        Object o = u.getContent();
        System.out.println("The class name is "+o.getClass().getName());
    }
}