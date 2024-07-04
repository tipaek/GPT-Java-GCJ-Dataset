// package codejam.Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		for (int x = 1; x <= t; x++) {
			String s = in.readLine();
			StringBuilder builder = new StringBuilder();
			int current = 0;
			for (int i = 0; i < s.length(); i++) {
				int value = s.charAt(i) - '0';
				while (current != value) {
					if (current < value) {
						current++;
						builder.append('(');
					} else {
						current--;
						builder.append(')');
					}
				}
				builder.append(value);
			}
			while (current != 0) {
				current--;
				builder.append(')');
			}
			System.out.println("Case #" + x + ": " + builder.toString());
		}
	}
}
