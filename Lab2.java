//WAP that finds local addresss of the local machine
import java.net.*;
public class Lab2{
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getLocalHost();
            System.out.println(address);
        }catch(UnknownHostException ex){
            System.out.println(ex);
        }
    }
}