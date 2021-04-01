package Queue_2;

import java.util.Scanner;

public class Binary {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        Queue_of_String queue_of_string= new Queue_of_String();
        int n= scn.nextInt();
        int i=1;
        while(i<= n+1)
        {
            if(i==1)
                queue_of_string.enqueue(String.valueOf(i));
            else
            {
                String str= queue_of_string.dequeue();
                queue_of_string.enqueue(str+ "0");
                queue_of_string.enqueue(str+ "1");
                System.out.print(str+ " ");
            }
            i++;
        }
    }
}


