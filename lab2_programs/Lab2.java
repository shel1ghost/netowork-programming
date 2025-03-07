//2. WAP that checks which protocols does a vitural machine support or not?

import java.net.*;
import java.util.*;

public class Lab2{
    public static void main(String[] args){
        String[] protocols = {"http", "https", "ftp", "sftp"};
        for (String protocol : protocols) {
            try {
                URI testUri = new URI(protocol + "://127.0.0.1");
                // Use the default ProxySelector to check the protocol
                List<Proxy> proxies = ProxySelector.getDefault().select(testUri);
                // If the ProxySelector returns a non-empty list, the protocol is supported
                System.out.println(protocol + " is supported: " + !proxies.isEmpty());
            } catch (Exception e) {
                System.out.println(protocol + " is not supported.");
            }
        }
    }
}