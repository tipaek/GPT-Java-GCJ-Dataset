import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		solve(in, System.out);
		in.close();
	}

	protected static void solve(Scanner in, PrintStream out) {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			String ret = solveLine(n);
			out.printf(Locale.ENGLISH, "Case #%d: %n%s", i, ret);
		}
	}

	private static String solveLine(int n) {
//		int check = 0;
		int row = 1, mask = 1;
		while ((row + 1) + (mask << 1) - 1 < n) {
			row++;
			mask <<= 1;
		}
		StringBuilder ans = new StringBuilder();
		int sum = 0;
		for (int i = 1; i < row; i++) {
			ans.append(i + " " + 1 + "\n");
//			check += pascal(i, i);
			sum++;
		}
		for (int i = 1; i <= row; i++) {
			ans.append(row).append(" ").append(i).append("\n");
//			check += pascal(row, i);
		}
		sum += mask; // -1
		while (sum < n) {
			row++;
			ans.append(row + " " + row + "\n");
//			check += pascal(row, row);
			sum++;
		}
//		assert (check == n);
		return ans.toString();
	}

	public static int pascal(int row, int col) {
		if (col < 0) return 0;
		if (col == 1) return 1;
		if (row == 1) return 1;
		if (col >= row) return 1;
		return pascal(row - 1, col - 1) + pascal(row - 1, col);
	}

}
