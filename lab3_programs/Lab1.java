import java.net.*;

class NoGovernmentCookies implements CookiePolicy{
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie){
        if(uri.getAuthority().toLowerCase().endsWith(".gov")){
            return false;
        }else if(cookie.getDomain() != null){
            if(cookie.getDomain().toLowerCase().endsWith(".gov")){
                return false;
            }
            return true;
        }else{
            return true;
        }
    }
}

public class Lab1{
    public static void main(String[] args) throws URISyntaxException{
        URI uri = new URI(args[0]);
        HttpCookie cookie = new HttpCookie(args[1], args[2]);
        NoGovernmentCookies check_cookie = new NoGovernmentCookies();
        boolean result = check_cookie.shouldAccept(uri, cookie);
        if(result){
            System.out.println("Accept this cookie.");
        }else{
            System.out.println("Don't accept this cookie.");
        }
    }
}