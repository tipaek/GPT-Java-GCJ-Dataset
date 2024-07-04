import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		for (int _t = 1; _t <= t; ++_t) {

			int n = in.nextInt();
			int[][] matrix = new int[n][2];
			int[][] matrixSorted = matrix.clone();
			char ps = 'J';
			char[] answer = new char[n];
			Stack<int[]> jamie = new Stack<>();
			Stack<int[]> cameron = new Stack<>();
			boolean impossible = false;

			Map<int[], Integer> map = new HashMap<>();

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = in.nextInt();
				}
				map.put(matrix[i], i);
			}

			Arrays.sort(matrixSorted, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return a[0] - b[0];
				}
			});

			for (int i = 0; i < matrixSorted.length; i++) {
				answer[map.get(matrixSorted[i])] = ps;

				if (i < matrixSorted.length - 1 && overlaps(matrixSorted[i], matrixSorted[i + 1])) {
					if (ps == 'J') {
						jamie.push(matrixSorted[i]);
						ps = reversePerson(ps);
						
						if (!cameron.isEmpty() && overlaps(cameron.peek(), matrixSorted[i+1])) {
							impossible = true;
							break;
						}
						
					} else {
						cameron.push(matrixSorted[i]);
						ps = reversePerson(ps);
						
						if (!jamie.isEmpty() && overlaps(jamie.peek(), matrixSorted[i+1])) {
							impossible = true;
							break;
						}
					}
				} else {
					if (ps == 'J') {
						jamie.push(matrixSorted[i]);
					} else {
						cameron.push(matrixSorted[i]);
					}
				}
			}
			System.out.println("Case #" + _t + ": " + (impossible ? "IMPOSSIBLE" : new String(answer)));
		}
	}

	private static char reversePerson(char c) {
		return c == 'J' ? 'C' : 'J';
	}

	private static boolean overlaps(int[] a, int[] b) {
		return a[1] > b[0];
	}
}
