import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int t = console.nextInt();
		for (int j = 0; j < t; j++) {
			System.out.print("Case #"+(j+1)+": ");
			String s = console.next();
			int n = s.length();
			int bracketNum = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				int val = s.charAt(i) - 48;
				if (val == bracketNum) {
					sb.append(s.charAt(i));
				} else if (val > bracketNum) {
					int diff = val - bracketNum;
					sb.append(generateOpenBraces(diff)).append(s.charAt(i));
					bracketNum += diff;
				} else {
					int diff = bracketNum - val;
					sb.append(generateCloseBraces(diff)).append(s.charAt(i));
					bracketNum -= diff;
				}
			}
			if (bracketNum > 0) {
				sb.append(generateCloseBraces(bracketNum));
			}
			System.out.println(sb.toString());

		}
	}

	public static String generateOpenBraces(int n) {
		return String.join("", Collections.nCopies(n, "("));
	}

	public static String generateCloseBraces(int n) {
		return String.join("", Collections.nCopies(n, ")"));
	}

}