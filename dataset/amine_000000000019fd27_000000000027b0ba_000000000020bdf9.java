import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	class Activity {
		
		int index;
		char current;
		int start;
		int end;
		
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
	    int testNumber = in.nextInt();
	    
	    for (int k = 1; k <= testNumber; ++k) {
	        
	    	int count = in.nextInt();
	    	StringBuilder response = new StringBuilder();
	    	boolean impossible = false;
	    	List<Activity> activityList = new ArrayList<>();
	    	
	    	for (int i = 0 ; i < count ; i ++) {
	    		
	    		int start = in.nextInt();
	    		int end = in.nextInt();
	    		
	    		Arrays.asList(start, end);
	    		
	    		Solution.Activity activity = new Solution().new Activity();
	    		activity.index = i;
	    		activity.start = start;
	    		activity.end = end;
	    		activityList.add(activity);
	    		
	    	}
	    	
	    	Collections.sort(activityList, (a1,a2) -> a1.start == a2.start ? a1.end - a2.end : a1.start - a2.start);
	    	
	    	int startJ = 0;
	    	int startC = 0;
	    	int endJ = 0;
	    	int endC = 0;
	    	
	    	for (Activity a : activityList) {
	    		
	    		if (a.start == endC || a.end == startC) {
	    			
	    			startC = a.start;
	    			endC = a.end;
	    			a.current = 'C';
	    			
	    		} else if (a.start == endJ || a.end == startJ) {
	    			
	    			endJ = a.end;
	    			startJ = a.start;
	    			a.current = 'J';
	    			
	    		} else  if (a.start > endJ || a.end < startJ) {
	    		
	    			endJ = a.end;
	    			startJ = a.start;
	    			a.current = 'J';
	    		
	    		} else if (a.start > endC || a.end < startC) {
	    			
	    			startC = a.start;
	    			endC = a.end;
	    			a.current = 'C';
	    			
	    		} else {
	    			
	    			impossible = true;
	    			break;
	    		
	    		}
	    		
	    	}
	    	
	    	if (impossible) {
    			response = new StringBuilder("IMPOSSIBLE");
	    	} else {
	    		
		    	Collections.sort(activityList, (a1,a2) -> a1.index - a2.index);
		    	activityList.stream()
		    		.sorted((a1,a2) -> a1.index - a2.index)
		    		.map(a -> a.current)
		    		.forEach(response::append);
	    		
	    	}
	        
	    	System.out.println("Case #" + k + ": " + response.toString());
	      
	    }
	}
}