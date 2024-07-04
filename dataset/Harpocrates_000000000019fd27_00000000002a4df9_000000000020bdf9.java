import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	public static class Schedule {
		public int start, end, pos;
		public Schedule(int start, int end, int pos) {
			this.start = start;
			this.end = end;
			this.pos = pos;
		}
	}
	
	public static class ScheduleComparator implements Comparator<Schedule> {
		@Override
		public int compare(Schedule o1, Schedule o2) {
			if (o1.start > o2.start) 
				return 1; 
			else if (o1.start < o2.start) 
				return -1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
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
        		
        		if (c <= schedule.start) {
        			pos[schedule.pos] = 'C';
        			c = schedule.end;
        		} else if (j <= schedule.start) {
        			pos[schedule.pos] = 'J';
        			j = schedule.end;
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