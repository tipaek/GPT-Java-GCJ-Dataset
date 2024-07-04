import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int N = input.nextInt();
			int k = input.nextInt();
				if (k % N == 0 && k <= (N*N))
					System.out.println("Case #" + t + ": POSSIBLE");
				else
					System.out.println("Case #" + t + ": IMPOSSIBLE");
		}
		input.close();
	}

}

