#include<iostream>
#include<cstdlib>
#include<ctime>

using namespace std;

void Merge(int arr[], int first, int mid, int last)
{
    int n1= mid-first+1;
    int n2= last- mid;
    int arr1[n1];
    int arr2[n2];
    for(int i=0; i< n1; i++)
        arr1[i]= arr[first+i];
    for(int i=0; i<n2; i++)
        arr2[i]= arr[mid+1+i];
    int i, j, k;
    i=j=0;
    k= first;
    while(i<n1 && j<n2)
    {
        if(arr1[i]<= arr2[j])
        {
            arr[k]= arr1[i];
            i++;
        }
        else
        {
            arr[k]= arr2[j];
            j++;
        }
        k++;
    }
    while(i< n1)
    {
        arr[k]= arr1[i];
        i++;
        k++;
    }
    while(j< n2)
    {
        arr[k]= arr2[j];
        j++;
        k++;
    }
}

void MergeSort(int arr[], int first, int last)
{
    if(first>=last)
        return;
    int mid= first+ (last- first)/2;
    MergeSort(arr, first, mid);
    MergeSort(arr, mid+1, last);
    Merge(arr, first, mid, last);
}

int Partition(int arr[], int first, int last)
{
    int t, pivot, pIndex;
    pivot= arr[last];
    pIndex= first;
    for(int i=first; i<last; i++)
    {
        if(arr[i]<= pivot)
        {
            t= arr[i];
            arr[i]= arr[pIndex];
            arr[pIndex]= t;
            pIndex++;
        }
    }
    arr[last]= arr[pIndex];
    arr[pIndex]= pivot;
    return pIndex;
}

void QuickSort(int arr[], int first, int last)
{
    if(first>= last)
        return;
    int pIndex;
    pIndex= Partition(arr, first, last);
    QuickSort(arr, first, pIndex- 1);
    QuickSort(arr, pIndex+1, last);
}


int main()
{
    while(1)
    {
        int n, order,  diff;
        cout<< "Enter total number: ";
        cin>> n;
        cout<< "Enter 1 for ascending, 2 for descending, 3 for random & 4 to quit: ";
        cin>> order;
        int arr[n], arr1[n];
        diff= rand()%1000;
        if(order== 4)
            exit(0);
        if(order== 1)
        {

            for(int i=rand()%100000, j=0; j<n; j++, i= i+diff)
            {
                arr[j]= i;
                arr1[j]= i;
            }
        }
        else if(order== 2)
        {
            for(int i=100000+ rand()%100000,j=0; j<n; i= i-diff, j++)
            {
                arr[j]= i;
                arr1[j]= i;
            }
        }
        else
        {
            for(int i=0; i<n; i++)
            {
                int k= rand()%1000000;
                arr[i]= k;
                arr1[i]= k;
            }
        }
        ///MergeSort
        clock_t mtime= clock();
        MergeSort(arr, 0, n-1);
        cout<< "For sorting "<< n<< " numbers MergeSort needs :"<< (float(clock()- mtime)/CLOCKS_PER_SEC)*1000 << " milliseconds\n";
        ///QuickSort
        clock_t qtime= clock();
        QuickSort(arr1, 0, n-1);
        cout<< "For sorting "<< n<< " numbers QuickSort needs :"<<(float(clock()- qtime)/CLOCKS_PER_SEC)*1000<< " milliseconds\n";

        for(int i=0; i< n; i++)
            cout<< arr[i]<< "   " << arr1[i]<< endl;
        cout<< endl;

    }
}

