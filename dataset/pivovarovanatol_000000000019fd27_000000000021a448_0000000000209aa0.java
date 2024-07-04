
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class Solution {
    public static void solve(Scanner input, int caseNum, int n, int k) {
    	int trace = 0;
    	String result = "IMPOSSIBLE";
    	// idea - go over all possible matrices and check if those are Latin squares and if the trace == k 
    	int[][] rowValues = new int[n][n+1];
    	int[][] colValues = new int[n][n+1];
    	int[][] m = new int[n][n];
    	
    	if (getMatrix(m, n, k, 0, 0, rowValues, colValues, trace)) {
    		System.out.println("Case #" + caseNum + ": POSSIBLE");
    		printMatrix(m);
    	} else {
    		System.out.println("Case #" + caseNum + ": IMPOSSIBLE");
    	}
    }

    static boolean getMatrix(int[][] m, int n, int k, int r, int c, int[][] rowValues, int[][] colValues, int trace) {
    	
    	if (r >= n-1 && c >= n) {
    		if  (trace == k) {
    			//System.out.println("Success! K = " + k + ", trace = " + trace);
    			//printMatrix(m);
    			return true;
    		} else {
    			//System.out.println("Failed! K = " + k + ", trace = " + trace);
    			//printMatrix(m);
    			return false;
    		}
    	}
    	
    	if (c >= n) {
    		c = 0;
    		r = r+1;
    	}
    	
    	for (int i=1;i<=n;i++) {
    		// check if value exists in row/column -> skip
    		// skip if value exists in the row
    		if (rowValues[r][i]!=0 || colValues[c][i]!=0) {
    			continue;
    		} 
    		
    		m[r][c] = i;
    		rowValues[r][i] = 1;
    		colValues[c][i] = 1;
    		if (r==c) trace += i;
    		boolean check = getMatrix(m, n, k, r, c+1, rowValues, colValues, trace);
    		if (check) {

    			return true;	
    		}
    		if (r==c) trace -= i;
    		rowValues[r][i] = 0;
    		colValues[c][i] = 0;    		
    	}
    	return false;
    }
    
    static void printMatrix(int[][] m) {
    	for (int i=0;i<m.length;i++) {
    		for (int j=0;j<m[0].length; j++) {
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    	
    }
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
         try {
 			input = new Scanner(new FileInputStream(new File("C:\\Users\\i855719\\git\\kickstart\\KickStart\\CodeJam2020\\qalificationRound\\Indicium\\input.txt")));
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        // number of cases
        int T = input.nextInt();
        
        // for every case - execute the solution
        for (int ks = 1; ks <= T; ks++) {
        	int N = input.nextInt();
        	int K = input.nextInt();
        	
            solve(input, ks, N, K);
        }
        
        input.close();
        
    }
}
