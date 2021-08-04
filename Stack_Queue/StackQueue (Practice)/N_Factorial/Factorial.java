package N_Factorial;

import java.util.Scanner;

public class Factorial{
    public static void main(String[] args) {
        StackofInts stackofInts= new StackofInts();
        Scanner scn= new Scanner(System.in);
        long s=1;
        int n= scn.nextInt();
        int i=n;
        while (i !=0)
        {
            stackofInts.push(i);
            i--;
        }
        while (!stackofInts.isEmpty())
            s= s* stackofInts.pop();
        System.out.println("The "+ n+ "th fibonacci number is: "+ s);
    }
}
