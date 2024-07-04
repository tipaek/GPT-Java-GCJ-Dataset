import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int n;
	static int[][] matrix;
	
	
	private static int[] testCase(Scanner in) {
		int[] res = new int[3];
		
		n = in.nextInt();
		
		matrix = new int[n+1][n+1];
		
		int f = n * (n+1) / 2;
		
		for(int i = 1; i <=n; i++) {
			for(int j= 1; j <= n; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		
		int[] col = new int[n+1];
		int[] rig = new int[n+1];
		
		for(int i = 1; i <=n ; i++) {
			res[0] += matrix[i][i];
			for(int j = 1; j <= n; j++) {
				col[i] += matrix[i][j];
				rig[i] += matrix[i][j];
			}
		}
		
		
		for(int i = 1; i <= n; i++) {
			if(col[i] != f) {
				res[2]++;
			}
			if(rig[i] != f) {
				res[1]++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			int[] out = testCase(in);
			System.out.println("Case #:" + i + out[0] + out [1] + out[2]);
		}
	}
}
