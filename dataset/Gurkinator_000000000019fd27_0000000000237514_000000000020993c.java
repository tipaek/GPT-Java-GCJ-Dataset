import java.util.Scanner;

public class Solution {

	private Scanner scanner = new Scanner(System.in);

	int	r	= 0;
	int	c	= 0;

	private int solve() throws Exception {
		int n = scanner.nextInt();
		int	r	= 0;
		int	c	= 0;

		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		int	temp	= 0;
		int	trace	= 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (j == temp) {
					trace += matrix[i][j];
					temp++;
					break;
				}
			}
		}


		for (int i = 0; i < matrix.length; i++) {
			boolean	con	= false;
			int a = 0;
			for (int k = 0; k < matrix[i].length; k++) {
				if (con == false) {
					for (int j = 0; j < matrix[i].length; j++) {
						if (j == a) continue;
						if (matrix[i][j] == matrix[i][a]) {
							r++;
							con = true;
							break;
						}
					}
					a++;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			boolean	con	= false;
			int		a	= 0;
			for (int k = 0; k < n; k++) {
				if (con == false) {
					for (int j = 0; j < matrix.length; j++) {
						if (j == a) continue;
						if (matrix[j][i] == matrix[a][i]) {
							c++;
							con = true;
							break;
						}
					}
					a++;
				}
			}
		}
		this.r	= r;
		this.c	= c;

		return trace;
	}

	private void run() throws Exception {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("Case #%d: %d %d %d%n", i + 1, solve(), r, c);
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
