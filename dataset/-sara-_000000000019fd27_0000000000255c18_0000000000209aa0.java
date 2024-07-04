import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			boolean caseSolved = false;
			int n = in.nextInt();
			int k = in.nextInt();
			int[][] matrix = new int[n][n];
			if (k % n == 0) {
				int diagonalElement = k /n;
				for (int j = 0; j < n ; j++) {
					matrix[j][j] = diagonalElement;
					for (int m = 1; m < n; m++) {
						matrix[j][(m+j)%n] = (diagonalElement-1 + m) % (n) + 1;
					}
				}
				System.out.println("Case #" + i + ": " + "POSSIBLE");
				for (int j = 0; j < n; j++) {
					System.out.println(Arrays.toString(
							matrix[j]).replace("[", "").replace(",", "").replace("]", ""));
				}
			} else if (k == Math.pow(n,2) -1 || k == n + 1 || (n == 3 && k == 5) ||
					(n == 3 && k == 7)) {
				System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
			} else {
				for (int j = 1; j <= n; j++) {
					int remainder = k - (n-2)*j;
					if (remainder % 2 == 0 && remainder < 2*n && remainder / 2 != j) {
						for (int m = 0; m < n-2; m++) {
							matrix[m][m] = j;
							matrix[m][(m+1) % (n-2)] = remainder / 2;
						}
						for (int m = n-2; m < n; m++) {
							matrix[m][m] = remainder / 2;
						}
						matrix[n-2][n-1] = j;
						matrix[n-1][n-2] = j;
						List<Integer> remainingNumbers = new ArrayList<Integer>();
						for (int x = 1; x <= n; x++) {
							if (x != j && x != remainder / 2) {
								remainingNumbers.add(x);
							}
						}
						for (int m = 0; m < n-2; m++) {
							matrix[m][n-1] = remainingNumbers.get(m);
							matrix[(m+1)%(n-2)][n-2]  = remainingNumbers.get(m);
						}
						if (n > 4) {
							for (int m = 0; m < n-2; m++) {
								matrix[m][(m+2)%(n-2)] = remainingNumbers.get((m+1)%(n-2));
							}
						}
						for (int m = 0; m < n-2; m++) {
							matrix[n-2][m] = remainingNumbers.get(m);
							matrix[n-1][m] = remainingNumbers.get((m+1)%(n-2));
						}
						System.out.println("Case #" + i + ": " + "POSSIBLE");
						for (int m = 0; m < n; m++) {
							System.out.println(Arrays.toString(
									matrix[m]).replace("[", "").replace(",", "").replace("]", ""));
						}
						caseSolved = true;
						break;
					}
				}
				if (caseSolved ) {
					continue;
				}
				for (int j = 1; j <= n; j++) {
					int remainder = k - (n-2)*j;
					if (remainder < 2*n && remainder/2 != j && remainder/2 != j-1) {
						for (int m = 0; m < n-2; m++) {
							matrix[m][m] = j;
						}
						matrix[n-1][n-1] = remainder/2 + 1;
						matrix[n-2][n-2] = remainder/2;
						matrix[n-2][n-1] = j;
						matrix[n-1][n-2] = j;
						List<Integer> remainingNumbers = new ArrayList<Integer>();
						for (int x = 1; x <= n; x++) {
							if (x != j && x != remainder/2 && x != remainder/2 + 1) {
								remainingNumbers.add(x);
							}
						}
						matrix[0][n-1] = remainder/2;
						matrix[1][n-2] = remainder/2 + 1;
						matrix[0][1] = remainder/2 + 1;
						matrix[1][0] = remainder/2;
						matrix[n-2][0] = remainder/2 + 1;
						matrix[n-1][1] = remainder/2;
						for (int m = 0; m < n-3; m++) {
							matrix[m+1][n-1] = remainingNumbers.get(m);
							matrix[n-2][m+1] = remainingNumbers.get(m);
						}
						matrix[0][n-2] = remainingNumbers.get(0);
						matrix[n-1][0] = remainingNumbers.get(0);
						for (int m = 2; m < n-3; m++) {
							matrix[m][n-2] = remainingNumbers.get(m-1);
							matrix[n-1][m] = remainingNumbers.get(m-1);
						}
						System.out.println("Case #" + i + ": " + "POSSIBLE");
						for (int m = 0; m < n; m++) {
							System.out.println(Arrays.toString(
									matrix[m]).replace("[", "").replace(",", "").replace("]", ""));
						}
						caseSolved = true;
						break;
					}
				}
				if (!caseSolved) {
					System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
				}
			}
		}
		in.close();
	}
}
