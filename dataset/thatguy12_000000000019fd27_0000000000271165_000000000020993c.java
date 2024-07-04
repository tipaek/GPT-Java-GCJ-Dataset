import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;


public class Solution{

	int caseNumber = 0;
	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args){

        Solution sol = new Solution();
        
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++){
        	sol.caseNumber = i;
            
        	int n = sc.nextInt();
        	int[][] matrix = new int[n][n];
        	for (int a = 0; a < n; a++) {
        		for (int b = 0; b < n; b++) {
        			matrix[a][b] = sc.nextInt();
        		}
        	}
        	
            sol.solve(  matrix  );
        }
        
        sc.close();
    }
    
    public Solution() {
    	
    }
    
    public void solve(  int[][] matrix  ){
    	int n = matrix.length;
		ArrayList<HashSet<Integer>> existing = new ArrayList<HashSet<Integer>>();
		int sum = 0;
		for (int i = 0; i < 2 * n; i++) {
			existing.add(new HashSet<Integer>());
		}
    	for (int i = 0; i < n; i++) {
    		
    		for (int j = 0; j < n; j++) {
    			existing.get(i).add(matrix[i][j]);
    			existing.get(n + j).add(matrix[i][j]);
    			if (i == j) {
    				sum += matrix[i][j];
    			}
    		}
    	}
    	int r = 0;
    	int c = 0;
    	for (int i = 0; i < n; i++) {
    		if (existing.get(i).size() != n) {
    			r++;
    		}
    		if (existing.get(i + n).size() != n) {
    			c++;
    		}
    	}
    	
        System.out.println("Case #" + caseNumber + ": "  + sum + " " + r + " " + c  );
    }
}