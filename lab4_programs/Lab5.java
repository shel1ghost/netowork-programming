//WAP to print the URL of URL Connections to hafoss.edu.np

import java.net.*;
import java.io.*;

public class Lab5{
    public static void main(String[] args){
        try{
            URL u = new URL("https://fohss.tu.edu.np/");
            URLConnection uc = u.openConnection();
            System.out.println(uc.getURL());
        }catch(IOException ex){
            System.err.println(ex);
        }
    }
}