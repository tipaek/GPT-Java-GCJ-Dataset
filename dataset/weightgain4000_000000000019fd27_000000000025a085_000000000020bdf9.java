import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * cd /Users/ottsjo/dev/spec/codejam/target
 * cd classes && java Solution && cd ..
 */
class Solution {

	public static void main(String[] args) {
		Solution problem = new Solution();
		problem.solve();
	}

	// paste from here :)

	private void solve() {
		Executor.executeDefault(this::getCaseResult);
	}

	private String getCaseResult(Scanner scanner) {
		int numberOfActivities = ScannerExtensions.getInt(scanner);

		List<Activity> allActivities = populateActivities(scanner, numberOfActivities);
		int jamieBusyUntil = -1;
		int cameronBusyUntil = -1;

		for (Activity activity : allActivities) {
			if (activity.getFrom() >= jamieBusyUntil) {
				activity.setPerson('J');
				jamieBusyUntil = activity.getTo();
			}
			else if (activity.getFrom() >= cameronBusyUntil) {
				activity.setPerson('C');
				cameronBusyUntil = activity.getTo();
			}
			else {
				return "IMPOSSIBLE";
			}
		}

		return toResult(allActivities);
	}

	private String toResult(List<Activity> allActivities) {
		return allActivities.stream()
				.map(Activity::getPerson)
				.map(Object::toString)
				.collect(Collectors.joining());
	}

	private boolean stillHasUnassignedActivities(List<Activity> allActivities) {
		return allActivities.stream().anyMatch(x -> !x.hasPerson());
	}

	private void assignOne(List<Activity> activities) {
		for (Activity activity : activities) {
			if (!activity.hasPerson()) {
				activity.setPerson('C');
				return;
			}
		}
	}

	private char inverse(char c) {
		return c == 'C' ? 'J' : 'C';
	}

	private List<Activity> populateActivities(Scanner scanner, int numberOfActivities) {
		List<Activity> activities = new ArrayList<>(numberOfActivities);
		for (int i = 0; i < numberOfActivities; i++) {
			activities.add(createActivity(ScannerExtensions.getIntArray(scanner), i));
		}

		activities.sort(Comparator.comparing(Activity::getFrom));
		return activities;
	}

	public Activity createActivity(int[] activity, int index) {
		return new Activity(index, activity[0], activity[1]);
	}

	public static class Activity {
		private final int index;
		private final int from;
		private final int to;
		private char person = ' ';

		public Activity(int index, int from, int to) {
			this.index = index;
			this.from = from;
			this.to = to;
		}

		public boolean hasPerson() {
			return person != ' ';
		}

		public char getPerson() {
			return person;
		}

		public void setPerson(char person) {
			this.person = person;
		}

		public boolean overlaps(Activity other) {
			return !noOverlap(other);
		}

		private boolean noOverlap(Activity other) {
			return other.to <= this.from || other.from >= this.to;
		}

		@Override
		public String toString() {
			return "Activity{" +
					"index=" + index +
					", from=" + from +
					", to=" + to +
					", person=" + person +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Activity activity = (Activity) o;
			return index == activity.index;
		}

		@Override
		public int hashCode() {
			return Objects.hash(index);
		}

		public int getIndex() {
			return index;
		}

		public int getFrom() {
			return from;
		}

		public int getTo() {
			return to;
		}
	}

	//	public static class Activities {
	//
	//		private final Activity[] activities;
	//		private final int size;
	//
	//		public Activities(int size) {
	//			this.activities = new Activity[size];
	//			this.size = size;
	//		}
	//
	//		public void add(int[] activity, int index) {
	//			activities[index] = new Activity(index, activity[0], activity[1]);
	//		}
	//
	//		public int getSize() {
	//			return size;
	//		}
	//
	//		public Activity getActivity(int index) {
	//			return activities[index];
	//		}
	//	}

	private static class Executor {

		static void executeDefault(Function<Scanner, String> getCaseResult) {
			Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
			execute(input, getCaseResult, System.out::println);
		}

		private static void execute(Scanner reader, Function<Scanner, String> getCaseResult, Consumer<String> resultConsumer) {
			int numberOfCases = ScannerExtensions.getInt(reader);
			for (int i = 0; i < numberOfCases; i++) {
				String result = getCaseResult.apply(reader);
				String caseString = createCaseString(i+1, result);
				resultConsumer.accept(caseString);
			}
		}

		static String createCaseString(long caseNumber, String result) {
			return "Case #" + caseNumber + ": " + result;
		}
	}

	private static class ScannerExtensions {

		private ScannerExtensions() {}

		static int getInt(Scanner scanner) {
			return Integer.parseInt(scanner.nextLine());
		}

		static long getLong(Scanner scanner) {
			return Long.parseLong(scanner.nextLine());
		}

		static double getDouble(Scanner scanner) {
			return Double.parseDouble(scanner.nextLine());
		}

		static int[] getIntArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		static long[] getLongArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
		}

		static double[] getDoubleArray(Scanner scanner) {
			return Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		}
	}
}
