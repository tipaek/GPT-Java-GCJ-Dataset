

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
		List<ParentEvent> events = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			events.add(new ParentEvent(start, end, i));
		}
		events.sort(new ParentEventStartComparator());
		for (ParentEvent event : events) {

			boolean jamieClear = scheduleIsClear(jamieSchedule, event);
			boolean cameronClear = scheduleIsClear(cameronSchedule, event);

			// if only one parent is available, give it to them
			if (jamieClear && !cameronClear) {
				schedule(jamieSchedule, event, JAMIE);
			} else if (cameronClear && !jamieClear) {
				schedule(cameronSchedule, event, CAMERON);
			} else //noinspection ConstantConditions
				if (cameronClear && jamieClear) {
					// if either can do it, give it to the one who frees up the soonest
					int cameronFree = earliestFree(cameronSchedule);
					int jamieFree = earliestFree(jamieSchedule);
					if (cameronFree < jamieFree) {
						schedule(cameronSchedule, event, CAMERON);
					} else {
						schedule(jamieSchedule, event, JAMIE);
					}
					// if 2 activities start at the same time, schedule the longest one first (this is accomplished by sorting events initially)
				} else {
					impossible = true;
				}
		}

		if (impossible) {
			pw.print("IMPOSSIBLE");
		} else {
			// re-sort the events by ordinal
			events.sort(new ParentEventOrdinalComparator());
			for (ParentEvent event : events) {
				pw.print(event.getParent());
			}
		}
	}

	private static int earliestFree(String[] schedule) {
		// start at the end and work backwards.  The first non-empty slot we find, the result is +1 from there
		for (int i = 1439; i >= 0; i--) {
			if (schedule[i] != null) {
				return i + 1;
			}
		}
		return 0;
	}

	private static void schedule(String[] schedule, ParentEvent event, String parent) {
		for (int i = event.getStart(); i < event.getEnd(); i++) {
			schedule[i] = "X"; // not null. That's all that matters.
		}
		event.setParent(parent);
	}

	private static boolean scheduleIsClear(String[] schedule, ParentEvent event) {
		for (int i = event.getStart(); i < event.getEnd(); i++) {
			if (schedule[i] != null) {
				return false;
			}
		}
		return true;
	}


	private static class ParentEvent {
		private final int start;
		private final int end;
		private final int ordinal;
		private String parent;

		ParentEvent(int start, int end, int ordinal) {
			this.start = start;
			this.end = end;
			this.ordinal = ordinal;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

		public int getOrdinal() {
			return ordinal;
		}

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		public int getDuration() {
			return end - start;
		}
	}

	private static class ParentEventStartComparator implements java.util.Comparator<ParentEvent> {
		@Override
		public int compare(ParentEvent o1, ParentEvent o2) {
			int result = o1.start - o2.start;
			return (result != 0) ? result : o1.getDuration() - o2.getDuration();
		}
	}

	private static class ParentEventOrdinalComparator implements java.util.Comparator<ParentEvent> {
		@Override
		public int compare(ParentEvent o1, ParentEvent o2) {
			return o1.getOrdinal() - o2.getOrdinal();
		}
	}
}
