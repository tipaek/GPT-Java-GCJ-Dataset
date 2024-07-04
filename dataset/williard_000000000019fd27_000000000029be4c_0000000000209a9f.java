import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int casenum = 1; casenum <= T; casenum++) {
			String s = sc.next();
			int currHeight = 0, currDigit;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				currDigit = (int)(s.charAt(i) - '0');
				while (currHeight < currDigit) {
					sb.append('(');
					currHeight++;
				}
				while (currHeight > currDigit) {
					sb.append(')');
					currHeight--;
				}
				sb.append(s.charAt(i));
			}
			while (currHeight > 0) {
				sb.append(')');
				currHeight--;
			}
			System.out.printf("Case #%d: %s\n", casenum, sb.toString());
		}
	}
}