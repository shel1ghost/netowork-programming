//WAP to implement the concept on Data Conversion

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

public class Lab3{
    public static void main(String[] args){
        try{
            ByteBuffer bf = ByteBuffer.allocate(8);
            bf.asIntBuffer().put(10).put(20);
            System.out.println("Original ByteBuffer: ");
            for(int i=0; i<2; i++){
                System.out.print(bf.getInt()+" ");
            }
            System.out.println();
            bf.rewind();
            int value1 = bf.getInt();
            System.out.println("Byte value: "+value1);
            int value2 = bf.getInt();
            System.out.println("Byte value: "+value2);
        }catch(BufferUnderflowException ex){
            System.err.println(ex);
        }
    }
}