#include<iostream>
#include<algorithm>
using namespace std;

int mincost(int arr[], int n, int k)
{
    sort(arr, arr + n, greater<int>());
    int c=1, sum=0;
    for(int i=0; i<n; i++)
    {
        sum= sum+ c* arr[i];
        if((i+1)%k==0)
            c++;
    }
    return sum;
}

int main()
{
    int n,k;
    cin>> n>> k;
    int arr[n],t;
    for(int i=0; i<n; i++)
        cin>> arr[i];
    cout<< "Total cost: "<< mincost(arr, n, k);
}
