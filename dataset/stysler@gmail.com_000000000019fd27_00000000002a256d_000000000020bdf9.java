import java.util.*;
import java.io.*;
public class Solution {
	static class Activity{
		int activityNum;
		int startTime;
		int endTime;
		
		public Activity(int num, int s, int e) {
			activityNum = num;
			startTime = s;
			endTime = e;
		}
		
		public int getActivityNum() {
			return activityNum;
		}
		
		public int getStartTime() {
			return startTime;
		}
		
		public int getEndTime() {
			return endTime;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testCases; ++i) {
        	int totalActivities = in.nextInt();
        	ArrayList<Activity> activitiesForTestCase = new ArrayList<>();
        	for(int activityNum = 1; activityNum <= totalActivities; activityNum++ ) {
        		Activity activity = new Activity(activityNum, in.nextInt(), in.nextInt());        		
        		activitiesForTestCase.add(activity);
        	}
        	System.out.println("Case #" + i + ": " +  getScheduleResult(activitiesForTestCase));
        	
        }
        in.close();
    }
	
	private static String getScheduleResult(ArrayList<Activity> activitiesForTestCase) {
		StringBuilder result = new StringBuilder();
		ArrayList<Activity> jamesActivities = new ArrayList<>();
		ArrayList<Activity> cameronActivities = new ArrayList<>();
		//for each activity check if either Cameron can do it or James. If none of them then it is impossible
		for(Activity act : activitiesForTestCase) {
			if(canPersonDoIt(cameronActivities, act)) {
				result.append("C");
				cameronActivities.add(act);
			}
			else if(canPersonDoIt(jamesActivities,act)) {				
				result.append("J");
				jamesActivities.add(act);
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		return result.toString();
	}

	private static boolean canPersonDoIt(ArrayList<Activity> personActivities, Activity activityToTest) {
		if(personActivities.isEmpty()) return true;
		//otherwise go through their activities and check fo conflicts
		for(Activity currentActivity : personActivities) {
			//case when activity overlaps
			if(currentActivity.getStartTime() == activityToTest.getStartTime()) return false;			
			if(currentActivity.getStartTime() > activityToTest.getStartTime() && currentActivity.getStartTime() < activityToTest.getEndTime() ) {
				return false;
			}
			else if(currentActivity.getStartTime() < activityToTest.getStartTime() && currentActivity.getEndTime() > activityToTest.getStartTime() ){
				return false;
			}
		}		
		return true;
	}
}
  