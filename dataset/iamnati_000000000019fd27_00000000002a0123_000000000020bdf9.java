
import java.util.*;
import java.io.*;

class Activity {
	int start;
	int end;
	char assignedTo;
	Map<Character, Boolean> allowedToAssignTo;
	int index;
	public Activity(int start, int end, int index) {
		this.start = start;
		this.end = end;
		allowedToAssignTo = new HashMap<>();
		assignedTo = 'N';
		this.index = index;
		initializeMap();
	}
	private void initializeMap() {
		allowedToAssignTo.put('C', true);
		allowedToAssignTo.put('J', true);
	}

	public boolean isAllowed(char c) {
		return allowedToAssignTo.containsKey(c) && allowedToAssignTo.get(c);
	}

	public boolean isAssigned() {
		return assignedTo != 'N';
	}

	public void assign(char c) {
		assignedTo = c;
	}

	public void forbid(char c) {
		allowedToAssignTo.put(c, false);
	}
	public void allow(char c) {
		allowedToAssignTo.put(c, true);
	}

	public char assignedParent() {
		return assignedTo;
	}

	@Override
	public boolean equals(Object o) {
		Activity other = (Activity) o;
		return Objects.equals(start, other.start) &&
			Objects.equals(end, other.end);
	}
	@Override
	public int hashCode() {
		
		return Objects.hash(start, end);
	}
}

public class Solution {
	public static String validSchedule(int[][] activitySchdules) {
		Activity[] activities = new Activity[activitySchdules.length];
		Map<Activity, Integer> activityOrderMap = new HashMap<>();
		for (int i = 0; i < activitySchdules.length; i++) {
			int[] a = activitySchdules[i];
			Activity activity = new Activity(a[0], a[1], i);
			activities[i] = activity;
			activityOrderMap.put(activity, i);
		}
		



		Arrays.sort(activities, (a,b) -> (a.start - b.start));
		Stack<Activity> schedule = new Stack<>();

		boolean solution = validSchedule(activities, 0, schedule);
		String result = solution ?  getStringVersion(schedule) : "IMPOSSIBLE";
		return result;
	}

	private static boolean validSchedule(Activity[] activities, int index, Stack<Activity> assignedActivities){
		if (activities.length == index) { 
			return true;
		}
		Activity currentActivity = activities[index];


		if (currentActivity.isAllowed('C')) {
			currentActivity.assign('C');
			modifyStateOfNextActivitiesIfPossible(activities, index, 'C');
			assignedActivities.push(currentActivity);
			boolean result = validSchedule(activities, index + 1, assignedActivities);
			if (result) {
				return result;
			}

			//undo moves
			undoModifiedStates(activities, index, 'C');
			assignedActivities.pop();
		}

		if (currentActivity.isAllowed('J')) {
			currentActivity.assign('J');
			modifyStateOfNextActivitiesIfPossible(activities, index, 'J');
			assignedActivities.push(currentActivity);
			boolean result = validSchedule(activities, index + 1, assignedActivities);
			if (result) {
				return result;
			}

			//undo moves
			undoModifiedStates(activities, index, 'J');
			assignedActivities.pop();
		}



		return false;
	}

	private static void modifyStateOfNextActivitiesIfPossible(Activity[] activities, int index, char parent) {
		Activity currentActivity = new Activity(activities[index].start, activities[index].end, -1);
		for (int i = index + 1; i < activities.length; i++) {
			Activity nextActivity = activities[i];
			if (!overlaps(currentActivity, nextActivity)) {
				break;
			} else {
				nextActivity.forbid(parent);
			}
		}
	}

	private static void undoModifiedStates(Activity[] activities, int index, char parent) {
		Activity currentActivity = new Activity(activities[index].start, activities[index].end, -1);
		for (int i = index + 1; i < activities.length; i++) {
			Activity nextActivity = activities[i];
			if (!overlaps(currentActivity, nextActivity)) {
				break;
			} else {
				nextActivity.allow(parent);
			}
		}
	}

	private static boolean overlaps(Activity curr, Activity next) {
		return next.start < curr.end;
	}

	private static String getStringVersion(Stack<Activity> activities) {

		char[] activityAssignment = new char[activities.size()];
		Iterator<Activity> scheduleIterator = activities.iterator();
		while (scheduleIterator.hasNext()) {
			Activity next = scheduleIterator.next();
			activityAssignment[next.index] = next.assignedParent();
		}

		return new String(activityAssignment);
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          in.nextLine();
          int[][] matrix = new int[n][2];
          for (int j = 0; j < n; j++) {
              String[] line = in.nextLine().split(" ");
              
                matrix[j][0] = Integer.parseInt(line[0]);
                matrix[j][1] = Integer.parseInt(line[1]);
             
          }
          String r = validSchedule(matrix);
          System.out.println("Case #" + i + ": " + (r));
        }

	}
}