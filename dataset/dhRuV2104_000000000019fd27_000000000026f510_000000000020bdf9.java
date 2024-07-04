import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Time{
	int time;
	String worker;
	boolean start;
	int index;
	
	public Time(int time,boolean start) {
		this.time = time;
		this.start = start;
	}
}

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			/*Queue<Time> pq = new PriorityQueue<>(new Comparator<Time>() {
				@Override
				public int compare(Time o1, Time o2) {
					if(o1.time <= o2.time)
						return -1;					
					return 1;
				}
			});*/
			
			List<Time> times = new ArrayList<>();
			Map<Time,Time> intervals = new HashMap<>();
			
			for(int j = 0;j<n;j++) {
				int start = in.nextInt();
				Time st = new Time(start,true);
				st.index = j;
				int end = in.nextInt();
				Time e = new Time(end,false);
				
				times.add(st);
				times.add(e);
				intervals.put(st, e);
			}
			
		    String ans = getRoutine(times,intervals);
			
			System.out.println("Case #" + i + ": " + ans);

		}

	}

	private static String getRoutine(List<Time> times, Map<Time, Time> intervals) {
		Collections.sort(times,new Comparator<Time>() {
			@Override
			public int compare(Time o1, Time o2) {
				if(o1.time < o2.time)
					return -1;
				if(o1.time == o2.time) {
					if(o1.start && o2.start)
						return 0;
					else if(!o2.start && o1.start)
						return 1;
					else
						return -1;
				}
				return 1;
			}
		});
		
		/*for(Time t : times)
			System.out.println(t.time + " " + t.start + " " + t.worker);
		*/
		
		Queue<String> q = new LinkedList<String>();
		q.offer("C");
		q.offer("J");
		
		int n = intervals.size();
		char[] ans = new char[n];
		
		StringBuilder sb = new StringBuilder();
		
		for(Time t : times) {
			if(t.start) {
				if(q.isEmpty())
					return "IMPOSSIBLE";
				String worker = q.poll();
				t.worker = worker;
				Time e = intervals.get(t);
				e.worker = worker;
				ans[t.index] = worker.charAt(0);
			//	sb.append(t.worker);
			}
			else {
				String worker = t.worker;
				q.offer(worker);
			}
		}
		
		for(char c : ans)
			sb.append(c);
		
		return sb.toString();
	}

}
