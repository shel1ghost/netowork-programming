//7. WAP to demonstrate the x-www-form-urlencoded strings
import java.net.*;
import java.io.UnsupportedEncodingException;

public class Lab7{
    public static void main(String[] args) throws UnsupportedEncodingException{
        String encoded_url = URLEncoder.encode("http://127.0.0.1/notes/id=12", "UTF-8");
        System.out.println("The encoded url is "+encoded_url);
        String decoded_url = URLDecoder.decode(encoded_url, "UTF-8");
        System.out.println("The decoded url is "+decoded_url);
    }
}
