import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static final boolean DEBUG = false;
	
	private static String solve(int[][] mat) {
		String result = "";
		int n = mat.length;
		int[] row = new int[n];
		int[] col = new int[n];
		int diagSum = 0;
		Arrays.fill(row, 0);
		Arrays.fill(col, 0);
		int r = 0, c = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				row[mat[i][j] - 1] = 1;
				col[mat[j][i] - 1] = 1;
				if(i == j) diagSum += mat[i][j];
			}
			for(int k = 0; k < n; k++) {
				if(row[k] == 0) {
					r++;
					break;
				}
			}
			for(int k = 0; k < n; k++) {
				if(col[k] == 0) {
					c++;
					break;
				}
			}
			Arrays.fill(row, 0);
			Arrays.fill(col, 0);
		}	
		result = diagSum + " " + r + " " + c;
		return result;
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("resources/vestigium.in") : System.in;
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		int testCount = scanner.nextInt();
		for(int testNum = 1;  testNum <= testCount; testNum++) {
			int n = scanner.nextInt();
			int[][] mat = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					mat[i][j] = scanner.nextInt();
				}
			}
			String result = solve(mat);
			System.out.println("Case #" + testNum + ": " + result);			
		}		
		scanner.close();
		//System.err.println("Solved in: " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
	}

}
