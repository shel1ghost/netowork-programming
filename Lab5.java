//WAP to get IPv4 and IPv6 address of a website
import java.net.*;
public class Lab5{
    public static int getVersion(InetAddress ia){
        byte[] address = ia.getAddress();
        if(address.length == 4){
            return 4;
        }else if(address.length == 6){
            return 6;
        }else{
            return -1;
        }
    }
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getByName("www.pascalcollege.edu.np");
            int version = getVersion(address);
            System.out.println(version);
        }catch(UnknownHostException ex){
            System.out.println(ex);
        }
    }
}