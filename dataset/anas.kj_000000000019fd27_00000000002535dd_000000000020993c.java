  import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
        
          int[][] Numbers = new int[n][n]; 
          for (int rr=0;rr<n;rr++)
          {
                for (int cc=0;cc<n;cc++)
                  {
                    Numbers[rr][cc]=  in.nextInt();
                  }
          }
          int k=0,r=0,c=0;
          // Get K
            for (int rr=0;rr<n;rr++)
          {
              k+= Numbers[rr][rr];
          }
          // get R
          int[] temp = new int[n]; 
            for (int rr=0;rr<n;rr++)
          {
                 
                 
                for (int ii=0;ii<n;ii++)
                  {
                    temp[ii]=  Numbers[rr][ii];
                  }
                  
                  quickSort(temp,0,n-1);
                 // Detect 
                  for (int ii=1;ii<n;ii++)
                  {
                   if( temp[ii]== temp[ii-1] )
                   {
                       r++;
                       break;
                   }
                  }
          }
          
          // get C
               for (int cc=0;cc<n;cc++)
          {
                 
                 
                for (int ii=0;ii<n;ii++)
                  {
                    temp[ii]=  Numbers[ii][cc];
                  }
                  
                  quickSort(temp,0,n-1);
                 // Detect 
                  for (int ii=1;ii<n;ii++)
                  {
                   if( temp[ii]== temp[ii-1] )
                   {
                       c++;
                       break;
                   }
                  }
          }
          System.out.println("Case #" + i + ": " + k + " " + r +" "+ c);
        }
        
      
              }
                public static void quickSort(int arr[], int begin, int end) {
            if (begin < end) {
                int partitionIndex = partition(arr, begin, end);
         
                quickSort(arr, begin, partitionIndex-1);
                quickSort(arr, partitionIndex+1, end);
            }
        }
        private static int partition(int arr[], int begin, int end) {
                int pivot = arr[end];
                int i = (begin-1);
             
                for (int j = begin; j < end; j++) {
                    if (arr[j] <= pivot) {
                        i++;
             
                        int swapTemp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = swapTemp;
                    }
                }
             
                int swapTemp = arr[i+1];
                arr[i+1] = arr[end];
                arr[end] = swapTemp;
             
                return i+1;
            }
    }