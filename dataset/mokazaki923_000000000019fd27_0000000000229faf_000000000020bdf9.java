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
			System.out.println("Case #" + i + ": " + solve(in));
		}
	}

	private static String solve(Scanner in) {
		int length = in.nextInt();
		in.nextLine();

		List<Schedule> scheduleList = new ArrayList<>();
		for (int index = 0; index < length; index++) {
			String[] parts = in.nextLine().split(" ");
			scheduleList.add(new Schedule(index, parts[0], parts[1]));
		}
		scheduleList.sort((a,b)-> {
			int result = Integer.compare(a.from, b.from);
			if (result != 0)
				return result;
			return Integer.compare(a.to, b.to);
		});

		char[] answer = new char[length];
		boolean[] cused = new boolean[60 * 24];
		boolean[] jused = new boolean[60 * 24];

		for (int index = 0; index < length; index++) {
			Schedule schedule = scheduleList.get(index);
			boolean cavailable = true;
			for (int t = schedule.from; t < schedule.to; t++) {
				if (!cused[t])
					continue;
				cavailable = false;
				break;
			}
			if (cavailable) {
				for (int t = schedule.from; t < schedule.to; t++)
					cused[t] = true;
				answer[schedule.index] = 'C';
				continue;
			}

			boolean javailable = true;
			for (int t = schedule.from; t < schedule.to; t++) {
				if (!jused[t])
					continue;
				javailable = false;
				break;
			}
			if (javailable) {
				for (int t = schedule.from; t < schedule.to; t++)
					jused[t] = true;
				answer[schedule.index] = 'J';
				continue;
			}

			return "IMPOSSIBLE";
		}

		return new String(answer);

	}

}

class Schedule {

	final int index;
	final int from;
	final int to;

	public Schedule(int index, String from, String to) {
		this.index = index;
		this.from = Integer.valueOf(from);
		this.to = Integer.valueOf(to);
	}

}