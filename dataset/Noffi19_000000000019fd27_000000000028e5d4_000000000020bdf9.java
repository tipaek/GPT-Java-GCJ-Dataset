import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
	public class Task implements Comparator<Object> {
		Integer index;
		Integer start;
		Integer end;
		String person;

		public Task(int index, int start, int end) {
			this.index = index;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compare(Object arg0, Object arg1) {
			return 0;
		}

		public Comparator<Task> compareByEnd = new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				return t1.end.compareTo(t2.end);
			}
		};

		public Comparator<Task> compareByIndex = new Comparator<Task>() {
			@Override
			public int compare(Task t1, Task t2) {
				return t1.index.compareTo(t2.index);
			}
		};
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		OutputStream outputStream = System.out;
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		OutputStreamWriter w = new OutputStreamWriter(outputStream, "UTF-8");
		int testCount = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= testCount; i++) {
			solve(i, reader, w);
		}
		w.close();
	}

	public static void solve(int i, BufferedReader reader,
			OutputStreamWriter writer) throws NumberFormatException,
			IOException {
		int n = Integer.parseInt(reader.readLine());

		ArrayList<Task> tasks = new ArrayList<Task>();
		Solution s = new Solution();
		for (int j = 0; j < n; j++) {
			String line = reader.readLine();
			String[] startEnd = line.trim().split(" ");
			int start = Integer.parseInt(startEnd[0]);
			int end = Integer.parseInt(startEnd[1]);
			tasks.add(s.new Task(j, start, end));
		}

		Collections.sort(tasks, s.new Task(0, 0, 0).compareByEnd);

		boolean[] cOccupied = new boolean[1440];
		boolean[] jOccupied = new boolean[1440];
		String ret = "";
		for (int j = 0; j < n; j++) {
			boolean cCanDo = true;
			boolean jCanDo = true;
			Task t = tasks.get(j);
			int start = t.start;
			int end = t.end;

			for (int k = start; k < end; k++) {
				if (cOccupied[k]) {
					cCanDo = false;
					break;
				}
			}
			for (int k = start; k < end; k++) {
				if (jOccupied[k]) {
					jCanDo = false;
					break;
				}
			}

			if (jCanDo && cCanDo) { // find min idle time
				for (int idx = start - 1; idx >= 0; idx--) {
					if (jOccupied[idx] != cOccupied[idx]) {
						if (jOccupied[idx]) {
							cCanDo = false;
						} else {
							jCanDo = false;
						}
						break;
					}
				}
			}

			if (cCanDo) {
				for (int k = start; k < end; k++) {
					cOccupied[k] = true;
				}
				t.person = "C";
				tasks.set(j, t);
			} else if (jCanDo) {
				for (int k = start; k < end; k++) {
					jOccupied[k] = true;
				}
				t.person = "J";
				tasks.set(j, t);
			} else {
				ret = "IMPOSSIBLE";
				break;
			}
		}

		if (!ret.equals("IMPOSSIBLE")) {
			Collections.sort(tasks, s.new Task(0, 0, 0).compareByIndex);
			for (int m = 0; m < tasks.size(); m++) {
				ret += tasks.get(m).person;
			}
		}
		writer.write("Case #" + i + ": " + ret + "\r\n");
	}
}