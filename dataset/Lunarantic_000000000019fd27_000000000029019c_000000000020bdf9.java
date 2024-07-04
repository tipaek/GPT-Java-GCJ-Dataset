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
		public int s, e;
		public Schedule(int s, int e) {
			this.s = s;
			this.e = e;
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
	        	StringBuilder solution = new StringBuilder();
	        	int n = in.nextInt();
	        	int c = 0, j = 0;
	        	boolean ignore = false;
	        	PriorityQueue<Schedule> pq = new PriorityQueue<Schedule>(n, new ScheduleComparator());
		    	
	        	for (int y = 0; y < n; ++y) {
	        		pq.add(new Schedule(in.nextInt(), in.nextInt()));
	        	}
	        	
	        	while (!pq.isEmpty()) {
	        		if (ignore) {
	        			continue;
	        		}
	        		
	        		Schedule schedule = pq.poll();
	        		
	        		if (c <= schedule.s) {
	        			solution.append('C');
	        			c = schedule.e;
	        		} else if (j <= schedule.s) {
	        			solution.append('J');
	        			j = schedule.e;
	        		} else {
	        			ignore = true;
	        			solution = new StringBuilder();
	        			solution.append("IMPOSSIBLE");
	        		}
	        	}
		    	
	            System.out.println("Case #" + z + ": " + solution.toString());
	        }
	        in.close();
		}
	}
	
	public static void main(String[] args) {
		new Solution();

        System.exit(0);
    }
}