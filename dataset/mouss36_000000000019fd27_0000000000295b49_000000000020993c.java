import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int x = 1; x <= t; ++x) {
			List col = new LinkedList<>();
			int k = 0;
			int r = 0;
			int c = 0;
			int n = in.nextInt();

			List line = new LinkedList<>();

			for (int p = 1; p <= n; p++) {

				line = new LinkedList<>();
				boolean rt = false;
				for (int j = 1; j <= n; j++) {
					int temps = in.nextInt();
					if (line.contains(temps)) {
						rt = true;
					}
					if (p == j) {
						k = k + temps;
					}
					line.add(temps);
				}
				col.add(line);

				if (rt) {
					r++;
				}
			}
			for (int p = 1; p <= n; p++) {
				Set tempss = new HashSet<>();

				for (Object coll : col) {
					tempss.add(((List) coll).get(p - 1));
				}

				if (tempss.size() != n) {
					c++;
				}
			}
			System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
		}
		in.close();
	}
}