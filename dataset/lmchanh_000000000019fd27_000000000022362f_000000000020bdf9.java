import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			solve(in, i);
		}

		in.close();
	}

	private static void solve(Scanner in, int num) {
		final int size = in.nextInt();

		int[][] jobs = new int[size][2];
		for (int i = 0; i < size; i++) {
			jobs[i][0] = in.nextInt();
			jobs[i][1] = in.nextInt();
		}

		int[][] sorted = new int[size][2];
		System.arraycopy(jobs, 0, sorted, 0, jobs.length);
		Arrays.sort(sorted, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});

		List<int[]> cj = new ArrayList<int[]>();
		List<int[]> jj = new ArrayList<int[]>();

		for (int[] job : sorted) {
			if (!doJob(cj, job)) {
				if (!doJob(jj, job)) {
					System.out.println("Case #" + num + ": IMPOSSIBLE");
					return;
				}
			}
		}

		String schedule = "";
		for (int[] job : jobs) {
			if (cj.contains(job))
				schedule += "C";
			else if (jj.contains(job)) {
				schedule += "J";
			}
		}

		System.out.println("Case #" + num + ": " + schedule);
	}

	private static boolean doJob(List<int[]> jobs, int[] newJob) {
		if (jobs.isEmpty()) {
			jobs.add(newJob);
			return true;
		}

		int[] last = jobs.get(jobs.size() - 1);
		if (last[1] <= newJob[0]) {
			jobs.add(newJob);
			return true;
		}

		return false;
	}
}