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
		int cameronCounter = 0;
		int jamieCounter = 0;
		for (int i = 0; i < schedules.size(); i++) {
			Schedule current = schedules.get(i);
			if (canApplyToSchedule(cameronSchedule, current)) {
				cameronSchedule.add(current);
				result.push("C");
				cameronCounter++;
				jamieCounter= 0;
			} else if (canApplyToSchedule(jamieSchedule, current)) {
				jamieSchedule.add(current);
				result.push("J");
				jamieCounter++;
				cameronCounter = 0;
			} else {
				if (cameronCounter > 0) {
					handleCallback(cameronCounter, jamieSchedule, cameronSchedule, result);
					i--;
					jamieCounter=0;
					cameronCounter=0;
					continue;
				} else if (jamieCounter > 0) {
					handleCallback(cameronCounter, jamieSchedule, cameronSchedule, result);
					i--;
					jamieCounter=0;
					cameronCounter=0;
					continue;
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

	private static int handleCallback(int counter, Stack<Schedule> jamieSchedule
			, Stack<Schedule> cameronSchedule, Stack<String> result) {
		Stack<Schedule> temp = new Stack<>();
		String lastCharacter = "";
		while (counter > 0) {
			if (result.peek().equals("C")) {
				temp.push(cameronSchedule.pop());
			} else {
				temp.push(jamieSchedule.pop());
			}
			lastCharacter = result.pop();
			counter--;
		}

		while (!temp.isEmpty()) {
			Schedule pop = temp.pop();
			if (lastCharacter.equals("J")) {
				if (canApplyToSchedule(cameronSchedule, pop)) {
					cameronSchedule.push(pop);
					result.push("C");
					lastCharacter = "C";
				} else if (canApplyToSchedule(jamieSchedule, pop)) {
					jamieSchedule.push(pop);
					result.push("J");
					lastCharacter = "J";
				}
			} else {
				if (canApplyToSchedule(jamieSchedule, pop)) {
					jamieSchedule.push(pop);
					result.push("J");
					lastCharacter = "J";
				} else if (canApplyToSchedule(cameronSchedule, pop)) {
					cameronSchedule.push(pop);
					result.push("C");
					lastCharacter = "C";
				}
			}
		}

		return temp.size();
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