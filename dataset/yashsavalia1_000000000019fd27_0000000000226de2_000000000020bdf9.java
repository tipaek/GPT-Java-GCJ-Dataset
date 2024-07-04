import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		String[] outputs = new String[testCases];
		for (int i = 1; i <= testCases; ++i) {
			int numActivities = Integer.parseInt(in.nextLine());
			Activity[] activities = new Activity[numActivities];
			for(int j = 0; j < numActivities; j++) {
				activities[j] = new Activity(in.nextLine().split(" "));
			}
			String output = delegate(activities);
			outputs[i - 1] = "Case #" + i + ": " + output;
		}
		for(int i = 0; i < testCases; i++) {
			System.out.println(outputs[i]);
		}
	}
	
	public static String delegate(Activity[] activities) {
		char[] delegatedActivs = new char[activities.length];
		Arrays.sort(activities, (a, b) -> a.compareTo(b));
		int[] cArray = new int[1440];
		int[] jArray = new int[1440];
		for(int i = 0; i < activities.length; i++) {
			if(cArray[activities[i].startTime] == 0) {
				for(int j = activities[i].startTime; j < activities[i].endTime; j++) {
					cArray[j] = 1;
				}
				delegatedActivs[i] = 'C';
			} else if(jArray[activities[i].startTime] == 0) {
				for(int j = activities[i].startTime; j < activities[i].endTime; j++) {
					jArray[j] = 1;
				}
				delegatedActivs[i] = 'J';
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(delegatedActivs);
	}
}

class Activity implements Comparable<Activity> {
	public int startTime;
	public int endTime;
	public Activity(String[] arr) {
		startTime = Integer.parseInt(arr[0]);
		endTime = Integer.parseInt(arr[1]);
	}
	
	public boolean isOverlapping(Activity a) {
		if(this.startTime < a.endTime && this.endTime > a.startTime) {
			return true;
		}
		return false;
	}

	public int compareTo(Activity a) {
		return this.startTime - a.startTime;
	}
}
