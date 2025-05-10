import java.net.*;
import java.nio.*;

public class Test{
  public static void main(String[] args){
    CharBuffer b1 = CharBuffer.wrap("12345678");
    CharBuffer b2 = CharBuffer.wrap("5678");
    b1.get();
    b1.get();
    b1.get();
    b1.get();    
    System.out.println(b1.equals(b2));
  }
}
