
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		int testCases;
		try {
			testCases = Integer.parseInt(br.readLine());
			for (int cases = 0; cases < testCases; cases++) {
				int sum = Integer.parseInt(br.readLine());
				int n = sum;
				int[][] arr = new int[n][n];
				int index = 0, tempSum = 1;
				for (int i = 1; i <= 1000; i++) {
					if (sum >= tempSum) {
						tempSum += Math.pow(2, i);
						index += 1;
					} else {
						break;
					}
				}

				for (int line = 0; line < n; line++) {
					for (int i = 0; i <= line; i++) {
						if (line == i || i == 0)
							arr[line][i] = 1;
						else
							arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
					}
				}
				System.out.println("Case #" + (cases + 1) + ": ");
				//System.out.println("sa"+index);
				boolean flag = false;
				abc: for (int i = 0; i < n; i++) {
					if (i < index) {
						if (flag) {
							for (int j = 0; j < n; j++) {
								if (arr[i][j] != 0) {
									sum = sum - arr[i][j];
									// System.out.println((arr[i][j]);
									System.out.println((i + 1) + " " + (j + 1));
								}
								if (sum <= 0) {
									break abc;
								}
							}
						} else {
							for (int j = n - 1; j >= 0; j--) {
								if (arr[i][j] != 0) {
									sum = sum - arr[i][j];
									System.out.println((i + 1) + " " + (j + 1));
								}
								if (sum <= 0) {
									break abc;
								}
							}
						}
						flag = flag ? false : true;
					} else {
						//System.out.println("else"+sum);
						if (flag) {
							if (sum == 0) {
								break abc;
							}
							sum -= arr[i][0];
							System.out.println((i + 1) + " " + (1));
						}
						else {
							for (int j = n - 1; j >= 0; j--) {
								if (sum == 0) {
									break abc;
								}
								if (arr[i][j] != 0) {
									sum = sum - arr[i][j];
									System.out.println((i + 1) + " " + (j + 1));
									break;
								}
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
