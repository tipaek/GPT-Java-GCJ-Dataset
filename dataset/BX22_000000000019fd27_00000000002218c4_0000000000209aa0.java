import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int trace=in.nextInt ();
			int [][] grid=new int [n][n];
			for (int j=0; j<n; j++) {
				grid[0][j]=j+1;
			}
			int s=0;
			for (int k=1; k<n; k++) {
				s++;
				int count=s;
				for (int j=0; j<n; j++) {
					int num=grid[0][count%n];
					grid[k][j]=num;
					count++;
				}
			}
			if (trace>=n&&trace<=n*n&&trace%n==0) {
				int num=trace/n;
				int [][]copy=new int [n][n];
				for (int m=0; m<n; m++) {
					int res=search (grid, m, num);
					copy[res]=grid[m];
				}
				System.out.println("Case #" + i + ": POSSIBLE");
				for (int a=0; a<n; a++) {
					for (int b=0; b<n; b++) {
						System.out.print (copy[a][b]+" ");
					}
					System.out.println ();
				}

			}
			else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}
	}
	public static int search (int [][] grid, int start, int target) {
		for (int i=0; i<grid.length; i++) {
			if (grid[start][i]==target) return i;
		}
		return 0;
	}
}