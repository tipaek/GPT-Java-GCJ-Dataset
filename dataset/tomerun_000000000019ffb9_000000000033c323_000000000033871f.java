import java.util.*;

public class Solution {
	static Scanner sc = new Scanner(System.in);
	static int C, D;
	static int[] X;
	static int[][] EI;
	static int[] minT;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			System.out.print("Case #" + i + ":");
			solve();
		}
	}

	static void solve() {
		C = sc.nextInt();
		D = sc.nextInt();
		X = new int[C];
		minT = new int[C];
		EI = new int[C][C];
		ArrayList<Integer> fixed = new ArrayList<>();
		fixed.add(0);
		ArrayList<ArrayList<Integer>> vs = new ArrayList<>();
		vs.add(new ArrayList<>());
		for (int i = 0; i < C; ++i) {
			Arrays.fill(EI[i], -1);
			vs.add(new ArrayList<>());
		}
		for (int i = 1; i < C; i++) {
			X[i] = sc.nextInt();
			if (X[i] > 0) {
				minT[i] = X[i];
				fixed.add(X[i]);
			} else {
				vs.get(-X[i]).add(i);
			}
		}
		Collections.sort(fixed);
		for (int i = 0; i < D; i++) {
			int U = sc.nextInt() - 1;
			int V = sc.nextInt() - 1;
			EI[U][V] = EI[V][U] = i;
		}
		PriorityQueue<Long> q = new PriorityQueue<>();
		q.add(0L);
		boolean[] visited = new boolean[C];
		visited[0] = true;
		for (int i = 0; i < C; i++) {
			int cur = (int) (long) q.poll();
			for (int j = 1; j < C; j++) {
				if (EI[cur][j] >= 0 && !visited[j]) {
					minT[j] = Math.max(minT[j], minT[cur] + 1);
					q.add(((long) minT[j] << 32) | j);
					visited[j] = true;
				}
			}
		}
//		System.err.println(Arrays.toString(minT));
		for (int i = 1; i <= C; i++) {
			if (vs.get(i).isEmpty()) continue;
			int time = fixed.get(i - 1) + 1;
			for (int v : vs.get(i)) {
				time = Math.max(time, minT[v]);
			}
			for (int v : vs.get(i)) {
				minT[v] = time;
				fixed.add(time);
			}
			Collections.sort(fixed);
		}
//		System.err.println(Arrays.toString(minT));
		ArrayList<Integer> qi = new ArrayList<>();
		int[] ans = new int[D];
		q.clear();
		q.add(0L);
		Arrays.fill(visited, false);
		visited[0] = true;
		for (int i = 0; i < C; i++) {
			int cur = (int) (long) q.poll();
			for (int j = 1; j < C; j++) {
				if (EI[cur][j] >= 0 && !visited[j]) {
					ans[EI[cur][j]] = minT[j] - minT[cur];
					q.add(((long) minT[j] << 32) | j);
					visited[j] = true;
				}
			}
		}
		for (int i = 0; i < D; i++) {
			System.out.print(" " + (ans[i] == 0 ? 1000000 : ans[i]));
		}
		System.out.println();
	}

}
