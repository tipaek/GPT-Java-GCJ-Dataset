import java.util.*;

public class Solution {

	private static String solve(char[] ch) {
		Stack<Character> st = new Stack();
		int cnt;

		cnt = ch[0] - '0';
		for (int i = 0; i < cnt; i++) {
			st.push('(');
		}
		st.push(ch[0]);
		for (int i = 0; i < cnt; i++) {
			st.push(')');
		}

		for (int j = 1; j < ch.length; j++) {
			cnt = ch[j] - '0';
			for (int i = 0; i < cnt; i++) {
				if (st.peek() == ')') {
					st.pop();
				} else {
					st.push('(');
				}
			}
			st.push(ch[j]);
			for (int i = 0; i < cnt; i++) {
				st.push(')');
			}
		}

		char[] res = new char[st.size()];
		int i = res.length - 1;

		while (!st.isEmpty()) {
			res[i--] = st.pop();
		}

		return new String(res);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int T = s.nextInt();
		for(int i = 1; i <= T; i++) {
			char[] ch = s.next().toCharArray();

			System.out.println("Case #" + i + ": " + solve(ch));
		}

		s.close();
	}
}