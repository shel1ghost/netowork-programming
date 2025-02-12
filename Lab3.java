//WAP to find the canonical hostname of given address
import java.net.*;
public class Lab3{
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address.getCanonicalHostName());
        }catch(UnknownHostException ex){
            System.out.println(ex);
        }
    }
}
