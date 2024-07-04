package qualification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int n;
	static int[][] matrix;
	static int[][] matrix1;
	
	private static boolean check(int[] arrs) {
		for(int i = 1; i < arrs.length; i++) {
			for(int j = i+1; j < arrs.length; j++) {
				if(arrs[i] == arrs[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	private static int[] testCase(Scanner in) {
		int[] res = new int[3];
		
		n = in.nextInt();
		
		matrix = new int[n+1][n+1];
		matrix1 = new int[n+1][n+1];

		
		for(int i = 1; i <=n; i++) {
			for(int j= 1; j <= n; j++) {
				matrix[i][j] = in.nextInt();
				matrix1[j][i] = matrix[i][j];
			}
			res[0] += matrix[i][i];
		}
		
		for(int i = 1; i <= n; i++) {
			res[1] += check(matrix[i]) ? 1 : 0;
			res[2] += check(matrix1[i]) ? 1 : 0;

		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for(int i = 1; i <= t; i++) {
			int[] out = testCase(in);
			System.out.println("Case #"+ i + ": "+  out[0] + " " +  out [1] +  " " + out[2]);
		}
		
//		int[] arr = new int[] {1, 2, 3, 5, 9,6 };
//		
//		System.out.println(check(arr));
	}
}
