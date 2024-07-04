import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		try {
			BufferedReader reader =
	                 new BufferedReader(new InputStreamReader(System.in));
			int numOfTestCases = Integer.parseInt(reader.readLine(), 10);
			for (int i = 0; i < numOfTestCases; i++) {
				int n = Integer.parseInt(reader.readLine(), 10);
				int[][] ses = new int[n][2];
				for (int j = 0; j < n; j++) {
					String line = reader.readLine();
					String[] twoNums = line.split(" ");
					ses[j][0] = Integer.parseInt(twoNums[0], 10);
					ses[j][1] = Integer.parseInt(twoNums[1], 10);
				}
				
				String r = solveSingleCase(ses);
				System.out.println("Case #"+(i+1)+": " + r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static class Interval{
		int start;
		int end;
		char assigned;
		int index;
		
		Interval(int s, int e, int i) {
			start = s;
			end = e;
			index = i;
		}
		
		public boolean overlaps(Interval that) {
			if (this.end <= that.start) {
				return false;
			}
			
			if (that.end <= this.start) {
				return false;
			}
			
			return true;
		}
	}
	
	public static String solveSingleCase(int[][] ses) {
		int n = ses.length;
		
		if (ses.length == 1) {
			return "C";
		}
		if (ses.length == 2) {
			return "CJ";
		}
		
		List<Interval> intervals = new ArrayList<>(n);
		for (int i = 0; i < ses.length; i++) {
			intervals.add(new Interval(ses[i][0], ses[i][1], i));
		}
		
		Collections.sort(intervals, (a,b) -> {
			if (a.start == b.start) {
				return a.end - b.end;
			}
			return a.start - b.start;
		});
		
		Interval c = null;
		Interval j = null;
		StringBuffer sb = new StringBuffer();
		
		for (Interval cur : intervals) {
			if (c != null && j != null) {
				if (c.overlaps(cur) && j.overlaps(cur)) {
					return "IMPOSSIBLE";
				}
			
				if (c.overlaps(cur)) {
					j = cur;
					cur.assigned = 'J';
					continue;
				}
				
				c = cur;
				cur.assigned = 'C';
				continue;
			}
			
			if (c != null) {
				if (c.overlaps(cur)) {
					j = cur;
					cur.assigned = 'J';
					continue;
				}
				c = cur;
				cur.assigned = 'C';
				continue;
			}
			
			if (j != null) {
				if (j.overlaps(cur)) {
					c = cur;
					cur.assigned = 'C';
					continue;
				}
				j = cur;
				cur.assigned = 'J';
				continue;
			}
			
			c = cur;
			cur.assigned = 'C';
		}
		
		Collections.sort(intervals, (a, b) -> {
			return a.index - b.index;
		});
		
		for (Interval cur : intervals) {
			sb.append(cur.assigned);
		}
		return sb.toString();
	}
}
