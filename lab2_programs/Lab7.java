//7. WAP to demonstrate the x-www-form-urlencoded strings
import java.net.*;
import java.io.UnsupportedEncodingException;

public class Lab7{
    public static void main(String[] args) throws UnsupportedEncodingException{
        String input_url = "http%3A%2F%2F127.0.0.1%2Fnotes%3Fid%3D12";
        String output = URLDecoder.decode(input_url, "UTF-8");
        System.out.println(output);
    }
}