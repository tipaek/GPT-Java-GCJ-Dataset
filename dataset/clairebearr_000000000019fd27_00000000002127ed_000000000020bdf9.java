import java.io.*;
import java.util.*;

//solution
public class Solution {
	
	static class Task implements Comparable<Task> {
		int ind, time, value;
		public Task(int i, int t, int v) {
			ind = i; time = t; value = v;
		}
		public int compareTo(Task t) {
			if (time == t.time) return value - t.value;
			return time - t.time;
		}
		public String toString() {
			return ind + " " + time + " " + value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		outer: for (int test = 1; test <= t; test++) {
			int n = sc.nextInt();
			Task[] list = new Task[2*n];
			for (int i = 0; i < n; i++) {
				list[2*i] = new Task(i, sc.nextInt(), 1);
				list[2*i+1] = new Task(i, sc.nextInt(), -1);
			}
			Arrays.sort(list);
//			for (Task i : list) {
//				System.out.println(i);
//			}
			boolean c = false;
			boolean j = false;
			int[] ans = new int[n];
			Arrays.fill(ans, -1);
			for (int i = 0; i < 2 * n; i++) {
				if (list[i].value == 1) { //task start
					if (!c) {
						c = true; ans[list[i].ind] = 0;
					} else if (!j) {
						j = true; ans[list[i].ind] = 1;
					} else {
						System.out.println("Case #" + test + ": IMPOSSIBLE");
						continue outer;
					}
				} else {
					if (ans[list[i].ind] == 0) {
						c = false;
					} else {
						j = false;
					}
				}
			}
			System.out.print("Case #" + test + ": ");
			for (int i : ans) {
				if (i == 0) {
					System.out.print('C');
				} else {
					System.out.print('J');
				}
			}
			System.out.println();
		}
		//solution
	}

}
