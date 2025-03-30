import java.net.*;
import java.util.List;

public class Lab2{
    public static void main(String[] args) throws URISyntaxException{
        CookieManager cm = new CookieManager();
        CookieStore cs = cm.getCookieStore();

        HttpCookie c1 = new HttpCookie("astra", "101");
        HttpCookie c2 = new HttpCookie("babi", "102");
        HttpCookie c3 = new HttpCookie("shellghost", "103");

        URI u1 = new URI("http://astra.com.np");
        URI u2 = new URI("http://babithakur.com.np");
        
        //add cookies into cookie store
        cs.add(u1, c1);
        cs.add(u2, c2);
        cs.add(null, c3);

        //read stored cookies
        List stored_cookies = cs.getCookies();
        System.out.println(stored_cookies);

        //remove cookies of the uri
        cs.remove(u1, c1);

        List stored_cookies_after_remove = cs.getCookies();
        System.out.println(stored_cookies_after_remove);

        //remove all cookies
        cs.removeAll();
        List cookies_after_remove_all = cs.getCookies();
        System.out.println(cookies_after_remove_all);
    }
}