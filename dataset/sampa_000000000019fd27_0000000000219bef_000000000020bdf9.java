import java.util.*;

public class Solution {

	private static String solve(int[][] jobs) {
		char[] res = new char[jobs.length];
		int c = 0;
		int j = 0;

		Arrays.sort(jobs, new Comparator<int[]>() {
			public int compare(int[] j1, int[] j2) {
				if (j1[1] < j2[1]) {
					return -1;
				} else if (j1[1] > j2[1]) {
					return 1;
				}

				if (j1[2] < j2[2]) {
					return -1;
				} else if (j1[2] > j2[2]) {
					return 1;
				}

				return (j1[0] - j2[0]);
			}
		});

		for (int i = 0; i < jobs.length; i++) {
			int[] job = jobs[i];
			if (job[1] >= c) {
				res[job[0]] = 'C';
				c = job[2];
			} else if (job[1] >= j) {
				res[job[0]] = 'J';
				j = job[2];
			} else {
				return "IMPOSSIBLE";
			}
		}

		return new String(res);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			int N = s.nextInt();
			int[][] jobs = new int[N][3];
			
			for (int j = 0; j < N; j++) {
				jobs[j][0] = j;
				jobs[j][1] = s.nextInt();
				jobs[j][2] = s.nextInt();
			}

			System.out.println("Case #" + i + ": " + solve(jobs));
		}

		s.close();
	}
}