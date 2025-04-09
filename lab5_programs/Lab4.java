//WAP to find out which of the first 1024 ports seem to be hosting TCP servers on a specified host (LowPort Scanner)
import java.net.*;
import java.io.*;

public class Lab4{
    public static void main(String[] args){
        for(int port=10; port<=1024; port++){
            try{
                Socket socket = new Socket("127.0.0.1", port);
                System.out.println("Open port: "+port);
            }catch(IOException ex){
                //must not be a server on this port
            }
        }
    }
}