import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static long[][] choose;

	public static void main(String[] args) {
		choose = new long[502][502];
		for (int x = 0; x < choose.length; x++) {
			choose[x] = new long[x + 1];
			choose[x][0] = choose[x][x] = 1;
			for (int y = 1; y < x; y++)
				choose[x][y] = choose[x - 1][y - 1] + choose[x - 1][y];
		}
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = in.nextInt();
			System.out.printf("Case #%d:\n", t);
			sum = 0;
			solve(n);
//			System.err.println(sum);
		}
	}

	static void solve(long n) {
		for (int rows = 1; rows <= 501; rows++) {
			for (int bits = 1; bits <= 32 && bits <= rows; bits++) {
				long cn = n - (rows - bits);
				if (cn < 0)
					continue;
				String s = Long.toBinaryString(cn);
				if (cn == 0 || s.length() <= rows && Long.bitCount(cn) == bits) {
//					System.out.println("going to get +" + (rows-bits) + " from non-bit rows, rows=" + rows + " bits=" + bits);
					boolean atStart = true;
					for (int row = 0; row < rows; row++) {
						if (atStart) {
							print(row, 0);
						} else {
							print(row,row);
						}
						
						char curChar = row < s.length() ? s.charAt(s.length()-1-row) : '0';
						
						if (curChar == '1') {
							if (atStart) {
								for (int col = 1; col < row+1; col++) {
									print(row,col);
								}
							} else {
								for (int col = row - 1; col >= 0; col--) {
									print(row,col);
								}
							}
							atStart = !atStart;
//							System.out.println("filled out row " + row + ", so flipped to " + atStart);
						}

					}

					return;
				}

			}
		}

	}
	static long sum = 0;
	static void print(int row, int col) {
		System.out.println((row+1) + " " + (col+1));
		sum += choose[row][col];
	}
}
