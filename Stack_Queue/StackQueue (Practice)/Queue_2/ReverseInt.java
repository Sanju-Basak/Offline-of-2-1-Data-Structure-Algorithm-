package Queue_2;

import java.util.Scanner;

public class ReverseInt {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        Queue_of_int queue_of_int= new Queue_of_int();
        int n= scn.nextInt();
        while(n!=0)
        {
            queue_of_int.enqueue(n%10);
            n= n/10;
        }
        while (!queue_of_int.isEmpty())
            System.out.print(queue_of_int.dequeue());
        System.out.println();
    }
}

