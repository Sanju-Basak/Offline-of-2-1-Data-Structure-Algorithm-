package Queue;

import java.util.Scanner;

public class NewString {

    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        String str= scn.next();
        int j=0,c=0;
        while(j< str.length())
        {
            MyQueue queue= new MyQueue();
            int []freq= new int[26];
            for(int i=0; i<=j; i++)
            {

                queue.enqueue(str.charAt(i));
                freq[str.charAt(i)- 'a']++;
            }
            while (!queue.isEmpty())
            {

                if(freq[queue.peek()- 'a']>1)
                    queue.remove();
                else
                {
                    c=1;
                    System.out.print(queue.dequeue());
                    break;
                }

            }
            if(queue.isEmpty() && c==0)
                System.out.print('#');
            j++;
            c=0;
        }

    }

}
