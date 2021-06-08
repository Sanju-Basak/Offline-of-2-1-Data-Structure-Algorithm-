#include<iostream>

using namespace std;

class Heap
{
    int *arr;
    int heap_size;
public:
    Heap(int n);
    void insert(int n);
    int size();
    int getMax();
    void deleteKey();
    void heapify_up(int index);
    void heapify_down(int *arr, int size1, int index);

};

Heap::Heap(int n)
{
    arr= new int[n +1];
    heap_size= 0;
}

int Heap::size()
{
    return heap_size;
}

void Heap::heapify_down(int *arr, int size1, int i)
{
    int max1= i;
    int left= 2*i;
    int right= 2*i +1;
    if(left<= size1 && arr[i]< arr[left])
        max1= left;
    if(right<= size1 && arr[max1]< arr[right])
        max1= right;
    if(max1 != i)
    {
        int temp= arr[i];
        arr[i]= arr[max1];
        arr[max1]= temp;
        heapify_down(arr, size1, max1);
    }

}

void Heap::heapify_up(int i)
{
    while(i>1)
    {
       if(arr[i/2]< arr[i])
       {
           int temp= arr[i];
           arr[i]= arr[i/2];
           arr[i/2]= temp;
           i= i/2;
       }
       else
        return;
    }
}

void Heap::insert(int n)
{
    heap_size++;
    arr[heap_size]= n;
    heapify_up(heap_size);
}

int Heap::getMax()
{
    return arr[1];
}

void Heap::deleteKey()
{
    arr[1]= arr[heap_size];
    heap_size--;
    heapify_down(arr,heap_size, 1);
}

void heapsort(vector<int>&v)
{
    int n;
    n= v.size();
    Heap h(n);
    int *arr1;
    arr1= new int[n+1];
    for(int i=1; i<v.size()+1; i++)
        arr1[i]= v[i-1];
    for(int i= n/2 ; i>= 1; i--)
        h.heapify_down(arr1, n, i);
    for(int i= n; i>1; i--)
    {
        int temp= arr1[1];
        arr1[1]= arr1[i];
        arr1[i]= temp;
        h.heapify_down(arr1, i-1, 1);
    }
    for(int i= n, j=0; i>0; i--, j++)
    {
        v[j]= arr1[i];
    }

}

