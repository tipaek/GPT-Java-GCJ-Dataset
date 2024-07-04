import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	String fnc(int n, int k) {
		// ptn1
		if (k % n == 0) {
			int[][] map1 = createMap1(n);
			swapMap(n, map1, k / n, 1);
			String ans = "POSSIBLE" + System.lineSeparator() + createMapStr(n, map1);
			return ans;
		}

		// ptn2
		if (n % 2 == 0 && k % 2 == 0) {
			int nn = n / 2;
			int sum1 = nn * (nn + 1);
			int sum2 = n * (n + 1) - sum1;

			if (sum1 <= k && k <= sum2) {
				int[][] map2 = createMap2(n);
				int[] nums = fnc2(n, k);
				for (int i = 0; i < nn; i++) {
					swapMap(n, map2, map2[i][i], nums[i]);
				}
				String ans = "POSSIBLE" + System.lineSeparator() + createMapStr(n, map2);
				return ans;
			}
		}

		return "IMPOSSIBLE" + System.lineSeparator();
	}

	String createMapStr(int n, int[][] map) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(map[i][j]);
				if (j != n - 1) {
					sb.append(" ");
				}
			}
			sb.append(System.lineSeparator());
		}

		return sb.toString();
	}

	void swapMap(int n, int[][] map, int a, int b) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == a) {
					map[i][j] = -b;
				} else if (map[i][j] == b) {
					map[i][j] = -a;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] < 0) {
					map[i][j] *= -1;
				}
			}
		}
	}

	int[][] createMap1(int n) {
		int[][] map1 = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map1[i][j] = (n - i + j) % n + 1;
			}
		}

		return map1;
	}

	int[][] createMap2(int n) {
		int[][] map2 = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map2[i][j] = (i + j) % n + 1;
			}
		}

		return map2;
	}

	int[] fnc2(int n, int k) {
		int kk = k / 2;
		int nn = n / 2;

		int[] nums = new int[nn];
		int sum = 0;
		for (int i = 0; i < nn - 1; i++) {
			nums[i] = i + 1;
			sum += nums[i];
		}
		nums[nn - 1] = kk - sum;

		Set<Integer> s = new HashSet<Integer>();

		while (true) {
			s.clear();
			for (int i = 0; i < nn - 1; i++) {
				s.add(nums[i]);
			}
			if (nums[nn - 1] >= 1 && nums[nn - 1] <= n && !s.contains(nums[nn - 1])) {
				break;
			}

			if (nums[nn - 1] > n || s.contains(nums[nn - 1])) {
				for (int i = 0; i < nn - 1; i++) {
					nums[i]++;
				}
				nums[nn - 1] -= (nn - 1);
			}
		}

		return nums;
	}

	void run() {
		try (Scanner sc = new Scanner(System.in)) {
			int testNum = sc.nextInt();
			for (int t = 1; t <= testNum; t++) {
				System.out.print("Case #" + t + ": " + fnc(sc.nextInt(), sc.nextInt()));
			}
		}
	}

	public static void main(String[] args) {
		new Solution().run();
	}
}
