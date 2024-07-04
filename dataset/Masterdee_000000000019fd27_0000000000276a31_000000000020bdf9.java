import java.io.*; 
import java.util.*;
class Solution 
{ 
    static int partition(int arr[][], int low, int high) 
    { 
        int pivot = arr[high][0];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j][0] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp0 = arr[i][0]; 
                arr[i][0] = arr[j][0]; 
                arr[j][0] = temp0; 
                int temp1 = arr[i][1]; 
                arr[i][1] = arr[j][1]; 
                arr[j][1] = temp1; 
                int temp2 = arr[i][2]; 
                arr[i][2] = arr[j][2]; 
                arr[j][2] = temp2; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 

        int temp0 = arr[i+1][0]; 
        arr[i+1][0] = arr[high][0]; 
        arr[high][0] = temp0; 
        int temp1 = arr[i+1][1]; 
        arr[i+1][1] = arr[high][1]; 
        arr[high][1] = temp1;  
        int temp2 = arr[i+1][2]; 
        arr[i+1][2] = arr[high][2]; 
        arr[high][2] = temp2;  
  
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
  public static void main(String[] args)throws Exception 
  { 
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    // Scanner sc = new Scanner(new FileReader(new File("test.txt")));
    
    int n = sc.nextInt();
    for (int i = 1; i <= n; ++i) {
        
        int num = sc.nextInt();
        int arr[][] = new int [num][3];

        for (int j = 0; j < num; ++j) {
            arr[j][0] = sc.nextInt();
            arr[j][1] = sc.nextInt();
            arr[j][2] = j;
        }
        sort(arr, 0, num - 1);

        char[] trace = new char[num];
        int cEnd = -1;
        int jEnd = -1;
        cEnd = arr[0][1];
        trace[arr[0][2]] = 'C';
        boolean possible = true;
        for (int k = 1; k < num; ++k) {
            if (cEnd <= arr[k][0]) {
                trace[arr[k][2]] = 'C';
                cEnd = arr[k][1];
            } else if (jEnd <= arr[k][0]) {
                trace[arr[k][2]] = 'J';
                jEnd = arr[k][1];
            } else {
                possible = false;
                break;
            }
        }
        String res  = new String(trace);
        if (possible)
            System.out.println("Case #" + i + ": " + res);
            else {
            System.out.println("Case #" + i + ": IMPOSSIBLE" );
            }
    }
  }
} 