import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String s = in.next();
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for (char c : s.toCharArray()) {
				while (count < c - '0') {
					sb.append('(');
					count++;
				}
				while (count > c - '0') {
					sb.append(')');
					count--;
				}
				sb.append(c);
			}
			while (count > 0) {
				sb.append(')');
				count--;
			}
			System.out.println("Case #" + i + ": " + sb);
		}
	}
}