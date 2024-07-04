import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static class Activity implements Comparable<Activity>{
		int start;
		int end;

		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Activity o) {
			// TODO Auto-generated method stub
			return this.start-o.start;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = sc.nextInt();
		int numOfActvities;
		for (int i = 0; i < testCases; i++) {
			numOfActvities = sc.nextInt();
			ArrayList<Activity> activities = new ArrayList<Activity>();
			for (int j = 0; j < numOfActvities; j++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				Activity a = new Activity(start, end);
				activities.add(a);
			}
			System.out.println("Case #" + (i + 1) + ": " + scheduleActivities(activities));
		}

	}

	private static String scheduleActivities(ArrayList<Activity> activities) {
		// TODO Auto-generated method stub
		int[] minutesInDay = new int[1441];
		Arrays.fill(minutesInDay, 0);
		
		int[] c = new int[1441];
		int[] j = new int[1441];
		Arrays.fill(c, 0);
		Arrays.fill(j, 0);
		String res = "";
		Collections.sort(activities);
		for(int i=0;i<activities.size();i++) {
			Activity activity = activities.get(i);
			if(isValid(c,activity)) {
				res += "C";
				populate(c,activity);
			}else if(isValid(j, activity)) {
				res += "J";
				populate(j, activity);
			}else {
				return "IMPOSSIBLE";
			}
		}
		return res;
	}

	private static void populate(int[] a, Activity activity) {
		// TODO Auto-generated method stub
		for(int i=activity.start;i<activity.end;i++) {
			a[i] = 1;
		}
	}

	private static boolean isValid(int[] a, Activity activity) {
		// TODO Auto-generated method stub
		for(int i=activity.start;i<activity.end;i++) {
			if(a[i]==1)
				return false;
		}
		return true;
	}
}
