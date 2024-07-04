import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scn.nextInt();
        int T=1;
        while(T<=t){
            int n = scn.nextInt();
            Activity[] activities = new Activity[n];
            for(int i=0;i<n;i++) {
            	activities[i] = new Activity();
            	activities[i].s = scn.nextInt();
            	activities[i].e = scn.nextInt();
            	activities[i].idx = i;
            }
            Arrays.sort(activities);
            char[] arrangement = new char[n];
            boolean notPossible = false;
            int lc=0,lj=0;
            for(int i = 0;i<n;i++) {
            	if(lc<=activities[i].s) {
            		lc = activities[i].e;
            		arrangement[activities[i].idx] = 'C';
            	}else if(lj<=activities[i].s) {
            		lj = activities[i].e;
            		arrangement[activities[i].idx] = 'J';
            	}else {
            		notPossible = true;
            		break;
            	}
            }
            
            String answer = (notPossible)?"IMPOSSIBLE":String.valueOf(arrangement);
            if(T<t)
            	System.out.println("Case #"+T+": "+answer);
            else
            	System.out.print("Case #"+T+": "+answer);           
            T++;
        }

	}
	static class Activity implements Comparable<Activity>{
		int s,e,idx;

		@Override
		public int compareTo(Activity a) {
			if(a.s == s)
				return a.e-e;
			else
				return s-a.s;
			
		}
		
	}

}
