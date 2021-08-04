package N_Factorial;

class Node
{
    int n;
    Node next;

    Node(int n)
    {
        this.n= n;
        next= null;
    }
}

public class StackofInts {
    private Node first= null;


    public boolean isEmpty()
    {
        return first==null;
    }

    public void push(int i)
    {
        Node newNode= new Node(i);
        newNode.next= first;
        first= newNode;

    }
    public int pop()
    {
        int n= first.n;
        first= first.next;
        return n;
    }

}
