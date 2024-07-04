import java.util.*;

public class Solution {
	
	static class Activity {
		public int num;
		public int begin;
		public int end;
	}
	
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	
        for (int test = 0; test < tests; ++test) {
        	int n_activities = scanner.nextInt();
        	
        	Activity activities[] = new Activity[n_activities];
        	for (int i = 0; i < n_activities; i++) {
        		Activity activity = new Activity();
        		activity.num = i;
        		activity.begin = scanner.nextInt();
        		activity.end = scanner.nextInt();
        		activities[i] = activity;
        	}
        	
        	Arrays.sort(activities, new Comparator<Activity>() {
        	    @Override
        	    public int compare(Activity a1, Activity a2) {
        	    	if (a1.begin < a2.begin) return -1;
        	    	if (a1.begin > a2.begin) return 1;
        	    	
        	    	if (a1.end < a2.end) return -1;
        	    	if (a1.end > a2.end) return 1;
        	    	
        	    	return 0;
        	    }
        	});
        	
        	int cEnd = -1;
        	int jEnd = -1;
        	        	
       	
        	char[] schedule = new char[n_activities];
        	
        	boolean impossible = false;
        	for (int i = 0; i < n_activities; i++) {
        		if (cEnd > activities[i].begin && jEnd > activities[i].begin) {
        			impossible = true;
            		break;
            	}
        		
        		if (cEnd <= activities[i].begin) {
        			schedule[activities[i].num] = 'C';
        			cEnd = activities[i].end; 
            	} else if (jEnd <= activities[i].begin) {
            		schedule[activities[i].num] = 'J';
            		jEnd = activities[i].end;
            	} 
        	}
        	
        	if (impossible) {
        		System.out.println(String.format("Case #%d: %s", test + 1, "IMPOSSIBLE"));
        	} else {
        		StringBuilder sb = new StringBuilder();
        		sb.append(schedule);
        		System.out.println(String.format("Case #%d: %s", test + 1, sb.toString()));
        	}
        }
	}
	
}
