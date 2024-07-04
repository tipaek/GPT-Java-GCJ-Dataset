/**
 * Round 1A 2020 - Code Jam 2020
 * 02 Pascal Walk
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Solution {
	public static int caseNum;
	public static String str;
	public static int[][] pTriangle;
	public static int[][] pTrace;
	public static int[][] wTrace;
	public static int steps;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("./src/cj2020/round01/a02/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		caseNum = Integer.parseInt(br.readLine().trim());
		
		pTriangle = new int[501][501];
		pTrace = new int[501][501];
		
		for(int r = 1; r <= 35; ++r) {
			pTriangle[r][1] = pTriangle[r][r] = 1;
			for(int k = 2; k < r; ++k) {
				pTriangle[r][k] = pTriangle[r-1][k-1] + pTriangle[r-1][k];
				
//				System.out.print(" " + pTriangle[r][k]);
			}
//			System.out.println();
		}

		for (int cn = 1; cn <= caseNum; ++cn) {
			int n = Integer.parseInt(br.readLine());
			wTrace = new int[501][2];
			pTrace = new int[501][501];
			steps = 0;
			
			walk(1, 1, n, 1);
			
//			String answer = "";
			
//			System.out.println("Case #" + cn + ": " + answer);
			System.out.println("Case #" + cn + ":");
			for(int i = 1; i <= steps; ++i) {
				System.out.println(wTrace[i][0] + " " + wTrace[i][1]);
			}
		}
	}
	
	public static boolean walk(int r, int k, int n, int s) {
		if(s >= 500) return false;
		
		if(r <= 0 || r > 35 || k <= 0 || k > 35 || k > r || n < 0 || pTrace[r][k] == 1) return false;
		
		
		int wValue = pTriangle[r][k];
		
		n -= wValue;
		if(n >= 0) {
			wTrace[s][0] = r;
			wTrace[s][1] = k;
			pTrace[r][k] = 1;
			if(n == 0) {
				steps = s;
				return true;
			}
		}
		
		boolean ret = false;
		
		ret = walk(r, k-1, n, s + 1);
		
		if(!ret) ret = walk(r, k+1, n, s + 1);
		
		if(!ret) ret = walk(r+1, k, n, s + 1);
		
		if(!ret) ret = walk(r+1, k+1, n, s + 1);
		
		if(!ret) ret = walk(r-1, k-1, n, s + 1);
		
		if(!ret) ret = walk(r-1, k, n, s + 1);
		
		if(!ret) pTrace[r][k] = 0;
		
		return ret;
	}
	
	

}
