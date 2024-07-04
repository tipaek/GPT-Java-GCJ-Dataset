import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String result = solveProblem(in);
		System.out.println(result);
	}

	public static String solveProblem(Scanner scanner) {
		String result = "";
		int t = scanner.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = scanner.nextInt();
			int[][] array = new int[n][n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++ ) {
					array[x][y] = scanner.nextInt();
				}
			}
			result+="Case #" + i + ": " + solveCase(n, array) + "\n";
		}

		return result;
	}

	public static String solveCase(int n, int[][] array) {
		int k = 0;
		for (int i = 0; i < n; i++) {
			k+= array[i][i];
		}
		List<Integer> tmp = new ArrayList<>();
		int c = 0;
		for (int x = 0; x < n; x++) {
			boolean foundDup = false;
			for(int y = 0; y < n; y++) {
				if (tmp.contains(array[x][y])) {
					foundDup = true;
					y = n;
				} else {
					tmp.add(array[x][y]);
				}
			}
			if (foundDup) {
				c++;
			}
			tmp.clear();
		}
		int r = 0;
		for (int y = 0; y < n; y++) {
			boolean foundDup = false;
			for(int x = 0; x < n; x++) {
				if (tmp.contains(array[x][y])) {
					foundDup = true;
					x = n;
				} else {
					tmp.add(array[x][y]);
				}
			}
			if (foundDup) {
				r++;
			}
			tmp.clear();
		}
		return k + " " + r + " "+ c;
	}
	
	
}
