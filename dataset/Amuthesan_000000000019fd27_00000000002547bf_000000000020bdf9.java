import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int noOfAct = in.nextInt();
			List<Integer[]> cam = new ArrayList<>();
			List<Integer[]> jam = new ArrayList<>();
			StringBuffer schedule = new StringBuffer();
			for (int j = 0; j < noOfAct; j++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				if (isAvailable(cam, startTime, endTime)) {
					schedule.append('C');
					cam.add(new Integer[] { startTime, endTime });
				} else if (isAvailable(jam, startTime, endTime)) {
					schedule.append('J');
					jam.add(new Integer[] { startTime, endTime });
				} else {
					schedule = new StringBuffer("IMPOSSIBLE");
					break;
				}
			}

			System.out.println("Case #" + i + ": " + schedule);
		}
	}

	private static boolean isAvailable(List<Integer[]> cam, int startTime, int endTime) {

		for (Integer[] schedule : cam) {
			int scheduleStart = schedule[0];
			int scheduleEnd = schedule[1];

			if (startTime < scheduleEnd && endTime > scheduleStart) {
				return false;
			}

		}
		return true;
	}

}
