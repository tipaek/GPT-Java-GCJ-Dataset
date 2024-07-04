import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
					Task task = new Task(S, E);
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
				String result = "";
				if (anyCycleOfLen3()) {
					result = "IMPOSSIBLE";
				} else {
					Map<Parent, Set<Integer>> tasksByParent = new HashMap<>();
					tasksByParent.put(Parent.C, new HashSet<>());
					tasksByParent.put(Parent.J, new HashSet<>());
					
					Parent currentParent = Parent.C;
					tasksByParent.get(currentParent).add(0);
					result += currentParent;
					for (int i = 1; i < N; i++) {
						boolean overlapsAnyOfCurrentParent = false;
						for (int task : tasksByParent.get(currentParent)) {
							if (overlapGraph[i][task]) {
								overlapsAnyOfCurrentParent = true;
								break;
							}
						}
						if (overlapsAnyOfCurrentParent) {
							if (currentParent == Parent.C) {
								tasksByParent.get(Parent.J).add(i);
								currentParent = Parent.J;
							} else {
								tasksByParent.get(Parent.C).add(i);
								currentParent = Parent.C;
							}
						} else {
							tasksByParent.get(currentParent).add(i);
						}
						result += currentParent;
					}
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
	
	private static class Task {
		private int start;
		private int end;
		public Task(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public boolean overlaps(Task other) {
			return other.start <= this.start && other.end > this.start ||
					other.start < this.end && other.end >= this.end ||
					other.start >= this.start && other.end <= this.end ||
					other.start <= this.start && other.end >= this.end;
		}
	}
}