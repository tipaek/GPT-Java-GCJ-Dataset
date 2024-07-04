import java.util.*;
import java.io.*;


class Task{
	int start;
	int end;
	int idx;
	String assignee;

	Task(int start, int end, int idx) {
		this.start = start;
		this.end = end;	
		this.idx = idx;
	}
}


class Solver {

	public String solve(List<Task> tasks) {
		Collections.sort(tasks, (one, two) -> one.end - two.end);
		List<Task> cameron = new ArrayList<>();
		List<Task> jamie = new ArrayList<>();
		for(Task task : tasks) {
			if(isAvailable(cameron, task)) {
				task.assignee = "C";
				cameron.add(task);
			}else if(isAvailable(jamie, task)) {
				task.assignee = "J";
				jamie.add(task);
			}else{
				return "IMPOSSIBLE";
			}		
		}
		Collections.sort(tasks, (one, two) -> one.idx - two.idx);
		StringBuilder sb = new StringBuilder(tasks.size());
		for(Task task : tasks)
			sb.append(task.assignee);
		return sb.toString();
	}

	public boolean isAvailable(List<Task> tasks, Task newTask) {
		for(Task oldTask : tasks) {
			if(!(newTask.start >= oldTask.end || newTask.end <= oldTask.start)){
				return false;
			}
		}
		return true;
	}

}


public class Solution {
	static BufferedReader br;
	static PrintWriter pw;

	public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(System.out);
		int tests = Integer.parseInt(br.readLine());
		Solver solver = new Solver();
		for(int test = 1; test <= tests; ++test) {
			int numTasks = 	Integer.parseInt(br.readLine());
			List<Task> tasks = new ArrayList<>();
			for(int task = 0; task < numTasks; ++task){
				tasks.add(readTask(task));
			}
			String solution = solver.solve(tasks);
			pw.printf("Case #%d: %s\n", test, solution);
		}
		pw.close();
	}

	public static Task readTask(int idx) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		return new Task(start, end, idx);
	}
}