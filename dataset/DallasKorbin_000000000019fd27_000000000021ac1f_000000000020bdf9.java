import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int numTests = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for(int i = 0; i < numTests; i++) {
        ActivitySchedule Cschedule = new ActivitySchedule();
        ActivitySchedule Jschedule = new ActivitySchedule();
        String result = "";
    	int numActivities = in.nextInt();
    	
    	for(int j = 0; j < numActivities ; j++) {
    		int startMins = in.nextInt();
    		int endMins = in.nextInt();
    		Activity activity = new Activity(startMins, endMins);
    		
    		if(Cschedule.canSchedule(activity)) {
    			Cschedule.add(activity);
    			result += "C";
    		} else if(Jschedule.canSchedule(activity)) {
    			Jschedule.add(activity);
    			result += "J";
    		} else {
    			result = "IMPOSSIBLE";
    			break;
    		}
    	}
    	
    	System.out.println("Case #" + (i+1) + ": " + result);
    }
    in.close();
  }

}

class ActivitySchedule {
	ArrayList<Activity> schedule = new ArrayList<>();
	
	public void add(Activity activity) {
		schedule.add(activity);
	}
	
	public boolean canSchedule(Activity newActivity) {
		for(Activity activty : schedule) {
			if(activty.contains(newActivity)) {
				return false;
			}
		}
		
		return true;
	}
}

class Activity {
	int start;
	int end;
	
	public Activity(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public boolean contains(Activity otherActivity) {
		if(otherActivity.start < end && otherActivity.end > start) {
			return true;
		}
		return false;
	}
}