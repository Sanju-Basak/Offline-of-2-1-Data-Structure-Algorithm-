public class Main {
    public static void main(String[] args) {
        String[] arr= {"Book", "Hello", "Jemy","World", "World", "Hello", "c++", "java", "World"};
        Array a1= new Array(arr);
        System.out.println("A1 Array elements:");
        for(int i=0; i< a1.length(); i++)
               System.out.print(a1.getAnElement(i)+ " ");
        System.out.println();
        Array a2= new Array();

        //Using isEmpty
        if(a2.isEmpty())
            System.out.println("Array is empty");
        else
            System.out.println("Array is populated");

        //Using getArray
        a2= a1.getArray();
        System.out.println("A2 Array elements:");
        for(int i=0; i< a2.length(); i++)
            System.out.print(a2.getAnElement(i)+ " ");
        System.out.println();

        //Using add
        a2.add("Book");
        System.out.println("After Adding, A2 Array elements:");
        for(int i=0; i< a2.length(); i++)
            System.out.print(a2.getAnElement(i)+ " ");
        System.out.println();
        a2.add(1,"Hello");
        System.out.println("After Adding, A2 Array elements:");
        for(int i=0; i< a2.length(); i++)
            System.out.print(a2.getAnElement(i)+ " ");
        System.out.println();

        //Using remove
        a2.remove("Hello");
        System.out.println("After Removing, A2 Array elements:");
        for(int i=0; i< a2.length(); i++)
            System.out.print(a2.getAnElement(i)+ " ");
        System.out.println();

        //Using findIndex
        int []arr1= a2.findindex("World");
        System.out.println("After findIndex, indexes are:");
        for(int i=0; arr1[i] !=-1; i++)
            System.out.print(arr1[i] + " ");
        System.out.println();
        //Using subArray
        Array sub= a2.subArray(1,8);
        System.out.println("Subarray elements are:");
        for(int i=0; i< sub.length(); i++)
            System.out.print(sub.getAnElement(i)+ " ");
        System.out.println();

        //Using merge
        String s1[]= {"area", "book", "cat", "eat", "foot"};
        String s2[]= {"Book", "dog", "foot", "good" };
        a2= a2.merge(s1,s2);
        System.out.println("After merging, A2 Array elements:");
        for(int i=0; i< a2.length(); i++)
            System.out.print(a2.getAnElement(i)+ " ");
        System.out.println();
    }
}
