/**
 * 
 */

import java.util.*;
import java.io.*;

/**
 * @author fedy2
 *
 */
public class Solution {
	
	static class Activity {
		public String parent;
		public ActivityEvent start;
		public ActivityEvent end;
	}
	
	static class ActivityEvent {
		public int time;
		public boolean isStart;
		public Activity activity;
		
		public ActivityEvent(int time, boolean isStart, Activity activity) {
			this.time = time;
			this.isStart = isStart;
			this.activity = activity;
		}

		@Override
		public String toString() {
			return "[time=" + time + ", isStart=" + isStart + "]";
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		//System.out.println("t: " + t);

		for (int tc = 1; tc <= t; tc++) {
			int n = in.nextInt();
			
			List<ActivityEvent> events = new ArrayList<>();
			List<Activity> activities = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int startTime = in.nextInt();
				int endTime = in.nextInt();
				
				Activity activity = new Activity();
				activities.add(activity);
				
				ActivityEvent startEvent = new ActivityEvent(startTime, true, activity);
				events.add(startEvent);
				activity.start = startEvent;
				
				ActivityEvent endEvent = new ActivityEvent(endTime, false, activity);
				events.add(endEvent);
				activity.end = endEvent;
			}

			solve(tc, n, events, activities);
		}
		in.close();
	}
	
	private static void solve(int tc, int n, List<ActivityEvent> events, List<Activity> activities) {
		/*System.out.println("tc: " + tc);
		System.out.println("n: " + n);
		for (ActivityEvent event:events) System.out.println(event);*/
		
		events.sort((ActivityEvent e1, ActivityEvent e2) -> Integer.compare(e1.time, e2.time));
		
		Stack<String> availableParents = new Stack<>();
		availableParents.add("J");
		availableParents.add("C");
		for (ActivityEvent event:events) {
			if (event.isStart) {
				if (availableParents.isEmpty()) {
					System.out.println("Case #" + tc + ": IMPOSSIBLE");
					return;
				}
				String parent = availableParents.pop();
				event.activity.parent = parent;
			} else {
				availableParents.add(event.activity.parent);
			}
		}
		
		StringBuilder r = new StringBuilder();
		for (Activity activity:activities) {
			r.append(activity.parent);
		}
		
		System.out.println("Case #" + tc + ": " + r.toString());
	}

}
