//3. WAP to write data to a server

import java.net.*;
import java.io.*;

public class Lab3{
    public static void main(String[] args){
        Socket socket = null;
        try{
            socket = new Socket("dict.org", 2628);
            socket.setSoTimeout(15000);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            for(String word: args){
                define(word, writer, reader);
            }
            writer.write("quit\r\n");
            writer.flush();
        }catch(IOException ex){
            System.err.println(ex);
        }finally{
            if(socket != null){
                try{
                    socket.close();
                }catch(IOException ex2){
                    System.err.println(ex2);
                }
            }
        }
    }

    static void define(String word, Writer writer, BufferedReader reader)throws IOException, UnsupportedEncodingException{
        writer.write("DEFINE eng-lat "+word+"\r\n");
        writer.flush();
        for(String line = reader.readLine(); line != null; line=reader.readLine()){
            if(line.startsWith("250")){
                return;
            }else if(line.startsWith("552")){
                System.out.println("No defination found for word "+word);
                return;
            }else if(line.matches("\\d\\d\\d .*")){
                continue;
            }else if(line.trim().equals(".")){
                continue;
            }else{
                System.out.println(line);
            }
        }
    }
}