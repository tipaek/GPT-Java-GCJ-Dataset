import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = input.nextInt();
		for (int t = 1;t<=T;t++) {
			int N = input.nextInt();

			List<Task>[] tasks = new List[1441];
			List<Task> resultTasks = new ArrayList<>();

			for (int n=0;n<N;n++) {
				int s = input.nextInt();
				int e = input.nextInt();

				Task task = new Task(s,e);

				if (tasks[s] == null) {
					tasks[s] = new ArrayList<Task>();
				}
				tasks[s].add(task);
				resultTasks.add(task);
			}

			Solver s = new Solver(tasks, resultTasks);
			String ret = s.solve();

			System.out.println("Case #" + t + ": " + ret);
		}

		input.close();
	}

}

class Task {
	int start;
	int end;
	String assigned;

	public Task (int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public void setAssigned(String s) {
		this.assigned = s;
	}

	public String getAssigned() {
		return assigned;
	}
}

class Solver {
	List<Task>[] tasks;
	List<Task> resultTasks;

	public Solver(List<Task>[] tasks, List<Task> resultTasks){
		this.tasks = tasks;
		this.resultTasks = resultTasks;
	}

	public String solve(){
		int C = -1;
		int J = -1;

		for (int i=0;i<1441;i++) {
			if (C == i) {
				C = -1;
			}
			if (J == i) {
				J = -1;
			}

			if (tasks[i] != null) {
				List<Task> taskList = tasks[i];

				if (taskList.size() >= 3) {
					return "IMPOSSIBLE";
				}

				for (int j=0;j<taskList.size();j++) {
					Task task = taskList.get(j);

					if (C == -1) {
						C = task.getEnd();
						task.setAssigned("C");
					} else if (J == -1) {
						J = task.getEnd();
						task.setAssigned("J");
					} else {
						return "IMPOSSIBLE";
					}
				}
			}
		}

		String ret = "";

		for (Task task : resultTasks) {
			ret += task.getAssigned();
		}

		return ret;
	}
}