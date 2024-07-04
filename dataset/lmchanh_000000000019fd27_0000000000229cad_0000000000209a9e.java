import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int T = in.nextInt();
		int B = in.nextInt();

		for (int i = 1; i <= T; ++i) {
			solve(in, i, B);
		}

		in.close();
	}

	private static void solve(Scanner in, int num, int length) {
		String answer = "";
		for (int i = 1; i <= length; i++) {
			System.out.println(i);
			answer += in.next();
		}
		
		System.out.println(answer);
		if (!in.next().equals("Y")) {
			System.exit(0);
		}
	}
}