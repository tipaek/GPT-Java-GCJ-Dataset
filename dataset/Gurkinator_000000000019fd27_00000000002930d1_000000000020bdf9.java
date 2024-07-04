import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	private Scanner scanner = new Scanner(System.in);

	int[][]	tasksJ	= new int[0][0];
	int[][]	tasksC	= new int[0][0];

	private String solve() throws Exception {
		tasksJ	= new int[0][0];
		tasksC	= new int[0][0];
		int		n		= scanner.nextInt();
		int[][]	tasks	= new int[n][2];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i][0]	= scanner.nextInt();
			tasks[i][1]	= scanner.nextInt();
		}

		int[] path = new int[n];
		for (int i = 0; i < path.length; i++) {
			path[i] = i;
		}

		boolean done = false;
		while (!done) {
			done = true;
			for (int i = 0; i < tasks.length - 1; i++) {
				int	a	= tasks[i][0];
				int	a_	= tasks[i][1];
				int	b	= tasks[i + 1][0];
				int	b_	= tasks[i + 1][1];
				if (a > b) {
					done			= false;
					tasks[i][0]		= b;
					tasks[i][1]		= b_;
					tasks[i + 1][0]	= a;
					tasks[i + 1][1]	= a_;

					int tempIndex = path[i];
					path[i]		= path[i + 1];
					path[i + 1]	= tempIndex;
				}
			}
		}

		boolean		current	= false;
		String[]	string	= new String[n];
		string[path[0]] = assign(current, tasks[0][0], tasks[0][1]);
		for (int i = 1; i < tasks.length; i++) {
			int	jL	= tasksJ.length;
			int	jC	= tasksC.length;

			boolean	roundfinalPerson	= false;
			int		x					= -1;
			int		y					= -1;

			if (current) {
				if (jL == 0) {
					string[path[i]] = assign(current, tasks[i][0], tasks[i][1]);
					current			= !current;
					break;
				}
				for (int j = 0; j < jL; j++) {
					if ((tasksJ[j][1] > tasks[i][0])) {

						current = !current;
						if (jC == 0) {
							string[path[i]] = assign(current, tasks[i][0], tasks[i][1]);
							current			= !current;
							break;
						}
						for (int c = 0; c < jC; c++) {
							if ((tasksC[c][1] > tasks[i][0])) {
								x	= -2;
								y	= -2;
							} else {
								roundfinalPerson	= current;
								x					= tasks[i][0];
								y					= tasks[i][1];
							}
						}

					} else {
						roundfinalPerson	= current;
						x					= tasks[i][0];
						y					= tasks[i][1];
					}
				}
			} else {
				if (jC == 0) {
					string[path[i]] = assign(current, tasks[i][0], tasks[i][1]);
					current			= !current;
					break;
				}
				for (int c = 0; c < jC; c++) {
					if ((tasksC[c][1] > tasks[i][0])) {

						current = !current;
						if (jL == 0) {
							string[path[i]] = assign(current, tasks[i][0], tasks[i][1]);
							current			= !current;
							break;
						}
						for (int j = 0; j < jL; j++) {
							if ((tasksJ[j][1] > tasks[i][0])) {
								x	= -2;
								y	= -2;
							} else {
								roundfinalPerson	= current;
								x					= tasks[i][0];
								y					= tasks[i][1];
							}
						}

					} else {
						roundfinalPerson	= current;
						x					= tasks[i][0];
						y					= tasks[i][1];
					}
				}
			}
			if (x == -2 && y == -2) return "IMPOSSIBLE";

			if (x != -1 && y != -1) string[path[i]] = assign(roundfinalPerson, x, y);
		}

		StringBuilder finalString = new StringBuilder();
		for (int i = 0; i < string.length; i++) {
			finalString.append(string[i]);
		}
		return finalString.toString();
	}

	private String assign(boolean current, int begin, int end) throws Exception {
		String person = "";
		if (current) {
			person							= "J";
			tasksJ							= Arrays.copyOf(tasksJ, tasksJ.length + 1);
			tasksJ[tasksJ.length - 1]		= new int[2];
			tasksJ[tasksJ.length - 1][0]	= begin;
			tasksJ[tasksJ.length - 1][1]	= end;
		} else {
			person							= "C";
			tasksC							= Arrays.copyOf(tasksC, tasksC.length + 1);
			tasksC[tasksC.length - 1]		= new int[2];
			tasksC[tasksC.length - 1][0]	= begin;
			tasksC[tasksC.length - 1][1]	= end;
		}
		return person;
	}

	private void run() throws Exception {
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			System.out.printf("Case #%d: %s%n", i + 1, solve());
		}
	}

	public static void main(String[] args) throws Exception { new Solution().run(); }
}
