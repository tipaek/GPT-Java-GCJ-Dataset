
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		new_solve();
	}

	public static void new_solve() {
		int n = scan.nextInt();

	     scan.nextLine();

		for (int i = 0; i < n; i++) {
			String res = solve_Test_2();
			System.out.println("Case #" + (i + 1) + ": " + res);
		}

	}

	public static String solve_Test_2() {
		int n = scan.nextInt();

		int[][] Array = new int[n][2];
		int[][] sorted = Array.clone();

		char person = 'J';
		char[] chars = new char[n];

		HashMap<int[], Integer> map = new HashMap<>();

		Stack<int[]> Stack1 = new Stack<>();
		Stack<int[]> Stack2 = new Stack<>();

		boolean impossible = false;

		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				Array[i][j] = scan.nextInt();

			}
			map.put(Array[i], i);
		}

		Arrays.sort(sorted, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		for (int i = 0; i < sorted.length; i++) {
			chars[map.get(sorted[i])] = person;
			if (i < sorted.length - 1 && doesOverlap(sorted[i], sorted[i + 1])) {
				if (person == 'J') {
					Stack1.push(sorted[i]);
					person =  getPersonId(person);

					if (!Stack2.isEmpty() && doesOverlap(Stack2.peek(), sorted[i + 1])) {
						impossible = true;
						break;
					}

				} else {
					Stack2.push(sorted[i]);
					person =  getPersonId(person);

					if (!Stack1.isEmpty() && doesOverlap(Stack1.peek(), sorted[i + 1])) {
						impossible = true;
						break;
					}

				}
			} else {

				if (person == 'J') {
					Stack1.push(sorted[i]);
				} else {
					Stack2.push(sorted[i]);
				}
			}

		}

		return impossible ? "IMPOSSIBLE" : new String(chars);

	}

	private static char getPersonId(char p) {
		return p == 'J' ? 'C' : 'J';
	}

	public static boolean doesOverlap(int[] a, int[] b) {
		return a[1] > b[0];
	}

}