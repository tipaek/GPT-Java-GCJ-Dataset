
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
    	HashMap<Integer, Set<Integer>> rowValues = new HashMap<>();
    	HashMap<Integer, Set<Integer>> colValues = new HashMap<>();
    	int[][] m = new int[n][n];
    	
    	result = getMatrix(m, n, k, 0, 0, rowValues, colValues, trace) ? "POSSIBLE" : result;
        System.out.println("Case #" + caseNum + ": " + result);
    }

    static boolean getMatrix(int[][] m, int n, int k, int r, int c, HashMap<Integer, Set<Integer>> rowValues, HashMap<Integer, Set<Integer>> colValues, int trace) {
    	
    	if (r >= n-1 && c >= n) {
    		return trace == k;
    	}
    	
    	if (c >= n) {
    		c = 0;
    		r = r+1;
    	}
    	
    	for (int i=1;i<=n;i++) {
    		// check if value exists in row/column -> skip
    		boolean rowsHave = true;
    		boolean colsHave = true;
    		if (!rowValues.containsKey(r)) {
    			rowsHave = false;
    			Set<Integer> s = new HashSet<>();
    			s.add(i);
    			rowValues.put(r, s);
    		} else {
    			if (!rowValues.get(r).contains(i)) {
        			rowsHave = false;
        			rowValues.get(r).add(i);
    			} else {
    				// value is in the row
    				rowsHave = true;
    			}
    		}
    		
    		if (!colValues.containsKey(c)) {
    			colsHave = false;
    			Set<Integer> s = new HashSet<>();
    			s.add(i);
    			colValues.put(c, s);
    		} else {
    			if (!colValues.get(c).contains(i)) {
        			colsHave = false;
        			colValues.get(c).add(i);
    			} else {
    				// value is in the row
    				colsHave = true;
    			}
    		} 		
    		// skip if value exists in the row
    		if (rowsHave || colsHave) {
        		rowValues.get(r).remove(i);
        		colValues.get(c).remove(i);    			
    			continue;	
    		}
    		
    		m[r][c] = i;
    		if (r==c) trace += i;
    		boolean check = getMatrix(m, n, k, r, c+1, rowValues, colValues, trace);
    		if (check) return check;
    		if (r==c) trace -= i;
    		
    		rowValues.get(r).remove(i);
    		colValues.get(c).remove(i);
    	}
    	return false;
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
