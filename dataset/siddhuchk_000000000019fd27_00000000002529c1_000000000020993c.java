import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int c = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] mat = new int[n][n];
			int trace = 0;
			Set<Integer> dupR = new HashSet<>();
			Set<Integer> dupC = new HashSet<>();
			Map<Integer, Set<Integer>> rows = new HashMap<>();
			Map<Integer, Set<Integer>> cols = new HashMap<>();

			for (int i = 0; i < n; i++) {
				if (!rows.containsKey(i)) {
					rows.put(i, new HashSet<>());
				}
				String[] vals = br.readLine().split("\\s+");
				for (int j = 0; j < n; j++) {
					if (!cols.containsKey(j)) {
						cols.put(j, new HashSet<>());
					}
					mat[i][j] = Integer.parseInt(vals[j]);
					if (i == j) {
						trace += mat[i][j];
					}
					if (rows.get(i).contains(mat[i][j])) {
						dupR.add(i);
					}
					if (cols.get(j).contains(mat[i][j])) {
						dupC.add(j);
					}
					rows.get(i).add(mat[i][j]);
					cols.get(j).add(mat[i][j]);
				}
			}
			System.out.println("Case #" + c + ": " + trace + " " + dupR.size() + " " + dupC.size());
			c++;
		}
	}
}