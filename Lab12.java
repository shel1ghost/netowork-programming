//WAP to demonstrate the spamcheck

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab12 {

    public static void main(String[] args) {
        String ipAddress = "207.34.56.23";
        String blackholeServiceDomain = "sbl.spamhaus.org";
        
        try {
            boolean isSpammer = checkIfSpammer(ipAddress, blackholeServiceDomain);
            if (isSpammer) {
                System.out.println(ipAddress + " is a known spammer.");
            } else {
                System.out.println(ipAddress + " is not a known spammer.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Error checking IP address: " + e.getMessage());
        }
    }

    public static boolean checkIfSpammer(String ipAddress, String domain) throws UnknownHostException {
        String reversedIp = reverseIpBytes(ipAddress);
        String lookupHost = reversedIp + "." + domain;

        InetAddress address = InetAddress.getByName(lookupHost);
        return address != null;
    }

    public static String reverseIpBytes(String ipAddress) {
        String[] bytes = ipAddress.split("\\.");
        return bytes[3] + "." + bytes[2] + "." + bytes[1] + "." + bytes[0];
    }
}


