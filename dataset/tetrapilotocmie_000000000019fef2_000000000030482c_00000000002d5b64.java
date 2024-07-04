import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	void solve(int R, int S) {
		// moves
		// ai, bi
		int moves = (R-1) * (S-1);
		System.out.println(moves);

		int bottomSize = 1;

		for (int r = R; r > 1; r--) {
			for (int s = 0; s < S-1; s++) {
				// trebuie sa mut r-1 elemente de la pozitia bottom -1;
				int a = R*S - (r-1) - bottomSize;
				int b = r-1;
				System.out.println(a + " " + b);
				bottomSize++;
			}
			bottomSize++;
		}
	}

	private static Scanner scanner;
	public static void main(String[] args) {
		scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();

		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			new Solution().solve(scanner.nextInt(), scanner.nextInt());
		}
	}
}