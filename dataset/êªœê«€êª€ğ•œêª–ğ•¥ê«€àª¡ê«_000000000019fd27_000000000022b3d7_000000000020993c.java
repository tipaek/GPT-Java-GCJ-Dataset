import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int te = 0;
		for (te = 0; te < t; te++) {
			int n = in.nextInt();
			Integer[][] a = new Integer[n][n];
			Integer[][] b = new Integer[n][n];
			int trace = 0;
			int maxR = 0, maxC = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					a[i][j] = in.nextInt();
					b[j][i] = a[i][j];
					if (i == j)
						trace += a[i][j];
				}
				maxR += comp(a[i]);
			}

			for (int j = 0; j < n; j++) {
				maxC += comp(b[j]);
			}

			System.out.println("Case #" + (1 + te) + ": " + trace + " " + maxR + " " + maxC);
		}
	}


	static int comp(Integer [] arrA) {
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(arrA));

		return (s.size() == arrA.length) ? 0 : 1;

	}
}