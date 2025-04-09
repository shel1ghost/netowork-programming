//WAP to print entire HTTP header
import java.io.*;
import java.net.*;

public class Lab3 {
    public static void main(String[] args) {
        String resource =" http://127.0.0.1/";
        try {
            URL u = new URL(resource);
            URLConnection uc = u.openConnection();
            for (int j = 1; ; j++) {
            String header = uc.getHeaderField(j);
            if (header == null) break;
            System.out.println(uc.getHeaderFieldKey(j) + ": " +header);

        }
        }catch(MalformedURLException ex) {
            System.err.println(resource + " is not a URL I understand.");

        } catch (IOException ex) {
            System.err.println(ex);

        }

    }

}
