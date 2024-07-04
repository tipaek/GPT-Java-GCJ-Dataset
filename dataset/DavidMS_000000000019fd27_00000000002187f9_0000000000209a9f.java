import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static StringBuilder wrapInParenthesis(int n, int howMany) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < howMany; i++) {
			sb.append('(');
		}
		sb.append(n);
		for (int i = 0; i < howMany; i++) {
			sb.append(')');
		}
		return sb;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int cas = Integer.parseInt(in.readLine());
		for (int c = 1; c <= cas; c++) {
			String line = in.readLine();
			char[] tmp = line.toCharArray();
			StringBuilder sb = new StringBuilder();
			int cur = tmp[0] - '0';
			sb.append(wrapInParenthesis(cur, cur));
			int idx = cur;
			for (int i = 1; i < tmp.length; i++) {
				cur = tmp[i] - '0';
				int last = sb.charAt(idx) - '0';
				if (cur == last) {
					idx++;
					sb.insert(idx, cur);
				} else if (cur > last) {
					idx++;
					sb.insert(idx, wrapInParenthesis(cur, cur - last));
					idx += cur - last;
				} else {
					idx = sb.length() - cur;
					sb.insert(idx, cur);
				}
			}
			System.out.println("Case #" + c + ": " + sb);
		}
	}
}