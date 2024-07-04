import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	ArrayList<HashSet<Integer>> rows;
	ArrayList<HashSet<Integer>> cols;
	int[] matrix;
	int N;
	int K;

	void solve(int N, int K) {
		if (K == N+1 || K == N*N-1) {
			return;
		}
		currentTrace = 0;
		traceElements = new HashMap<>();
		this.N = N;
		this.K = K;

		matrix = new int[N*N];

		HashSet<Integer> available = new HashSet<>();
		for (int i = 0; i < N; i++) {
			available.add(i+1);
		}

		rows = new ArrayList<>(N);
		cols = new ArrayList<>(N);

		for (int i = 0; i < N; i++) {
			rows.add(i, new HashSet<>(available));
			cols.add(i, new HashSet<>(available));
		}

		search(0, 0);
	}

	int currentTrace;
	Map<Integer, Integer> traceElements;
	private void search(int pos, int steps) {
		if (pos == N*N) {
			int trace = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j) {
						trace += matrix[i * N + j];
					}
				}
			}
			assert trace == currentTrace;
			
			if (trace == K) {
				System.out.println("POSSIBLE");
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (j > 0) System.out.print(" ");
						System.out.print(matrix[i * N + j]);
					}
					System.out.println();
				}

				throw new RuntimeException("found");
			}

			return;
		}

		for (int val = 1; val <= N; val++) {
			int row = pos / N;
			int col = pos % N;

			if (!rows.get(row).contains(val) || !cols.get(col).contains(val)) {
				continue;
			}

			// choose val
			matrix[pos] = val;
			rows.get(row).remove(val);
			cols.get(col).remove(val);

			if (row == col) {
				currentTrace += val;
				traceElements.compute(val, (a,b) -> b == null ? 1 : b+1);
			}

			// is there a chance?
			boolean skipAndReturn = false;
			if (steps >= N && currentTrace != K) {
				skipAndReturn = true;
			}
			if (steps >= N && traceElements.size() == 2 && N > 2) {
				for (int count : traceElements.values()) {
					if (count == 1) {
						skipAndReturn = true;
						break;
					}
				}
			}

			if (!skipAndReturn) {
				search(next(pos), steps + 1);
			}

			if (row == col) {
				currentTrace -= val;
				traceElements.compute(val, (a,b)-> b > 1 ? b-1 : null);
			}

			// add it back
			matrix[pos] = 0;
			rows.get(row).add(val);
			cols.get(col).add(val);

			if (skipAndReturn) {
				return;
			}
		}
	}

	int next(int pos) {
		if (pos == N*N-1) {
			return 1;
		}

		if (pos % (N+1) == 0) {
			return pos + N+1;
		}

		int next = pos + 1;
		if (next % (N+1) == 0) {
			next++;
		}

		return next;
	}


	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = scanner.nextInt();
		scanner.nextLine();

		for (int i = 1; i <= testCases; i++) {
			System.out.print("Case #" + i + ": ");
			try {
				new Solution().solve(scanner.nextInt(), scanner.nextInt());

				System.out.println("IMPOSSIBLE");
			}
			catch (RuntimeException ignore) {}
		}
	}
}
