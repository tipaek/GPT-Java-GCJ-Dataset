import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	static class Job implements Comparable<Job>{
		int start;
		int end;
		int index;

		public Job(int start, int end, int index) {
			this.start = start;
			this.end = end;
			this.index = index;
		}

		public int compareTo(Job o) {
			return start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		int caseNumber = Integer.parseInt(reader.readLine());
		int caseIterater = 0;
		while (caseNumber != caseIterater++) {
			StringBuilder builder = new StringBuilder();
			PriorityQueue<Job> pq = new PriorityQueue<Job>();
			int n = Integer.parseInt(reader.readLine());
			int jamie = 0, cameron = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				pq.add(new Job(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()), i));
			}

			boolean[] task = new boolean[n];
			boolean impossible = false;
			while (!pq.isEmpty()) {
				Job cur = pq.poll();
				if (cameron <= cur.start) {
					cameron = cur.end;
					task[cur.index] = true;
				} else if (jamie <= cur.start) {
					jamie = cur.end;
				} else {
					impossible = true;
				}
			}

			for (int i = 0; i < n; i++) {
				if (task[i])builder.append("C");
				else builder.append("J");
			}

			if (impossible) System.out.println(String.format("Case #%d: %s",caseIterater, "IMPOSSIBLE"));
			else System.out.println(String.format("Case #%d: %s",caseIterater, builder.toString()));
		}
	}
}
