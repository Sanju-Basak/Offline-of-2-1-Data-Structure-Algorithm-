package Reverse_of_String;


class Node
{
    char ch;
    Node next;

    Node(char ch)
    {
        this.ch= ch;
        next= null;
    }
}

public class StackofChars {
    private Node first= null;


    public boolean isEmpty()
    {
        return first==null;
    }

    public void push(char ch)
    {
        Node newNode= new Node(ch);
        newNode.next= first;
        first= newNode;

    }
    public char pop()
    {
        char ch= first.ch;
        first= first.next;
        return ch;
    }

}


