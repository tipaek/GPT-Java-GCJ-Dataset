import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		List<String> answers = new ArrayList<>();

		for (int count = 1; count <= t; count++) {

			String answer = "";

			int n = s.nextInt();

			int[] start = new int[n];
			int[] end = new int[n];
			char[] assigns = new char[n];

			for (int i = 0; i < n; i++) {
				start[i] = s.nextInt();
				end[i] = s.nextInt();
			}

			List<List<Integer>> lists = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int s1 = start[i];
				int e1 = end[i];
				List<Integer> clashing = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					if (i != j) {
						int s2 = start[j];
						int e2 = end[j];
						boolean condition1 = (s1 <= s2) && (e1 > s2);
						boolean condition2 = (s1 < e2) && (e1 >= e2);
						boolean condition3 = (s1 >= s2) && (e1 <= e2);
						boolean condition4 = (s1 < s2) && (e1 > e2);
						if (condition1 || condition2 || condition3 || condition4) {
							clashing.add(j);
						}
					}
				}
				lists.add(clashing);
			}

			for (int i = 0; i < n; i++) {
				assigns[i] = 'O';
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int task = 0; task < n; task++) {

				if (assigns[task] == 'O') {
					assigns[task] = 'J';

					queue.add(task);

					while (!queue.isEmpty()) {
						int v = queue.remove();

						for (int i = 0; i < lists.get(v).size(); i++) {
							int dd = lists.get(v).get(i);

							if (assigns[dd] == 'O') {
								if (assigns[v] == 'J') {
									assigns[dd] = 'C';
								} else if (assigns[v] == 'C') {
									assigns[dd] = 'J';
								}
								queue.add(dd);
							} else if (assigns[v] == assigns[dd]) {
								answer = "IMPOSSIBLE";
							}
						}
					}
				}

			}

			if (!answer.equals("IMPOSSIBLE")) {
				answer = new String(assigns);
			}
			answers.add(answer);

		}

		int cc = 1;
		for (String answer : answers) {
			System.out.println("Case #" + cc + ": " + answer);
			cc++;
		}
	}

}