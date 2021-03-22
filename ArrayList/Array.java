public class Array {

    private String str[];
    private int arrsize;
    private int listsize;
    private void resize()
    {
        String temp[]= new String[arrsize* 2];
        for(int i=0; i<arrsize; i++)
            temp[i]= str[i];
        str= temp;
        arrsize= 2* arrsize;
    }
    private Boolean needtoresize()
    {
        return arrsize==listsize;
    }
    Array()
    {
        str= new String[10];
        arrsize= 10;
        listsize= 0;
    }

    Array(int n)
    {
        str= new String[n];
        arrsize= n;
        listsize= 0;
    }

    Array(String A[])
    {
        str= new String[A.length];
        arrsize= A.length;
        listsize= A.length;
        for(int i=0; i<listsize; i++)
            str[i]= A[i];
    }

    public Array getArray()
    {
        return this;
    }

    public String getAnElement(int i)
    {
        if(i>=0 && i<listsize)
            return str[i];
        else
            return null;
    }

    public void add(String element)
    {
        if(needtoresize())
            resize();
        str[listsize]= element;
        listsize++;
    }

    public void add(int index,String element)
    {
        if(index<0 || index>listsize)
        {
            System.out.println("Invalid array index");
            return;
        }
        if(needtoresize())
            resize();
        for(int i= listsize; i>index; i--)
        {
            str[i]= str[i-1];
        }
        str[index]= element;
        listsize++;
    }

    public void remove(String element)
    {
        for(int i=0; i<listsize; i++)
        {
            if(str[i]== element)
            {
                for(int j=i; j<listsize-1; j++)
                    str[j]= str[j+1];
                listsize--;
                i--;
            }
        }

    }
    public int length()
    {
        return listsize;
    }

    public int[] findindex(String element)
    {
        int i,j;
        int arr[]= new int[listsize+ 1];
        for(i=0,j=0; i<listsize; i++) {
            if (str[i] == element) {
                arr[j] = i;
                j++;
            }
        }
        arr[j]= -1;
        return arr;
    }

    public Array subArray(int start, int end)
    {
        if(start<0 || start>listsize-1 || end<0 || end>listsize-1 || end<start)
        {
            System.out.println("Index error! You will get the main array");
            return this;
        }
        Array a1= new Array(end-start+1);
        for(int i=0; i<end-start+1; i++)
            a1.add(str[start+i]);
        return a1;
    }
    public boolean isEmpty()
    {
        if(listsize==0)
            return true;
        else
            return false;
    }

    public Array merge(String A1[], String A2[]) {
        Array array = new Array(A1.length + A2.length);
        int i=0, j=0;
        while (true){
            if (i >= A1.length) {
                for (; j < A2.length; j++)
                    array.add(A2[j]);
                break;
            }
            if (j >= A2.length) {
                for (; i < A1.length; i++)
                    array.add(A1[i]);
                break;
            }
            else if (A1[i].compareTo(A2[j]) <= 0) {
                array.add(A1[i]);
                i++;
            } else if (A2[j].compareTo(A1[i]) <= 0) {
                array.add(A2[j]);
                j++;
            }
        }
        return array;
    }

}
