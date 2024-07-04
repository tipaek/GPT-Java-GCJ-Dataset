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
    	ArrayList<Activity> allActivities = new ArrayList<>();
    	
    	for(int j = 0; j < numActivities ; j++) {
    		int startMins = in.nextInt();
    		int endMins = in.nextInt();
    		Activity activity = new Activity(startMins, endMins, j);
    		allActivities.add(activity);
    	}
    	
    	allActivities.sort(new Comparator<Activity>() {
    		public int compare(Activity one, Activity two) {
    			return one.start - two.start;
    		}
		});
    	
    	boolean impposible = false;
    	for(Activity activity : allActivities) {
    		if(impposible) {
    			//do nothing
    		} else if(Cschedule.canSchedule(activity)) {
    			Cschedule.add(activity);
    			activity.parent="C";
    		} else if(Jschedule.canSchedule(activity)) {
    			Jschedule.add(activity);
    			activity.parent="J";
    		} else {
    			impposible = true;
    		}
    	}
    	
    	if(impposible) {
    		result = "IMPOSSIBLE";
    	} else {
        	allActivities.sort(new Comparator<Activity>() {
        		public int compare(Activity one, Activity two) {
        			return one.originalOrder - two.originalOrder;
        		}
    		});
    		for(Activity activity : allActivities) {
    			result += activity.parent;
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
	int originalOrder;
	String parent = "";
	
	public Activity(int start, int end, int originalOrder) {
		this.start = start;
		this.end = end;
		this.originalOrder = originalOrder;
	}
	
	public boolean contains(Activity otherActivity) {
		if(otherActivity.start < end && otherActivity.end > start) {
			return true;
		}
		return false;
	}
	
}