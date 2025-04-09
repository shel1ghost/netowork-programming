//WAP to get the time when a URL was last changed

import java.net.*;
import java.io.*;
import java.util.*;

public class Lab6{
    public static void main(String[] args) throws MalformedURLException, IOException{
        URL u = new URL("http://127.0.0.1/");
        URLConnection uc = u.openConnection();
        System.out.println(new Date(uc.getLastModified()));
    }
}