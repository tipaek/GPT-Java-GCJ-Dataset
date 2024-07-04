import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int testCases = scanner.nextInt();

		if (100 < testCases || testCases < 1)
			extracted();

		int[][] inputs = new int[testCases][];

		for (int t = 0; t < testCases; t++) {
			int n = scanner.nextInt();
			if (n < 2 || n > 50)
				extracted();

			int k = scanner.nextInt();
			//if (k < n || k > (n * n))
			//	extracted();

			inputs[t] = new int[] { n, k };

		}

		for (int t = 0; t < testCases; t++) {

			String result = "";

			int n = inputs[t][0];
			int k = inputs[t][1];

			long[][] matrix = new long[n][n];

			if (k % n == 0 && k <= (n * n))
			{
				result = "POSSIBLE";

				int quo = k / n;

				for (int row = 0; row < n; row++) {

					for (int col = 0; col < n; col++) {

						if(row==col)
						{
							matrix[row][row]=quo;
						}
						else if(col==0)
							matrix[row][col]=matrix[row-1][n-1];
						else
							matrix[row][col]=(matrix[row][col-1]+1)%n ==0 ? n : (matrix[row][col-1]+1)%n;
							
					}
					
				}

				System.out.println("Case #" + (t + 1) + ": " + result);
				for (int row = 0; row < n; row++) {
					for (int col = 0; col < n; col++) {

						System.out.print(matrix[row][col] + " ");
					}
					System.out.println();
				}

			} else {
				result = "IMPOSSIBLE";
				System.out.println("Case #" + (t + 1) + ": " + result);
			}

		}

	}

	private static void extracted() throws Exception {
		throw new Exception();
	}
}
