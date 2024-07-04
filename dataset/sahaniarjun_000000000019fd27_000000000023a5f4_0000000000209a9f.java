package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String line = br.readLine().trim();
			StringBuilder sb = new StringBuilder();
			int open = 0;
			int num;
			for (int j = 0; j < line.length(); j++) {
				num = Character.getNumericValue(line.charAt(j));
				if (open > num) {
					for (int k = 0; k < open - num; k++) {
						sb.append(")");
					}
					open = num;
				} else if (open < num) {
					for (int k = 0; k < num - open; k++) {
						sb.append("(");
					}
					open = num;
				}
				sb.append(num);
			}
			for (int j = 0; j < open; j++) {
				sb.append(")");
			}

			System.out.println("Case #" + (i + 1) + ": " + sb.toString());

		}
	}
}
