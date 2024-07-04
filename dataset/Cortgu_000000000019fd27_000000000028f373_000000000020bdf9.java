import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static int N;
	private static boolean[][] overlapGraph;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numberOfCases = in.nextInt(); // Number of cases
			for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
				N = in.nextInt();
				Task[] tasks = new Task[N];
				overlapGraph = new boolean[N][N];
				for (int i = 0; i < N; i++) {
					final int S = in.nextInt();
					final int E = in.nextInt();
					Task task = new Task(i, S, E);
					tasks[i] = task;
					for (int j = 0; j < i; j++) {
						if (tasks[j].overlaps(task)) {
							overlapGraph[i][j] = true;
							overlapGraph[j][i] = true;
						}
					}
				}

				// Solve Case
				
				// Check if impossible (any cycle of length 3 in overlap graph)
				String result;
				if (anyCycleOfLen3()) {
					result = "IMPOSSIBLE";
				} else {
					final List<Task> taskList = Arrays.asList(tasks);
					Collections.sort(taskList);
					
					Parent[] assignments = new Parent[N];
					Parent currentParent = Parent.C;
					Task previousTask = null;
					for (int i = 0; i < taskList.size(); i++) {
						final Task task = taskList.get(i);
						if (previousTask == null) {
							assignments[task.id] = currentParent;
						} else {
							if (overlapGraph[previousTask.id][task.id]) {
								if (currentParent == Parent.C) {
									assignments[task.id] = Parent.J;
									currentParent = Parent.J;
								} else {
									assignments[task.id] = Parent.C;
									currentParent = Parent.C;
								}
							} else {
								assignments[task.id] = currentParent;
							}
						}
						previousTask = task;
					}
					StringBuilder builder = new StringBuilder();
					for (int i = 0; i < assignments.length; i++) {
						builder.append(assignments[i]);
					}
					result = builder.toString();
				}
				System.out.println("Case #" + caseNo + ": " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
 
	private static boolean any3Cycle;
	private static boolean anyCycleOfLen3() {
		any3Cycle = false;
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N - 2; i++) {
			anyCycleOfLen3(visited, 2, i, i);
			visited[i] = true;
			if (any3Cycle) {
				break;
			}
		}
		return any3Cycle;
	}
	
	private static void anyCycleOfLen3(boolean[] visited, int length, int task, int initial) {
		visited[task] = true;
		
		if (length == 0) {
			visited[task] = false;
			if (overlapGraph[task][initial]) {
				any3Cycle = true;
				return;
			} else {
				return;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i] && overlapGraph[task][i]) {
				anyCycleOfLen3(visited, length - 1, i, initial);
				if (any3Cycle) {
					break;
				}
			}
		}
		visited[task] = false;
	}

	private enum Parent {
		J, C;
	}
	
	private static class Task implements Comparable<Task> {
		private int id;
		private int start;
		private int end;
		public Task(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
		
		public boolean overlaps(Task other) {
			return other.start <= this.start && other.end > this.start ||
					other.start < this.end && other.end >= this.end ||
					other.start >= this.start && other.end <= this.end ||
					other.start <= this.start && other.end >= this.end;
		}

		@Override
		public String toString() {
			return "Task [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Task o) {
			if (this.start < o.start) {
				return -1;
			} else if (this.start == o.start) {
				return 0;
			} else {
				return 1;
			}
		}
	}
}
