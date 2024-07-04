import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Solution {

	//////////////////////////////////////////////////
	private static String solve(int x, int y, String m) {
		int dist = Math.abs(x) + Math.abs(y);
		char[] cs = m.toCharArray();
		for (int i = 0, len = cs.length; i < len; i++) {
			switch (cs[i]) {
			case 'N':
				y++;
				break;
			case 'S':
				y--;
				break;
			case 'E':
				x++;
				break;
			case 'W':
				x--;
				break;
			default:
				throw new IllegalArgumentException("Unknowm char (" + cs[i] + ") in " + m);
			}
			dist = Math.abs(x) + Math.abs(y);
			if (i + 1 >= dist)
				return String.valueOf(i + 1);
		}
		return "IMPOSSIBLE";
	}

	//////////////////////////////////////////////////
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int t = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int x = in.nextInt();
			int y = in.nextInt();
			String m = in.nextLine().trim();
			out.println("Case #" + i + ": " + solve(x, y, m));
		}
		in.close();
	}
}