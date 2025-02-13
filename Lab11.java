//WAP to check remote system is reachable or not 
import java.net.*;
import java.io.IOException;

public class Lab11{
    public static boolean isReachable(String host, int timeout){
        try{
            InetAddress address = InetAddress.getByName(host);
            return address.isReachable(timeout);
        }catch(IOException ex){
            System.out.println(ex);
            return false;
        }
    }
    public static void main(String[] args){
        boolean result = isReachable("pascalcollege.edu.np", 10000);
        System.out.println("Host reachable: "+result);
    }
}