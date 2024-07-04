
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Schedule> list;
	static int cmd;
	static StringBuffer cur;

	public static void select(boolean[] select, int index) {
		if (index == cmd) {
			int cend = 0;
			int jend = 0;

			boolean result = true;
			for (int i = 0; i < cmd; i++) {
				if (select[i]) {
					if (cend <= list.get(i).start) {
						cend = list.get(i).end;
					} else {
						result = false;
						break;
					}
				} else {
					if (jend <= list.get(i).start) {
						jend = list.get(i).end;
					} else {
						result = false;
						break;
					}
				}
			}
			if (result) {
				char[] cd = new char[cmd];

				for (int i = 0; i < cmd; i++) {
					if (select[i]) {
						cd[list.get(i).index] = 'C';
					} else {
						cd[list.get(i).index] = 'J';
					}
				}

				cur = new StringBuffer();

				for (int i = 0; i < cmd; i++)
					cur.append(cd[i]);

			}
		} else {
			select[index] = true;
			select(select, index + 1);
			select[index] = false;
			select(select, index + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();

		int tc = Integer.parseInt(bf.readLine());

		for (int test_Case = 1; test_Case <= tc; test_Case++) {
			cur = new StringBuffer("IMPOSSIBLE");
			cmd = Integer.parseInt(bf.readLine());
			list = new ArrayList<Schedule>();
			boolean result = true;
			for (int i = 0; i < cmd; i++) {
				st = new StringTokenizer(bf.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				list.add(new Schedule(i, start, end));
			}

			Collections.sort(list);

			select(new boolean[cmd], 0);

			sb.append("Case #");
			sb.append(test_Case);
			sb.append(": ");
			sb.append(cur);
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
