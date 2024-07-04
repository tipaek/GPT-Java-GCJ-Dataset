import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			int numTasks = Integer.parseInt(sc.nextLine());
			int[][] jobs = new int[numTasks][3];
			for (int task = 0; task < numTasks; task++) {
				String[] times = sc.nextLine().split(" ");
				jobs[task] = new int[] {
						Integer.parseInt(times[0]),
						Integer.parseInt(times[1]),
						task
						};
			}
			Arrays.sort(jobs, new ArrayComparator());
			System.out.println("Case #" + (index + 1) + ": " + solveSchedule(jobs));
		}
		sc.close();
	}
	
	private static String solveSchedule(int[][] jobs) {
		if (jobs.length == 0) {
			return "";
		}
		char[] ret = new char[jobs.length];
		
		int cEndTime = -1;
		int jEndTime = -1;
		for (int i = 0; i < jobs.length; i++) {
			if (jobs[i][0] < cEndTime) { // need second helper
				if (jobs[i][0] < jEndTime) { // no schedule :(
					return "IMPOSSIBLE";
				} else { // assign to Jamie
					ret[jobs[i][2]] = 'J';
					jEndTime = jobs[i][1];
				}
			} else { // assign to Cameron
				ret[jobs[i][2]] = 'C';
				cEndTime = jobs[i][1];
			}
		}
		return new String(ret);
	}
}

class ArrayComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] o1, int[] o2) {
		return o1[0] - o2[0];
	}
}