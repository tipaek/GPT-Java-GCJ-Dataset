import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Pair<U, V> {
		public final U first;
		public final V second;

		private Pair(U first, V second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Pair<?, ?> pair = (Pair<?, ?>) o;
			return first.equals(pair.first) && second.equals(pair.second);
		}

		@Override
		public int hashCode() {
			return 31 * first.hashCode() + second.hashCode();
		}

		@Override
		public String toString() {
			return "(" + first + ", " + second + ")";
		}

		public static <U, V> Pair<U, V> of(U a, V b) {
			return new Pair<>(a, b);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = Integer.parseInt(scanner.nextLine());
		
		for (int i = 0; i < testCases; i++) {
			List<Pair<Integer, Integer>> activities = new ArrayList<>();
			int activityCount = Integer.parseInt(scanner.nextLine());
			
			for (int j = 0; j < activityCount; j++) {
				String[] input = scanner.nextLine().split(" ");
				Pair<Integer, Integer> activity = Pair.of(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
				activities.add(activity);
			}
			
			activities.sort(Comparator.comparingInt(pair -> pair.first));
			
			List<Pair<Integer, Integer>> cameronSchedule = new ArrayList<>();
			List<Pair<Integer, Integer>> jamieSchedule = new ArrayList<>();
			StringBuilder result = new StringBuilder();
			boolean impossible = false;
			
			for (int j = 0; j < activities.size(); j++) {
				Pair<Integer, Integer> currentActivity = activities.get(j);
				
				if (j == 0) {
					result.append("C");
					cameronSchedule.add(currentActivity);
				} else if (j == 1) {
					result.append("J");
					jamieSchedule.add(currentActivity);
				} else {
					int startTime = currentActivity.first;
					
					if (cameronSchedule.get(cameronSchedule.size() - 1).second <= startTime) {
						cameronSchedule.add(currentActivity);
						result.append("C");
					} else if (jamieSchedule.get(jamieSchedule.size() - 1).second <= startTime) {
						jamieSchedule.add(currentActivity);
						result.append("J");
					} else {
						impossible = true;
						break;
					}
				}
			}
			
			if (impossible) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (i + 1) + ": " + result);
			}
		}
		
		scanner.close();
	}
}