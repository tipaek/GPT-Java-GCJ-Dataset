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

			System.out.println("Case #" + (i + 1) + ": " + find(ar)+" ");

		}
  }
  
  public static String find(int[][] ar) {

		int[] start = new int[ar.length];
		int[] end = new int[ar.length];

		for (int i = 0; i < ar.length; i++)
			start[i] = ar[i][0];

		for (int i = 0; i < ar.length; i++)
			end[i] = ar[i][1];

		Arrays.sort(start);
		Arrays.sort(end);

		int i = 0, j = 0;

		Queue<Character> q = new LinkedList<>();
		q.add('C');
		q.add('J');
		char[] ch = new char[start.length];
		while (i < start.length) {

			if (start[i] < end[j]) {

				if (q.isEmpty())
					return "IMPOSSIBLE";

				ch[i] = q.poll();
				i++;
			} else {
				q.add(ch[j]);
				j++;
			}
		}

		return new String(ch);

	}
}