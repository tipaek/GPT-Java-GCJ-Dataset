import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	private Scanner scanner;
	private List<Task> tasks;

	public Solution(Scanner scanner) {
		this.scanner = scanner;
	}

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			Solution solution = new Solution(scanner);

			int testCases = scanner.nextInt();

			for (int tc = 1; tc <= testCases; tc++) {
				solution.processInput();
				System.out.printf("Case #%d:", tc);
				solution.solve();
				System.out.println();
			}
		}
	}

	void processInput() {
		tasks = new ArrayList<>();
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			tasks.add(new Task(i + 1, scanner.nextInt(), scanner.nextInt()));
		}
	}

	void solve() {
		Collections.sort(tasks);
		List<Task> cameronTasks = new ArrayList<>();
		List<Task> jamieTasks = new ArrayList<>();
		boolean impossible = false;

		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			try {
				task.assign(cameronTasks, jamieTasks);
			} catch (IllegalStateException | UnsupportedOperationException e) {
				System.out.print(" IMPOSSIBLE");
				impossible = true;
				break;
			}
		}

		if (!impossible) {
			String result = tasks.stream()
					.sorted((o1, o2) -> Integer.compare(o1.id, o2.id))
					.map(t -> t.assignee)
					.collect(Collectors.joining());
			System.out.print(result);
		}
	}

	class Task implements Comparable<Task> {
		int id, start, end;
		String assignee;
		int tries = 0;

		Task(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}

		void assign(List<Task> cameronTasks, List<Task> jamieTasks) {
			tries++;
			if (tries > 30) throw new UnsupportedOperationException();
			if (assignee == null && canAssignTo(cameronTasks)) {
				assignee = "C";
				cameronTasks.add(this);
			} else if (assignee == null && canAssignTo(jamieTasks)) {
				assignee = "J";
				jamieTasks.add(this);
			} else {
				throw new IllegalStateException();
			}
		}

		boolean canAssignTo(List<Task> taskList) {
			return taskList.isEmpty() || taskList.get(taskList.size() - 1).end <= this.start;
		}

		@Override
		public int compareTo(Task other) {
			return Integer.compare(this.end, other.end);
		}

		@Override
		public String toString() {
			return String.format("Task [id=%d, start=%d, end=%d, assignee=%s]", id, start, end, assignee);
		}
	}
}