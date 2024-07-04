import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	static Scanner scn = new Scanner(System.in);

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static FastReader s = new FastReader();

	public static void main(String[] args) {
		int t = s.nextInt();
		int caseNumber = 1;

		while (t-- > 0) {
			int n = s.nextInt();
			int[] startTimes = new int[n];
			int[] endTimes = new int[n];
			Pair[] activities = new Pair[n];

			for (int i = 0; i < n; i++) {
				startTimes[i] = s.nextInt();
				endTimes[i] = s.nextInt();
				activities[i] = new Pair(startTimes[i], endTimes[i], i);
			}

			Arrays.parallelSort(activities, new ActivityComparator());

			char[] schedule = new char[n];
			int cEnd = 0, jEnd = 0;
			boolean possible = true;

			for (int i = 0; i < n; i++) {
				if (cEnd <= activities[i].start) {
					schedule[activities[i].index] = 'C';
					cEnd = activities[i].end;
				} else if (jEnd <= activities[i].start) {
					schedule[activities[i].index] = 'J';
					jEnd = activities[i].end;
				} else {
					possible = false;
					break;
				}
			}

			System.out.print("Case #" + caseNumber + ": ");
			if (possible) {
				for (char c : schedule) {
					System.out.print(c);
				}
				System.out.println();
			} else {
				System.out.println("IMPOSSIBLE");
			}

			caseNumber++;
		}
	}

	static class Pair {
		int start, end, index;

		Pair(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}
	}

	static class ActivityComparator implements Comparator<Pair> {
		@Override
		public int compare(Pair p1, Pair p2) {
			return Integer.compare(p1.start, p2.start);
		}
	}
}