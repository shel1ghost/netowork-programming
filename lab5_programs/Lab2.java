//2. WAP to construct a Date by talking to time.nist.gov

/*InputStreamReader is focused on character decoding from byte streams.

BufferedReader is designed to improve reading performance by buffering data and providing convenient methods like readLine().*/

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.*;

public class Lab2{
    public static void main(String[] args){
        try{
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(8000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for(int i = reader.read(); i != -1; i=reader.read()){
                time.append((char)i);
            }
            Date date = parseDate(time.toString());
            System.out.println(date);
            System.out.println(time);
        }catch(IOException ex){
            System.err.println(ex);
        }catch(ParseException ex2){
            System.err.println(ex2);
        }
    }

    static Date parseDate(String s) throws ParseException{
        String[] pieces = s.split(" ");
        String dateTime = pieces[1]+" "+pieces[2]+" UTC";
        DateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
        return format.parse(dateTime);
    }
}