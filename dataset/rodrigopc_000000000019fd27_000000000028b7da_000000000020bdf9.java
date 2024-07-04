import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static final Scanner sc = new Scanner(System.in);

	enum Parent{
		J, C
	}
	
	static class Task {
		public int id;
		public int start;
		public int end;
		public Parent parent;

		public Task(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
			this.parent = null;
		}
	}

	public static void main(String[] args) {
		int ncases = sc.nextInt();
		for (int ncase = 1; ncase <= ncases; ncase++) {
			int ntasks = sc.nextInt();
			List<Task> tasks = new ArrayList<>();
			for (int ntask = 0; ntask < ntasks; ntask++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				tasks.add(new Task(ntask, start, end));
			}
			tasks.sort((i, j) -> (i.start != j.start)? i.start - j.start: i.end - j.end);
			int lastC = -1;
			int lastJ = -1;
			boolean impossible = false;
			for (Task task: tasks) {
				if (task.start >= lastC) {
					task.parent = Parent.C;
					lastC = task.end;
				} else if (task.start >= lastJ) {
					task.parent = Parent.J;
					lastJ = task.end;
				} else {
					impossible = true;
					break;
				}
			}
			if (impossible) {
				System.out.println(String.format("Case #%d: IMPOSSIBLE", ncase));
			} else {
				tasks.sort((i, j) -> i.id - j.id);
				StringBuilder sb = new StringBuilder();
				for (Task task: tasks) sb.append(task.parent.toString());
 				System.out.println(String.format("Case #%d: %s", ncase, sb.toString()));
			}
		}
	}
}
