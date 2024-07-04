import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

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
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		for (int[] interval : intervals) {
			if (!pq.isEmpty() && pq.peek()[1] <= interval[0]) {
				pq.poll();
			}
			pq.add(interval);
		}
		if (pq.size() > 2)
			return "IMPOSSIBLE";
		HashSet<Integer> c = new HashSet<Integer>();
		HashSet<Integer> j = new HashSet<Integer>();
		for (int[] interval : intervals) {
			int start = interval[0];
			int end = interval[1];
			if (!c.contains(start)) {
				for (int t = start; t < end; t++)
					c.add(t);
				ans += "C";
				continue;
			}
			if (!j.contains(start)) {
				for (int t = start; t < end; t++)
					j.add(t);
				ans += "J";
			}
		}
		return ans;
	}
}