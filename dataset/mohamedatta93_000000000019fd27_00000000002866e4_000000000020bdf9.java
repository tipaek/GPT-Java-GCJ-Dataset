
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	class Activity {

		Integer startTime;
		Integer endTime;

		public Integer getStartTime() {
			return startTime;
		}

		public void setStartTime(Integer startTime) {
			this.startTime = startTime;
		}

		public Integer getEndTime() {
			return endTime;
		}

		public void setEndTime(Integer endTime) {
			this.endTime = endTime;
		}

		public Activity(Integer startTime, Integer endTime) {
			super();
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public boolean  hasConflicWith(Activity activity) {
			Activity smallActivity = activity;
			Activity longActivity = this;
			if((this.endTime-this.startTime)<(activity.endTime-activity.startTime)) {
				smallActivity = this;
				longActivity = activity;
			}

			if((smallActivity.startTime>longActivity.startTime&&smallActivity.startTime<longActivity.endTime)||
					(smallActivity.endTime<longActivity.endTime&&smallActivity.endTime>longActivity.startTime))
				return true;
			return false;
		}
		public boolean  hasConflicWith2(Activity activity) {
			
			if (this.startTime < activity.endTime && activity.startTime < this.endTime) 
		        return true; 
		    return false; 
		}
	}

	static boolean hasConflictsWith(List<Activity>activities,Activity activity) {

		for (int i = 0; i < activities.size(); i++) {
			if(activities.get(i).hasConflicWith(activity)) 
				return  true;
		}
		return false;
	}
	
	
	
    
	public static void main(String[] args) {
		Solution problem3 =new Solution();
		
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {

			int n = in.nextInt();
			List<Activity> activities = new ArrayList<Solution.Activity>();
			for (int j = 0; j < n; j++) {
				activities.add(problem3.new Activity(in.nextInt(), in.nextInt()));
			}
			List<Activity> JActivities = new ArrayList<Solution.Activity>();
			List<Activity> CActivities = new ArrayList<Solution.Activity>();
			String solution = "";
			for (int j = 0; j <n; j++) {
				if(!hasConflictsWith(CActivities, activities.get(j))) {
					CActivities.add(activities.get(j));
					solution += "C";
					continue;

				}
				if(!hasConflictsWith(JActivities, activities.get(j))) {
					JActivities.add(activities.get(j));
					solution += "J";
					continue;
				}
				
				solution = "IMPOSSIBLE";
				break;
			}

			System.out.println("Case #" + i + ": " + solution);

		}

	}

}
