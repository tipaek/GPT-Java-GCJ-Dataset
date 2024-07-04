import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

//javac Solution2.java
//python interactive_runner.py python.exe testing_tool.py 0 -- java Solution2
//change name before submit

public class Solution {

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 1; i <= T; i++) {
			StringBuilder res = new StringBuilder();
			String s = input.next();
			int cur = 0;
			for (int ii = 0; ii < s.length(); ii++) {
				int pom = (int)s.charAt(ii) - 48;
				if (pom > cur) {
					for (int iii = 0; iii < pom - cur; iii++) {
						res.append('(');
					}
				}
				if (pom < cur) {
					for (int iii = 0; iii < cur - pom; iii++) {
						res.append(')');
					}
				}
				cur = pom;
				res.append(pom);
			}
			for (int ii = 0; ii < cur; ii++) {
				res.append(')');
			}
			System.out.println("Case #" + i + ": " + res);
		}
	}
}