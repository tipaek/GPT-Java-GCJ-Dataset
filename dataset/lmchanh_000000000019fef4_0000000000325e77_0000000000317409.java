import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			System.out.print("Case #" + i + ": ");
			solve(in);
		}

		in.close();
	}

	private static void solve(Scanner in) {
		int distanceX = in.nextInt();
		int distanceY = in.nextInt();
		String path = in.next();

		for (int i = 0; i < path.length(); i++) {
			switch (path.charAt(i)) {
			case 'S':
				distanceY--;
				break;
			case 'N':
				distanceY++;
				break;
			case 'W':
				distanceX--;
				break;
			case 'E':
				distanceX++;
				break;
			}

			int distance = Math.abs(distanceX) + Math.abs(distanceY);
			int walked = i + 1;
			if (distance <= walked) {
				System.out.println(String.valueOf(walked));
				return;
			}
		}

		System.out.println("IMPOSSIBLE");
	}
}