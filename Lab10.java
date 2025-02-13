//WAP that use of network interfaces getter methods
import java.net.*;
import java.util.*;

public class Lab10{
    public static void main(String[] args) throws SocketException{
        NetworkInterface wlp1s0 = NetworkInterface.getByName("wlp1s0");
        Enumeration address = wlp1s0.getInetAddresses();
        while(address.hasMoreElements()){
            System.out.println(address.nextElement());
        }
        String wlp1s0_name = wlp1s0.getName();
        System.out.println("The interface name is "+wlp1s0_name);
        String wlp1s0_display_name = wlp1s0.getDisplayName();
        System.out.println("The interface display name is "+wlp1s0_display_name);

    }
}