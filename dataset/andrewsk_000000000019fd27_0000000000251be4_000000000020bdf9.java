import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[] start = new int[n];
			int[] stop = new int[n];
			for (int j = 0; j < n; j++) {
				start[j] = in.nextInt();
				stop[j] = in.nextInt();
			}
			String res = process(start, stop);
			System.out.println("Case #" + i + ": " + res);
		}
	}

	private static String process(int[] start, int[] stop) {
		List<Duty> duties = getDuties(start, stop);
		int busyC = 0;
		int busyJ = 0;
		for (Duty d : duties) {
			if (d.start >= busyC) {
				d.person = "C";
				busyC = d.finish;
			} else if (d.start >= busyJ) {
				d.person = "J";
				busyJ = d.finish;
			} else {
				return "IMPOSSIBLE";
			}
		}
		duties.sort(Comparator.comparing(Duty::getNumber));
		String schedule = duties.stream().map(Duty::getPerson).collect(Collectors.joining());
		return schedule;
	}

	private static List<Duty> getDuties(int[] start, int[] stop) {
		List<Duty> duties = new ArrayList<>();
		for (int i = 0; i < start.length; i++) {
			duties.add(new Duty(start[i], stop[i], i));
		}
		duties.sort(Comparator.comparing(Duty::getStart));
		return duties;
	}

	static class Duty {
		int start;
		int finish;
		int number;
		String person;

		public Duty(int start, int finish, int number) {
			this.start = start;
			this.finish = finish;
			this.number = number;
		}

		public int getStart() {
			return start;
		}

		public int getNumber() {
			return number;
		}

		public String getPerson() {
			return person;
		}
	}
}
