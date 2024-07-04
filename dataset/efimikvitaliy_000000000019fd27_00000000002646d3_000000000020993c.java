import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		int[][] A = new int[100][100];
		boolean[] B = new boolean[101];
		int numRows;
		int numCols;
		int trace;
		
		for(int t = 1; t<=T; ++t) {
			int N = sc.nextInt();
			
			
			
			for(int i=0; i<N; i++) {
				for(int k=0; k<N; k++) {
					A[i][k] = sc.nextInt();
				}
			}
			
			numRows = 0;
			
			for(int i=0; i<N; i++) {
				for(int k=0; k<N+1; ++k) {
					B[k] = false;
				}
				for(int k=0; k<N; k++) {
					if(B[A[i][k]]) {
						numRows++;
						break;
					}
					else {
						B[A[i][k]] = true;
					}
				}
			}
			
			numCols = 0;
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N+1; ++i) {
					B[i] = false;
				}
				for(int i=0; i<N; i++) {
					if(B[A[i][k]]) {
						numCols++;
						break;
					}
					else {
						B[A[i][k]] = true;
					}
				}
			}
			
			trace = 0;
			for(int i=0; i<N; ++i) {
				trace += A[i][i];
			}
			
			System.out.println(String.format("Case #%d: %d %d %d", t, trace, numRows, numCols));
			
		}
	}

}