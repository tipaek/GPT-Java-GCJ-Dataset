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
		for (int row = 0; row < length; row++) {
			String[] parts = new StringBuilder(in.nextLine()).toString().split(" ");
			scheduleList.add(new Schedule(parts[0], parts[1]));
		}

		String answer = "";
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
				answer += "C";
				continue;
			}
			
			boolean javailable = false;
			for (int t = schedule.from; t < schedule.to; t++) {
				if (!jused[t])
					continue;
				javailable = false;
				break;
			}
			if (javailable) {
				for (int t = schedule.from; t < schedule.to; t++)
					jused[t] = true;
				answer += "J";
				continue;
			}

			return "IMPOSSIBLE";
		}
		
		return answer;
		
	}

}

 class Schedule {

	 final int from;
	 final int to;
	public Schedule(String from, String to) {
		this.from = Integer.valueOf(from);
		this.to = Integer.valueOf(to);
	}
	 
 }