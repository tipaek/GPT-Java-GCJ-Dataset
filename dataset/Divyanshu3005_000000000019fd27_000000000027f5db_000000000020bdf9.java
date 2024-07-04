import java.io.*;
import java.util.*;

class Solution{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int c = 1; c <= t; c++){
            int n = sc.nextInt();
            boolean flag = true;
            int[][] arr = new int[n][3];
            for(int i = 0; i < n; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
                arr[i][2] = i;
            }
            char[] ans = new char[n];
            arr = sortbyColumn(arr, 0);
            int je = 0;
            int ce = 0;
            int js = 0;
            int cs = 0;
            
            for(int i = 0; i < n; i++){
                if(arr[i][0] >= je){
                    je = arr[i][1];
                    ans[arr[i][2]] = 'J';
                    continue;
                } else if(arr[i][0] >= ce) {
                    ce = arr[i][1];
                    ans[arr[i][2]] = 'C';
                    continue;
                }
                flag = false;
                break;
            }
            
            String str = new String(ans);
            if(flag)
                System.out.println("Case #" + c + ": " + str);
            else
                System.out.println("Case #" + c + ": " + "IMPOSSIBLE");
            
        
        }
    }
    public static int[][] sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          public int compare(final int[] a1,  
                             final int[] a2) { 
  
            if (a1[col] > a2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });
        
        return arr;
    } 
    
}