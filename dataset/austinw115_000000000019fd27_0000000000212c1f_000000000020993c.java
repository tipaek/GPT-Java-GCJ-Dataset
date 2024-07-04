import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] storage = new int[N][N];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					storage[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			int trace = printDiagonalSums(storage, N);
			int row = checkDuplicatesRow(storage, N);
			int column = checkDuplicatesColumn(storage, N);
			
			pw.println("Case #" + i + ": " + trace + " " + row + " " + column);
			
		}
		pw.close();
		
	}
	
	public static int printDiagonalSums(int[][] matrix, int n) { 
		int trace = 0;
		for (int i = 0; i < n; i++) { 
			for (int j = 0; j < n; j++) { 
				if (i == j) 
					trace += matrix[i][j]; 
			}	
		} 
		return trace;
	}
	
	public static int checkDuplicatesRow(int[][] matrix, int n) {
		int count = 0;
		boolean c = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int z = j+1; z < n; z++) {
					if (matrix[i][j]==matrix[i][z]) {
						count++;
						c = true;
						break;
					}
				}
				if (c) {
					c = false;
					break;
				}
			}
		}
		return count;
	}
	
	public static int checkDuplicatesColumn(int[][] matrix, int n) {
		int count = 0;
		boolean c = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int z = j+1; z < n; z++) {
					if (matrix[j][i]== matrix[z][i]) {
						count++;
						c = true;
						break;
					}
				}
				if (c) {
					c = false;
					break;
				}
			}
		}
		return count;
	}
}
