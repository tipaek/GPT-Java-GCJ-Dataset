import java.util.Arrays;
import java.util.Scanner;

public class Solution {
		
	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
                
        int cases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= cases; testCase++) {
            int size = scanner.nextInt();
        	
            Activity[] activities = new Activity[size];
            
            for (int activity = 0; activity < size; activity++) {
            	
            	int start = scanner.nextInt();
            	int end = scanner.nextInt();
            	
            	activities[activity] = new Activity(start, end, activity);
            }
            
            System.out.println("Case #" + testCase + ": " + generateString(activities));
        }
        
        scanner.close();
    }

	public static String generateString(Activity[] activities) {
		
		char[] chars = new char[activities.length];
		
		Arrays.sort(activities);
        
		activities[0].symbol = 'C';
        
        Activity lastC = activities[0];
        Activity lastJ = null;
        
        for (int j = 1; j < activities.length; j++) {
        	Activity current = activities[j];
        		
    		if (!current.collision(lastJ)) {
    			lastJ = current;
    			lastJ.symbol = 'J';
    		}
    		else if(!current.collision(lastC)) {
    			lastC = current;
    			lastC.symbol = 'C';
    		}
    		else
    			return "IMPOSSIBLE";
        }
        
        for(int i = 0; i < activities.length; i++) {
        	chars[activities[i].index] = activities[i].symbol;
        }
        
        return new String(chars);
	}

}

class Activity implements Comparable<Activity>{
	
	int start;
	int end;
	int index;
	
	char symbol;
	
	public Activity(int start, int end, int index) {
		
		this.start = start;
		this.end = end;
		this.index = index;
	}

	@Override
	public int compareTo(Activity activity) {
		
		if (this.start == activity.start) 
			return this.end - activity.end;
		
		return this.start - activity.start;
	}
	
	public boolean collision(Activity activity) {
		
		if (activity == null) 
			return false;
		
		if ((this.start >= activity.start && this.start < activity.end) || (activity.start >= this.start && activity.start < this.end)) 
			return true;
		
		return false;
	}
}
