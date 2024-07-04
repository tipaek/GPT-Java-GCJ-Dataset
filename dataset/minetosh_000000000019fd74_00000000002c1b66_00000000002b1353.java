import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	static int pascal[][];

	static void makePascal(int max) {
		pascal = new int[max][max];
		pascal[0][0] = 1;
		for (int j = 1; j < max; j++) {
			for (int i = 0; i <= j; i++) {
				if (i == 0)
					pascal[i][j] = pascal[i][j-1];
				else if (i == j)
					pascal[i][j] = pascal[i-1][j-1];
				else {
					if (pascal[i-1][j-1] >= 10000 || pascal[i][j-1] >= 10000 ||
						pascal[i-1][j-1] + pascal[i][j-1] >= 10000)
						pascal[i][j] = 10000;
					else
						pascal[i][j] = pascal[i-1][j-1] + pascal[i][j-1];
				}
			}
		}
	}

	static void printPascal(int max) {
		for (int j = 0; j < max; j++) {
			for (int i = 0; i <= j; i++) {
				System.err.print(pascal[i][j]);
				if (i == j)
					System.err.println();
				else
					System.err.print(' ');
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		makePascal(1000);
//		printPascal(1000);
// System.exit(0);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++)
			System.out.println("Case #" + i + ": " + resolv(sc));
	}

	static ArrayList<Long> search(int N, ArrayList<Long> route, int sum,
		int x, int y) {

		// loop
		long nc = (long)x * 10000 + (long)y;
		if (route.contains(nc))
			return null;

// System.err.println(y + " " + x + " " + pascal[x][y]);
// System.err.println(route);

		// over
		int ns = sum + pascal[x][y];
		if (N < ns)
			return null;

		// copy
		ArrayList<Long> nr = new ArrayList<Long>();
		for (int i = 0; i < route.size(); i++)
			nr.add(route.get(i));
		// add
		nr.add(nc);

		// found
		if (ns == N)
			return nr;

		ArrayList<Long> ret;
		if (x < (y + 1) / 2) {
			ret = search(N, nr, ns, x + 1, y + 1);
			if (ret != null)
				return ret;
			ret = search(N, nr, ns, x, y + 1);
			if (ret != null)
				return ret;
			if (x > 1) {
				ret = search(N, nr, ns, x - 1, y);
				if (ret != null)
					return ret;
			}
			ret = search(N, nr, ns, x + 1, y);
			if (ret != null)
				return ret;
		} else {
			ret = search(N, nr, ns, x, y + 1);
			if (ret != null)
				return ret;
			ret = search(N, nr, ns, x + 1, y + 1);
			if (ret != null)
				return ret;
			ret = search(N, nr, ns, x - 1, y);
			if (ret != null)
				return ret;
			if (x < y) {
				ret = search(N, nr, ns, x + 1, y);
				if (ret != null)
					return ret;
			}
		}
		return null;
	}

	private static String resolv(Scanner sc) {
		int N = sc.nextInt();
		ArrayList<Long> route = new ArrayList<Long>();

		ArrayList<Long> kekka = search(N, route, 0, 0, 0);

		StringBuffer sb = new StringBuffer();
		for (int n = 0; n < kekka.size(); n++) {
			long a = kekka.get(n);
			int i = (int)(a / 10000);
			int j = (int)(a % 10000);
			sb.append('\n');
			sb.append(j + 1);
			sb.append(' ');
			sb.append(i + 1);
		}
		return sb.toString();
	}
}
