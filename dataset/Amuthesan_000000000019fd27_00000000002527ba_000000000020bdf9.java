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
			StringBuffer schedule = new StringBuffer();
			for (int j = 0; j < noOfAct; j++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				if (isAvailable(cam, startTime, endTime)) {
					schedule.append('C');
					cam[j][0] = startTime;
					cam[j][1] = endTime;

				} else if (isAvailable(jam, startTime, endTime)) {
					schedule.append('J');
					jam[j][0] = startTime;
					jam[j][1] = endTime;

				} else {
					schedule = new StringBuffer("IMPOSSIBLE");
					break;
				}
			}

			System.out.println("Case #" + i + ": " + schedule);
		}
	}

	private static boolean isAvailable(int[][] cam, int startTime, int endTime) {

		for (int[] schedule : cam) {
			int scheduleStart = schedule[0];
			int scheduleEnd = schedule[1];

			if (startTime < scheduleEnd && endTime > scheduleStart) {
				return false;
			}

		}
		return true;
	}

}
