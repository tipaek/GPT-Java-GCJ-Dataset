
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = sc.nextInt();
		sc.nextLine(); // sometimes necesary after nextInt to go to next line
		
		for (int i = 1; i <= tests; i++) {
			String[] in = sc.nextLine().split(" "); 
			
			solve(Integer.parseInt(in[0]), Integer.parseInt(in[1]), i);
		}
	}
	
	public static void solve (int n, int k, int index) {
		
		int[][] a = new int[n][n];
		boolean valid = solveRec(a, n, 0, 0, 1, 1, k);
		
		if (valid) {
			System.out.println("Case #" + index + ": POSSIBLE");
			printit(a, n);
		} else {
			System.out.println("Case #" + index + ": IMPOSSIBLE");
		}
	}
	
	private static boolean solveRec(int a[][], int n, int i, int j, int val, int sense, int k) {
		// if we got back to square one this is most def false
    	if (i<0) {
    		return false;
    	}
    	
//    	if (i==0 && j==0) {
//    		return false;
//    	}
    	
    	if (j<0) {
    		return solveRec(a, n, i-1, n-1, 1, -1, k);
    	}
    	
    	// skip past diagonal
//    	if (i==j) {
//    		if (sense < 0) {
//    			return solveRec2(a, n, i, j-1, 1, -1, k);
//    		} 
//    		return solveRec2(a, n, i, j+1, 1, 1, k);
//    	}
    	
    	// out of bounds col, go to next row
    	if (j>=n) {
    		return solveRec(a, n, i+1, 0, 1, 1, k);
    	}
    	
    	// out of bounds row, we good!
    	if (i>=n) {
    		boolean isGood = isTraced(a, n, k);
    		
    		if (isGood) {
    			return true;
    		}
    		
    		return solveRec(a, n, n-1, n-1, 1, -1, k);
    	}
    	
    	if (a[i][j] != 0) {
    		// we've been here before and now we are back!
    		val = a[i][j] + 1;
    		a[i][j] = 0;
    	}
    	
    	// val out of bounds, go back 1
    	if (val > n) {
    		return solveRec(a, n, i, j-1, 1, -1, k);
    	}
    	
    	if (isSafe(a, n, i, j, val)) {
    		a[i][j] = val;
    		return solveRec(a, n, i, j+1, 1, 1, k);
    	} else {
    		return solveRec(a, n, i, j, val + 1, 0, k);
    	}
    }
    
    private static boolean isSafe(int board[][], int n, int row, int col, int val) { 
        /* Check this row on left side */
        for (int i = 0; i < col; i++) {
        	if (board[row][i] == val) {
        		return false;
        	}
        }
        
        /* Check this row on right side */
        for (int i = col + 1; i < n; i++) {
        	if (board[row][i] == val) {
        		return false;
        	}
        }
        
        /* Check this row on top side */
        for (int i = 0; i < row; i++) {
        	if (board[i][col] == val) {
        		return false;
        	}
        }
            
        /* Check this row on top side */
        for (int i = row + 1; i < n; i++) {
        	if (board[i][col] == val) {
        		return false;
        	}
        }        
  
        return true; 
    } 
    
    private static boolean isTraced (int a[][], int n, int k) {
    	int sum = 0;
    	for (int i=0;i<n;i++) {
    		sum += a[i][i];
    	}
    	
    	return sum == k;
    }
    
    private static void printit (int[][] a, int n) {
    	for (int i=0;i<n;i++) {
    		for (int j=0;j<n;j++) {
				System.out.print(a[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
	
    public static List<List<Integer>> computeRepartitionNumber(int number_to_decompose, int number_of_subnumbers, int threshold_number) {
        List<List<Integer>> resultRec = new ArrayList<>();

        if (number_of_subnumbers == 1) {
            List<List<Integer>> resultEnd = new ArrayList<>();
            ArrayList<Integer> unitary = new ArrayList<>();
            resultEnd.add(unitary);
            unitary.add(number_to_decompose);
            return resultEnd;
        }

        for (int i = threshold_number; i <= Math.min(number_to_decompose-threshold_number, number_of_subnumbers); i++) {
            int remain = number_to_decompose - i;
            List<List<Integer>> partialRec = computeRepartitionNumber(remain, number_of_subnumbers - 1, threshold_number);
            for(List<Integer> subList : partialRec){
                subList.add(i);             
            }
            resultRec.addAll(partialRec);
        }
        return resultRec;

    }

}