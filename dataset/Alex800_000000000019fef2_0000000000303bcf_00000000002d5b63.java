import java.util.*;
import java.io.*;

public class Solution {
	static int A = 0;
	static int B = 0;
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

	public static int[] findHor(int x, int y, Scanner in) {
		int lboundary = (x - 2 * A >= -1000000000) ? x - 2 * A : -1000000000;
		int rboundary = x;
		int Left = binaryFind(lboundary, rboundary, y, in, 1);
		if (Left == 1000000001) {
			int[] ans = { Left, Left };
			return ans;
		}

		rboundary = x;
		lboundary = (x + 2 * A >= 1000000000) ? 1000000000 : x + 2 * A;
		int Right = binaryFind(rboundary, lboundary, y, in, -1);
		if (Right == 1000000001) {
			int[] ans = { Right, Right };
			return ans;
		}

		int[] ans = { Left, Right};
		return ans;
	}

	public static int findVer(int x, int y, Scanner in) {
		int lboundary = (y - 2 * A >= -1000000000) ? y - 2 * A : -1000000000;
		int rboundary = y;
		int Lower = binaryFindV(lboundary, rboundary, x, in, 1);
		return Lower;
	}

	public static int binaryFindV(int lboundary, int rboundary, int y,
			Scanner in, int L) {
		if (lboundary == rboundary)
			return lboundary;

		int M = (lboundary + rboundary) / 2;
		String guess = y + " " + String.valueOf(M);
		System.out.println(guess);

		String res = in.next();

		if (res.equals("CENTER"))
			return 1000000001;
		if (res.equals("HIT")) {
			guess = y + " " + String.valueOf(M - L);
			System.out.println(guess);

			String res2 = in.next();

			if (res2 == "HIT")
				return binaryFindV(lboundary, M - L, y, in, L);
			else
				return M;
		} else {
			guess = y + " " + String.valueOf(M + L);
			System.out.println(guess);

			String res2 = in.next();

			if (res2 == "HIT")
				return M + L;
			return binaryFindV(M + L, rboundary, y, in, L);
		}

	}

	public static int binaryFind(int lboundary, int rboundary, int y,
			Scanner in, int L) {
		if (lboundary == rboundary)
			return lboundary;

		int M = (lboundary + rboundary) / 2;
		String guess = String.valueOf(M) + " " + y;
		System.out.println(guess);

		String res = in.next();

		if (res.equals("CENTER"))
			return 1000000001;
		if (res.equals("HIT")) {
			guess = String.valueOf(M - L) + " " + y;
			System.out.println(guess);

			String res2 = in.next();

			if (res2 == "HIT")
				return binaryFind(lboundary, M - L, y, in, L);
			else
				return M;
		} else {
			guess = String.valueOf(M + L) + " " + y;
			System.out.println(guess);

			String res2 = in.next();

			if (res2 == "HIT")
				return M + L;
			return binaryFind(M + L, rboundary, y, in, L);
		}

	}

	public static void solve(String s, Scanner in) {
		int ind = s.indexOf(" ");
		int x = Integer.parseInt(s.substring(0, ind));
		int y = Integer.parseInt(s.substring(ind + 1));
		
		int[] hor = findHor(x, y, in);
		if (hor[0] == 1000000001)
			return;
				
		int lower = findVer(x, y, in);
		if (lower == 1000000001)
			return;
		
		int up = y + (x - hor[0]) * (hor[1] - x) / (y - lower);
		
		int centerX = (hor[0] + hor[1])/2;
		int centerY = (lower + up)/2;
		
		String guess = centerX + " " + centerY;
		System.out.println(guess);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(
				new BufferedReader(new InputStreamReader(System.in)));

		int T = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();

		for (int t = 1; t <= T; ++t) {
			String[] guesses = { "0 0", "1000000000 1000000000",
					"-1000000000 1000000000", "1000000000 -1000000000",
					"-1000000000 -1000000000" };
			boolean hit = false;
			int count = 0;

			while (hit == false) {
				String guess = guesses[count];

				System.out.println(guess);
				String s = in.next();
				if (s.equals("CENTER"))
					return;
				if (s.equals("HIT"))
					hit = true;
				count++;
			}

			solve(guesses[--count], in);
		}
		in.close();
	}
}