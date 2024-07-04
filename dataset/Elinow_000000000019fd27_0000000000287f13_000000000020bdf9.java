import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int T = in.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = in.nextInt();
			List<Job> jobs = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				Job job = new Job(i, in.nextInt(), in.nextInt());
				jobs.add(job);
			}
			int[] res = solve(jobs);
			String resStr;
			if (res == null) {
				resStr = "IMPOSSIBLE";
			} else {
				StringBuilder sb = new StringBuilder(res.length);
				for (int i = 0; i < res.length; i++) {
					if (i == 1) {
						sb.append('C');
					} else {
						sb.append('J');
					}
				}
				resStr = sb.toString();
			}
			System.out.println(String.format("Case #%d: %s", t, resStr));
		}
	}

	private static int[] solve(List<Job> jobs) {
		int n = jobs.size();
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			if (res[i] == 0) {
				res[i] = 1;
			}
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (jobs.get(j).intersects(jobs.get(i))) {
					if (res[j] == 0) {
						res[j] = 3 - res[i];
					} else if (res[i] == res[j]) {
						return null;
					}
				}
			}
		}
		return res;
	}

	private static class Job {

		private final int id;
		private final int start;
		private final int end;

		public Job(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}

		public boolean intersects(Job job) {
			return !(job.start >= end || job.end <= start);
		}

		@Override
		public String toString() {
			return "Job [id=" + id + ", start=" + start + ", end=" + end + "]";
		}

	}

	public static class InputReader {

		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
