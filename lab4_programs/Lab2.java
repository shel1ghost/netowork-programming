//WAP to read value of HTTP header fields
import java.net.*;
import java.io.*;
import java.util.*;

public class Lab2{
    public static void main(String[] args){
        try{
            URL u = new URL("http://127.0.0.1");
            URLConnection uc = u.openConnection();
            System.out.println("Content Type: "+uc.getContentType());
            if(uc.getContentEncoding() != null){
                System.out.println("Contnet Encoding: "+uc.getContentEncoding());
            }
            if(uc.getDate() != 0){
                System.out.println("Date: "+new Date(uc.getDate()));
            }
            if(uc.getLastModified() != 0){
                System.out.println("Last Modified Date: "+new Date(uc.getLastModified()));
            }
            if(uc.getExpiration() !=0 ){
                System.out.println("Expiration Date: "+new Date(uc.getExpiration()));
            }
            if(uc.getContentLength() != -1){
                System.out.println("Content Length: "+uc.getContentLength());
            }
        }catch(MalformedURLException ex){
            System.err.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}