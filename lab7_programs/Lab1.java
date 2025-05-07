//WAP for creating secure sockets with fohss.tu.edu.np

import javax.net.ssl.*;
import java.io.*;

public class Lab1{
    public static void main(String[] args){
        SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        try{
            SSLSocket socket = (SSLSocket)factory.createSocket("pascalcollege.edu.np", 443);
            String[] supportedCipherSuite = socket.getSupportedCipherSuites();
            socket.setEnabledCipherSuites(supportedCipherSuite);
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            out.write("GET http://pascalcollege.edu.np/ HTTP/1.1\r\n");
            out.write("Host: pascalcollege.edu.np\r\n");
            out.flush();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response;
            while(!(response = input.readLine()).equals("")){
                System.out.println(response);
            }
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}