import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		for (int t = 1; t <= T; ++t) {
			int N = in.nextInt();
			StringBuilder sb = new StringBuilder();
			String start = "";
			String end = "";
			boolean possible = true;

			for (int n = 0; n < N; ++n) {
				String S = in.next();
				int fa = S.indexOf('*');
				int la = S.lastIndexOf('*');

				String middle = fa == la ? "" : S.substring(fa, la + 1).replaceAll("\\*", "");
				sb.append(middle);

				String lstart = S.substring(0, fa);
				String lend = la == S.length() - 1 ? "" : S.substring(la + 1, S.length());

				if (lstart.length() <= start.length() && !start.startsWith(lstart) || lstart.length() > start.length() && !lstart.startsWith(start)) {
					possible = false;
				}
				if (lend.length() <= end.length() && !end.endsWith(lend) || lend.length() > end.length() && !lend.endsWith(end)) {
					possible = false;
				}
				
				if(lstart.length() > start.length())
					start = lstart;
				if(lend.length() > end.length())
					end = lend;
			}

			if (possible) {
				System.out.println("Case #" + t + ": " + start + sb.toString() + end);
			} else {
				System.out.println("Case #" + t + ": *");
			}
		}
	}

}
