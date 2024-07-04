import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.println("Case #" + i + ": " + solution(s));
		}
	}

	private static String solution(Scanner s) {
		String line = s.next();
		StringBuilder b = new StringBuilder();
		char prev = line.charAt(0);
		char ch;
		int count = 1;
		int depth = 0;
		for (int i = 1; i < line.length(); i++) {
			ch = line.charAt(i);
			if (ch == prev) {
				count++;
			} else {
				depth = append(prev, count, depth, b);

				count = 1;
				prev = ch;
			}
		}
		depth = append(prev, count, depth, b);
		while (depth > 0) {
			b.append(')');
			depth--;
		}
		return b.toString();
	}

	private static int append(char ch, int count, int depth, StringBuilder b) {
		int toDepth = ch - '0';
		while (toDepth < depth) {
			b.append(')');
			depth--;
		}
		while (toDepth > depth) {
			b.append('(');
			depth++;
		}
		while (count > 0) {
			b.append(ch);
			count--;
		}
		return depth;
	}
}
