
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int[][] M;
	static int[] R,C;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for(int test=1;test<=tests;test++) {
			N = in.nextInt();
			M = new int[N][N];
			R = new int[N+1];
			C = new int[N+1];
			int tra = 0,r = 0,row = 0,c = 0,col = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					M[i][j] = in.nextInt();
				}
			}
			for(int i=0;i<N;i++) {
				Arrays.fill(R, 0);
				Arrays.fill(C, 0);
				for(int j=0;j<N;j++) {
					if(i==j) tra += M[i][j];
					if(R[M[i][j]]==0) {
						R[M[i][j]] = 1;
					}else {
						row++;
					}
					if(C[M[j][i]]==0) {
						C[M[j][i]] = 1;
					}else {
						col++;
					}
				}
				if(row!=r) {
					r++;
					row = r;
				}
				if(col!=c) {
					c++;
					col = c;
				}
			}
			
			System.out.printf("Case #%d: %d %d %d\n",test,tra,row,col);
		}
	}
	
}
