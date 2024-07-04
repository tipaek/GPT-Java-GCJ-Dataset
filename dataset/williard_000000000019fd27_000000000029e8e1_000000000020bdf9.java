import java.io.*;
import java.util.*;

public class Solution {
	static class Activity implements Comparable<Activity> {
		int S, E;
		int pos;
		public Activity(int a, int b, int c) {
			S = a; E = b; pos = c;
		}
		public Activity() {}
		public int compareTo(Activity temp) {
			if (this.S != temp.S)
				return this.S - temp.S;
			return this.E - temp.E;
		}
	}
	static Activity activityList[];
	static int N;
	static int memo[][] = new int[1005][1005];
	static int dp(int C, int J) {
		int i = Math.max(C, J) + 1;
		if (i > N)
			return 0;
		if (memo[C][J] != -1)
			return memo[C][J];
		int ret = -2;
		// try to assign i to Cameron
		if (activityList[i].S >= activityList[C].E) {
			int dpval = dp(i, J);
			if (dpval > -1)
				return memo[C][J] = i;
		}
		// try to assign i to Jamie
		if (activityList[i].S >= activityList[J].E) {
			int dpval = dp(C, i);
			if (dpval > -1)
				return memo[C][J] = i + 1000;
		}
		return memo[C][J] = ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int casenum = 1; casenum <= T; casenum++) {
			N = sc.nextInt();
			activityList = new Activity[N + 1];
			activityList[0] = new Activity(0, 0, 0);
			for (int i = 1; i <= N; i++) {
				int S = sc.nextInt();
				int E = sc.nextInt();
				activityList[i] = new Activity(S, E, i - 1);
			}
			Arrays.sort(activityList);
			for (int arr[] : memo)
				Arrays.fill(arr, -1);
			int dpval = dp(0, 0);			
			if (dpval >= 0) {
				char solution[] = new char[N];
				int C = 0, J = 0;
				for (int i = 0; i < N; i++) {
					if (dpval > 1000) {
						solution[activityList[i + 1].pos] = 'J';
						J = dpval - 1000;
					}
					else if (dpval > 0) {
						solution[activityList[i + 1].pos] = 'C';
						C = dpval;
					}
					dpval = memo[C][J];
				}
				System.out.printf("Case #%d: %s\n", casenum, new String(solution));
			}
			else
				System.out.printf("Case #%d: IMPOSSIBLE\n", casenum);
		}
	}
}