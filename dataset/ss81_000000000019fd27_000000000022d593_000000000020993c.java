import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        
        int testcase = scanner.nextInt();
        
        for (int k=0;k<testcase;k++) {
            int N = scanner.nextInt();
            int a[][] = new int[N][N];
            
            for (int i=0;i<N;i++)
            for (int j=0;j<N;j++) 
                a[i][j]= scanner.nextInt();
                
            fun(a,N, k+1);
            System.out.println("");
        }
        
    }
    
    public static void fun(int [][]A, int N, int tcase) {
        
        //System.out.println(a.deepToString());
    
        
        int sum=0;
        int dRow=0;
        int dCol = 0;
        
        for (int i=0;i<N;i++) {
        HashMap<Integer, Boolean> row = new HashMap<>();
        HashMap<Integer, Boolean> col = new HashMap<>();
        boolean rowD=false;
        boolean colD=false;
        
        
        for (int j=0;j<N;j++) {
            
            if (!rowD) {
               if (row.containsKey(A[i][j]) ) {
                dRow++; rowD=true;
            } else {
                row.put(A[i][j], true);
            } 
            }
            
            if (!colD) {
               if (col.containsKey(A[j][i]) ) {
                dCol++; colD=true;
            } else {
                col.put(A[j][i], true);
            } 
            }
            
            if (i==j) sum+= A[i][j];
            
        }
        
        }
        System.out.printf("Case #%d: %d %d %d", tcase, sum, dRow,dCol );
        
        // System.out.println(dRow);
        // System.out.println(dCol);
        // System.out.println(sum);
    }
    

}
