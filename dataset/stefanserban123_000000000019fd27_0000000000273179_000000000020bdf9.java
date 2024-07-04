
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = sc.nextInt();

		for (int i = 1; i <= tests; i++) {
			int n = sc.nextInt();
			sc.nextLine(); // sometimes necesary after nextInt to go to next line
			String[] input = new String[n];

			for (int j = 0; j < n; j++) {
				input[j] = sc.nextLine();

			}
			
			System.out.println(solve(input, i));
		}

	}

	public static String solve(String[] input, int index) {
		Timeline timeline = new Timeline();

		for (int i = 0; i < input.length; i++) {
			String[] se = input[i].split(" ");
			timeline.addTask(new Interval(se[0], se[1], i));
		}

		return timeline.resolve(index);

	}
}

class Timeline {
	List<Interval> tasks = new ArrayList<>();

	public void addTask(Interval task) {
		tasks.add(task);
	}

	public String resolve(int index) {
		tasks.sort((a, b) -> a.start < b.start ? -1 : a.start == b.start ? 0 : 1);

		for (Interval task : tasks) {
			List<Interval> bA = tasks.stream().filter(e -> e.asignee == "C").collect(Collectors.toList());
			List<Interval> bB = tasks.stream().filter(e -> e.asignee == "J").collect(Collectors.toList());

			boolean interfA = false;
			boolean interfB = false;

			for (Interval a : bA) {
				if (interference(task, a)) {
					interfA = true;
				}
			}

			if (!interfA) {
				task.asignee = "C";
			} else {
				for (Interval b : bB) {
					if (interference(task, b)) {
						interfB = true;
					}
				}

				if (!interfB) {
					task.asignee = "J";
				} else {
					return "Case #" + index + ": IMPOSSIBLE";
				}
			}
		}

		tasks.sort((a, b) -> a.c < b.c ? -1 : a.c == b.c ? 0 : 1);
		String result = String.join("", tasks.stream().map(e -> e.asignee).collect(Collectors.toList()));

		return "Case #" + index + ": " + result;
	}

	public boolean interference(Interval task1, Interval task2) {
		// x1 <= y2 && y1 <= x2
		// max(x1,y1) <= min(x2,y2)
		// (y2 - x1) * (x2 - y1) >= 0
		return (task2.end - task1.start) * (task1.end - task2.start) > 0;
		// return Math.max(task.start, e.start) < Math.min(task.end, e.end);
	}

}

class Interval {
	Integer start;
	Integer end;
	String asignee;
	int c;

	public Interval(String start, String end, int c) {
		this.start = Integer.parseInt(start);
		this.end = Integer.parseInt(end);
		this.c = c;
	}
}
