import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int t1 = 1; t1 <= t; t1++) {
			char[] a = br.readLine().trim().toCharArray();
			StringBuffer sb = new StringBuffer();
			int op = 0;
			char prev = ' ';
			for (int i = 0; i < a.length; i++) {
				char ch = a[i];
				int x = ch - 48;
				if (prev != ch) {
					if (x > op) {
						int d = x - op;
						for (int j = 0; j < d; j++) {
							sb.append("(");
						}
						op = x;
					} else if (x < op) {
						int d = op - x;
						for (int j = 0; j < d; j++) {
							sb.append(")");
						}
					}
					op = x;
				} else
					op = x;
				sb.append(ch);
				prev = ch;
			}
			for (int i = 0; i < op; i++)
				sb.append(")");
			System.out.println(sb);
		}
	}
}
