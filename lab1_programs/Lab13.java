//WAP to process web server logfiles.

import java.net.*;
import java.io.*;

public class Lab13{
    public static void main(String[] args){
        try{
            FileInputStream fin = new FileInputStream(args[0]);
            Reader in = new InputStreamReader(fin);
            BufferedReader bin = new BufferedReader(in);
            for(String entry = bin.readLine(); entry != null; entry = bin.readLine()){
                int index = entry.indexOf(' ');
                String ip = entry.substring(0, index);
                String theRest = entry.substring(index);
                try{
                    InetAddress address = InetAddress.getByName(ip);
                    System.out.println(address.getHostName()+theRest);
                }catch(UnknownHostException ex1){
                    System.out.println(ex1);
                }
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}