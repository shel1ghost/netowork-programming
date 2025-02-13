//WAP that compare the domain name same or not (www.nepalstock.com.np and nepalstock.com)
import java.net.*;

public class Lab8{
    public static void main(String[] args){
        try{
            InetAddress address1 = InetAddress.getByName("www.nepalstock.com.np");
            InetAddress address2 = InetAddress.getByName("nepalstock.com.np");
            if(address1.equals(address2)){
                System.out.println("www.nepalstock.com.np is same as www.nepalstock.com");
            }else{
                System.out.println("www.nepalstock.com.np is not same as www.nepalstock.com");
            }
        }catch(UnknownHostException ex){
            System.out.println(ex);
        }
    }
}