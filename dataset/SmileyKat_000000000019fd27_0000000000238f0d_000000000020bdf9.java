import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		for (int test = 1; test <= numTest; ++test) {
			int n = sc.nextInt();
			List<int[]> jobs = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				int l = sc.nextInt(), r = sc.nextInt();
				jobs.add(new int[] { i, l, r });
			}

			jobs.sort((p1, p2) -> p1[1] == p2[1] ? p1[2] - p2[2] : p1[1] - p2[1]);
			boolean ok = true;
			int cur1 = -1, cur2 = -1;
			char[] res = new char[n];
			for (int i = 0; ok && i < n; ++i) {
				int[] job = jobs.get(i);
				if (job[1] >= cur1) {
					res[job[0]] = 'C';
					cur1 = job[2];
				} else if (job[1] >= cur2) {
					res[job[0]] = 'J';
					cur2 = job[2];
				} else {
					ok = false;
				}
			}
			System.out.printf("Case #%d: ", test);
			if (ok) System.out.println(res);
			else System.out.println("IMPOSSIBLE");
		}
		sc.close();
	}

}
