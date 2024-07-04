
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		
		int cases = in.nextInt();
		for ( int i = 1; i <= cases; i++ ) {
			processCase(i, in);
		}
	}
	
	static void processCase(int caseNo, Scanner in) throws Exception {
		int taskC = in.nextInt();
		Task[] tasks = new Task[taskC];
		for ( int i = 0; i < taskC; i++ ) {
			int start = in.nextInt();
			int end = in.nextInt();
			tasks[i] = new Task(i, start, end);
		}

		SortedSet<Task> set = new TreeSet<>();
		for ( int i = 0; i < taskC; i++ )
			set.add(tasks[i]);

		Task[] sortedTasks = new Task[taskC];
		int idx = 0;
		for ( Task t : set ) {
			sortedTasks[idx++] = t;
		}

		Stack<Task> cam = new Stack<>();
		Stack<Task> jul = new Stack<>();
		if ( assign(sortedTasks, 0, cam, jul) ) {
			System.out.printf("Case #%s: ", caseNo);
			for ( int i = 0; i < tasks.length; i++ )
				System.out.print(tasks[i].assignee);
			System.out.println();
		} else {
			System.out.printf("Case #%s: IMPOSSIBLE\n", caseNo);
		}
	}
	
	static boolean assign(Task[] tasks, int index, Stack<Task> cam, Stack<Task> jul) {
		if ( index >= tasks.length ) return true;
		Task task = tasks[index];

		if ( true ) {
			Task camT = cam.size() > 0 ? cam.peek() : null;
			if ( (null == camT) || (! task.overlaps(camT)) ) {
				task.assignee = "C";
				cam.push(task);
				if ( assign(tasks, index+1, cam, jul) )
					return true;
				if ( cam.size() > 0 ) cam.pop();
			}
		}

		if ( true ) {
			Task julT = jul.size() > 0 ? jul.peek() : null;
			if ( (null == julT) || (! task.overlaps(julT)) ) {
				task.assignee = "J";
				jul.push(task);
				if ( assign(tasks, index+1, cam, jul) )
					return true;
				if ( jul.size() > 0 ) jul.pop();
			}
		}
		
		return false;
	}

	static class Task implements Comparable<Task> {
		Task(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
		
		boolean overlaps(Task t) {
			if ( t.start >= end )
				return false;
			if ( t.end <= start )
				return false;
			if ( start >= t.end )
				return false;
			if ( end <= t.start )
				return false;
			return true;
		}

		public int compareTo(Task t) {
			if ( start == t.start )
				return end - t.end;
			return start - t.start;
		}

		int id; int start; int end;
		String assignee;
	}
}
