import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
    private static final class Activity {
        public final int begin;
        public final int end;
        public final int parentingPartner;

        public Activity(int begin, int end, int parentingPartner) {
            this.begin = begin;
            this.end = end;
            this.parentingPartner = parentingPartner;
        }
    }
    


    private static String solve(Activity[] activities, int size) {
    	Arrays.sort(activities, (a, b) -> a.begin - b.begin);
        StringBuilder sb = new StringBuilder();
         ArrayList<Activity> c = new ArrayList<>();
         ArrayList<Activity> j = new ArrayList<>();
           	for (int i = 0; i < activities.length; i++) {
           	 boolean c_ = false;
             boolean j_ = false;

    		if(i==0 || c.isEmpty()) {
    			c.add(activities[i]);
    			sb.append("C");
    			c_ = true;
    			continue;
    		}
    		
    		for (int m = 0; m < c.size(); m++) {
	    		if (c.get(m).end <= activities[i].begin) {
	    				c.add(activities[i]);
	        			sb.append("C");
	        			c_ = true;
	        			break;
	    		}
    		}
    		if (c_ == true) continue;
    		
    		if (sb.length() == size) break;
    		if (j.isEmpty()){
    			j.add(activities[i]);
    			sb.append("J");
    			j_ = true;
    			continue;
    		}
    		for (int m = 0; m < j.size(); m++) {
	    		if (j.get(m).end <= activities[i].begin) {
	    				c.add(activities[i]);
	        			sb.append("J");
	        			j_ = true;
	    	    		break;
	    		}
    		}
    		if (j_ == true) continue;
    		
    		if (!c_ && !j_) {
    			sb.replace(0, sb.length(), "IMPOSSIBLE");
    			//sb = "IMPOSSIBLE";
    			break;
    		}
    		
    		
    		
    	}
		return sb.toString();
    	
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<String> res = new ArrayList<>();
        
        
        for (int z=1; z <= T; z++) {
        	int size=sc.nextInt();
        	Activity[] activities = new Activity[size];
    		int index = 0;
        	for (int i = 0; i < size; i++) {
	        	activities[i] = new Activity(sc.nextInt(), sc.nextInt(), index++);
	        	
        	}
        	String sb = solve(activities, size);
            System.out.println("Case #" + z + ": " + sb);

        			
        }
	}

}