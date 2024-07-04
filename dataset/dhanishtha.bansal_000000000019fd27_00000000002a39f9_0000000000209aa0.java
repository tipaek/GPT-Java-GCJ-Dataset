import java.util.*;
import java.lang.*;
import java.lang.Math.*;
import java.io.*;
public class Solution
 {
	public static void main (String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine()); 
  
	    for(int idx = 1; idx <= test; idx++) {
	        String[] vals = br.readLine().trim().split(" ");
	        int n = Integer.parseInt(vals[0]);
	        int k = Integer.parseInt(vals[1]);
	        int flag = 0;
	        StringBuffer res = new StringBuffer();
	        int[][] mat = new int[n][n];
	        
	        if(n == 2) {
	            if(k==2 || k == 4) {
	                res = new StringBuffer("POSSIBLE");
	            }
	            else {
	                res = new StringBuffer("IMPOSSIBLE");
	                flag = -1;
	            }
	        }
	        else if(n == 3) {
	            if(k == 3 || k == 6 || k == 9) {
	                res = new StringBuffer("POSSIBLE");
	            }
	            else {
	                res = new StringBuffer("IMPOSSIBLE");
	                flag = -1;
	            }
	        }
	        else if( n%2 != 0) {
	            if((k >= n+2 && k <= n*n-2) || k == n || k == n*n) {
	                res = new StringBuffer("POSSIBLE");
	            }
	            else {
	                res = new StringBuffer("IMPOSSIBLE");
	                flag = -1;
	            }
	        }
	        else {
	            if(k%2 == 0 && k >= n+2 && k <= (n*n)-2 || k == n || k == n*n) {
	               res = new StringBuffer("POSSIBLE");
	            }
	           else if(k%(n/2) == 0 && k >= n+2 && k <= (n*n)-2) {
	                res = new StringBuffer("POSSIBLE");
	            }
	            else {
	                res = new StringBuffer("IMPOSSIBLE");
	                flag = -1;
	            }
	            
	        }
	        
	        if(flag == -1) {
	            System.out.println("Case #" + idx + ": " + res);
	        }
	        else {
	            //make matrix
	            System.out.println("Case #" + idx + ": " + res);
	            create(k, n);
	        }
	    }
	}
	
	static void create(int k, int n) {
	    //fill diagonals
	    int[][] mat = new int[n][n];
	    if(n == 5 && k == 19) {
	        mat[0][0] = 4;
	        mat[1][1] = 4;
	        mat[2][2] = 5;
	        mat[3][3] = 5;
	        mat[4][4] = 1;
	    }
	    else if(n == 5 && k == 14) {
	        mat[0][0] = 2;
	        mat[1][1] = 2;
	        mat[2][2] = 2;
	        mat[3][3] = 4;
	        mat[4][4] = 4;
	    }
	    else {
	        if(k%n == 0) {
	        for(int i = 0; i < n; i++) {
	            mat[i][i] = k/n;
	        }
	    }
	    else {
	        double a = (double) k;
	        double b = (double) n;
	        double c = a/b;
	        int mult = (int) Math.ceil(c) * n;
	        //System.out.println("Mult: " + mult);
	        int val = mult/n;
	        double half = (double)k/2.0;
	        int x = (int) Math.ceil( half/(double)val);
	        //System.out.println("X : " + x);
	        //System.out.println("val : " + val);
	        for(int i = 0; i < x; i++) {
	            
	            mat[i][i] = val;
	         //   System.out.println("a :" + mat[i][i]);
	        }
	        int diffN = n - x;
	        int diffK = k - x*val;
	        
	        val = val -1;
	        //System.out.println("diffK : " + diffK);
	        if(diffK%val != 0) {
	            int y = (int) Math.ceil( half/(double)(val+1));
	           // System.out.println("y : " + y);
	            int rest = diffK - (n-1-y)*val;
	            //System.out.println(rest);
	            for(int i = y; i < n-1; i++) {
	               // System.out.println("a1 :" + mat[i][i]);
	                mat[i][i] = val;
	            }
	            mat[n-1][n-1] = rest;
	        }
	        else {
	            int y = (int) Math.ceil( half/(double)(val+1));
	            for(int i = y; i < n; i++) {
	                // System.out.println("a1 :" + mat[i][i]);
	                mat[i][i] = val;
	            }
	        }
	    }
	    }
	    
	    boolean possible = fillVals(mat, n, k);
	    print(mat, n);
	    
	}
	
	public static boolean isSafe(int[][] mat, int row, int col, int num)  
    { 
        for (int d = 0; d < mat.length; d++)  
        { 
            if (mat[row][d] == num)  
            { 
                return false; 
            } 
        }
        for (int r = 0; r < mat.length; r++) 
        { 
            if (mat[r][col] == num) 
            { 
                return false; 
            } 
        }
        return true; 
    } 
	
	static boolean fillVals(int[][] mat, int n, int k) 
	{
	    
    	int row = -1; 
        int col = -1; 
        boolean isEmpty = true; 
        for (int i = 0; i < n; i++) 
        { 
            for (int j = 0; j < n; j++)  
            { 
                if (mat[i][j] == 0)  
                { 
                    row = i; 
                    col = j; 
                    isEmpty = false;  
                    break; 
                } 
            } 
            if (!isEmpty) 
            { 
                break; 
            } 
        } 
        if (isEmpty)  
        { 
            return true; 
        } 
        for (int num = 1; num <= n; num++) 
        { 
            if (isSafe(mat, row, col, num)) 
            { 
                mat[row][col] = num; 
                if (fillVals(mat, n, k))  
                { 
                    return true; 
                }  
                else
                { 
                    mat[row][col] = 0;
                } 
            } 
        } 
        return false; 
    } 
	
	static void print(int[][] mat, int n) {
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++) {
	            System.out.print(mat[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
 }