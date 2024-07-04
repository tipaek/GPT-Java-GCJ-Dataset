import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
	
	static class Event implements Comparable<Event> {
		private boolean starts;
		private int time;
		private int activity;
		public Event(int time, int activity, boolean starts) {
			super();
			this.time = time;
			this.activity = activity;
			this.starts = starts;
		}
		@Override
		public int compareTo(Event other) {
			int result = Integer.compare(time, other.time);
			if (result != 0) {
				return result;
			}
			result = Boolean.compare(starts, other.starts);
			return result;
		}
		public boolean isStarts() {
			return starts;
		}
		public int getTime() {
			return time;
		}
		public int getActivity() {
			return activity;
		}
		@Override
		public String toString() {
			return activity + (starts ? " starting at " : " ending at ") + time;
		}
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int x=1; x<=t; x++) {
        	int nActivities = in.nextInt();
        	List<Event> events = new ArrayList<>();
        	for (int i=1; i<=nActivities; i++) {
        		int si = in.nextInt();
        		int ei = in.nextInt();
        		events.add(new Event(si, i, true));
        		events.add(new Event(ei, i, false));
        	}
        	Collections.sort(events);
        	int cActivity = 0;
        	int jActivity = 0;
        	char[] assignments = new char[nActivities];
        	boolean possible = true;
        	
        	for (Event evt : events) {
        		int activity = evt.getActivity();
        		if (evt.isStarts()) {
        			if (cActivity == 0) {
        				cActivity = activity;
        				assignments[activity-1] = 'C';
        			} else if (jActivity == 0) {
        				jActivity = activity;
        				assignments[activity-1] = 'J';
        			} else {
        				possible = false;
        			}
        		} else {
        			if (cActivity == activity) {
        				cActivity = 0;
        			} else if (jActivity == activity) {
        				jActivity = 0;
        			}
        		}
        	}
        	String result = possible ? new String(assignments) : "IMPOSSIBLE";

        	System.out.format(Locale.ROOT, "Case #%d: %s%n", x, result);
        }
        in.close();
    }
}
