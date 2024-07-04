import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int activitiesNumber = in.nextInt();
			List<Schedule> schedules = new ArrayList<>();
			for (int j = 0; j < activitiesNumber; j++) {
				schedules.add(new Schedule(in.nextInt(), in.nextInt()));
			}
			System.out.println("Case #" + i + ": " + analyzeSchedule(schedules));
		}
	}

	private static String analyzeSchedule(List<Schedule> schedules) {
		StringBuilder sb = new StringBuilder();
		List<Schedule> cameronSchedule = new ArrayList<>();
		List<Schedule> jamieSchedule = new ArrayList<>();

		Iterator<Schedule> iterator = schedules.iterator();
		while (iterator.hasNext()) {
			Schedule next = iterator.next();
			if (canApplyToSchedule(cameronSchedule, next)) {
				cameronSchedule.add(next);
				sb.append("C");
			} else if (canApplyToSchedule(jamieSchedule, next)) {
				jamieSchedule.add(next);
				sb.append("J");
			} else {
				sb.setLength(0);
				break;
			}
		}
		return sb.length() == 0 ? "IMPOSSIBLE" : sb.toString();
	}

 private static boolean canApplyToSchedule(List<Schedule> schedules, Schedule schedule) {
		for (Schedule schedule1 : schedules) {
			if (schedule1.start == schedule.start
				&& schedule1.start == schedule.stop) {
				return false;
			}
			if (schedule1.stop == schedule.start
					&& schedule1.stop == schedule.stop) {
				return false;
			}
			if (schedule.start >= schedule1.start) {
				if (schedule.start < schedule1.stop) {
					return false;
				}
			} else if (schedule.start < schedule1.start) {
				if (schedule.stop < schedule1.stop && schedule.stop>schedule1.start) {
					return false;
				} else if (schedule.stop > schedule1.stop) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static class Schedule {
		private final int start;
		private final int stop;

		Schedule(int start, int stop) {
			this.start = start;
			this.stop = stop;
		}
	}
}