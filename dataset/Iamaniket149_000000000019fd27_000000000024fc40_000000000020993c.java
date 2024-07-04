import java.util.*;
 class Trace {
    public static int trace(int arr[][] , int n)
    {
        int sum = 0;
        for (int i = 0 ; i<n ; i++)
        {
            sum = sum + arr[i][i];
        }
        return sum;
    }
    public static int[] row_and_column(int arr[][] , int n)
    {
        int row_count = 0; 
        int column_count = 0;
        for (int i = 0 ; i< n ; i++)
        {
            HashSet <Integer> row_set= new HashSet<Integer>();
            HashSet <Integer> column_set = new HashSet<Integer>();
            
            for (int j = 0 ; j < n ; j++)
            {
                row_set.add(arr[i][j]);
                column_set.add(arr[j][i]);
            }
            
            if(row_set.size() != n) row_count++;
            if (column_set.size() != n) column_count++; 
           
            
        }
        int a[] = new int[2];
        a[0] = row_count;
        a[1] = column_count;
        
        return a;
    }
    public static void main(String args[])
    {
       Scanner in = new Scanner(System.in); 
       int testcase = in.nextInt();
       for (int z = 0 ; z< testcase ; z++)
       {
           int n = in.nextInt();
           int arr[][] = new int[n][n];
           for (int i = 0 ; i<n ; i++)
           { 
               for (int j = 0 ; j< n ; j++)
               {
                   arr[i][j] = in.nextInt();
               }
           }
           int t = trace(arr, n);
           int result[] = row_and_column(arr,n);
           System.out.println("Case #" + (z+1) + ": " + t + " " + result[0] + " " + result[1]);
           
       }
    }
}
