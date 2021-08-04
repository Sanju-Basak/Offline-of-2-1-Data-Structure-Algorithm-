#include<iostream>
using namespace std;

class Stack_Array
{
    int capacity;
    int arrsize;
    int *arr;
public:
    Stack_Array()
    {
        arr= new int[10];
        capacity= 10;
        arrsize= 0;
    }
    void resize(int max)
    {
        int *arr1= new int[max];
        for(int i=0; i< arrsize; i++)
            arr1[i]= arr[i];
        arr= arr1;
        capacity= max;

    }
    bool isEmpty()
    {
        return arrsize==0;
    }
    int pop()
    {
        if(arrsize== capacity/4)
            resize(capacity/2);
        return arr[--arrsize];
    }
    void push(int i)
    {
        if(arrsize== capacity)
            resize(2*capacity);
        arr[arrsize++]= i;
    }
    int get_size()
    {
        return arrsize;
    }
    int get_capacity()
    {
        return capacity;
    }

};

int main()
{
    Stack_Array stk;
    int i=0;
    while(i<20)
    {
        stk.push(i+1);
        i++;
    }
    i=0;
    while(i<20)
    {
        cout<< stk.pop()<< " ";
        i++;
    }

}
