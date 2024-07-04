import java.util.*;
class Solution {

    static char[][] finded = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int cn = 1;
		while(T > 0) {
			T--;
            int N = sc.nextInt();
            int K = sc.nextInt();
            
			char[] origin = new char[N];

			for (int i =0 ;i < N; i++) {
				origin[i] = (char)(i + '1');
			}

			char[] target = new char[N];
			boolean[] visit = new boolean[N];
			List<String> res = new ArrayList<>();

			find(origin, target, visit, 0, N, res);

			int[] path = new int[N];
			visit = new boolean[res.size()];
			find(res, visit, N, 0, path, K);

			if (finded == null)
				System.out.printf("Case #%d: IMPOSSIBLE%n", cn);
			else {
				System.out.printf("Case #%d: POSSIBLE%n", cn);
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						System.out.print(finded[i][j] + " ");
					}
					System.out.println();
				}
			}

			cn++;
			finded = null;
		}
	}
	
	public static void find(char[] origin, char[] target, boolean[] visit, int depth, int n, List<String> results) {
		if (depth == n) {
			results.add(new String(target));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				target[depth] = origin[i];
				visit[i] = true;
				find(origin, target, visit, depth + 1, n, results);
				visit[i] = false;
			}
		}
	}

	public static void find(List<String> list, boolean[] visit, int N, int cnt, int[] path, int K) {
		if (finded != null) return;
		char[][] map = new char[N][N];
		for (int i = 0; i < cnt; i++) {
			String cur = list.get(path[i]);
			for (int j = 0; j < cur.length(); j++) {
				map[i][j] = cur.charAt(j);
			}
		}

		for (int i = 0; i < cnt; i++) {
			Map<Character, Character> trace = new HashMap<>();
			for (int j = 0; j < N; j++) {
				if (trace.get(map[i][j]) != null) {
					return;

				}
				trace.put(map[i][j], map[i][j]);
			}

			trace.clear();
			for (int j = 0; j < cnt; j++) {
				if (trace.get(map[j][i]) != null) {
					return;

				}

				trace.put(map[j][i], map[j][i]);
			}

		}

		if (cnt == N) {
			int k = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) k += Integer.valueOf(map[i][j] - '0');
				}
			}

			if (k == K) {
				finded = map;
				return;
			}

			return;
		}
		
		int len = list.size();
		for (int i = 0; i < len; i++) {
			if (!visit[i]) {
				visit[i] = true;
				path[cnt] = i;
				find(list, visit, N, cnt + 1, path, K);
				visit[i] = false;
			}
		}
	}

}