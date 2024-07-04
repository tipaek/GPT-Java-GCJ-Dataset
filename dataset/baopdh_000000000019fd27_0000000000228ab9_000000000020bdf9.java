import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = scanner.nextInt();

			int[][] a = new int[n][3];
			for (int j = 0; j < n; ++j) {
				a[j][0] = scanner.nextInt();
				a[j][1] = scanner.nextInt();
				a[j][2] = j;
			}

			Arrays.sort(a, new Comparator<int[]>() {
			    public int compare(int[] a, int[] b) {
			        return a[0] - b[0];
			    }
			});

			int c = 0, j = 0;
			boolean[] isC = new boolean[n];
			for (int k = 0; k < n; ++k) {
				if (a[k][0] >= c) {
					isC[a[k][2]] = true;
					c = a[k][1];
				} else if (a[k][0] >= j) {
					j = a[k][1];
				} else {
					c = -1;
					break;
				}
			}			

			if (c != -1) {
				StringBuilder res = new StringBuilder();
				for (boolean isDoneByC: isC) {
					res.append(isDoneByC ? "C" : "J");
				}
				System.out.printf("Case #%d: %s\n", i, res.toString());
			}
			else {
				System.out.printf("Case #%d: IMPOSSIBLE\n", i);
			}
		}
		scanner.close();
	}
}