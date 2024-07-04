import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt();
        for (int t=1; t<=T; t++) {
        	int N = in.nextInt();
        	Activity[] activities = new Activity[N];
        	for (int i=0; i<N; i++) {
        		Activity a = new Activity();
        		a.index = i;
        		a.start = in.nextInt();
        		a.end = in.nextInt();
        		a.assign = 0;
        		activities[i] = a;
        	}
        	
        	Arrays.sort(activities, new Comparator<Activity>() {
				@Override
				public int compare(Activity o1, Activity o2) {
					return o1.start - o2.start;
				}
        	});
        	
        	int cEnd = 0;
        	int jEnd = 0;
        	boolean impossible = false;
        	for (Activity a : activities) {
        		if (a.start >= cEnd) {
        			a.assign = 'C';
        			cEnd = a.end;
        		} else if (a.start >= jEnd) {
        			a.assign = 'J';
        			jEnd = a.end;
        		} else {
        			impossible = true;
        			break;
        		}
        	}

    		System.out.print("Case #" + t + ": ");
        	if (impossible) {
        		System.out.print("IMPOSSIBLE");
        	} else {
        		Arrays.sort(activities, new Comparator<Activity>() {
    				@Override
    				public int compare(Activity o1, Activity o2) {
    					return o1.index - o2.index;
    				}
            	});
        		for (Activity a : activities) {
        			System.out.print(a.assign);
        		}
        	}
    		System.out.print("\n");
        }

        in.close();
	}
	
	static class Activity {
		int index;
		int start;
		int end;
		char assign;
	}
}