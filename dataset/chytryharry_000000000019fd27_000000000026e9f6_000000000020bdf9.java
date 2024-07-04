import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int activitiesNumber = in.nextInt();
			List<Schedule> schedules = new ArrayList<>();
			for (int j = 0; j < activitiesNumber; j++) {
				schedules.add(new Schedule(in.nextInt(), in.nextInt(), j));
			}
			System.out.println("Case #" + i + ": " + analyzeSchedule(schedules));
		}
	}

	private static String analyzeSchedule(List<Schedule> schedules) {
		List<Schedule> cameronSchedule = new ArrayList<>();
		List<Schedule> jamieSchedule = new ArrayList<>();
		List<Result> results = new ArrayList<>();
		Map<Schedule, Integer> scheduletoItsPosition = new HashMap<>();
		int idx = 0;
		for (Schedule schedule : schedules) {
			scheduletoItsPosition.put(schedule, idx++);
		}
		Collections.sort(schedules, new Comparator<Schedule>() {
			@Override
			public int compare(Schedule schedule, Schedule t1) {
				return Integer.compare(schedule.stop, t1.stop);
			}
		});

		for (int i = 0; i < schedules.size(); i++) {
			Schedule current = schedules.get(i);
			if (canApplyToSchedule(cameronSchedule, current)) {
				cameronSchedule.add(current);
				results.add(new Result(current, i, new Character('C')));
			} else if (canApplyToSchedule(jamieSchedule, current)) {
				jamieSchedule.add(current);
				results.add(new Result(current, i, new Character('J')));
			} else {
				return "IMPOSSIBLE";
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (Result result : results) {
			stringBuilder.append("x");
		}
		for (Result result : results) {
			Integer integer = scheduletoItsPosition.get(result.schedule);
			stringBuilder.setCharAt(integer, result.type);
		}
		return stringBuilder.toString();
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

	private static class Result {
		Schedule schedule;
		int position;
		Character type;

		public Result(Schedule schedule, int position, Character type) {
			this.schedule = schedule;
			this.position = position;
			this.type = type;
		}
	}
	private static class Schedule {
		private final int start;
		private final int stop;
		private final int i;

		Schedule(int start, int stop, int i) {
			this.start = start;
			this.stop = stop;
			this.i = i;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Schedule schedule = (Schedule) o;
			return start == schedule.start &&
					stop == schedule.stop &&
					i == schedule.i;
		}

		@Override
		public int hashCode() {
			return Objects.hash(start, stop, i);
		}
	}

}