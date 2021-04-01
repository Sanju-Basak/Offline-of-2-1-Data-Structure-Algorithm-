package Stack;

public class Stack_of_doubles {
    private double[] db;
    private int capacity;
    private int top;
    Stack_of_doubles()
    {
        db= new double[10];
        capacity= 10;
        top= -1;
    }

    public void resize(int max)
    {
        double [] dup= new double[max];
        for(int i=0; i< top+1; i++)
            dup[i]= db[i];
        db= dup;
        capacity= max;
    }

    public int getTop()
    {
        return top;
    }

    public boolean isEmpty()
    {
        return top==-1;
    }

    public void push(double db1)
    {
        if(top== capacity-1)
            resize(capacity*2);
        top++;
        db[top]= db1;
    }

    public double pop()
    {
        if(top+1== db.length/4)
            resize(capacity/2);
        double db1= db[top];
        top--;
        return db1;
    }

    public double display()
    {
        return db[top];
    }



}

