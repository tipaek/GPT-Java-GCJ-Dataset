import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Stack<Character> st = new Stack<Character>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		String ipString;
		t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			ipString = sc.next();
			matchParentesis(ipString, t);
		}

	}

	private static void matchParentesis(String ipString, int t) {
		char ch;
		int prevTop = '0';
		int curr;
		String opString = "";
		for (int i = 0; i < ipString.length(); i++) {
			ch = ipString.charAt(i);
			curr = ch;
			int diff;
			if (curr < prevTop) {
				diff = prevTop - curr;
				for (int j = 0; j < diff; j++) {
					st.pop();
					opString = opString + ")";
					//System.out.println(opString);
				}
				opString = opString + ch;
				//System.out.println(opString);

			} else {
				diff = curr - prevTop;
				for (int j = 0; j < diff; j++) {
					st.add('(');
					opString = opString + "(";
					//System.out.println(opString);
				}
				opString = opString + ch;
				//System.out.println(opString);
			}
			prevTop = ch;
		}
		while (!st.empty()) {
			st.pop();
			opString = opString + ")";
		}
		System.out.println("Case #" + t+ ": "+opString);
	}
}
