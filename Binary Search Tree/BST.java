
class Node
{
    int value;
    Node left, right;
    Node(int value)
    {
        this.value= value;
        left= null;
        right= null;
    }

}

public class BST {
    Node root= new Node(-1);

    public void insertItem(int value)
    {
        Node nd= new Node(value);
        Node temp= root;
        while(true)
        {
            if(temp.value== -1)
            {
                temp.value= value;
                break;
            }
            else if(nd.value< temp.value)
            {
                if(temp.left== null)
                {
                    temp.left= nd;
                    break;
                }
                else
                    temp= temp.left;

            }
            else if(nd.value> temp.value)
            {
                if(temp.right== null)
                {
                    temp.right= nd;
                    break;
                }
                else
                    temp= temp.right;
            }


        }
    }

    public boolean searchItem(int value)
    {
        Node temp= root;
        while(true)
        {
            if(temp.value== value)
                return true;
            else if(value< temp.value)
                temp= temp.left;
            else if(value> temp.value)
                temp = temp.right;
            if(temp == null)
                return false;
        }
    }

    public void printInOrder()
    {
        Node temp= root;
        printInOrder(temp);
        System.out.println();
    }

    private void printInOrder(Node node)
    {
        if(node != null)
        {
            printInOrder(node.left);
            System.out.print(node.value+ " ");
            printInOrder(node.right);
        }
    }

    public void printPreOrder()
    {
        Node temp= root;
        printPreOrder(temp);
        System.out.println();
    }

    private void printPreOrder(Node node)
    {
        if(node != null)
        {
            System.out.print(node.value+ " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printPostOrder()
    {
        Node temp= root;
        printPostOrder(temp);
        System.out.println();
    }

    private void printPostOrder(Node node)
    {
        if(node != null)
        {
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value+ " ");
        }
    }

    public int getMaxItem()
    {
        Node temp= root;
        return getMaxItem(temp);
    }

    private int getMaxItem(Node temp)
    {
        while(temp.right!= null)
            temp= temp.right;
        return temp.value;
    }

    public int getMinItem()
    {
        Node temp= root;
        return getMinItem(temp);
    }

    private int getMinItem(Node temp)
    {
        while(temp.left!= null)
            temp= temp.left;
        return temp.value;
    }

    public int getSize()
    {
        Node temp= root;
        if(temp.value== -1)
            return 0;
        return getSize(temp);
    }

    private int getSize(Node node)
    {
        if(node== null)
            return 0;
        else
            return 1+ getSize(node.left)+ getSize(node.right);
    }

    public int getItemDepth(int value)
    {
        Node temp= root;
        int c=0;
        if(!searchItem(value))
            return -1;
        else if(temp.value== value)
            return c;
        else
        {
            while (temp.value!= value)
            {
                if(value< temp.value)
                {
                    c++;
                    temp= temp.left;
                }
                else
                {
                    c++;
                    temp= temp.right;
                }
            }
            return c;
        }
    }

    public int getHeight()
    {
        Node temp= root;
        if(temp.value== -1)
            return -1;
        else
            return getHeight(temp);
    }

    private int getHeight(Node temp)
    {
        int lh;
        int rh;
        if(temp== null)
            return -1;
        else
        {
            lh= getHeight(temp.left);
            rh= getHeight(temp.right);
            return 1+ (Math.max(lh, rh));
        }
    }

    public int getInOrderSuccessor(int value)
    {
        if(!searchItem(value) || value== getMaxItem())
            return -1;
        else
        {
            Node temp= root;
            while (true)
            {
                if(temp.value== value)
                    break;
                else if(value< temp.value)
                    temp= temp.left;
                else
                    temp= temp.right;
            }
            if(temp.right != null)
                return getMinItem(temp.right);
            else
            {
                temp= root;
                Node successor= null;
                while (true)
                {
                    if(value< temp.value)
                    {
                        successor= temp;
                        temp= temp.left;
                    }
                    else if(value> temp.value)
                        temp= temp.right;
                    else
                        break;
                }
                return successor.value;
            }
        }
    }

    public int getInOrderPredecessor(int value)
    {
        if(!searchItem(value) || value== getMinItem())
            return -1;
        else
        {
            Node temp= root;
            while (true)
            {
                if(temp.value== value)
                    break;
                else if(value< temp.value)
                    temp= temp.left;
                else
                    temp= temp.right;
            }
            if(temp.left != null)
                return getMaxItem(temp.left);
            else
            {
                temp= root;
                Node predecessor= null;
                while (true)
                {
                    if(value< temp.value)
                        temp= temp.left;
                    else if(value> temp.value)
                    {
                        predecessor= temp;
                        temp= temp.right;
                    }
                    else
                        break;
                }
                return predecessor.value;
            }
        }
    }

    public void deleteItem(int value)
    {
        Node temp= root;
        if(temp.value== value && temp.left== null && temp.right== null)
        {
            temp.value= -1;
            return;
        }
        temp= deleteItem(temp, value);
    }

    private Node deleteItem(Node temp, int value)
    {
        if(temp== null)
            return null;
        else if(value== temp.value)
        {
            if(temp.left== null && temp.right== null)
                return null;
            else if(temp.right ==null)
                return temp.left;
            else if(temp.left == null)
                return temp.right;
            else
            {
                int item= getMinItem(temp.right);
                temp.value= item;
                temp.right= deleteItem(temp.right, item);
                return temp;
            }
        }
        else if(value< temp.value)
        {
            temp.left= deleteItem(temp.left, value);
            return temp;
        }
        else
        {
            temp.right= deleteItem(temp.right, value);
            return temp;
        }

    }



}

