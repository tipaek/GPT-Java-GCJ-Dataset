import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int sum = 0;
			List<Set<Integer>> columns = new ArrayList<>(n);
			for (int j = 0; j < n; j++) {
				columns.add(new HashSet<>());
			}
			int rows = 0;
			for (int j = 0; j < n; j++) {
				Set<Integer> row = new HashSet<>();
				for (int k = 0; k < n; k++) {
					int v = sc.nextInt();
					if (j == k) {
						sum += v;
					}
					columns.get(k).add(v);
					row.add(v);
				}
				if (row.size() < n) {
					rows++;
				}
			}
			int cols = (int) columns.stream().filter(c -> c.size() < n).count();
			System.out.println(String.format("Case #%d: %d %d %d", i, sum, rows, cols));
		}
	}
}
