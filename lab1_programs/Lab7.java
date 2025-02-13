//WAP for testing the characteristics of an IP address 

import java.net.*;

public class Lab7{
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getByName(args[0]);
            if(address.isAnyLocalAddress()){
                System.out.println(address+" is wildcard address.");
            }
            if(address.isLoopbackAddress()){
                System.out.println(address+" is loopback address.");
            }
            if(address.isLinkLocalAddress()){
                System.out.println(address+" is a link local address.");
            }
            if(address.isSiteLocalAddress()){
                System.out.println(address+" is a site-local address.");
            }
            if(address.isMulticastAddress()){
                System.out.println(address+" is a multicast address.");
            }
            if(address.isMCGlobal()){
                System.out.println(address+" is a global multicast address.");
            }
            if(address.isMCNodeLocal()){
                System.out.println(address+" is an interface local multicast address.");
            }
            if(address.isMCLinkLocal()){
                System.out.println(address+" is a subnet-wide address.");
            }
            if(address.isMCSiteLocal()){
                System.out.println(address+" is a site-wide multicast address.");
            }
            if(address.isMCOrgLocal()){
                System.out.println(address+" is an organization wide multicast address.");
            }
        }catch(UnknownHostException ex){
            System.out.println(ex);
        }
    }
}