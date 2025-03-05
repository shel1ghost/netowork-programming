//5. WAP to split the parts of URI
import java.net.*;

public class Lab5{
    public static void main(String[] args){
        try{
            URI u = new URI("tel:+1-800-9988-9938");
            if(u.isOpaque()){
                System.out.println("This is opaque uri");
                System.out.println("The scheme is "+u.getScheme());
                System.out.println("The scheme specific part is "+u.getSchemeSpecificPart());
                System.out.println("The fragment id is "+u.getFragment());
            }else{
                System.out.println("This is a hierarchial uri.");
                System.out.println("The scheme is "+u.getScheme());
                try{
                    u = u.parseServerAuthority();
                    System.out.println("The host is "+u.getHost());
                    System.out.println("The user info is "+u.getUserInfo());
                    System.out.println("The port is "+u.getPort());
                }catch(URISyntaxException ex){
                    System.out.println("The authority is "+u.getAuthority());
                }
                System.out.println("The path is "+u.getPath());
                System.out.println("The query strint is "+u.getQuery());
                System.out.println("The fragement id is "+u.getFragment());
            }
        }catch(URISyntaxException ex){
            System.err.println("This does not seem to an URI.");
        }
    }
}