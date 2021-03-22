package Double;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        Scanner scn1= new Scanner(System.in);
        n= scn1.nextInt();
        DLL dll= new DLL();
        dll.setNum_player(n);
        Scanner scn= new Scanner(System.in);
        String str= scn.nextLine();
        String[] str1= str.split(" ");
        for(int i=0; i< str1.length; i++ )
        {
            int s= Integer.parseInt(str1[i]);
            DLLNode d= new DLLNode(s, i+1, null, null);
            dll.insertAtLast(d);

        }
        int c= dll.getNum_player();

        while (true)
        {
            Scanner scn2= new Scanner(System.in);
            String str2= scn.nextLine();
            String[] str3= str2.split(" ");
            if(dll.getNum_player()==1)
            {
                DLLNode dllNode= dll.showCurrent(Integer.parseInt(str3[0]));
                System.out.println("Game Over : Player "+ dllNode.getPlayer()+ " wins!!");
                break;
            }
            else if(str3[1].equals("F"))
            {
                //print current sequence
                DLLNode dllNode= dll.showCurrent(Integer.parseInt(str3[0]));
                System.out.print("Game Over : Player "+  dllNode.getPlayer() + " is holding the pillow at t= "+ Integer.parseInt(str3[0])+ ", pillow passing sequence = Player " );
                dll.printFirstToLast();
                break;
            }
            else if(str3[1].equals("M"))
            {
                //eliminate holder
                //print who is eliminated
                DLLNode dllNode= dll.remove(Integer.parseInt(str3[0]));
                System.out.println("Player " + dllNode.getPlayer() + " has been eliminated at t= " +Integer.parseInt(str3[0]));
            }
            else if(str3[1].equals("R"))
            {
                //Reverse direction
                dll.reverseDirection(Integer.parseInt(str3[0]));
            }
            else if(str3[1].equals("P"))
            {
                //print current holder
                DLLNode dllNode= dll.showCurrent(Integer.parseInt(str3[0]));
                System.out.println("Player "+  dllNode.getPlayer() + " is holding the pillow at t= "+ Integer.parseInt(str3[0]));

            }
            else if(str3[1].equals("I"))
            {
                //add new node
                c++;
                dll.insertNew(Integer.parseInt(str3[0]), Integer.parseInt(str3[2]), c);
            }

        }
    }
}
