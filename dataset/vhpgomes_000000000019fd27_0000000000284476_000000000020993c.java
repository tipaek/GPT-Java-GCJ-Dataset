import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();
			for (int t = 1; t <= T; ++t) {
				int N = in.nextInt();
				
				List<Set<Integer>> rows = new ArrayList<>(N);
				List<Set<Integer>> cols = new ArrayList<>(N);
				
				for (int i = 0; i < N; ++i) {
					rows.add(new HashSet<>());
					cols.add(new HashSet<>());
				}

				int k = 0;
				for (int i = 0; i < N; ++i) {
					for (int j = 0; j < N; ++j) {
						int val = in.nextInt();
						rows.get(i).add(val);
						cols.get(j).add(val);
						if (i == j) k += val;
					}
				}

				int r = 0, c = 0;
				for (int i = 0; i < N; ++i) {
					r += (rows.get(i).size() == N) ? 0 : 1;
					c += (cols.get(i).size() == N) ? 0 : 1;
				}

				System.out.println("Case #" + t + ": " + k + " " + r + " " + c);
			}
		}
	}
}