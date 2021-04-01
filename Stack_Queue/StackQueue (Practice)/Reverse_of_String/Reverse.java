package Reverse_of_String;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        StackofChars stack= new StackofChars();
        Scanner scn= new Scanner(System.in);
        String str= scn.nextLine();
        for(int i=0; i<str.length(); i++)
            stack.push(str.charAt(i));
        while (!stack.isEmpty())
            System.out.print(stack.pop());

    }
}
