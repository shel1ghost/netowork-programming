//1. WAP that splits the parts of a URL
import java.net.*;

public class Lab1{
    public static void main(String[] args) throws MalformedURLException{
        URL u = new URL("https://www.youtube.com/watch?v=vlQt_ZQpaeg");
        //System.out.println("The url is "+u);
        System.out.println("The authority is "+u.getAuthority());
        System.out.println("The default port is "+u.getDefaultPort());
        System.out.println("The scheme is "+u.getProtocol());
        System.out.println("The user info is "+u.getUserInfo());
        System.out.println("The host is "+u.getHost());
        System.out.println("The port is "+u.getPort());
        System.out.println("The path is "+u.getPath());
        System.out.println("The ref is "+u.getRef());
        System.out.println("The query string is "+u.getQuery());
    }
}