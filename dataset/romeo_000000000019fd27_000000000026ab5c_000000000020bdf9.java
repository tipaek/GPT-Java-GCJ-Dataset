import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Interval implements Comparable<Interval> {
	int s;
	int e;
	int idx;
	char ch;
	Interval(int s, int e, int idx) {
		this.s = s;
		this.e = e;
		this.idx = idx;
	}
	public int compareTo(Interval interval) {
		return this.s - interval.s;
	}
}

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			int N = Integer.parseInt(br.readLine());
			Interval[] intervals = new Interval[N];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				int s = Integer.parseInt(str[0]);
				int e = Integer.parseInt(str[1]);
				intervals[i] = new Interval(s, e, i);
			}
			
			Arrays.sort(intervals);
//			for(int i=0;i<N;i++) System.out.println(intervals[i].s + " " + intervals[i].e);
			
			boolean isPossible = true;
			int[][] assignMatrix = new int[2][2];
			for (int i = 0; i < N; i++) {
				if (intervals[i].s >= assignMatrix[0][1]) {
					intervals[i].ch = 'C';
					assignMatrix[0][0] = intervals[i].s;
					assignMatrix[0][1] = intervals[i].e;
				} else if (intervals[i].s >= assignMatrix[1][1]) {
					intervals[i].ch = 'J';
					assignMatrix[1][0] = intervals[i].s;
					assignMatrix[1][1] = intervals[i].e;
				} else {
					isPossible = false;
					break;
				}
			}

			String result;
			if (!isPossible) result = "IMPOSSIBLE";
			else
			{
				char[] ret = new char[N];
				for(int i=0;i<N;i++)
					ret[intervals[i].idx] = intervals[i].ch;
				result = new String(ret);
			}
			System.out.println("Case #" + t + ": " + result);
		}
	}

}