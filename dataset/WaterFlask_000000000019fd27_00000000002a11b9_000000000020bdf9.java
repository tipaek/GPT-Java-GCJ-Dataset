import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {


        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        
        for(int i = 1; i <= cases; ++i) {
            int tasks = in.nextInt();
            int[][] intervals = new int[tasks][2];
            for(int t = 0; t < tasks; ++t) {
    			int start = in.nextInt();
    			int end = in.nextInt();
    			intervals[t][0] = start;
    			intervals[t][1] = end;
    		}
            
            System.out.print("Case #" + i + ": ");
            System.out.println(merge(intervals));
        }
        in.close();
	}
	public static class Interval {
		int time;
		char c;
		public Interval(int i, char d) {
			this.time = i;
			this.c = d;
		}
		
	}
	public static String merge(int[][] intervals) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a1, a2)->a1[0]-a2[0] == 0 ? a1[1] - a2[1] : a1[0] - a2[0]);

		for(int i = 0; i < intervals.length; ++i) {
			pq.add(intervals[i]);
		}
		
		int[] first = pq.poll();
		int[] second = null;
		Map<String, Character> m = new HashMap<>();
		m.put(first[0] + "_" + first[1], 'C');
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(cur[0] >= first[1]) {
				first = cur;
				m.put(first[0] + "_" + first[1], 'C');
			}
			else if(second == null) {
				second = cur;
				m.put(second[0] + "_" + second[1], 'J');
			}
			else if(cur[0] >= second[1]) {
				second = cur;
				m.put(second[0] + "_" + second[1], 'J');
			}
			else {
				return "IMPOSSIBLE";
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < intervals.length; ++i) {
			String key = intervals[i][0] + "_" + intervals[i][1];
			sb.append(m.get(key));
		}
		return sb.toString();
	}


}