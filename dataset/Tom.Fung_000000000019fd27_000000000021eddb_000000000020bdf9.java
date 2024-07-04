import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int totalCase = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= totalCase; i++) {
			boolean[] carmen = new boolean[1441];
			boolean[] james = new boolean[1441];
			// false = free time
			int t = Integer.parseInt(sc.nextLine());
			boolean totalFail = false;
			StringBuilder subResult = new StringBuilder();
			for (int ii = 0; ii < t; ii++) {
				String[] timeslot = sc.nextLine().split(" ");
				int from = Integer.parseInt(timeslot[0]);
				int to = Integer.parseInt(timeslot[1]);

				// check carmen first
				if (!totalFail) {
					if (isFree(carmen, from, to)) {
						carmen = fill(carmen, from, to);
						subResult.append('C');
					} else if (isFree(james, from, to)) {
						james = fill(james, from, to);
						subResult.append('J');
					} else {
						totalFail = true;
					}
				}

			}
			if (totalFail) {
				result.append("Case #" + i + ": IMPOSSIBLE\n");
			} else {
				result.append("Case #" + i + ": " + subResult.toString() + "\n");
			}

		}
		System.out.print(result.toString());

	}

	public static boolean isFree(boolean[] a, int from, int to) {
		for (int i = from; i < to; i++) {
			if (a[i])
				return false;
		}
		return true;
	}

	public static boolean[] fill(boolean[] a, int from, int to) {
		for (int i = from; i < to; i++) {
			a[i] = true;
		}
		return a;
	}

}
