import java.util.*;
import java.io.*;

public class Solution {
	
	private static String solution(int[][] activity) {
		Arrays.sort(activity, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		//System.out.println(Arrays.deepToString(activity));
		char[] r = new char[activity.length];
		int endc = 0;
		int endj = 0;
		for (int i = 0; i < activity.length; i++) {
			if (endc <= activity[i][0]) {
				// c can take the job
				r[activity[i][2]] = 'C';
				endc = activity[i][1];
			} else if (endj <= activity[i][0]) {
				// j can take the job
				r[activity[i][2]] = 'J';
				endj = activity[i][1];
			} else {
				return "IMPOSSIBLE";
			}
		}
		return new String(r);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
	
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			int[][] a = new int[n][3];
			for (int j = 0; j < n; j++) {
				a[j][0] = in.nextInt();
				a[j][1] = in.nextInt();
				a[j][2] = j;
			}
			System.out.println("Case #" + i + ": " + solution(a));
		}
	}
}