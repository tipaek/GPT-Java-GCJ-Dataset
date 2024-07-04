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
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[R][C];
			
			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(f.readLine());
				for (int k = 0; k < C; k++) {
					matrix[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			out.println(sum(matrix)+simulate(matrix));
		}
		
		out.close();
	}
	
	
	public static int sum(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}
	
	public static int simulate (int[][] matrix) {
		int count = 0;
		
		boolean[][] deleted = new boolean[matrix.length][matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				boolean curr = remove(i, j, matrix);
				deleted[i][j] = curr;
				if (curr) { count++; }
			}
		}
		
//		System.out.println("[");
//		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(Arrays.toString(matrix[i]));
//		}
//		System.out.println("]");
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (deleted[i][j]) {
					matrix[i][j] = 0;
				}
			}
		}
		
		if (count == 0) {
			return 0;
		} else {
			return sum(matrix) + simulate(matrix);
		}
	}
	
	
	public static boolean remove (int r, int c, int[][] matrix) {
		double a = 0;
		int count = 0;
		
		int i = r-1;
		boolean up = false;
		while(i >= 0 && !up) {
			if (matrix[i][c] != 0) {
				up = true;
				a += matrix[i][c];
				count++;
			} else {
				i--;
			}
		}
		
		int j = r+1;
		boolean down = false;
		while(j < matrix.length && !down) {
			if (matrix[j][c] != 0) {
				down = true;
				a += matrix[j][c];
				count++;
			} else {
				j++;
			}
		}
		
		int k = c-1;
		boolean left = false;
		while(k >= 0 && !left) {
			if (matrix[r][k] != 0) {
				left = true;
				a += matrix[r][k];
				count++;
			} else {
				k--;
			}
		}
		
		int l = c+1;
		boolean right = false;
		while(l < matrix[0].length && !right) {
			if (matrix[r][l] != 0) {
				right = true;
				a += matrix[r][l];
				count++;
			} else {
				l++;
			}
		}		
		
		return (a/count > matrix[r][c]) && matrix[r][c] != 0;
	}
}


