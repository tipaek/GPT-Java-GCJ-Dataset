import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

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
		Stack<String> result = new Stack<>();
		Stack<Schedule> cameronSchedule = new Stack<>();
		Stack<Schedule> jamieSchedule = new Stack<>();

		for (int i = 0; i < schedules.size(); i++) {
			Schedule current = schedules.get(i);
			if (canApplyToSchedule(cameronSchedule, current)) {
				cameronSchedule.add(current);
				result.push("C");
			} else if (canApplyToSchedule(jamieSchedule, current)) {
				jamieSchedule.add(current);
				result.push("J");
			} else {
				if (result.peek().equalsIgnoreCase("C")) {
					Schedule fromCameronSchedule = cameronSchedule.pop();
					result.pop();
					if (canApplyToSchedule(jamieSchedule, fromCameronSchedule)) {
						result.push("J");
						i--;
						continue;
					}
				} else if (result.peek().equalsIgnoreCase("J")) {
					Schedule fromJamieSchedule = jamieSchedule.pop();
					result.pop();
					if (canApplyToSchedule(cameronSchedule, fromJamieSchedule)) {
						result.push("C");
						i--;
						continue;
					}
				}
				return "IMPOSSIBLE";
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		while (!result.isEmpty()) {
			stringBuilder.append(result.pop());
		}
		return stringBuilder.reverse().toString();
	}

	private static boolean canApplyToSchedule(List<Schedule> schedules, Schedule schedule) {
		for (Schedule schedule1 : schedules) {
			if (schedule.start >= schedule1.start) {
				if (schedule.start < schedule1.stop) {
					return false;
				}
			} else if (schedule.start < schedule1.start) {
				if (schedule.stop < schedule1.stop && schedule.stop > schedule1.start) {
					return false;
				} else if (schedule.stop >= schedule1.stop) {
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