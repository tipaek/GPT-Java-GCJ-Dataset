
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
		boolean valid = false;
		
		if (k<n || k > n*n) {
		    System.out.println("Case #" + index + ": IMPOSSIBLE");
		    return;
		}
		
		List<List<Integer>> traces = computeRepartitionNumber(k, n, 1);
		
		for (List<Integer> trace : traces) {
			
			if (trace.stream().anyMatch(e->e>n)) {
				continue;
			}
			
			// System.out.println(trace);
			int[][] a = new int[n][n];
			
			for (int i=0;i<n;i++) {
				a[i][i] = trace.get(i);
			}
			
			valid = solveRec(a, n, 0, 1, 1, 1);
			
			// System.out.println(valid);
			
			if (valid) {
				System.out.println("Case #" + index + ": POSSIBLE");
				printit(a, n);
				break;
			}
		}
		
		if (!valid) {
			System.out.println("Case #" + index + ": IMPOSSIBLE");
		}
	}
	
	private static boolean solveRec(int a[][], int n, int i, int j, int val, int sense) {
    	// if we got back to square one this is most def false
    	if (i==0 && j==0) {
    		return false;
    	}
    	
    	if (j<0) {
    		return solveRec(a, n, i-1, n-1, 1, -1);
    	}
    	
    	// skip past diagonal
    	if (i==j) {
    		if (sense < 0) {
    			return solveRec(a, n, i, j-1, 1, -1);
    		} 
    		return solveRec(a, n, i, j+1, 1, 1);
    	}
    	
    	// out of bounds col, go to next row
    	if (j>=n) {
    		return solveRec(a, n, i+1, 0, 1, 1);
    	}
    	
    	// out of bounds row, we good!
    	if (i>=n) {
    		return true;
    	}
    	
    	if (a[i][j] != 0) {
    		// we've been here before and now we are back!
    		val = a[i][j] + 1;
    		a[i][j] = 0;
    	}
    	
    	// val out of bounds, go back 1
    	if (val > n) {
    		return solveRec(a, n, i, j-1, 1, -1);
    	}
    	
    	if (isSafe(a, n, i, j, val)) {
    		a[i][j] = val;
    		return solveRec(a, n, i, j+1, 1, 1);
    	} else {
    		return solveRec(a, n, i, j, val + 1, 0);
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