import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {

	private static String solve(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0, len = s.length(); i < len; i++) {
			char c = s.charAt(i);
			int d = c - '0';
			for (int j = 0; j < d; j++) {
				Character cc = deque.peek();
				if (cc != null && cc == ')') {
					deque.poll();
					continue;
				}
				deque.push('(');
			}
			deque.push(c);
			for (int j = 0; j < d; j++) {
				deque.push(')');
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Iterator<Character> it = deque.descendingIterator(); it.hasNext();) {
			sb.append(it.next());
		}
		return sb.toString();
	}

	//////////////////////////////////////////////////
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int t = in.nextInt();
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			String s = in.nextLine();
			out.println("Case #" + i + ": " + solve(s));
		}
		in.close();
	}
}