import java.io.*;
import java.util.*;

public class Solution{
    
    public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    }
    
    public static void main(String args[]){
        Scanner ip = new Scanner(System.in);
        int t = ip.nextInt();
        for(int c=0;c<t;c++){
            int n = ip.nextInt();
            int[][] a = new int[n][2];
            for(int i=0;i<n;i++){
                a[i][0] = ip.nextInt();
                a[i][1] = ip.nextInt();
            }
            sortbyColumn(a, 0); 
            System.out.print("Case #"+(c+1)+": ");
            boolean flag = true;
            String sol = "";
            int C = 0;
            int J = 0;
            for(int i=0;i<n;i++){
                if(i == 0){
                    sol += "C";
                    C = a[i][1];
                }else{
                    if(C <= a[i][0]){
                        sol += "C";
                        C = a[i][1];
                    }else if(J <= a[i][0]){
                        sol += "J";
                        J = a[i][1];
                    }else{
                        sol = "IMPOSSIBLE";
                        break;
                    }
                }
            }
            System.out.println(sol);
        }
    }
}