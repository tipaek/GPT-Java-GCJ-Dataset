import java.util.*;
import java.io.*;
import java.lang.*; 

public class Solution{
    public static void main(String[] args){
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
        for(int m = 0; m<n;m++){
            int x = in.nextInt();
            boolean flag = true;
            int [][]f = new int[x][2];
            int[] order = new int[24*60+1];
            for(int i = 0; i<x;i++){
                f[i][0] = in.nextInt();
                //remember original order
                order[f[i][0]] = i;
                f[i][1] = in.nextInt();
            }
            int [][] p = new int[x][2];
            for (int i = 0; i<x; i++){
                p[i][0] = f[i][0];
                p[i][1] = f[i][1];
            }
            
                //array that stores assignments in order
                char[] cs = new char[x];
                for(int i = 0; i<x; i++){
                    cs[i] = 't';
                }
                //sort by starting time
                sort(f,0,x-1);
                int c = -1; 
                int j = -1;
                String res = "";
                System.out.println(p[1][0]);
                for(int i = 0; i<x;i++){
                    //mark either one as free if their time is up
                    if(f[i][0] >= c){
                        c  = -1;
                    }
                    if(f[i][0] >= j){
                        j  = -1;
                    }
                    //if available, assign to task 
                    if(c == -1){ 
                        c = f[i][1];
                        cs[order[f[i][0]]] = 'C';
                    }else if(j == -1){
                        j = f[i][1];
                        cs[order[f[i][0]]] = 'J';
                    }else{
                        //if neither can be assigned, impossible 
                         System.out.println("Case #" + (m+1) + ": "  +"IMPOSSIBLE");
                         flag = false;
                         break;
                    }

                }
            if(flag){
                //  doesnt work!!
                for(int i = 0; i<x; i++){
                    if(cs[i] == 't'){
                        if(cs[order[p[i][0]]] == 'C'){
                            cs[i] = 'J';
                        }else{
                            cs[i] = 'C';
                        }
                    }
                        res += cs[i];
                    }
                System.out.println("Case #" + (m+1) + ": "  + res);
            }
        }
    }
    static void merge(int arr[][], int l, int m, int r) 
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
        for (int j=0; j<n2; ++j){
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
            if (L[i][0] <= R[j][0]) 
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
    static void sort(int arr[][], int l, int r) 
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
}