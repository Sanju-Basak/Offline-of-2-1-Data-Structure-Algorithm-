import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        BST bst= new BST();
        while (true)
        {
            System.out.println("Menu: ");
            System.out.println("1. Insert Item");
            System.out.println("2. Search Item");
            System.out.println("3. Get In Order Successor");
            System.out.println("4. Get In Order Predecessor");
            System.out.println("5. Delete Item");
            System.out.println("6. Get Item Depth");
            System.out.println("7. Get Max Item");
            System.out.println("8. Get Min Item");
            System.out.println("9. Get Height");
            System.out.println("10. Print In order");
            System.out.println("11. Print Pre Order");
            System.out.println("12. Print Post Order");
            System.out.println("13. Get Size");
            System.out.println("14. Exit");
            Scanner scn= new Scanner(System.in);
            int n= scn.nextInt();
            if(n==1)
            {
                //insertItem
                System.out.print("Enter Node value:");
                Scanner scn1= new Scanner(System.in);
                int i= scn1.nextInt();
                bst.insertItem(i);
            }
            else if(n==2)
            {
                //searchItem
                System.out.print("Enter Node value:");
                Scanner scn1= new Scanner(System.in);
                int i= scn1.nextInt();
                if(bst.searchItem(i))
                    System.out.println(i + " has been found");
                else
                    System.out.println(i+ " has not been found");
            }
            else if(n==3)
            {
                //getInOrderSuccessor
                System.out.print("Enter Node value:");
                Scanner scn1= new Scanner(System.in);
                int i= scn1.nextInt();
                int c= bst.getInOrderSuccessor(i);
                if(c== -1)
                    System.out.println("No Successor");
                else
                    System.out.println("The Successor of " + i+ " is: "+ c);
            }
            else if(n==4)
            {
                //getInOrderPredecessor
                System.out.print("Enter Node value:");
                Scanner scn1= new Scanner(System.in);
                int i= scn1.nextInt();
                int c= bst.getInOrderPredecessor(i);
                if(c== -1)
                    System.out.println("No Predecessor");
                else
                    System.out.println("The Predecessor of " + i+ " is: "+ c);
            }
            else if(n==5)
            {
                //deleteItem
                System.out.print("Enter Node value:");
                Scanner scn1= new Scanner(System.in);
                int i= scn1.nextInt();
                bst.deleteItem(i);

            }
            else if(n==6)
            {
                //getItemDepth
                System.out.print("Enter Node value:");
                Scanner scn1= new Scanner(System.in);
                int i= scn1.nextInt();
                System.out.println("Item depth is : "+ bst.getItemDepth(i));

            }
            else if(n==7)
            {
                //getMaxItem
                //withoutRecursive
                System.out.println("Max Item is: " + bst.getMaxItem());
            }
            else if(n==8)
            {
                //getMinItem
                //withoutRecursive
                System.out.println("Min Item is: " + bst.getMinItem());

            }
            else if(n==9)
            {
                //getHeigth
                System.out.println("The height of the tree is : " + bst.getHeight());
            }
            else if(n==10)
            {
                //printInOrder
                System.out.println("In order of the tree:");
                bst.printInOrder();
            }
            else if(n==11)
            {
                //printPreOrder
                System.out.println("Pre order of the tree:");
                bst.printPreOrder();
            }
            else if(n==12)
            {
                //printPostOrder
                System.out.println("Post order of the tree:");
                bst.printPostOrder();
            }
            else if(n==13)
            {
                //getSize
                //withRecursion
                System.out.println("The Size of the Tree is: " + bst.getSize());
            }

            else
                break;
        }

    }
}
