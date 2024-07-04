
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
private static final boolean DEBUG = false;
	
	private static String solve(int[][] interval) {
		StringBuilder result = new StringBuilder();
		Arrays.sort(interval, (int[] a, int[] b) -> a[0] - b[0]);
		char[] cj = {'C','J'};
		int[] end = new int[2];
		Arrays.fill(end, 0);
		int idx = 0;
		
		for(int i  = 0; i < interval.length; i++) {
			int[] ith = interval[i];
			if(end[idx] <= ith[0]) {
				end[idx]  = ith[1];
				result.append(cj[idx]);
			}else {
				idx = (idx+1) % 2;
				if(end[idx] <= ith[0]) {
					end[idx] = ith[1];
					result.append(cj[idx]);
				}else {
					return "IMPOSSIBLE";
				}
			}
		}
		
		return result.toString();
	}

	public static void main(String[] args) throws FileNotFoundException {
		long startTime = System.nanoTime();
		InputStream is = DEBUG ? new FileInputStream("resources/parenting.in") : System.in;
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
		int testCount = scanner.nextInt();
		for(int testNum = 1;  testNum <= testCount; testNum++) {
			int n = scanner.nextInt();
			int[][] interval = new int[n][2];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < 2; j++) {
					interval[i][j] = scanner.nextInt();
				}
			}
			String result = solve(interval);
			System.out.println("Case #" + testNum + ": " + result);			
		}		
		scanner.close();
		//System.err.println("Solved in: " + ((System.nanoTime() - startTime) / 1e9) + " seconds.");
	}

}
