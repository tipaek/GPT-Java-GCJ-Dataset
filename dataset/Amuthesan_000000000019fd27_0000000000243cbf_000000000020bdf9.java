import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int noOfAct = in.nextInt();
			int[][] cam = new int[noOfAct][2];
			int[][] jam = new int[noOfAct][2];
			String schedule = "";
			for (int j = 0; j < noOfAct; j++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				if (isAvailable(cam, startTime, endTime)) {
					schedule += 'C';
					assignUser(cam, j, startTime, endTime);
				} else if (isAvailable(jam, startTime, endTime)) {
					schedule += 'J';
					assignUser(jam, j, startTime, endTime);
				} else {
					schedule = "IMPOSSIBLE";
					break;
				}
				System.out.println(schedule);
			}

			System.out.println("Case #" + i + ": " + schedule);
		}
	}

	private static void assignUser(int[][] schedules, int j, int startTime, int endTime) {
		schedules[j][0] = startTime;
		schedules[j][1] = endTime;

	}

	private static boolean isAvailable(int[][] schedules, int startTime, int endTime) {
		for (int[] schedule : schedules) {
			int scheduleStart = schedule[0];
			int scheduleEnd = schedule[1];
			if ((startTime < scheduleEnd && startTime > scheduleStart)
					|| (endTime > scheduleStart && endTime < scheduleEnd)) {
				return false;
			}
		}
		return true;
	}

}
