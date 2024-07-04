/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 	}
// }

class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int t = in.nextInt();
        while(t>0) {
            t--;
            int n = in.nextInt();
            int[][] mat = new int[n][n];
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    mat[i][j]=in.nextInt();
                }
            }
            
            Set<Integer>[] rows = new HashSet[n];
            Set<Integer>[] cols = new HashSet[n];
            
            for(int i=0;i<n;i++) {
                rows[i]=new HashSet<Integer>();
                cols[i]=new HashSet<Integer>();
            }
            
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    rows[i].add(mat[i][j]);
                    cols[j].add(mat[i][j]);
                }
            }
            
            int row=0,col=0,trace=0;
            for(int i=0;i<n;i++) {
                if(rows[i].size()!=n) {
                    row++;
                }
                if(cols[i].size()!=n) {
                    col++;
                }
                trace+=mat[i][i];
            }
            System.out.println(trace + " " + row + " " + col);
        }
    }
}
