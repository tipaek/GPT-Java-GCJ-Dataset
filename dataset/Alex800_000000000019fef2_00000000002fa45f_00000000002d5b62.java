import java.util.*;
import java.io.*;

public class Solution {
	// static class Tuple implements Comparable<Tuple> {
	// int n1;
	// int n2;
	// boolean s;
	//
	// public Tuple(int n1, int n2, boolean s) {
	// this.n1 = n1;
	// this.n2 = n2;
	// this.s = s;
	// }
	//
	// public int compareTo(Tuple a) {
	// if (n1 == a.n1 && !s && a.s)
	// return -1;
	// else if (n1 == a.n1 && !a.s && s)
	// return 1;
	// else
	// return n1 - a.n1;
	// }
	// }
	// public static String binary(int i) {
	// if (i == 1)
	// return "1";
	// else if (i == 0)
	// return "0";
	// return (i % 2) + binary(i / 2);
	// }

	public static String answer(int x, int y) {
		if (x % 2 == y % 2)
			return "IMPOSSIBLE";

		if (x <= 1 && y <= 1)
			if (x == 1)
				return "E";
			else
				return "N";

		if (x % 2 == 1)
			if ((x - 1) % 4 == y % 4)
				return "W" + answer((x + 1) / 2, y / 2);
			else
				return "E" + answer(x / 2, y / 2);

		if (y % 2 == 1)
			if ((y - 1) % 4 == x % 4)
				return "S" + answer(x / 2, (y + 1) / 2);
			else
				return "N" + answer(x / 2, y / 2);

		return "what the";
	}

	public static String opposite(String s, boolean x, boolean y) {
		String ans = "";

		for (int i = 0; i < s.length(); i++)
			switch (s.charAt(i)) {
			case 'N':
				if (x)
					ans += "N";
				else
					ans += "S";
				break;
			case 'S':
				if (x)
					ans += "S";
				else
					ans += "N";
				break;
			case 'W':
				if (y)
					ans += "W";
				else
					ans += "E";
				break;
			case 'E':
				if (y)
					ans += "E";
				else
					ans += "W";
				break;
			}

		return ans;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(
				new BufferedReader(new InputStreamReader(System.in)));

		int T = in.nextInt();

		for (int t = 1; t <= T; ++t) {
			int X = in.nextInt();
			int Y = in.nextInt();

			boolean x = true;
			boolean y = true;

			if (X < 0) {
				X = X * (-1);
				x = false;
			}

			if (Y < 0) {
				Y = Y * (-1);
				y = false;
			}

			String ans = answer(X, Y);
			if (!ans.equals("IMPOSSIBLE"))
				ans = opposite(ans, x, y);

			System.out.println("Case #" + t + ": " + ans);
		}
		in.close();
	}
}