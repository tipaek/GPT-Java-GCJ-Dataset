package vestigium;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < T; i++) {
			int N = scanner.nextInt();
			scanner.nextLine();
			
			int[][] M = new int[N][N];
			int[][] MTransposed = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					M[j][k] = scanner.nextInt();
					MTransposed[k][j] = M[j][k];
				}
				scanner.nextLine();
			}
			
			System.out.println("Case #" + (i + 1) + ": " + trace(M) + " " + repeatedNumbersInRows(M) + " " + repeatedNumbersInRows(MTransposed));
		}

		scanner.close();
	}
	
	public static int trace(int[][] M) {
		int trace = 0;
		for (int i = 0; i < M.length; i++) trace += M[i][i];
		return trace;
	}

	public static int repeatedNumbersInRows(int[][] M) {
		int repeated = 0;
		for (int j = 0; j < M.length; j++) {
			Set<Integer> set = new HashSet<Integer>();
			for (int k = 0; k < M.length; k++) {
				int prevSetSize = set.size();
				set.add(M[j][k]);
				if (prevSetSize == set.size()) {
					repeated++;
					break;
				}
			}
		}
		return repeated;
	}
}
