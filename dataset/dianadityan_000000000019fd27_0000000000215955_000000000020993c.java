import java.util.*;
import java.io.*;
	
public class Solution {
	public static void main(String args[]) throws FileNotFoundException {
		/* INPUT */
		// Scanner in = new Scanner(new File("./input.txt"));
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));	
		
		/* VARIABLE */
		int T, N, expectedSum, sum, k, r, c, rowRes, colRes;
		int M[][] = new int[100][100];
		int rowMap[] = new int[100];
		int colMap[] = new int[100];
		
		T = in.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			N = in.nextInt();
			
			expectedSum = (1 + N)*N/2;
			k = 0;
			for(int row=0; row<N; row++) {
				for(int col=0; col<N; col++) {
					M[row][col] = in.nextInt();
					
					if(row == col) k += M[row][col];
				}
			}
			
			// Each row
			r = 0;
			for(int row=0; row<N; row++) {
				colRes = 0;
				
				for(int col=0; col<N; col++) {
					colMap[col] = 0;
				}
				
				for(int col=0; col<N; col++) {
					colMap[M[row][col]-1] = 1;
				}
				
				for(int col=0; col<N; col++) {
					colRes += colMap[col];
				}
				
				if(colRes != N) r++;
			}
			
			// Each row
			c = 0;
			for(int col=0; col<N; col++) {
				rowRes = 0;
				
				for(int row=0; row<N; row++) {
					rowMap[row] = 0;
				}
				
				for(int row=0; row<N; row++) {
					rowMap[M[row][col]-1] = 1;
				}
				
				for(int row=0; row<N; row++) {
					rowRes += rowMap[row];
				}
				
				if(rowRes != N) c++;
			}
			
			System.out.println("Case #" + testCase + ": " + k + ' ' + r + ' ' + c);
		}
		
		in.close();
	}
}
