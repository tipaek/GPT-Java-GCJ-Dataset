import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Task {
	private int start;
	private int end;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Task(int s, int e) {
		this.start = s;
		this.end = e;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Task)) {
			return false;
		}
		Task task = (Task) o;
		return start == task.start && end == task.end;
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
//		Scanner infile = new Scanner(new File("inputParenting"));
		Scanner infile = new Scanner(System.in);
		int T = infile.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int numberOfInput = infile.nextInt();
			List<Task> inputList = new LinkedList<Task>();
			for (int i = 0; i < numberOfInput; i++) {
				int start = infile.nextInt();
				int end = infile.nextInt();
				inputList.add(new Task(start, end));
			}
			List<Task> sortedList = inputList.stream()
			                                 .collect(Collectors.toCollection(LinkedList::new));

			Collections.sort(sortedList, (a, b) -> Integer.compare(a.getStart(), b.getStart()));
			int cEnd = 0;
			int jEnd = 0;
			boolean isImpossible = false;
			Set<Task> duplicateTask = new HashSet<Task>();
			Map<Task, Character> taskAssignmentMap = new HashMap<Task, Character>();
			for (Task task : sortedList) {
				char assignee;
				if (task.getStart() < cEnd && task.getStart() < jEnd) {
					isImpossible = true;
					break;
				}
				if (task.getStart() >= cEnd) {
					assignee = 'C';
				} else {
					assignee = 'J';
				}
				if (taskAssignmentMap.containsKey(task)) {
					if (duplicateTask.contains(task)) {
						isImpossible = true;
						break;
					} else {
						duplicateTask.add(task);
					}
				} else {
					taskAssignmentMap.put(task, assignee);
					if (assignee == 'C') {
						cEnd = task.getEnd();
					} else {
						jEnd = task.getEnd();
					}

				}
			}
			if (isImpossible) {
				System.out.println("Case #" + (tc + 1) + ": " + "IMPOSSIBLE");
				isImpossible = false;
			} else {
				StringBuilder outputStrB = new StringBuilder();
				for (Task task : inputList) {
					Character character = taskAssignmentMap.get(task);
					outputStrB.append(character);
				}
				if(tc+1==T)
				    {
				        System.out.print("Case #" + (tc + 1) + ": " + outputStrB.toString());
				        
				    }
				else{
				System.out.println("Case #" + (tc + 1) + ": " + outputStrB.toString());
				    
				}
			}
		}

	}
}
