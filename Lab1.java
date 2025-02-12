//Write a program that prints the address of https://pascalcollege.edu.np
import java.net.*;
public class Lab1{
    public static void main(String[] args){
        try{
            InetAddress address = InetAddress.getByName("www.pascalcollege.edu.np");
            System.out.println(address);
        }catch(UnknownHostException ex){
            System.out.println(ex);
        }
    }
}