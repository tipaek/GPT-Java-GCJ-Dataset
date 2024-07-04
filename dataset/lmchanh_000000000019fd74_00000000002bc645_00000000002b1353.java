import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			solve(in, i);
		}

		in.close();
	}

	private static void solve(Scanner in, int num) {
		int n = in.nextInt();

		System.out.println("Case #" + num + ":");
		System.out.println("1 1");

		int row = 2;
		while (n > row) {
			System.out.println(row + " 2");
			n -= (row - 1);
			row++;
		}

		row--;
		while (n > 1) {
			System.out.println(row + " 1");
			n--;
			row++;
		}
	}
}