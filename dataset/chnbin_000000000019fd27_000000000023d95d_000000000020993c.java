import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] grid = new int[N][N];
			int sum = 0;
			int rowRepeat = 0;
			int colRepeat = 0;
			
			
			for (int j = 0; j < N; j++) {
				boolean isRowRepeat = false;
				Set<Integer> rowSet = new HashSet<>();
				for (int k = 0; k < N; k++) {
					int num = sc.nextInt();
					if (rowSet.contains(num)) {
						isRowRepeat = true;
					} else {
						rowSet.add(num);
					}
					grid[j][k] = num;
					
					if (j == k) {
						sum += num;
					}
				}
				if (isRowRepeat) { rowRepeat++; }
			}
			
			
			for (int cols = 0; cols < N; cols++) {
				boolean iscolRepeat = false;
				Set<Integer> colSet = new HashSet<>();
				for (int rows = 0; rows < N; rows++) {
					int num = grid[rows][cols];
					if (colSet.contains(num)) {
						iscolRepeat = true;
					} else {
						colSet.add(num);
					}
				}
				if (iscolRepeat) { colRepeat++; }
			}
			
			System.out.println("Case #" + i + ": "+sum + " " + rowRepeat + " " + colRepeat);
		}
	}
}
