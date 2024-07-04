import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = in.nextInt();

			for (int i = 0; i < numOfTestCases; i++) {
				int n = in.nextInt();
				int[][] matrix = new int[n][n];
				for (int y = 0; y < n; y++) {
					for (int x = 0; x < n; x++) {
						int value = in.nextInt();
						matrix[y][x] = value;
					}
				}
				solve(matrix, n, i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static void solve(int[][] matrix, int n, int testcase) {
		int trace = 0;
		int repeatedRows = 0;
		int repeatedColumns = 0;
		
		
		for (int i = 0; i < n; i++) {
			int y = i;
			int x = i;
			
			trace += matrix[y][x];
			
			int rowX = i;
			int rowY = 0;
			
			Set<Integer> seen;
			
			seen = new HashSet<Integer>();
			for (; rowY < n; rowY++) {
				int cell = matrix[rowY][rowX];
				if (seen.contains(cell)) {
					repeatedColumns++;
					break;
				}
				seen.add(cell);
			}
			
			int columnX = 0;
			int columnY = i;

			seen = new HashSet<Integer>();
			for (; columnX < n; columnX++) {
				int cell = matrix[columnY][columnX];
				if (seen.contains(cell)) {
					repeatedRows++;
					break;
				}
				seen.add(cell);
			}
		}
		
		System.out.println(String.format("Case #%d: %d %d %d", testcase, trace, repeatedRows, repeatedColumns));
	}

}
