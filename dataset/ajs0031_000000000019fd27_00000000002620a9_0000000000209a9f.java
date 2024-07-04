import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scanner.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int curCase = 1; curCase <= numCases; curCase++) {
			String s = scanner.next();
			System.out.println("Case #" + curCase + ": " + getResult(s));
		}
	}

	public static String getResult(String s) {
		String result = "";
		List<String> list = new LinkedList<String>();
		String cur = "" + s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == cur.charAt(0)) {
				cur += s.charAt(i);
			} else {
				list.add(cur);
				cur = "" + s.charAt(i);
			}
		}
		list.add(cur);
		int level = 0;
		for (String curString : list) {
			int val = curString.charAt(0) - '0';
			while (level < val) {
				level++;
				result += "(";
			}
			while (level > val) {
				level--;
				result += ")";
			}
			result += curString;
		}
		while (level > 0) {
			level--;
			result += ")";
		}
		return result;
	}

}
