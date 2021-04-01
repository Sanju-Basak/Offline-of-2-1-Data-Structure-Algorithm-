package Queue;

class Node{
    char ch;
    Node next;

    Node(char ch)
    {
        this.ch= ch;
        next= null;
    }
}


public class MyQueue {
    private Node first= null, last= null;

    public void enqueue(char ch){
        Node newNode= new Node(ch);
        if(first==null)
            first=last= newNode;
        else
        {
            last.next= newNode;
            last= newNode;
        }
    }

    public char dequeue()
    {
        char ch= first.ch;
        first= first.next;
        return ch;
    }
    public boolean isEmpty()
    {
        return first==null;
    }

    public char peek()
    {
        return first.ch;
    }

    public void remove()
    {
        first= first.next;
    }

}
