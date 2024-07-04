import java.util.*;
import java.io.*;

class Solution{

  int partition(int arr[][], int low, int high){
      int pivot = arr[1][high];
      int i = (low-1);
      for (int j=low; j<high; j++)
      {
          // If current element is smaller than the pivot
          if (arr[1][j] < pivot)
          {
              i++;

              // swap arr[i] and arr[j]
              for(int z=0;z<3;z++){
                int temp = arr[z][i];
                arr[z][i] = arr[z][j];
                arr[z][j] = temp;
              }
          }
      }

      // swap arr[i+1] and arr[high] (or pivot)
      for(int z=0;z<3;z++){
        int temp = arr[z][i+1];
        arr[z][i+1] = arr[z][high];
        arr[z][high] = temp;
      }


      return i+1;
  }


  /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index */
  void sort(int arr[][], int low, int high){
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

  void printing(int a[][], int N){
    for(int i=0;i<3;i++){
      for(int j=0;j<N;j++)
      System.out.print(a[i][j]+" ");
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    Solution obj = new Solution();
    int T = sc.nextInt();

    if(!(T>=1 && T<=100))
      System.exit(0);

    for(int z=0; z<T; z++){
      int N = sc.nextInt();

      int C=-1, J=-1;
      boolean flag = true;

      int a[][] = new int[3][N];
      for(int i=0;i<N;i++){
        a[0][i] = i;
        int S = sc.nextInt();
        int E = sc.nextInt();
        if(!(S>=0 && S<E && E<=(24*60)))
          System.exit(0);
        a[1][i] = S;
        a[2][i] = E;

      }

      obj.sort(a,0,N-1);

      char out[] = new char[N];

      for(int i=0;i<N;i++){
        if(C<=a[1][i] && J<=a[1][i]){
          C=a[2][i];
          out[a[0][i]] = 'C';
        }
        else if(C>a[1][i] && J<=a[1][i]){
          J=a[2][i];
          out[a[0][i]] = 'J';
        }
        else if(J>a[1][i] && C<=a[1][i]){
          C=a[2][i];
          out[a[0][i]] = 'C';
        }
        else{
          flag = false;
          break;
        }
      }

      String res = "";
      if(flag){
        for(int i=0;i<out.length;i++)
        res = res + Character.toString(out[i]);
        System.out.println("Case #"+(z+1)+": "+res);
      }
      else
      System.out.println("Case #"+(z+1)+": IMPOSSIBLE");
    }
  }
}
