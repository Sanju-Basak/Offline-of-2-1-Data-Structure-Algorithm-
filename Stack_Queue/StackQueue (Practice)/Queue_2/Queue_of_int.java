package Queue_2;

class Node{
    int n;
    Node next;

    Node(int n)
    {
        this.n= n;
        next= null;
    }
}


public class Queue_of_int {
    private Node first= null, last= null;

    public void enqueue(int n){
        Node newNode= new Node(n);
        if(first==null)
            first=last= newNode;
        else
        {
            last.next= newNode;
            last= newNode;
        }
    }

    public int dequeue()
    {
        int n= first.n;
        first= first.next;
        return n;
    }
    public boolean isEmpty()
    {
        return first==null;
    }

}
