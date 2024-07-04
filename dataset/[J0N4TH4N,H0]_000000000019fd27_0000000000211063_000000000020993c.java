import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		
//		BufferedReader f = new BufferedReader(new  FileReader (new  File("sample.txt")));	
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sample.txt")));
//		StringTokenizer st = new StringTokenizer(f.readLine());

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));	
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(f.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < T; i++) {
			out.print("Case #" + (i+1) + ": ");
			st = new StringTokenizer(f.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] mat = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(f.readLine());
				int[] row = new int[N];
				for (int k = 0; k < N; k++) {
					row[k] = Integer.parseInt(st.nextToken());
				}
				mat[j] = row;
			}
			
			out.println(trace(mat, N) + " " + (N-row(mat, N)) + " " + (N-col(mat, N)));
		}
		
		out.close();
	}
	
	public static int row(int[][] mat, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (checkRow(mat, n, i)) {
				count++;
			}
		}
		return count;
	}
	
	public static int col(int[][] mat, int n) {
		int count = 0;
		for (int j = 0; j < n; j++) {
			if (checkRow(mat, n, j)) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean checkRow(int[][] mat, int n, int i) {
		int[] arr = new int[n+1];
		for (int j = 0; j < n; j++) {
			int value = mat[i][j];
			if (arr[value] > 0) {
				return false;
			}
			arr[value]++;
		}
		return true;
	}
	
	public static boolean checkCol(int[][] mat, int n, int j) {
		int[] arr = new int[n+1];
		for (int i = 0; i < n; i++) {
			int value = mat[i][j];
			if (arr[value] > 0) {
				return false;
			}
			arr[value]++;
		}
		return true;
	}
	
	public static int trace(int[][] mat, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += mat[i][i];
		}
		return sum;
	}
}


