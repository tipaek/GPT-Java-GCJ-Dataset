import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int K;
	static int[][] sqr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1: 1
		// 2: 2, 4
		// 3: 6, 3, 3, 6, 6, 6, 6, 6, 9, 6, 6, 9
		// 4: 4, 10

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			sqr = new int[N][N];
			K = Integer.parseInt(st.nextToken());
			if (!solve(i, new int[N], N, 0)) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
		}
	}

	public static boolean solve(int testnum, int[] nums, int n, int depth) {
		if (depth == n) {
			int sum = 0;
			for (int x : nums) {
				sum += x;
			}
			if (sum == K) {

				//System.out.println(Arrays.toString(nums));
				ArrayList<ArrayList<Integer>> rowdups = new ArrayList<ArrayList<Integer>>(n);
				ArrayList<ArrayList<Integer>> currcols = new ArrayList<ArrayList<Integer>>(n);
				for (int i = 0; i < n; i++) {
					rowdups.add(new ArrayList<Integer>());
					currcols.add(new ArrayList<Integer>());
					for (int j = 1; j <= n; j++) {
						rowdups.get(i).add(j);
					}
				}
				// System.out.println("rowdups: ");
				for (int i = 0; i < n; i++) {
					sqr[i][i] = nums[i];
					rowdups.get(i).remove((Integer) nums[i]);
					currcols.get(i).add(sqr[i][i]);
					// System.out.println(rowdups.get(i));
				}
				/*if (nums[1] == 3) {
					System.out.println("in here");
				}*/
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (sqr[i][j] == 0) {
							for (int k = 0; k < rowdups.get(i).size(); k++) {
								if (!currcols.get(j).contains(rowdups.get(i).get(k))) {
									sqr[i][j] = rowdups.get(i).get(k);
									rowdups.get(i).remove(k);
									currcols.get(j).add(sqr[i][j]);
									break;
								}
							}
						}
						if (sqr[i][j] == 0) {
							return false;
						}
					}
				}
				System.out.println("Case #"+(testnum+1)+": POSSIBLE");
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						System.out.print(sqr[i][j] + " ");
					}
					System.out.println();
				}
				return true;
			}
		} else {
			for (int i = 1; i <= n; i++) {
				nums[depth] = i;
				sqr = new int[n][n];

				if (solve(testnum, nums, n, depth + 1)) {
					return true;
				}

				// solve(nums, n, depth + 1);
			}
		}
		return false;

	}

}
