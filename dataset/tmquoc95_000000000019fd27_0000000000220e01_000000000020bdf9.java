import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int nTestCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= nTestCases; ++i) {
			int nActivities = in.nextInt();
			Case aCase = new Case();
			for (int j = 0; j < nActivities; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				aCase.addActivity(start, end);
			}
			String result = aCase.schedule();
			System.out.printf("Case #%d: %s%n", i, result);
		}
	}

	interface IEvent extends Comparable<IEvent> {
		boolean run();

		int getTime();

		int getEventPriority();

		@Override
		default int compareTo(IEvent other) {
			int timeDiff = this.getTime() - other.getTime();
			if (timeDiff == 0) {
				return this.getEventPriority() - other.getEventPriority();
			}
			return timeDiff;
		}
	}

	static class Case {
		static final int START_PRIORITY = 1;
		static final int END_EVENT_PRIORITY = 0;

		private boolean Cameron = false;
		private boolean Jamie = false;

		private PriorityQueue<IEvent> queue = new PriorityQueue<>();
		private List<Start> activities = new ArrayList<>();

		void addActivity(int startTime, int endTime) {
			Start event = new Start(startTime, endTime);
			activities.add(event);
			queue.add(event);
		}

		String schedule() {
			while (!queue.isEmpty()) {
				IEvent event = queue.poll();
				if (!event.run()) {
					return "IMPOSSIBLE";
				}
			}

			StringBuilder builder = new StringBuilder();
			for (Start activity : activities) {
				builder.append(activity.assignee);
			}

			return builder.toString();
		}

		class Start implements IEvent {
			private final int startTime;
			private final int endTime;

			private char assignee;

			public Start(int startTime, int endTime) {
				this.startTime = startTime;
				this.endTime = endTime;
			}

			@Override
			public boolean run() {
				if (!Cameron) {
					Cameron = true;
					assignee = 'C';
					queue.add(new End(endTime, () -> Cameron = false));
				} else if (!Jamie) {
					Jamie = true;
					assignee = 'J';
					queue.add(new End(endTime, () -> Jamie = false));
				} else {
					return false;
				}
				return true;
			}

			@Override
			public int getTime() {
				return startTime;
			}

			@Override
			public int getEventPriority() {
				return START_PRIORITY;
			}
		}

		class End implements IEvent {

			private int time;
			Runnable delegate;

			End(int time, Runnable delegate) {
				this.time = time;
				this.delegate = delegate;
			}

			@Override
			public boolean run() {
				delegate.run();
				return true;
			}

			@Override
			public int getTime() {
				return time;
			}

			@Override
			public int getEventPriority() {
				return END_EVENT_PRIORITY;
			}
		}
	}
}
