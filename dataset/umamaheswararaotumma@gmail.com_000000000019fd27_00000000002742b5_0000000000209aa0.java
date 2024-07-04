import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseNo = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			boolean foundSolution = false;
			for(int i = 1; i<=n; i++) {
				if(n*i == k) {
					foundSolution = true;
					System.out.println("Case #" + caseNo++ + ": POSSIBLE");
				    printTraceMatrix(i,n);
					break;
				}
			}
			if(n>2 && !foundSolution && (n*(n+1))/2 == k){
				foundSolution = true;
				System.out.println("Case #" + caseNo++ + ": POSSIBLE");
				printTraceMatrix(n);
			}
			if(!foundSolution) {
				System.out.println("Case #" + caseNo++ + ": IMPOSSIBLE");
			}
			
		}
	}
	
	private static void printTraceMatrix(int n) {
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			matrix[i][i] = i+1;
		}
		if(createSudoku(matrix, n)) {
			for(int i=0;i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}
	private static void printTraceMatrix(int traceElement, int n) {
		int[][] matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			matrix[i][i] = traceElement;
		}
		if(createSudoku(matrix, n)) {
			for(int i=0;i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}

	private static boolean createSudoku(int[][] matrix, int n) {
		int row = -1, col = -1;
		boolean isSolved= true;
		outer: for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(matrix[i][j] == 0) {
					row = i;col =j;
					isSolved = false;
					break outer;
				}
			}
		}
		if(isSolved) {
			return true;
		}
		
		for(int i =1; i<= n; i++) {
			if(isSafe(matrix, i, row, col, n)) {
				matrix[row][col] = i;
				if(createSudoku(matrix, n)) {
					return true;
				}
				else {
					matrix[row][col] = 0;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] matrix, int number, int row, int col, int n) {
		for(int i =0; i<n; i++) {
			if(matrix[row][i] == number) {
				return false;
			}
		}
		for(int i =0; i<n; i++) {
			if(matrix[i][col] == number) {
				return false;
			}
		}
		return true;
	}


}