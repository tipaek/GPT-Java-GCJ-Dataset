import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int inputs = file.nextInt();
		for(int i = 1; i <= inputs; i++) {
			int n = file.nextInt();
			Task[] tasks = new Task[n];
			for(int j = 0; j < n; j++) {
				tasks[j] = new Task(file.nextInt(), file.nextInt(), j);
			}
			Arrays.sort(tasks);
			int c, j;
			c = j = 0;
			char[] assigned = new char[n];
			boolean pos = true;
			for(Task t : tasks) {
				if(t.start >= c) {
					c = t.end;
					assigned[t.id] = 'C'; 
				}
				else if(t.start >= j) {
					j = t.end;
					assigned[t.id] = 'J'; 
				}
				else {
					pos = false;
					break;
				}
			}
			if(pos) {
				StringBuilder ans = new StringBuilder();
				for(char a : assigned) {
					ans.append(a);
				}
				System.out.println("Case #" + i + ": " + ans);
			}
			else {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}
		file.close();
	}

}

class Task implements Comparable<Task> {
	int start, end, id;
	public Task(int s, int e, int i) {
		start = s;
		end = e;
		id = i;
	}
	public int compareTo(Task t) {
		if(start == t.start) 
			return end - t.end;
		return start - t.start;
	}
	public String toString() {
		return start + " " + end;
	}
}
