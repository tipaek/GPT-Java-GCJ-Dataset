

import java.io.PrintWriter;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int mumCases = sc.nextInt();
		sc.nextLine();
		for (int caseNumber = 0; caseNumber < mumCases; caseNumber++) {
			pw.print("Case #" + (caseNumber + 1) + ": ");
			solve(sc, pw);
			pw.println();
		}
		pw.println();
		pw.flush();
		pw.close();
		sc.close();
	}

	private static void solve(Scanner sc, PrintWriter pw) {
		final int N = sc.nextInt();
		String JAMIE = "J";
		String CAMERON = "C";

		String[] jamieSchedule = new String[1440]; // because there are 1440 minutes in the day.
		String[] cameronSchedule = new String[1440]; // because there are 1440 minutes in the day.
		boolean impossible = false;
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			if (scheduleIsClear(jamieSchedule, start, end)) {
				schedule(jamieSchedule, start, end);
				result.append(JAMIE);
			} else if (scheduleIsClear(cameronSchedule, start, end)) {
				schedule(cameronSchedule, start, end);
				result.append(CAMERON);
			} else {
				impossible = true;
			}
		}

		if (impossible) {
			pw.print("IMPOSSIBLE");
		} else {
			pw.print(result.toString());
		}
	}

	private static void schedule(String[] schedule, int start, int end) {
		for (int i = start; i < end; i++) {
			schedule[i] = "X"; // not null. That's all that matters.
		}
	}

	private static boolean scheduleIsClear(String[] schedule, int start, int end) {
		for (int i = start; i < end; i++) {
			if (schedule[i] != null) {
				return false;
			}
		}
		return true;
	}


}
