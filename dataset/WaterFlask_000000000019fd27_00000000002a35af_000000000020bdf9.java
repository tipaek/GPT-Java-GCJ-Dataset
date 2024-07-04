import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
	

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        
        for(int i = 1; i <= cases; ++i) {
            int tasks = in.nextInt();
            int[][] intervals = new int[tasks][3];
            for(int t = 0; t < tasks; ++t) {
    			int start = in.nextInt();
    			int end = in.nextInt();
    			intervals[t][0] = start;
    			intervals[t][1] = end;
    			intervals[t][2] = t;
    		}
            
            System.out.print("Case #" + i + ": ");
            System.out.println(merge(intervals));
        }
        in.close();
	}
	
	public static String merge(int[][] intervals) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a1, a2)->a1[0]-a2[0] == 0 ? 
						(a1[1] - a2[1] == 0 ? a1[2] - a2[2] : a1[1] - a2[1]) : a1[0] - a2[0]);

		for(int i = 0; i < intervals.length; ++i) {
			pq.add(intervals[i]);
		}
		
		int[] first = pq.poll();
		int[] second = null;
		Map<String, Character> m = new HashMap<>();
		m.put(first[0] + "_" + first[1] + "_" + first[2], 'C');
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			if(second != null) {
				if(first[1] <= second[1]) {
					if(cur[0] >= first[1]) {
						first = cur;
						String key = first[0] + "_" + first[1] + "_" + first[2];
						m.put(key, 'C');
					}
					else {
						return "IMPOSSIBLE";
					}
				}
				else {
					if(cur[0] >= second[1]) {
						second = cur;
						String key = second[0] + "_" + second[1] + "_" + second[2];
						m.put(key, 'J');
					}
					else {
						return "IMPOSSIBLE";
					}
				}
			}
			
			else {
				if(cur[0] >= first[1]) {
					first = cur;
					m.put(first[0] + "_" + first[1] + "_" + first[2], 'C');
				}
				else {
					second = cur;
					m.put(second[0] + "_" + second[1] + "_" + second[2], 'J');
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < intervals.length; ++i) {
			String key = intervals[i][0] + "_" + intervals[i][1] + "_" + intervals[i][2];
			sb.append(m.get(key));
		}
		return sb.toString();
	}

}