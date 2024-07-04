import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static boolean checkClash(int[] starts, int[] ends, List<Integer> existing, int newStart, int newEnd) {

		for (Integer e : existing) {
			int start = starts[e];
			int end = ends[e];

			boolean condition1 = (newStart <= start) && (newEnd > start);
			boolean condition2 = (newStart < end) && (newEnd >= end);
			boolean condition3 = (newStart >= start) && (newEnd <= end);
			boolean condition4 = (newStart < start) && (newEnd > end);
			if (condition1 || condition2 || condition3 || condition4)
				return true;

		}
		return false;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		List<String> answers = new ArrayList<>();

		for (int count = 1; count <= t; count++) {

			String answer = "";

			List<Integer> cameron = new ArrayList<>();
			List<Integer> jamie = new ArrayList<>();

			int n = s.nextInt();

			int[] start = new int[n];
			int[] end = new int[n];

			for (int i = 0; i < n; i++) {
				start[i] = s.nextInt();
				end[i] = s.nextInt();
			}

			for (int i = 0; i < n; i++) {

				boolean clash = checkClash(start, end, cameron, start[i], end[i]);

				if (clash) {
					clash = checkClash(start, end, jamie, start[i], end[i]);
					if (clash) {
						answer = "IMPOSSIBLE";
						break;
					} else {
						jamie.add(i);
						answer = answer + ("J");
					}
				} else {
					cameron.add(i);
					answer = answer + "C";
				}
			}

			answers.add(answer);
		}

		s.close();

		int cc = 1;
		for (String answer : answers) {
			System.out.println("Case #" + cc + ": " + answer);
			cc++;
		}
	}

}