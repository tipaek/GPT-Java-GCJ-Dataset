import java.util.*;
import java.util.Map.Entry;

import java.math.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);
		// InputReader in = new InputReader(new
		// File("ethan_traverses_a_tree.txt"));
		// PrintWriter out = new PrintWriter(new
		// File("ethan_traverses_a_tree-output.txt"));

		int pi = in.nextInt();
		for (int qi = 1; qi <= pi; qi++) {
			int n = in.nextInt();
			List<Activity> list = new ArrayList<Activity>();
			for (int i = 0; i < n; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				list.add(new Activity(i, start, end));
			}

			Collections.sort(list, new Comparator<Activity>() {

				@Override
				public int compare(Activity o1, Activity o2) {
					return o1.start - o2.start;
				}
			});

			boolean ok = true;
			int end1 = 0;
			int end2 = 0;
			for (Activity activity : list) {
				if (activity.start >= end1) {
					end1 = activity.end;
					activity.ans = 'C';
				} else if (activity.start >= end2) {
					end2 = activity.end;
					activity.ans = 'J';
				} else {
					ok = false;
					break;
				}
			}
			if (!ok) {
				out.printf("Case #2: IMPOSSIBLE\n");
			} else {

				Collections.sort(list, new Comparator<Activity>() {

					@Override
					public int compare(Activity o1, Activity o2) {
						return o1.id - o2.id;
					}
				});
				char[] tmp = new char[n];
				for (int i = 0; i < n; i++) {
					tmp[i] = list.get(i).ans;
				}
				out.printf("Case #1: %s\n", String.valueOf(tmp));
			}
		}

		out.close();
	}

	static class Activity {
		int id;
		int start;
		int end;
		char ans;

		public Activity(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}

	}

	static class InputReader {
		BufferedReader br;
		StringTokenizer st;

		public InputReader(File f) {
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		public InputReader(InputStream in) {
			br = new BufferedReader(new InputStreamReader(in));
		}

		public String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		public boolean hasNext() {
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}