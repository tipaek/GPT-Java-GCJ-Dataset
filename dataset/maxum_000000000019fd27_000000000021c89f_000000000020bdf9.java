import java.util.*;
import java.io.*;


public class Solution {

	public static String computeSchedule(int[][] times) {
		if (times.length == 0) {
			return "";
		}

		char[] schedule = new char[times.length];
		Arrays.sort(times, (a,b)-> a[0] - b[0]);

		int endC = 0, endJ = 0;
		for (int i = 0; i < times.length; i++) {
			if (times[i][0] >= endC) {
				endC = times[i][1];
				schedule[times[i][2]] = 'C';
			} else if (times[i][0] >= endJ) {
				endJ = times[i][1];
				schedule[times[i][2]] = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}

		return new String(schedule);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(
					new InputStreamReader(System.in)));

		int T = in.nextInt();
		for (int i = 1; i <= T; i++) {
			int n = in.nextInt();
			int[][] times = new int[n][3];
			for (int j = 0; j < n; j++) {
				times[j][0] = in.nextInt();
				times[j][1] = in.nextInt();
				times[j][2] = j;
			}

			System.out.println("Case #" + i + ": " + computeSchedule(times));
		}


	}

}
