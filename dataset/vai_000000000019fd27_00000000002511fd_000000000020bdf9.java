import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Range {

	private int startTime;
	private int endTime;

	Range(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return getStartTime() + "-" + getEndTime();
	}

	@Override
	public boolean equals(Object obj) {
		Range range = (Range) obj;
		return (this.getStartTime() == range.getStartTime() && this.getEndTime() == range.getEndTime());
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}

public class Solution {

	public static void main(String[] args) throws Exception {
	
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int total = in.nextInt();
		for (int counter = 1; counter <= total; counter++) {

			int n = in.nextInt();
			List<Range> tasks = new ArrayList<Range>();
			for (int i = 0; i < n; i++) {
				String row = in.next() + in.nextLine();
				String[] task = row.split(" ");
				tasks.add(new Range(Integer.parseInt(task[0]), Integer.parseInt(task[1])));
			}

			// List ordered by task start-time
			List<Range> sortedTasks = new ArrayList<Range>(tasks);
			sortedTasks.sort(new Comparator<Range>() {
				@Override
				public int compare(Range r1, Range r2) {
					return (r1.getStartTime() - r2.getStartTime());
				}
			});

			// Users
			Range c = new Range(-1, 0);
			Range j = new Range(-1, 0);
			Map<Range, String> taskAllocation = new HashMap<Range, String>();

			// Start allocating tasks in order
			for (Range task : sortedTasks) {
				if (c.getEndTime() <= task.getStartTime()) {
					c = task;
					taskAllocation.put(task, "C");
				} else if (j.getEndTime() <= task.getStartTime()) {
					j = task;
					taskAllocation.put(task, "J");
				} else {
					// System.out.println(counter + ": IMPOSSIBLE");
					taskAllocation.clear();
					break;
				}
			}

			// Output
			StringBuffer output = new StringBuffer();
			if (taskAllocation.size() < 1) {
				output.append("IMPOSSIBLE");
			} else {
				for (Range range : tasks) {
					output.append(taskAllocation.get(range));
				}
			}
			System.out.println("Case #" + counter + ": " + output);

		}
		in.close();
	}

}
