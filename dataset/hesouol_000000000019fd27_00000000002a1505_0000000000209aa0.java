import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int t1 = 0; t1 < t; t1++) {
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] matrix = solve(n, k);

			if (matrix != null) {
				System.out.format("Case #%d: %s\n",t1+1, "POSSIBLE");
				printMatrix(matrix, n);
			} else {
				System.out.format("Case #%d: %s\n",t1+1, "IMPOSSIBLE");
			}
		}
		in.close();
	}

	public static int[][] solve(int n, int k) {

//		System.out.format("DEBUG: Solving for n: %d & k: %d\n", n, k);
		boolean available[][][] = new boolean[n][n][n + 1];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int l = 0; l < n; l++)
					available[i][j][l + 1] = true;

		int[][] m = getDiag(k, n);
		
		if(m==null) return null; //nao foi possivel gerar diag

		for (int i = 0; i < n; i++)
			available = setValue(i, i, m[i][i], available, false);

		return fillMatrix(m, available);
	}

	public static int[][] fillMatrix(int m[][], boolean[][][] available) {
		{
//			System.out.println("Matrix.");
//			printMatrix(m, m.length);
			
			int row = -1;
			int col = -1;
			int n = m.length;
			boolean isEmpty = true;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (m[i][j] == 0) {// precisa ser preenchida
						row = i;
						col = j;
						isEmpty = false; // ainda precisamos preencher a matriz
						break;
					}
				}
		        if (!isEmpty) 
		        { 
		            break; 
		        } 
			}

			if (isEmpty)
				return m; // completamente preenchida

			for (int num = 1; num <= n; num++) // backtracking
			{
//				System.out.println("Matrix de Available.");
//				printAvailable(available, n);
				
				if (available[row][col][num]) {
					m[row][col] = num;
					setValue(row, col, num, available, false);

					int[][] newM = fillMatrix(m, available);

					if (newM != null)
						return newM;
					else
						m[row][col] = 0; // replace it
						setValue(row, col, num, available, true);
				}
			}
		}
		return null;
	}

	public static int[][] getDiag(int k, int n) {

		int value = 0;
		int[][] m = new int[n][n];
		int average = k / n;
		value = n * average;
		boolean precisaAjuste = false;
		
		if(value % n==1 || value % (n-1)==1) { //casos que falham a distribuicao
			precisaAjuste=true;
		}
		

		for (int i = 0; i < n; i++) {
			m[i][i] = average;
		}

		for (int i = 0; i < n && value != k; i++) {
			m[i][i]++;
			value++;
		}
		
		if(precisaAjuste) {
			m[n-1][n-1]--;
			m[0][0]++;
		}
		
		return m[n-1][n-1]==0 || m[0][0]>n+1 ? null : m;
	}
	
	
	public static boolean[][][] setValue(int row, int col, int value, boolean[][][] available, boolean set) {
		int n = available.length;
		boolean[][][] newAvailable = available;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(i == row || j == col)
					newAvailable[i][j][value] = set;
			}
		}
		return newAvailable;
	}
	
	
	public static void printMatrix(int[][] m, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.format("%d ", m[i][j]);
			}
			System.out.println("");
		}
	}
	

	public static void printAvailable(boolean[][][] a, int n) {
		for(int n1=1; n1<=n; n1++) {
			System.out.format("Para o numero %d\n", n1);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(a[i][j][n1])
						System.out.format("1 ");
					else 
						System.out.format("0 ");
				}
				System.out.println("");
			}
		}
	}

}
