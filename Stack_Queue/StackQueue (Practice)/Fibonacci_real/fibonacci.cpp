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

};

int main()
{
    Stack_Array stk;
    int n;
    cin>> n;
    if(n<3)
        cout<< 1;
    else
    {
        int i,j,c,k;
        i=1;
        j=1;
        c=2;
        stk.push(1);
        stk.push(1);
        while(c<n)
        {
            k= i+j;
            stk.push(k);
            i= j;
            j= k;
            c++;
        }
        cout<< n<< "th fibonacci number:"<< stk.pop()<< endl;
    }

}
