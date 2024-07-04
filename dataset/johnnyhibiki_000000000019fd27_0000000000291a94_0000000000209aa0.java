import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	String fnc(int n, int k) {

		int[] nums = fnc2(n, k);
		if (nums == null) {
			return "IMPOSSIBLE";
		}

		int[][] map = null;

		if (nums[n - 2] == nums[0]) {
			map = createMap1(n);
			swapMap(n, map, 1, nums[0]);
		} else if (nums[n - 2] == nums[n - 1]) {
			map = createMap3(n);

			swapMap(n, map, 1, nums[0]);
			if (map[0][0] == 2) {
				swapMap(n, map, 1, 3);
			}
			swapMap(n, map, map[n - 2][n - 2], nums[n - 2]);
		} else {
			map = createMap2(n);

			swapMap(n, map, 1, nums[0]);
			if (nums[n - 2] == map[0][0]) {
				swapMap(n, map, map[n - 2][n - 2], 3);
			}
			swapMap(n, map, map[n - 2][n - 2], nums[n - 2]);

			if (nums[n - 1] == map[0][0] || nums[n - 1] == map[n - 2][n - 2]) {
				int tgt = 1;
				for (int i = 1; i <= n; i++) {
					if (i != map[0][0] && i != map[n - 2][n - 2]) {
						tgt = i;
						break;
					}
				}
				swapMap(n, map, map[n - 1][n - 1], tgt);
			}
			swapMap(n, map, map[n - 1][n - 1], nums[n - 1]);
		}

		return "POSSIBLE" + System.lineSeparator() + createMapStr(n, map);
	}

	boolean checkNums(int[] nums, int n) {
		if (n == 3 && nums[0] != nums[2]) {
			if (nums[0] == nums[1] || nums[1] == nums[2]) {
				return false;
			}
		}

		if (nums[n - 1] == 0 || nums[n - 2] == 0 || nums[n - 1] > n || nums[n - 2] > n) {
			return false;
		}

		if (nums[n - 1] == nums[n - 2]) {
			return true;
		}

		if (nums[n - 1] == nums[0] || nums[n - 2] == nums[0]) {
			return false;
		}

		return true;
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
		int[][] map2 = createMap1(n);

		int[] tmp = new int[n];
		for (int j = 0; j < n; j++) {
			tmp[j] = map2[n - 2][j];
		}
		for (int j = 0; j < n; j++) {
			map2[n - 2][j] = map2[n - 1][j];
		}
		for (int j = 0; j < n; j++) {
			map2[n - 1][j] = tmp[j];
		}

		return map2;
	}

	int[][] createMap3(int n) {
		int[][] map3 = createMap1(n);

		for (int i = n - 3; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map3[i][j] = 0;
			}
		}

		map3[n - 3][n - 3] = 1;
		map3[n - 2][n - 1] = 1;
		map3[n - 1][n - 2] = 1;
		map3[n - 2][n - 2] = 2;
		map3[n - 1][n - 1] = 2;
		map3[n - 3][n - 2] = n;
		map3[n - 3][n - 1] = 3;

		Set<Integer> cs = new HashSet<Integer>();
		Set<Integer> rs = new HashSet<Integer>();
		for (int i = n - 3; i < n; i++) {
			for (int j = 0; j < n - 2; j++) {
				if (map3[i][j] == 0) {
					cs.clear();
					rs.clear();
					for (int h = 0; h < n; h++) {
						cs.add(map3[h][j]);
						rs.add(map3[i][h]);
					}
					for (int h = 1; h <= n; h++) {
						if (!cs.contains(h) && !rs.contains(h)) {
							map3[i][j] = h;
							break;
						}
					}
				}
			}
		}

		return map3;
	}

	int[] fnc2(int n, int k) {
		int[] nums = new int[n];

		for (int d = 0;; d++) {
			int z = k / n + d;
			int res = k - z * (n - 2);
			int zz = res / 2;
			int zzz = res / 2 + res % 2;

			if (z == zz && zz != zzz) {
				zz--;
				zzz++;
			}

			if (zz <= 0 || z > n) {
				break;
			}

			for (int i = 0; i < n - 2; i++) {
				nums[i] = z;
			}
			nums[n - 2] = zz;
			nums[n - 1] = zzz;

			if (checkNums(nums, n)) {
				return nums;
			}
		}

		return null;
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
