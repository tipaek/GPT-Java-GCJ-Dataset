
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
		int lastId = 1;
		
		for (int i = 0; i < n; i++) {
			tasks.add(new Task(lastId++, scanner.nextInt(), scanner.nextInt()));
		}
	}

	List<Task> cameronTasks = new ArrayList<>();
	List<Task> jamieTasks = new ArrayList<>();

	void solve() {
		Collections.sort(tasks);

		cameronTasks = new ArrayList<>();
		jamieTasks = new ArrayList<>();
		
		boolean imp = false;
		
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			try {
				task.assign();
			} catch (IllegalStateException e) {
				task.unassign();
				i--;
			} catch (UnsupportedOperationException e) {
				System.out.print(" IMPOSSIBLE");
				imp = true;
				break;
			}
			if (i < 0) {
				System.out.print(" IMPOSSIBLE");
				imp = true;
				break;
			}
		}
		
		if (!imp) {
			List<String> collect = tasks.stream().sorted((Task o1, Task o2) -> o1.id - o2.id).map(t -> t.assignee).collect(Collectors.toList());
			System.out.print(" " + String.join("", collect));
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
	
	class Task implements Comparable<Task> {
		int id, start, end;
		String assignee;
		int tries = 0;
	
		Task(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
		
		public void assign() {
			tries++;
			if (tries > 1000) throw new UnsupportedOperationException();
			if (assignee == null && canAssignTo(this, cameronTasks)) {
				assignee = "C";
				cameronTasks.add(this);
				return;
			}
			if (assignee == "C" || canAssignTo(this, jamieTasks)) {
				assignee = "J";
				jamieTasks.add(this);
				return;
			}
			throw new IllegalStateException();
		}
		
		public void unassign() {
			assignee = null;
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
}

