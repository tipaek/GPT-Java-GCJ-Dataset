import java.util.*;
import java.io.*;
public class Solution{
   public static void main(String[] main) throws Exception{
      Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      for(int trial = 1; trial <= t; trial++){
         int N = s.nextInt();
         int[][] times = new int[N][2];
         int[][] helper = new int[N][2];
         for(int i = 0; i < N; i++){
            times[i][0] = s.nextInt();
            helper[i][0] = times[i][0];
            times[i][1] = s.nextInt();
            helper[i][1] = times[i][1];
         }
         quickSort(helper,0,N-1);
         String[] order = new String[N];
         boolean worked = true;
         int max1 = 0, max2 = 0;
         String latest = "C";
         HashMap<String,String> op = new HashMap<String,String>();
         op.put("C","J");
         op.put("J","C");
         for(int i = 0; i < N; i++){
            if(i == 0){
               order[i] = "C";
               max1 = helper[i][1];
            }
            else{
               if(helper[i][0] < max2){
                  worked = false;
                  System.out.println("Case #" + trial + ": IMPOSSIBLE");
                  break;
               }
               else if(helper[i][0] < max1){
                  order[i] = op.get(latest);
                  if(max1 < helper[i][1]){
                     latest = op.get(latest);
                     max2 = max1;
                     max1 = helper[i][1];
                  }
                  else
                     max2 = helper[i][1];
               }
               else{
                  order[i] = "C";
                  max2 = max1;
                  max1 = helper[i][1];
               }
            }
         }
         if(worked){
            System.out.print("Case #" + trial + ": ");
            for(int i = 0; i < N; i++){
               int k = binarySearch(helper,times[i][0], times[i][1]);
               //for(int j = 0; j < N; j++)
                 // System.out.println(helper[j][0] + " " + helper[j][1]);
               System.out.print(order[k]);
            }
            System.out.println();
         }
      }
   }
   public static void quickSort(int[][] arr, int start, int end){
 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
 
    public static int partition(int[][] arr, int start, int end) 
    { 
        int pivot = arr[end][0];  
        int i = (start-1); // index of smaller element 
        for (int j=start; j<end; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j][0] < pivot || (arr[j][0] == pivot && arr[j][1] < arr[end][1])) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp1 = arr[i][0]; 
                int temp2 = arr[i][1];
                arr[i][0] = arr[j][0]; 
                arr[i][1] = arr[j][1];
                arr[j][0] = temp1; 
                arr[j][1] = temp2;
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp1 = arr[i+1][0]; 
        int temp2 = arr[i+1][1];
        arr[i+1][0] = arr[end][0]; 
        arr[i+1][1] = arr[end][1];
        arr[end][0] = temp1; 
        arr[end][1] = temp2;
  
        return i+1; 
    } 
   public static int binarySearch(int arr[][], int x, int y)
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m][0] == x && arr[m][1] == y) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m][0] < x || (arr[m][0] == x && arr[m][1] < y)) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
        // not present 
        return -1; 
     }

}