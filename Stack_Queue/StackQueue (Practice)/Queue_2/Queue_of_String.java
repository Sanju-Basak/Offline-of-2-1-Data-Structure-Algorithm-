package Queue_2;

class Node1{
    String str;
    Node1 next;

    Node1(String str)
    {
        this.str= str;
        next= null;
    }
}


public class Queue_of_String {
    private Node1 first= null, last= null;

    public void enqueue(String str){
        Node1 newNode= new Node1(str);
        if(first==null)
            first=last= newNode;
        else
        {
            last.next= newNode;
            last= newNode;
        }
    }

    public String dequeue()
    {
        String str1= first.str;
        first= first.next;
        return str1;
    }
    public boolean isEmpty()
    {
        return first==null;
    }

}

