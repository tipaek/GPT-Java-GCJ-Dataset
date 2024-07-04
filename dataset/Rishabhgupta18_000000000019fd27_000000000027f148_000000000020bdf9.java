import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt("" + in.nextLine());

		for (int i = 0; i < t; i++) {

			int n = in.nextInt();

			int[][] ar = new int[n][2];

			for (int j = 0; j < n; j++) {
				ar[j][0] = in.nextInt();
				ar[j][1] = in.nextInt();
			}

			System.out.println("Case #" + (i + 1) + ": " + find(ar));

		}

	}

	public static String find(int[][] ar) {

		int[][] start = new int[ar.length][2];
		int[][] end = new int[ar.length][2];

		for (int i = 0; i < ar.length; i++) {
			start[i][0] = ar[i][0];
			start[i][1] = i;
		}

		for (int i = 0; i < ar.length; i++) {
			end[i][0] = ar[i][1];
			end[i][1] = i;
		}

		Arrays.sort(start, (int[] a, int[] b) -> {
			return a[0] - b[0];
		});
		Arrays.sort(end, (int[] a, int[] b) -> {
			return a[0] - b[0];
		});

		int i = 0, j = 0;

		Queue<Character> q = new LinkedList<>();
		q.add('J');
		q.add('C');
		char[] ch = new char[start.length];
		Map<Integer, Character> process = new HashMap<>(start.length);
		while (i < start.length) {

			if (start[i][0] < end[j][0]) {

				if (q.isEmpty())
					return "IMPOSSIBLE";

				ch[i] = q.poll();
				process.put(start[i][1], ch[i]);
				i++;
			} else {
				q.add(process.get(end[j][1]));
				j++;
			}
		}

		return new String(ch);

	}
}