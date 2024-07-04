
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int tc = Integer.parseInt(bf.readLine());

		StringBuffer imp = new StringBuffer("IMPOSSIBLE");
		for (int test_Case = 1; test_Case <= tc; test_Case++) {
			StringBuffer cur = new StringBuffer();
			int cmd = Integer.parseInt(bf.readLine());
			List<Schedule> list = new ArrayList<Schedule>();
			boolean result = true;
			for (int i = 0; i < cmd; i++) {
				st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list.add(new Schedule(i, start, end));
			}

			Collections.sort(list);

			boolean[] c = new boolean[cmd];
			int endtime = 0;

			for (int i = 0; i < list.size(); i++) {
				if (endtime <= list.get(i).start) {
					c[list.get(i).index] = true;
					endtime = list.get(i).end;
				}
			}
			endtime = 0;
			for (int i = 0; i < list.size(); i++) {
				if (c[list.get(i).index])
					continue;

				if (endtime <= list.get(i).start) {
					endtime = list.get(i).end;
				} else {
					result = false;
				}
			}

			sb.append("Case #");
			sb.append(test_Case);
			sb.append(": ");

			if (result) {
				for (int i = 0; i < cmd; i++) {
					if (c[i])
						cur.append('C');
					else
						cur.append('J');
				}

				sb.append(cur);
			} else {
				sb.append(imp);
			}

			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	public static class Schedule implements Comparable<Schedule> {
		int index, start, end;

		public Schedule(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Schedule o) {
			if (o.end == this.end)
				return this.start - o.start;
			return this.end - o.end;
		}

		@Override
		public String toString() {
			return "Schedule [index=" + index + ", start=" + start + ", end=" + end + "]";
		}

	}
}
