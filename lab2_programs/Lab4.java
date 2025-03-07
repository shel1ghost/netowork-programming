//4. WAP for resolving relatives URI

import java.net.*;

public class Lab4{
    public static void main(String[] args) throws URISyntaxException{
        URI u1 = new URI("http://127.0.0.1/");
        URI u2 = u1.resolve("goat.html");
        System.out.println("The resolved URI is "+u2.toString());
    }
}
