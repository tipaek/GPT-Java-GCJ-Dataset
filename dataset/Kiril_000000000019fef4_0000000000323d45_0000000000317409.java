
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		final InputStream is;
		if (args.length == 0) {
			is = System.in;
		} else {
			is = new FileInputStream(args[0]);
		}
		final Scanner s = new Scanner(new BufferedInputStream(is));
		final PrintStream pw = System.out;
		final int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			pw.print("Case #");
			pw.print(i);
			pw.print(": ");
			solution(s, pw);
		}
		pw.flush();
	}

	private static void solution(Scanner s, PrintStream pw) {
		int x = s.nextInt();
		int y = s.nextInt();
		if (dist(x, y) == 0) {
			pw.println(0);
			return;
		}

		String path = s.next();
		for (int i = 0; i < path.length(); i++) {
			char ch = path.charAt(i);
			switch (ch) {
			case 'S':
				y--;
				break;
			case 'N':
				y++;
				break;
			case 'W':
				x--;
				break;
			case 'E':
				x++;
				break;
			}
			int d = dist(x, y);
			if (d <= i + 1) {
				pw.println(i + 1);
				return;
			}
		}

		pw.println("IMPOSSIBLE");
	}

	private static int dist(int x, int y) {
		return Math.abs(x) + Math.abs(y);
	}

}
