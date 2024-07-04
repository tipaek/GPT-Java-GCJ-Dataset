import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int j = 1; j <= t; ++j) {
			int n = in.nextInt();
			int[][] time = new int[n][3];
			for (int i = 0; i < n; i++) {
				time[i][0] = in.nextInt();
				time[i][1] = in.nextInt();
				time[i][2] = i;
			}
			System.out.println("Case #"+j+": "+getSchedule(time, n));
		}
		in.close();
	}

	private static String getSchedule(int[][] intervals, int n) {
		String ans = "";
		Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : intervals) {
            m.put(t[0], m.getOrDefault(t[0], 0) + 1);
            m.put(t[1], m.getOrDefault(t[1], 0) - 1);
        }
        int res = 0, cur = 0;
        for (int v : m.values()) {
            res = Math.max(res, cur += v);
        }
        
		if (res > 2)
			return "IMPOSSIBLE";
		HashSet<Integer> c = new HashSet<Integer>();
		HashSet<Integer> j = new HashSet<Integer>();
		for (int[] interval : intervals) {
			int start = interval[0];
			int end = interval[1];
			if (canDo(c,start,end)) {
				for (int t = start; t < end; t++)
					c.add(t);
				ans += "C";
				continue;
			}else {
				for (int t = start; t < end; t++)
					j.add(t);
				ans += "J";
			}
			
		}
		return ans;
	}
	
	private static boolean canDo(HashSet<Integer> set,int start,int time) {
		for(int i=start;i<time;i++) {
			if(set.contains(i))return false;
		}
		return true;
	}
}