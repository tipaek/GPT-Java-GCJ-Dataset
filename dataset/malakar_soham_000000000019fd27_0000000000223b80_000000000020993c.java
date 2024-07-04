import java.util.*;
import java.util.regex.*;
import java.io.*;

class Vestigium{

    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[][])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i){
        for(int j=0;j<n;j++)
            System.out.print(arr[i][j]+" ");
        System.out.println();
      }
    }


  boolean unicheck(int a[],int n){
    sort(a,0,n-1);
    for(int i=0;i<n-1;i++){
      if(a[i]==a[i+1])
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Vestigium obj = new Vestigium();

    int T = sc.nextInt();
    if(!(T>=1 && T<=100))
    System.exit(0);

    for(int z=0;z<T;z++){
      int n = sc.nextInt();
      if(!(n>=2 && n<=100))
      System.exit(0);

      int a[][] = new int[n][n];

      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
          a[i][j] = sc.nextInt();
          if(a[i][j]>n || a[i][j]<1)
          System.exit(0);
        }
      }

      int b[] = new int[n];
      int c[] = new int[n];
      int sum=0, row=0, col=0;
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++)
        c[j] = a[i][j];
        if(!obj.unicheck(c,n))
        row += 1;
        for(int j=0;j<n;j++)
        b[j] = a[j][i];
        if(!obj.unicheck(b,n))
        col += 1;
        sum += a[i][i];
      }
      System.out.println("Case #"+(z+1)+":"+sum+" "+row+" "+col);
    }
  }
}
