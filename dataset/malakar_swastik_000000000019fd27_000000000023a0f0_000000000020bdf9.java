import java.util.Scanner;
import java.io.*;
class Solution
{

  static int partition(int arr[][], int low, int high)
    {
        int pivot = arr[1][high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[1][j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                for (int k= 0;k<3;k++)
                {
                int temp = arr[k][i];
                arr[k][i] = arr[k][j];
                arr[k][j] = temp;
                }
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        for (int k= 0;k<3;k++)
        {
          int temp = arr[k][i+1];
          arr[k][i+1] = arr[k][high];
          arr[k][high] = temp;
        }

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
     static void sort(int arr[][], int low, int high)
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

  public static void main(String args[])
  {
  Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
  int t = sc.nextInt();
  int i=0;int j=0;
  for (int k=0;k<t;k++)
  {
      int N= sc.nextInt();
      int A[][] = new int[3][N];
      int C = -1;
      int J = -1;


        for (j=0;j<N;j++)
        {
          A[0][j]=j;
          A[1][j]=sc.nextInt();
          A[2][j]=sc.nextInt();
        }

      sort(A, 0, N-1);
      char R[] = new char[N];
      boolean flag = false;
      for(int x=0;x<N;x++)
      {
      if(C <= A[1][x] && J <= A[1][x])//both free
      {
        C = A[2][x];
        R[A[0][x]] = 'C';
      }
      else if(C <= A[1][x])//C free
      {
        C = A[2][x];
        R[A[0][x]] = 'C';
      }
      else if(J <= A[1][x])//J free
      {
        J = A[2][x];
        R[A[0][x]] = 'J';
      }
      else{
      flag=true;
      break;
    }
      }
      System.out.print("Case #"+(k+1)+": ");
      if(!flag)
      for(int z = 0;z<N;z++)
      System.out.print(R[z]);
      else
      System.out.print("IMPOSSIBLE");
      System.out.println("");
      }
  }
}
