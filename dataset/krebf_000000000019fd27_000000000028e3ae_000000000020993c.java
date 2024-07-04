import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws Exception {
		try (Scanner sc = new Scanner(System.in)) {
			int nc = sc.nextInt();
			for (int i = 1; i <= nc; i++) {
				int dim = sc.nextInt();
				int t = 0;
				List<Set<Integer>> rc = new ArrayList<>(dim);
				List<Set<Integer>> cc = new ArrayList<>(dim);
				for (int j = 0; j < dim; j++) {
					rc.add(new HashSet<>());
					cc.add(new HashSet<>());
				}
				for (int r = 0; r < dim; r++) {
					for (int c = 0; c < dim; c++) {
						int v = sc.nextInt();
						if (r == c) {
							t += v;
						}
						rc.get(r).add(v);
						cc.get(c).add(v);
					}
				}
				long r = rc.stream().filter(e->e.size() < dim).count();
				long c = cc.stream().filter(e->e.size() < dim).count();
				System.out.println("Case #" + i + ": " + t + " " + r + " " + c);
			}
		}
	}
}
