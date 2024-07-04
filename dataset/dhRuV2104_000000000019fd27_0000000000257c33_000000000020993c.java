import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();

			int[][] matrix = new int[n][n];

			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++)
					matrix[j][k] = in.nextInt();
			
		    int[] ans = getTrace(matrix);
			
			System.out.println("Case #" + i + ": " + ans[0] + " " + ans[1] + " " + ans[2]);

		}
	}

	private static int[] getTrace(int[][] matrix) {
		int n = matrix.length;
		
		int[] ans = new int[3];
		int k = 0,r=0,c=0;
		
		int m = 0;
		while(m < n) {
			k += matrix[m][m];
			m++;
		}
		
		for(int i= 0;i<n;i++) {
			Set<Integer> uniq = new HashSet<>();
			for(int j = 0;j<n;j++) {
				if(uniq.contains(matrix[i][j])){
					r++; 
					break;
				}
				uniq.add(matrix[i][j]);
			}
		}
		
		for(int i= 0;i<n;i++) {
			Set<Integer> uniq = new HashSet<>();
			for(int j = 0;j<n;j++) {
				if(uniq.contains(matrix[j][i])){
					c++; 
					break;
				}
				uniq.add(matrix[j][i]);
			}
		}
		
		ans[0] = k;
		ans[1] = r;
		ans[2] = c;
		
		return ans;
	}
}