import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int T = Integer.parseInt(sc.nextLine());

			for (int t = 1; t <= T; t++) {
				List<Task> tasks = new ArrayList<>();
				int N = Integer.parseInt(sc.nextLine());
				for (int n = 0; n < N; n++) {
					String[] pom = sc.nextLine().split(" ");
					tasks.add(new Task(Integer.parseInt(pom[0]), Integer.parseInt(pom[1]), n));
				}

		        tasks.sort((o1, o2) -> o1.from - o2.from);

				System.out.println("Case #" + t + ": " + solve(tasks));
			}
		}
	}

	private static String solve(List<Task> tasks) {
		String solution = "";
		Person cameron = new Person("Cameron");
		Person james = new Person("James");
		for (Task task : tasks) {
			if (cameron.isAvailable(task)) {
				cameron.tasks.add(task);
//				solution += "C";
			} else if (james.isAvailable(task)) {
				james.tasks.add(task);
//				solution += "J";
			} else {
//				solution = "IMPOSSIBLE";
				return "IMPOSSIBLE";
			}
		}
        tasks.sort((o1, o2) -> o1.id - o2.id);
		for (Task task : tasks) {
			if (cameron.containsTast(task)) {
				solution += "C";
			} else {
				solution += "J";				
			}
		}
		return solution;
	}

	public static class Task {
		private int from;
		private int to;
		private int id;

		public Task(int from, int to, int id) {
			this.from = from;
			this.to = to;
			this.id = id;
		}		
	}

	public static class Person {
		private String name;
		private List<Task> tasks = new ArrayList<>();

		public Person(String name) {
			this.name = name;
		}

		public boolean isAvailable(Task newTask) {
			for (Task task : tasks) {
				if (newTask.from >= task.from && newTask.from < task.to) {
					return false;
				}
				if (newTask.to >= task.from && newTask.to < task.to) {
					return false;
				}
			}
			return true;
		}
		
		public boolean containsTast(Task t) {
			return tasks.contains(t);
		}
	}
}
