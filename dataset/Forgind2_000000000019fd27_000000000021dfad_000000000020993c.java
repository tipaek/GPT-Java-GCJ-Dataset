import java.util.Scanner;
import java.util.HashSet;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int z = in.nextInt();
		in.nextLine();
		for (int y = 1; y <= z; y++) {
			int n = in.nextInt();
			in.nextLine();
			HashSet<Integer>[] rows = new HashSet[n];
			HashSet<Integer>[] cols = new HashSet[n];
			for (int a = 0; a < n; a++) {
				rows[a] = new HashSet<Integer>();
				cols[a] = new HashSet<Integer>();
			}
			int trace = 0;
			for (int a = 0; a < n; a++) {
				String[] next = in.nextLine().trim().split(" ");
				for (int b = 0; b < n; b++) {
					int k = Integer.parseInt(next[b]);
					rows[a].add(k);
					cols[b].add(k);
					if (a == b)
						trace += k;
				}
			}
			int rs = 0;
			int cs = 0;
			for (HashSet<Integer> x: rows)
				if (x.size() != n)
					rs++;
			for (HashSet<Integer> x: cols)
				if (x.size() != n)
					cs++;
			System.out.println("Case #" + y + ": " + trace + " " + rs + " " + cs);
		}
		in.close();
	}
}
