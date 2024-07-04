import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = scanner.nextInt();
		
		for (int x = 1; x <= t; ++x) {
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
			
			System.out.println("Case #" + x + ": " + sum + " " + rows + " " + cols);
		}
	}
}

/*
int n = scanner.nextInt();
			int[][] arr = new int[n][n];
			long sum = 0;
			int rows = 0;
			int cols = 0;
			HashMap<Integer, HashSet<Integer>> colMap = new HashMap<>();
			boolean[] repeatCols = new boolean[n];
			
			for (int i = 0; i < n; ++i) {
				boolean repeatRow = false;
				HashSet<Integer> rowSet = new HashSet<>();
				
				for (int j = 0; j < n; ++j) {
					int m = scanner.nextInt();
					arr[i][j] = m;
					if (i == j) {
						sum += m;
					}
					
					if (!repeatRow) {
						if (rowSet.contains(m)) {
							repeatRow = true;
							++rows;
						} else {
							rowSet.add(m);
						}
					}
					
					if (i == 0) {
						HashSet<Integer> colSet = new HashSet<>();
						colSet.add(m);
						colMap.put(j, colSet);
						repeatCols[j] = false;
					} else {
						if (!repeatCols[j]) {
							if (colMap.get(j).contains(m)) {
								++cols;
								repeatCols[j] = true;
							} else {
								colMap.get(j).add(m);
							}
						}
					}
				}
			}
			
			System.out.println("Case #" + (t + 1) + ": " + sum + " " + rows + " " + cols);
 */