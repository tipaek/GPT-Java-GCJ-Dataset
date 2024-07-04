import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		// Only use for local test cases 
		// Remove when submitting on code jam
//		File test =  new File("src/Vertigium/test1");
		
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		
		for (int i = 1; i <= numCases; i++) {
			int n = in.nextInt();
			int[][] arr = new int[n][n];
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					arr[j][k] = in.nextInt();
				}
			}
	
			inspect(i, arr, n);
			if (i != numCases) System.out.print("\n");
		}
		
	}
	
	private static void inspect(int caseNum, int[][] arr, int n) {
		int r = 0;
		int c = 0;
		
		for (int i = 0; i < n; i++) {
			boolean[] hits = new boolean[n+1];
			for (int j = 0; j < n; j++) {
				if (hits[arr[i][j]]) {
					r++;
					break;
				} else {
					hits[arr[i][j]] = true;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			boolean[] hits = new boolean[n+1];
			for (int j = 0; j < n; j++) {
				if (hits[arr[j][i]]) {
					c++;
					break;
				} else {
					hits[arr[j][i]] = true;
				}
			}
		}
		
		int trace = 0;
		for (int i = 0; i < n; i++) {
			trace += arr[i][i];
		}
		
		System.out.printf("Case #%d: %d %d %d", caseNum, trace, r, c);
	}
}
