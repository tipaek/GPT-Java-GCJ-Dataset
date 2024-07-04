

import java.util.Scanner;

class Solution {

	static String map5[] = { "1 2 3 4 5,2 1 4 5 3,3 5 1 2 4,4 3 5 1 2,5 4 2 3 1","1 3 4 2 5,2 1 3 5 4,3 5 2 4 1,4 2 5 1 3,5 4 1 3 2",
			"1 3 4 2 5,2 1 5 4 3,3 2 1 5 4,4 5 2 3 1,5 4 3 1 2","1 3 4 2 5,2 1 3 5 4,3 5 1 4 2,4 2 5 3 1,5 4 2 1 3","1 3 4 2 5,2 4 5 3 1,3 2 1 5 4,4 5 3 1 2,5 1 2 4 3",
			"1 3 4 2 5,2 4 5 3 1,3 1 2 5 4,4 5 3 1 2,5 2 1 4 3","1 3 4 2 5,2 5 3 4 1,3 4 1 5 2,4 2 5 1 3,5 1 2 3 4","1 3 4 2 5,2 5 3 1 4,3 4 1 5 2,4 2 5 3 1,5 1 2 4 3",
			"1 3 4 2 5,2 5 3 1 4,3 4 2 5 1,4 1 5 3 2,5 2 1 4 3","1 3 4 2 5,2 5 1 4 3,3 4 2 5 1,4 1 5 3 2,5 2 3 1 4","1 3 4 5 2,2 4 3 1 5,3 2 5 4 1,4 5 1 2 3,5 1 2 3 4",
			"1 3 4 2 5,2 5 1 4 3,3 2 5 1 4,4 1 3 5 2,5 4 2 3 1","1 3 4 5 2,2 5 1 4 3,3 4 5 2 1,4 1 2 3 5,5 2 3 1 4","1 4 3 2 5,2 5 4 3 1,3 2 5 1 4,4 3 1 5 2,5 1 2 4 3",
			"1 4 2 3 5,2 5 4 1 3,3 2 5 4 1,4 3 1 5 2,5 1 3 2 4","3 1 2 4 5,2 5 4 3 1,4 3 5 1 2,1 2 3 5 4,5 4 1 2 3","3 4 1 2 5,2 5 4 1 3,1 3 5 4 2,4 2 3 5 1,5 1 2 3 4",
			"4 2 3 1 5,1 5 4 3 2,2 1 5 4 3,3 4 2 5 1,5 3 1 2 4","5 1 2 3 4,2 5 4 1 3,1 3 5 4 2,4 2 3 5 1,3 4 1 2 5" };

	static String map4[] = { "1 2 3 4,2 1 4 3,3 4 1 2,4 3 2 1","1 2 3 4,2 1 4 3,3 4 2 1,4 3 1 2","1 3 4 2,2 1 3 4,3 4 2 1,4 2 1 3","1 2 4 3,2 3 1 4,3 4 2 1,4 1 3 2",
			"1 2 4 3,2 4 3 1,3 1 2 4,4 3 1 2","1 3 2 4,2 4 1 3,3 1 4 2,4 2 3 1","1 3 2 4,2 4 1 3,3 2 4 1,4 1 3 2","1 3 2 4,2 4 3 1,3 1 4 2,4 2 1 3",
			"4 3 2 1,2 4 1 3,1 2 3 4,3 1 4 2","4 3 2 1,3 4 1 2,2 1 3 4,1 2 4 3","4 1 3 2,1 4 2 3,3 2 4 1,2 3 1 4" };

	static String map3[] = { "1 2 3,3 1 2,2 3 1","2 3 1,1 2 3,3 1 2","3 1 2,2 3 1,1 2 3" };

	static String map2[] = { "1 2,2 1", "2 1,1 2" };

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			if (n >= 2 && n <= 5) {
				String res = get(n, k);
				System.out.println("Case #" + i + ": " + res);

			} else
				System.out.println("Case #" + i + ": ");
		}
		sc.close();
	}

	private static String get(int n, int k) {
		String res = "";
		if (n == 2) {
			if (k % 2 != 0)
				return "IMPOSSIBLE";
			res = map2[k / 2 - 1];
		} else if (n == 3) {
			if (k % 3 != 0)
				return "IMPOSSIBLE";
			res = map3[k / 3 - 1];
		} else if (n == 4) {
			if (k == 5 || k == 15)
				return "IMPOSSIBLE";
			if (k == 4)
				res = map4[0];
			else if (k == 16)
				res = map4[map4.length - 1];
			else
				res = map4[k - 5];
		} else {
			if (k == 6 || k == 24)
				return "IMPOSSIBLE";
			if (k == 5)
				res = map4[0];
			if (k == 24)
				res = map4[map4.length - 1];
			else
				res = map5[k - 6];

		}

		String r[] = res.split(",");
		StringBuilder sb = new StringBuilder("POSSIBLE");
		for (int i = 0; i < r.length; i++) {
			if (i < r.length)
				sb.append("\n");
			sb.append(r[i]);
		}
		return sb.toString();
	}
}