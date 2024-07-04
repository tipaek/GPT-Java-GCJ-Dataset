import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			List<Task> cameron = new ArrayList<>();
			List<Task> jamie = new ArrayList<>();
			char[] result = new char[n];
			boolean impossible = false;
			for (int j = 0; j < n; j++) {
				Task task = new Task(sc.nextInt(), sc.nextInt());
				int count = (int) cameron.stream().filter(ct -> Task.overlap(ct, task)).count();
				if (count == 0) {
					cameron.add(task);
					result[j] = 'C';
				} else {
					count = (int) jamie.stream().filter(ct -> Task.overlap(ct, task)).count();
					if (count == 0) {
						jamie.add(task);
						result[j] = 'J';
					} else {
						impossible = true;
						break;
					}
				}
			}
			System.out.println(String.format("Case #%d: %s", i, impossible ? "IMPOSSIBLE" : String.valueOf(result)));
		}
	}

	private static class Task {

		private final int s;
		private final int e;

		private Task(int s, int e) {
			this.s = s;
			this.e = e;
		}

		public static boolean overlap(Task t1, Task t2) {
			return (t2.s < t1.e && t2.e > t1.s);
		}
	}
}