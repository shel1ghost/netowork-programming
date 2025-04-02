import java.net.*;
import java.util.*;

public class Lab3{
    public static void main(String[] args) throws Exception{
        String uri = "https://youtube.com";
        CookieManager cm = new CookieManager();
        CookieHandler.setDefault(cm);

        CookiePolicy cp = CookiePolicy.ACCEPT_ORIGINAL_SERVER;
        cm.setCookiePolicy(cp);

        URL url = new URL(uri);
        URLConnection connection = url.openConnection();
        connection.getContent();
        CookieStore cs = cm.getCookieStore();

        List<HttpCookie> cookie_list = cs.getCookies();

        for(HttpCookie cookie: cookie_list){
            System.out.println("Domain name is "+cookie.getDomain());
            System.out.println("Cookie name is "+cookie.getName());
        }
    }
}