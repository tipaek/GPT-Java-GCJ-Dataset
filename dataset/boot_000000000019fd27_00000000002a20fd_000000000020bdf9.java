
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
		int lastId = 1;
		
		for (int i = 0; i < n; i++) {
			tasks.add(new Task(lastId++, scanner.nextInt(), scanner.nextInt()));
		}
	}


	void solve() {
		Collections.sort(tasks);

		boolean impossible = false;
		List<Task> cameronTasks = new ArrayList<>();
		List<Task> jamieTasks = new ArrayList<>();
		
		String answer = "";
		for (Task task : tasks) {
			if (canAssignTo(task, cameronTasks)) {
				cameronTasks.add(task);
				task.assignee = "C";
				answer += "C";
				continue;
			}
			if (canAssignTo(task, jamieTasks)) {
				jamieTasks.add(task);
				task.assignee = "J";
				answer += "J";
				continue;
			}
			impossible = true;
			break;
		}
		if (impossible) {
			System.out.print(" IMPOSSIBLE");
		} else {
			System.out.print(" " + answer);
		}
	}

	private boolean canAssignTo(Task task, List<Task> taskList) {
		if (taskList.isEmpty()) {
			return true;
		}
		if (taskList.get(taskList.size() - 1).end <= task.start) {
			return true;
		}
		return false;
	}
}

class Task implements Comparable<Task> {
	int id, start, end;
	String assignee;

	Task(int id, int start, int end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Task o) {
		return end - o.end;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", start=" + start + ", end=" + end + ", assignee=" + assignee + "]\n";
	}
}
