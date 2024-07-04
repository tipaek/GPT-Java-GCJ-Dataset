import java.util.Scanner;

public class Solution {
	static int n;
	static int[][] ar;
	static int k;
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scn.nextInt();
		int T = 1;
		while (T <= t) {
			n = scn.nextInt();
			k = scn.nextInt();
			ar = new int[n][n];
			boolean ans = canFillTrace();
			if (ans) {
				System.out.print("Case #" + T + ": POSSIBLE");
				for (int i = 0; i < n; i++) {
					System.out.println();
					for (int j = 0; j < n; j++)
						System.out.print(ar[i][j] + ((j < n - 1) ? " " : ""));
				}
			} else
				System.out.print("Case #" + T + ": IMPOSSIBLE");
			if (T < t)
				System.out.println();
			T++;
		}
	}
	public static boolean canFillTrace()  
	{ 
	    int row = -1; 
	    int col = -1; 
	    int trace=0;
	    boolean isEmpty = false; 
	    for (int i = 0; i < n; i++) 
	    { 
	        for (int j = 0; j < n; j++)  
	        { 
	        	if(i==j)
	        		trace+=ar[i][j];
	            if (ar[i][j] == 0)  
	            { 
	                row = i; 
	                col = j; 
	                  
	                isEmpty = true;  
	                break; 
	            } 
	        } 
	        if (isEmpty) 
	        { 
	            break; 
	        } 
	    } 
	  
	    if (!isEmpty)  
	    { 
	    	//check for trace
	    	if(trace == k)
	    		return true; 
	    	else return false;
	    } 
	  
	    for (int num = 1; num <= n; num++) 
	    { 
	        if (canAddInRow(row, num) && canAddInCol(col, num)) 
	        { 
	            ar[row][col] = num; 
	            if (canFillTrace())  
	            { 
	                return true; 
	            }  
	            else
	            { 
	                ar[row][col] = 0; 
	            } 
	        } 
	    } 
	    return false; 
	}
	static boolean canAddInRow(int r, int val) {
		for (int c = 0; c < n; c++) {
			if (ar[r][c] == val)
				return false;
		}
		return true;
	}

	static boolean canAddInCol(int c, int val) {
		for (int r = 0; r < n; r++) {
			if (ar[r][c] == val)
				return false;
		}
		return true;
	}

	static void print() {
		for (int i = 0; i < n; i++) {
			System.out.println();
			for (int j = 0; j < n; j++)
				System.out.print(ar[i][j] + " ");
		}
	}
}
