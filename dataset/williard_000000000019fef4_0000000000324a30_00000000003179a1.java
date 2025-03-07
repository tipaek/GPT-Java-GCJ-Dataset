import java.io.*;
import java.util.*;

public class Solution {
	static class Digit implements Comparable<Digit> {
		char digit;
		double ratio;
		public Digit(char a, double b) {
			digit = a; ratio = b;
		}
		public int compareTo(Digit temp) {
			if (this.ratio < temp.ratio)
				return 1;
			else if (this.ratio > temp.ratio)
				return -1;
			else
				return 0;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		StringTokenizer st;
		int numcases = Integer.parseInt(br.readLine());
		for (int casenum = 1; casenum <= numcases; casenum++) {
			int U = Integer.parseInt(br.readLine());
			long count[] = new long[30];
			TreeSet<Character> ts = new TreeSet<Character>();
			for (int i = 0; i < 10000; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s = st.nextToken();

				// for (int j = 0; j < s.length(); j++) {
				// 	count[(int)(s.charAt(j) - 'A')]++;
				// }
				for (int j = 0; j < s.length(); j++)
					ts.add(s.charAt(j));
					

				if (s.length() == U)
					for (int j = 0; j < 1; j++) {
						count[(int)(s.charAt(j) - 'A')]++;
					}
			}
			long total = 0;
			for (int i = 0; i < 26; i++)
				total += count[i];
			// System.out.printf("Total: %d\n", total);
			ArrayList<Digit> list = new ArrayList<Digit>();
			for (int i = 0; i < 26; i++) {
				list.add(new Digit((char)(i+'A'), 100.0 * (double)count[i] / (double)total));
			}
			Collections.sort(list);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++)
				ts.remove(list.get(i).digit);
			sb.append(ts.first());
			for (int i = 0; i < 9; i++)
				sb.append(list.get(i).digit);
			
			System.out.printf("Case #%d: %s\n", casenum, sb.toString());

			// System.out.printf("%f", list.get(9).ratio);
			// for (int i = 0; i < 9; i++)
			// 	System.out.printf(" %f", list.get(i).ratio);
			// System.out.printf("\n");
		}
		System.out.print(out);
	}
}
