import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//2020

public class Solution {
	
	public Solution() {
		Decider decider = new Decider();
		decider.runner();
	}
	
	public class Schedule {
		public int s, e, p;
		public Schedule(int s, int e, int p) {
			this.s = s;
			this.e = e;
			this.p = p;
		}
	}
	
	public class ScheduleComparator implements Comparator<Schedule> {
		@Override
		public int compare(Schedule o1, Schedule o2) {
			if (o1.s > o2.s) 
				return 1; 
			else if (o1.s < o2.s) 
				return -1;
			return 0;
		}
	}
	
	public class Decider {
		public void runner() {
			Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	        int t = in.nextInt();

	        for (int z = 1; z <= t; ++z) {
	        	int n = in.nextInt();
	        	int c = 0, j = 0;
	        	boolean ignore = false;
	        	PriorityQueue<Schedule> pq = new PriorityQueue<Schedule>(n, new ScheduleComparator());
	        	char[] pos = new char[n];
		    	
	        	for (int y = 0; y < n; ++y) {
	        		pq.add(new Schedule(in.nextInt(), in.nextInt(), y));
	        	}
	        	
	        	while (!pq.isEmpty()) {
	        		Schedule schedule = pq.poll();
	        		
	        		if (c <= schedule.s) {
	        			pos[schedule.p] = 'C';
	        			c = schedule.e;
	        		} else if (j <= schedule.s) {
	        			pos[schedule.p] = 'J';
	        			j = schedule.e;
	        		} else {
	        			ignore = true;
	        			break;
	        		}
	        	}
		    	
	        	if (ignore) {
	        		System.out.println("Case #" + z + ": IMPOSSIBLE");
	        	} else {
	        		System.out.println("Case #" + z + ": " + new String(pos));
	        	}
	        }
	        in.close();
		}
	}
	
	public static void main(String[] args) {
		new Solution();

        System.exit(0);
    }
}
