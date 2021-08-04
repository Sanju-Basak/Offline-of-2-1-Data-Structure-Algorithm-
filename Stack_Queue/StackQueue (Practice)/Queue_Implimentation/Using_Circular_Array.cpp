#include<iostream>
using namespace std;

class Queue_Array
{
    int capacity=10;
    int first= -1;
    int last= -1;
    int *arr= new int[10];
public:
    void enqueue(int x)
    {
        if(first==-1 && last==-1)
        {
            first=last=0;
            arr[first]= x;
        }
        else if((last+1)%capacity==first)
        {
            cout<< "Queue is full!";
        }
        else
        {
            last= (last+1)%capacity;
            arr[last]= x;
        }
    }
    int dequeue()
    {
        if(first==-1 && last==-1)
        {
            cout<< "Queue is empty!";
            exit(1);
        }
        else if(first== last)
        {
            int x= arr[first];
            first= -1, last= -1;
            return x;
        }
        else
        {
            int x= arr[first];
            first= (first+1)%capacity;
            return x;
        }
    }
    int peek()
    {
        if(first==-1)
        {
            cout<< "Queue is empty!";
            exit(1);
        }
        return arr[first];
    }
};



int main()
{
    Queue_Array que;
    for(int i=0; i< 10; i++)
        que.enqueue(i+1);
    for(int i=0; i<5; i++)
        cout<< que.dequeue()<< " ";
    cout<< endl;
    for(int i=0; i<2; i++)
        que.enqueue(i+1);
    for(int i=0; i<7; i++)
        cout<< que.dequeue()<< " ";
    cout<< que.dequeue();

}
