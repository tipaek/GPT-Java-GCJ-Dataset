import java.lang.*;
import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int test = 1;
        while(t-->0)
        {
            int n = sc.nextInt();
            int [][]M = new int[n][n];
            if(n>=2) {
 
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                
                M[i][j] = sc.nextInt();
            }
        }
 
        int k=0, r=0, c=0;
 
        // calculate k
        for(int i=0; i<n; i++) {
            k += M[i][i];
        }
        int colfreq[][] = new int[n][n+1];
         int rowfreq[][] = new int[n][n+1];

        // calculate r
         for(int i=0; i<n; i++) {
             for(int j=0; j<n; j++) {
            	 rowfreq[i][M[i][j]]= 0;
            	 colfreq[i][M[i][j]]= 0;

                
             }
         }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                
                if(rowfreq[i][M[i][j]] > 0) {
                	r++;
                	break;}
                
                rowfreq[i][M[i][j]]++;
                
            }
        }
        
         for(int j=0; j<n; j++) {
            for(int i=0; i<n; i++) {
                
                if(colfreq[j][M[i][j]] > 0) {c++;
                break;}
                colfreq[j][M[i][j]]++;
            }
        }
         
         
 
 
        System.out.println("Case #"+(test++)+": "+k+" "+r+" "+c);
    }
        }
    }
}