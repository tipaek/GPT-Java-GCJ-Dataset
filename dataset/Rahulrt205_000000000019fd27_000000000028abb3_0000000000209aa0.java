import java.util.Scanner;

class Solution {

	static String map5[] = { "12345,21453,35124,43512,54231", "13425,21354,35241,42513,54132",
			"13425,21543,32154,45231,54312", "13425,21354,35142,42531,54213", "13425,24531,32154,45312,51243",
			"13425,24531,31254,45312,52143", "13425,25341,34152,42513,51234", "13425,25314,34152,42531,51243",
			"13425,25314,34251,41532,52143", "13425,25143,34251,41532,52314", "13452,24315,32541,45123,51234",
			"13425,25143,32514,41352,54231", "13452,25143,34521,41235,52314", "14325,25431,32514,43152,51243",
			"14235,25413,32541,43152,51324", "31245,25431,43512,12354,54123", "34125,25413,13542,42351,51234",
			"42315,15432,21543,34251,53124", "51234,25413,13542,42351,34125" };

	static String map4[] = { "1234,2143,3412,4321", "1234,2143,3421,4312", "1342,2134,3421,4213", "1243,2314,3421,4132",
			"1243,2431,3124,4312", "1324,2413,3142,4231", "1324,2413,3241,4132", "1324,2431,3142,4213",
			"4321,2413,1234,3142", "4321,3412,2134,1243", "4132,1423,3241,2314" };

	static String map3[] = { "123,312,231", "231,123,312", "312,231,123" };

	static String map2[] = { "12,21", "21,12" };

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