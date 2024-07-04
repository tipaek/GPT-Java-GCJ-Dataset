import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int N;
		String overlaping, prev;
		ArrayList<Schedule> scheduleList = new ArrayList<>(20);
		boolean impossible = false;
		for (int i = 1; i <= T; i++) {

			N = in.nextInt();
			scheduleList.clear();
			for (int j = 0; j < N; j++)
				scheduleList.add(new Schedule(in.nextInt(), in.nextInt(), j));

			Collections.sort(scheduleList);
			impossible = false;
			prev = "J";
			scheduleList.get(0).inCharge = prev;
			Schedule schedule;
			for (int j = 1; j < scheduleList.size(); j++) {
				schedule = scheduleList.get(j);
				overlaping = overlaping(schedule, scheduleList, j);
				if (overlaping.isEmpty())
					schedule.inCharge = prev;
				else if (overlaping.contains("J") && overlaping.contains("C")) {
					impossible = true;
					break;
				} else if (overlaping.contains("J")) {
					prev = "C";
					schedule.inCharge = prev;
				} else {
					prev = "J";
					schedule.inCharge = prev;
				}

			}
			if (impossible)
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			else {
				String[] s = new String[scheduleList.size()];
				for (Schedule schedule2 : scheduleList) {
					s[schedule2.id] = schedule2.inCharge;
				}
				String res = Arrays.asList(s).stream().reduce("", (a, b) -> a + b);
				System.out.println("Case #" + i + ": " + res);
			}
		}

	}

	static String overlaping(Schedule schedule, ArrayList<Schedule> scheduleList, int boundry) {
		String value = "";
		for (int i = 0; i < boundry; i++) {
			if (scheduleList.get(i).overlap(schedule))
				value += scheduleList.get(i).inCharge;
		}

		return value;
	}

	private static class Schedule implements Comparable<Schedule> {
		int		start, end, id;
		String	inCharge	= "";

		public Schedule(int start, int end, int id) {
			this.start = start;
			this.end = end;
			this.id = id;
		}

		boolean overlap(Schedule s) {
			return (s.start >= start && s.start < end) || (s.end > start && s.end <= end);
			// || (s.start <= start && s.end <= end);
		}

		@Override
		public int compareTo(Schedule s) {
			return start - s.start;
		}

		@Override
		public String toString() {
			return start + " - " + end + " = " + id + " - " + inCharge;
		}

	}

}
