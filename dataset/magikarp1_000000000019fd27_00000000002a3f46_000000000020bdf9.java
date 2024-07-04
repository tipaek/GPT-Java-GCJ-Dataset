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
         sort(helper,0,N-1);
         for(int i = 0; i < N; i++)
            System.out.println(helper[i][0] + " " + helper[i][1]);
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
                  latest = "C";
                  max2 = max1;
                  max1 = helper[i][1];
               }
            }
         }
         if(worked){
            HashSet<Integer> used = new HashSet<Integer>();
            String ans = "";
            for(int i = 0; i < N; i++){
               int n = times[i][0] * 10000 + times[i][1];
               int k = binarySearch(helper,times[i][0], times[i][1]);
               if(used.contains(n))
                  ans += op.get(order[k]);
               else{
                  ans += order[k];
                  used.add(n);
               }
            }
            System.out.println("Case #" + trial + ": " + ans);
         }
      }
   }
   public static void merge(int[][] arr, int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[][] = new int [n1][2]; 
        int R[][] = new int [n2][2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
            L[i][0] = arr[l + i][0]; 
            L[i][1] = arr[l + i][1]; 
         }
        for (int j=0; j<n2; ++j) {
            R[j][0] = arr[m + 1+ j][0]; 
            R[j][1] = arr[m + 1+ j][1]; 
        }
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i][0] < R[j][0] || (L[i][0] == R[j][0] && L[i][1] <= R[j][1])) 
            { 
                arr[k][0] = L[i][0]; 
                arr[k][1] = L[i][1]; 
                i++; 
            } 
            else
            { 
                arr[k][0] = R[j][0]; 
                arr[k][1] = R[j][1]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k][0] = L[i][0]; 
            arr[k][1] = L[i][1]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k][0] = R[j][0]; 
            arr[k][1] = R[j][1];
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    public static void sort(int arr[][], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
   /*public static void quickSort(int[][] arr, int start, int end){
 
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
    } */
   public static int binarySearch(int arr[][], int x, int y)
    { 
        int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = (l + r) / 2; 
  
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