import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCases = Integer.parseInt(in.nextLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<testCases;i++) {
			StringBuilder sbThisCase = new StringBuilder();
			int activitiesCount = Integer.parseInt(in.nextLine());
			List<Activity> activities = new ArrayList<>();
			for(int j=0;j<activitiesCount;j++) {
				String[] timesArr = in.nextLine().split(" ");
				activities.add(new Activity(Integer.parseInt(timesArr[0]), Integer.parseInt(timesArr[1]), j));
			}
			activities.sort((a1,a2) -> {
				return a1.start - a2.start;
			});
			List<Activity> currentActivities = new ArrayList<>();
			for(Activity activity : activities) {
				//First, let's remove from currentActivities
				currentActivities.removeIf((a) -> { return a.end <= activity.start; });
				if(currentActivities.size() > 1) {
					sbThisCase.append("IMPOSSIBLE");
					break;
				}
				if(currentActivities.size() == 0) {
					activity.person = "J";
				} else {
					//There is only one current activity. So assign the other person
					if(currentActivities.get(0).person.equals("J")) {
						activity.person = "C";
					} else {
						activity.person = "J";
					}
				}
				currentActivities.add(activity);
			}
			if(sbThisCase.length() == 0) {
				activities.sort((a1,a2) -> {
					return a1.order - a2.order;
				});
				for(Activity activity : activities) {
					sbThisCase.append(activity.person);
				}
			}
			
			sb.append("Case #").append(i+1).append(": ").append(sbThisCase).append("\n");
		}
		System.out.print(sb);
	}

	public static class Activity {
		public int start;
		public int end;
		public int order;
		public String person;
		public Activity(int start, int end, int order) {
			this.start = start;
			this.end = end;
			this.order = order;
		}
	}
}
