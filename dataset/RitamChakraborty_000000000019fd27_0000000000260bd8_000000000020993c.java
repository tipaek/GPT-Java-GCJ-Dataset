import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		while (t-- > 0) {
			int n = scanner.nextInt();
			int[][] arr = new int[n][n];
			int rows = 0;
			int cols = 0;
			long sum = 0;
			
			for (int i = 0; i < n; ++i) {
				HashSet<Integer> set = new HashSet<>();
				boolean flag = false;
				
				for (int j = 0; j < n; ++j) {
					int m = scanner.nextInt();
					if (i == j) {
						sum += m;
					}
					arr[i][j] = m;
					
					if (!flag && set.contains(m)) {
						flag = true;
						++rows;
					} else {
						set.add(m);
					}
				}
			}
			
			for (int j = 0; j < n; ++j) {
				HashSet<Integer> set = new HashSet<>();
				boolean flag = false;
				
				for (int i = 0; i < n; ++i) {
					int m = arr[i][j];
					
					if (!flag && set.contains(m)) {
						flag = true;
						++cols;
					} else {
						set.add(m);
					}
				}
			}
			
			System.out.println("Case #" + (t + 1) + ": " + sum + " " + rows + " " + cols);
		}
	}
}