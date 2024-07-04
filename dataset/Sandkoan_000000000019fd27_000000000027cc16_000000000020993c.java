
import java.util.*;
import java.lang.*;
import java.io.*;

public class GoogleCodeJam3 {
	static List<String> l = new ArrayList<>();
	static Queue<Character> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int k = 0; k < T; k++) {
			int N = in.nextInt();
			l.clear();
			q.clear();
			for (int i = 0; i < N; i++) {
				l.add(in.nextInt() + "s");
				l.add(in.nextInt() + "d");
			}

			q.add('C');
			q.add('J');
			StringBuilder sb = new StringBuilder();
			int p = 0, flag = 1;
			int prev = -1;
			for (String str : l) {
				if (str.endsWith("s")) {
					if (p >= 2) {
						System.out.println("Case #" + (k + 1) + ": IMPOSSIBLE");
						flag = 0;
						break;
					}
					p++;
					if (prev == Integer.valueOf(str.substring(0, str.length() - 1))) {
						sb.append(sb.toString().charAt(sb.length() - 1));
					} else {
						sb.append(q.poll());
					}
				} else {
					p--;
					char ch;
					if (q.size() == 0) {
						q.add('C');
						q.add('J');
					} else if (q.size() == 1) {
						q.add('C');
					}
					prev = Integer.valueOf(str.substring(0, str.length() - 1));
				}
			}
			System.out.println("Case #" + (k + 1) + ": " + Arrays.toString(l.toArray()));

			if (flag == 1)
				System.out.println("Case #" + (k + 1) + ": " + sb.toString());
		}
	}
}
