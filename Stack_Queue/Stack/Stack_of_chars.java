package Stack;

public class Stack_of_chars {
    private char[] ch;
    private int capacity;
    private int top;
    Stack_of_chars()
    {
        ch= new char[10];
        capacity= 10;
        top= -1;
    }

    public void resize(int max)
    {
        char [] dup= new char[max];
        for(int i=0; i< top+1; i++)
            dup[i]= ch[i];
        ch= dup;
        capacity= max;
    }

    public boolean isEmpty()
    {
        return top==-1;
    }

    public void push(char ch1)
    {
        if(top== capacity-1)
            resize(capacity*2);
        top++;
        ch[top]= ch1;
    }

    public char pop()
    {
        if(top+1== ch.length/4)
            resize(capacity/2);
        char ch1= ch[top];
        top--;
        return ch1;
    }

    public char display()
    {
        return ch[top];
    }

    public void remove()
    {
        top--;
    }


}
