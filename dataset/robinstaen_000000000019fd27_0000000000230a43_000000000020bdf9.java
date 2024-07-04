import java.util.*;
import java.io.*;


class Task{
	int start;
	int end;
	Task(int start, int end) {
		this.start = start;
		this.end = end;	
	}
}


class Solver {

	public String solve(List<Task> tasks) {
		List<Task> cameron = new ArrayList<>();
		List<Task> jamie = new ArrayList<>();
		StringBuilder sb = new StringBuilder(tasks.size());
		for(Task task : tasks) {
			if(isAvailableFor(cameron, task)){
				cameron.add(task);
				sb.append("C");
			}else if(isAvailableFor(jamie, task)) {
				jamie.add(task);
				sb.append("J");
			}else{
				return "IMPOSSIBLE";
			}
		}
		return sb.toString();
	}

	public boolean isAvailableFor(List<Task> tasks, Task newTask) {
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
				tasks.add(readTask());
			}
			String solution = solver.solve(tasks);
			pw.printf("Case #%d: %s\n", test, solution);
		}
		pw.close();
	}

	public static Task readTask() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		return new Task(start, end);
	}
}