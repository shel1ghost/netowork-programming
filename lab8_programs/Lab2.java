/*WAP to implement the concept on Filling and Draining buffer, Duplicating buffer, Slicing
buffer, Compact buffer*/

import java.net.*;
import java.io.*;
import java.nio.*;

public class Lab2{
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //creating a buffer with an integer array
        IntBuffer bf = IntBuffer.wrap(numbers);
        //displaying the elements in the buffer (draining)
        System.out.println("The elements in buffer created from an array are: ");
        while(bf.hasRemaining()){
            System.out.print(bf.get()+" ");
        }
        System.out.println();

        //filling a buffer
        CharBuffer bf2 = CharBuffer.allocate(5);
        bf2.put('S');
        bf2.put('H');
        bf2.put('I');
        bf2.put('V');
        bf2.put('A');
        
        //printing the filled buffer data items (draining)
        bf2.flip();
        System.out.println("The filled buffer data are: ");
        while(bf2.hasRemaining()){
            System.out.print(bf2.get());
        }
        System.out.println();

        //duplicating
        IntBuffer bf3 = bf.duplicate();
        bf3.position(0);
        System.out.println("The duplicate buffer elements are: ");
        while(bf3.hasRemaining()){
            System.out.print(bf3.get() + " ");
        }
        System.out.println();
        /*When you duplicate a buffer using the duplicate() method, the duplicate 
        shares the same position, limit, and mark as the original at the time of 
        duplication. In the example, the original buffer had already been read to 
        the end, so its position was at the limit. Consequently, the duplicate 
        buffer also had the same position, meaning it wouldn't display any remaining 
        elements unless its position was reset.*/

        //slicing buffer
        // Set position and limit to define the range for slicing
        bf.position(2);
        bf.limit(7);
        IntBuffer bf4 = bf.slice();
        System.out.println("The sliced buffer elements are: ");
        while(bf4.hasRemaining()){
            System.out.print(bf4.get()+ " ");
        }
        System.out.println();

        //compacting buffer: Moves all the unread elements to the beginning of the buffer.
        int[] numbers2 = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        IntBuffer bf5 = IntBuffer.wrap(numbers2);
        System.out.println("Reading buffer before compacting: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(bf5.get()+" "); //prints upto 50
        }
        // Compact the buffer
        bf5.compact();

        System.out.println();
        // Display the compacted buffer's elements
        System.out.println("Compacted buffer:");
        while (bf5.hasRemaining()) {
            System.out.print(bf5.get() + " "); //prints data after 50 i.e 60, 70, 80 ...
        }
        
    }
}