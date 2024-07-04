
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		// Read number of test cases
		int numCases = in.nextInt();

		for (int i = 1; i <= numCases; i++) {
			int numActivities = in.nextInt();
			List<Activity> activities = new ArrayList<>();
			for (int x = 1; x <= numActivities; x++) {
				activities.add(new Activity(x, in.nextInt(), in.nextInt()));
			}

			List<Activity> equivalentActivities = getEquivalentActivities(activities);

			// Collections.sort(equivalentActivities, new Comparator<Activity>() {
			//
			// @Override
			// public int compare(Activity arg0, Activity arg1) {
			// return Integer.compare(arg0.getStartTime(), arg1.getStartTime());
			// }
			//
			// });

			// Check feasibility
			boolean feasible = true;
			for (Activity activity : equivalentActivities) {
				// System.out.println(activity.getStartTime());
				int collisions = 0;
				for (Activity otherActivity : equivalentActivities) {
					if (!activity.equals(otherActivity)) {
						if (activity.getStartTime() >= otherActivity.getStartTime() && activity.getStartTime() < otherActivity.getEndTime()
								|| activity.getEndTime() >= otherActivity.getStartTime() && activity.getEndTime() <= otherActivity.getEndTime()
								|| activity.getStartTime() <= otherActivity.getStartTime() && activity.getEndTime() >= otherActivity.getEndTime()) {
							collisions++;
							if (collisions > 1) {
								feasible = false;
								break;
							}
						}
					}
				}
				if (!feasible) {
					break;
				}
			}
			if (!feasible) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
				break;
			}
			// feasible
			Collections.sort(activities, new Comparator<Activity>() {

				@Override
				public int compare(Activity arg0, Activity arg1) {
					return Integer.compare(arg0.getStartTime(), arg1.getStartTime());
				}

			});

			int whenCameronIsFree = -1;
			for (Activity activity : activities) {
				if (activity.getStartTime() >= whenCameronIsFree) {
					activity.setAssignee("C");
					whenCameronIsFree = activity.getEndTime();
				} else {
					activity.setAssignee("J");
				}
			}

			Collections.sort(activities, new Comparator<Activity>() {
				@Override
				public int compare(Activity arg0, Activity arg1) {
					return Integer.compare(arg0.getId(), arg1.getId());
				}
			});

			System.out.print("Case #" + i + ": ");
			for (Activity activity : activities) {
				System.out.print(activity.getAssignee());
			}
			System.out.print("\n");

		}
	}

	private static List<Activity> getEquivalentActivities(List<Activity> activities) {
		Map<Integer, Activity> equivalentActivitiesMap = new HashMap<>();
		for (Activity activity : activities) {
			equivalentActivitiesMap.put(activity.getId(), activity);
		}
		int nextId = activities.size() + 1;
		// for (Entry<Integer, Activity> otherActivity : equivalentActivitiesMap.entrySet()) {
		// System.out.println(otherActivity.getValue());
		// }
		// System.out.println("---------");

		boolean done = false;
		while (!done) {
			Integer firstCollider = null;
			Integer secondCollider = null;
			boolean completeOverlapping = false;
			for (Entry<Integer, Activity> activity : equivalentActivitiesMap.entrySet()) {
				for (Entry<Integer, Activity> otherActivity : equivalentActivitiesMap.entrySet()) {
					if (!activity.equals(otherActivity)) {
						if (activity.getValue().getStartTime() >= otherActivity.getValue().getStartTime()
								&& activity.getValue().getStartTime() < otherActivity.getValue().getEndTime()
								|| activity.getValue().getEndTime() > otherActivity.getValue().getStartTime()
										&& activity.getValue().getEndTime() <= otherActivity.getValue().getEndTime()) {
							firstCollider = activity.getKey();
							secondCollider = otherActivity.getKey();
							completeOverlapping = false;
							break;
						} else if (activity.getValue().getStartTime() <= otherActivity.getValue().getStartTime()
								&& activity.getValue().getEndTime() >= otherActivity.getValue().getEndTime()) {
							firstCollider = activity.getKey();
							secondCollider = otherActivity.getKey();
							completeOverlapping = true;
							break;
						}
					}
				}
				if (firstCollider != null) {
					break;
				}
				done = true;
			}
			if (firstCollider != null) {
				// split activities
				Activity firstToStart = equivalentActivitiesMap.get(firstCollider);
				Activity secondToStart = equivalentActivitiesMap.get(secondCollider);
				if (secondToStart.getStartTime() < firstToStart.getStartTime()) {
					Activity temp = firstToStart;
					firstToStart = secondToStart;
					secondToStart = temp;
				}

				if (completeOverlapping) {
					equivalentActivitiesMap.put(nextId, new Activity(nextId, firstToStart.getStartTime(), secondToStart.getStartTime()));
					nextId++;
					if (firstToStart.getEndTime() < secondToStart.getEndTime()) {
						equivalentActivitiesMap.put(nextId, new Activity(nextId, firstToStart.getEndTime(), secondToStart.getEndTime()));
					} else {
						equivalentActivitiesMap.put(nextId, new Activity(nextId, secondToStart.getEndTime(), firstToStart.getEndTime()));

					}
					nextId++;
					equivalentActivitiesMap.remove(firstToStart.getId());
				} else {
					equivalentActivitiesMap.put(nextId, new Activity(nextId, firstToStart.getStartTime(), secondToStart.getStartTime()));
					nextId++;
					if (firstToStart.getEndTime() < secondToStart.getEndTime()) {
						equivalentActivitiesMap.put(nextId, new Activity(nextId, firstToStart.getEndTime(), secondToStart.getEndTime()));
					} else {
						equivalentActivitiesMap.put(nextId, new Activity(nextId, secondToStart.getEndTime(), firstToStart.getEndTime()));

					}
					nextId++;
					equivalentActivitiesMap.put(nextId, new Activity(nextId, secondToStart.getStartTime(), firstToStart.getEndTime()));
					nextId++;
					equivalentActivitiesMap.remove(firstToStart.getId());
					equivalentActivitiesMap.remove(secondToStart.getId());
				}

				firstCollider = null;
				secondCollider = null;
				// for (Entry<Integer, Activity> otherActivity : equivalentActivitiesMap.entrySet()) {
				// System.out.println(otherActivity.getValue());
				// }
				// System.out.println("---------");
			}
		}
		List<Activity> result = new ArrayList<>();
		for (Entry<Integer, Activity> otherActivity : equivalentActivitiesMap.entrySet()) {
			result.add(otherActivity.getValue());
			// System.out.println(otherActivity.getValue());
		}

		return result;
	}

	public static class Activity {

		int id = 0;
		int startTime = 0;
		int endTime = 0;
		String assignee = null;

		public Activity(int id, int start, int end) {
			this.id = id;
			this.startTime = start;
			this.endTime = end;
		}

		public String getAssignee() {
			return assignee;
		}

		public void setAssignee(String assignee) {
			this.assignee = assignee;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Activity other = (Activity) obj;
			if (id != other.id)
				return false;
			return true;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}

		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		@Override
		public String toString() {
			return "Activity [id=" + id + ", startTime=" + startTime + ", endTime=" + endTime + ", assignee=" + assignee + "]";
		}

	}
}