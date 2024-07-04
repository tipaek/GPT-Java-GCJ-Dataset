import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = sc.nextInt();
			List<Activity> activities = new ArrayList<Activity>(n);
			for (int j = 0; j < n; j++) {
				Activity activity = new Activity(sc.nextInt(), sc.nextInt());
				activities.add(activity);
			}

			Parent C = new Parent('C');
			Parent J = new Parent('J');
			StringBuilder sb = new StringBuilder();
			List<Activity> copy = new ArrayList<>(activities);
			Collections.sort(copy);
			for (Activity activity : copy) {
				boolean isAdded = false;
				if (C.addActivity(activity)) {
					isAdded = true;
					activity.setAssignee(C);
				}

				if (!isAdded && J.addActivity(activity)) {
					isAdded = true;
					activity.setAssignee(J);
				}

				if (!isAdded && !sb.toString().equals("IMPOSSIBLE")) {
					sb.append("IMPOSSIBLE");
				}
			}

			if (!sb.toString().equals("IMPOSSIBLE")) {
				for (Activity activity : activities) {
					sb.append(activity.getAssignee().name);
				}
			}
			System.out.println("Case #" + i + ": " + sb.toString());
		}
		sc.close();
	}
}

class Activity implements Comparable<Activity> {
	int startTime;
	int endTime;
	private Parent assignee;

	Activity(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Activity [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public boolean hasOverlap(Activity activity) {
		if ((this.startTime < activity.startTime && activity.startTime < this.endTime)
				|| (this.startTime < activity.endTime && activity.endTime < this.endTime)
				|| (activity.startTime < this.startTime && this.startTime < activity.endTime)
				|| (activity.startTime < this.endTime && this.endTime < activity.endTime)
				|| (this.startTime == activity.startTime && this.endTime == activity.endTime))
			return true;
		return false;
	}

	@Override
	public int compareTo(Activity activity) {
		if (this.startTime == activity.startTime)
			return 0;
		else if (this.startTime > activity.startTime)
			return 1;
		else
			return -1;
	}

	public Parent getAssignee() {
		return assignee;
	}

	public void setAssignee(Parent assignee) {
		this.assignee = assignee;
	}

}

class Parent {
	char name;
	List<Activity> activities = new ArrayList<Activity>();

	Parent(char name) {
		this.name = name;
	}

	public boolean addActivity(Activity activity) {
		if (activities.size() == 0)
			return activities.add(activity);
		Activity assignActivity = getLastActivity();
			if (!assignActivity.hasOverlap(activity)) {
				return activities.add(activity);
			}
		return false;
	}
	
	public Activity getLastActivity() {
		return activities.get(activities.size() - 1);
	}
}