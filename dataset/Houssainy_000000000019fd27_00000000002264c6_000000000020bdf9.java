
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static class Point {
		int v;
		int taskInex;

		public Point(int v, int taskInex) {
			this.v = v;
			this.taskInex = taskInex;
		}
	}

	static class StartPoint extends Point {

		public StartPoint(int v, int taskInex) {
			super(v, taskInex);
		}
	}

	static class EndPoint extends Point {

		public EndPoint(int v, int taskInex) {
			super(v, taskInex);
		}
	}

	static void solve(Point[] points, int caseNum) {
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.v == o2.v)
					return 0;
				
				return o1.v > o2.v ? 1 : -1;
			}
		});

		int numTask = points.length / 2;
		char[] taskSchedule = new char[numTask];
		
		Queue<Character> availableQ = new LinkedList<Character>();
		availableQ.add(new Character('C'));
		availableQ.add(new Character('J'));

		boolean isPossible = true;

		char person;
		for (int i = 0; i < points.length && isPossible; i++) {
			if (points[i] instanceof StartPoint) {
				// Start point
				
				if (availableQ.isEmpty()) {
					isPossible = false;
					break;
				} else {
					person = availableQ.poll();
					
					taskSchedule[points[i].taskInex] = person;
				}
			} else {
				// End point
				person = taskSchedule[points[i].taskInex];
				availableQ.add(person);
			}
		}
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < taskSchedule.length && isPossible; i++) {
			res.append(taskSchedule[i]);
		}
		
		System.out.println("Case #" + caseNum + ": " + (isPossible ? res.toString() : "IMPOSSIBLE"));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		int taskIndex;
		Point[] points;
		for (int i = 1; i <= t; i++) {
			points = new Point[in.nextInt() * 2];
			taskIndex = 0;

			for (int j = 0; j < points.length; j += 2) {
				points[j] = new StartPoint(in.nextInt(), taskIndex);
				points[j + 1] = new EndPoint(in.nextInt(), taskIndex++);
			}

			solve(points, i);
		}

		in.close();
	}
}