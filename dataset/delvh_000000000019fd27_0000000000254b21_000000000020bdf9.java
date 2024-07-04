import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	Scanner in = new Scanner(System.in);

	private void solve() throws Exception {
		int	endtimePartnerA	= 0;
		int	endtimePartnerB	= 0;
		int	numberOfTasks	= in.nextInt();
		// auto-succeed if only two tasks are assigned
		if (numberOfTasks == 2) {
			System.out.print("CJ");
			return;
		}
		// initialization of task times
		int[][] tasks = new int[numberOfTasks][4];
		for (int i = 0; i < numberOfTasks; i++) {
			tasks[i][0]	= in.nextInt();
			tasks[i][1]	= in.nextInt();
			tasks[i][2]	= i;
		}
		Arrays.parallelSort(tasks, (int1, int2) -> Integer.compare(int1[0], int2[0]));
		for (int[] task : tasks)
			if (endtimePartnerA <= task[0]) {
				endtimePartnerA	= task[1];
				task[3]			= 'C';
			} else if (endtimePartnerB <= task[0]) {
				endtimePartnerB	= task[1];
				task[3]			= 'J';
			} else if (endtimePartnerA > task[0] && endtimePartnerB > task[0]) {
				System.out.print("IMPOSSIBLE\n");
				return;
			}
		Arrays.parallelSort(tasks, (int1, int2) -> Integer.compare(int1[2], int2[2]));
		for (int[] task : tasks)
			System.out.print((char) task[3]);
		System.out.print("\n");
	}

	private void run() throws Exception {
		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			out.printf("Case #%d: ", i);
			solve();
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
