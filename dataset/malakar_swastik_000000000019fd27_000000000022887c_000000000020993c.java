import java.util.Scanner;
class Solution
{

  static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
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
    static void sort(int arr[], int low, int high)
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

    public static boolean rep(int a[])
    {
      int cun=0;
      sort(a, 0, a.length-1);
      for (int i=0 ; i<a.length-1 ; i++ )
      {
            if(a[i]==a[i+1])
            return true;
      }
      return false;
    }

  public static void main(String[] args)
  {
      Scanner sc = new Scanner(System.in);
      int T, N, r, c, k;//T:num of testcase; r/c:num of rep rows/c; k:trace
      T = sc.nextInt();

      for(int x=0;x<T;x++){
        k = 0;r = 0;c = 0;
        N = sc.nextInt();
      int M[][] = new int[N][N];

      //taking input
      for (int i=0 ; i<N ; i++ )
      {
          for (int j=0 ; j<N ; j++ )
          {
            M[i][j] = sc.nextInt();
          }
      }

      //working
      int[] a =new int[N];
      int[] b =new int[N];
      for (int i=0;i<N;i++)
      {
        for (int j=0;j<N;j++)
        {
          a[j] = M[i][j];//rows
          b[j] = M[j][i];//cols
        }
        k+=M[i][i];//trace
        if(rep(a) == true)//repeating rows
        r++;
        if(rep(b)==true)//repeating cols
        c++;
      }

      System.out.println("Case #"+(x+1)+": "+k+" "+r+" "+c);}
  }
}
