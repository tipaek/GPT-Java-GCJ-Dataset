import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			in.nextLine();
			String[] patterns = new String[n];
			String solution = "";
			for (int j = 0; j < n; j++) {
				patterns[j] = in.nextLine();
				if (patterns[j].beginsWith(" ") || patterns[j].endsWith(" ")) {
				        throw new RuntimeException("oops");
				}
			}
			String endingPattern = "";
			for (int j = 0; j < n; j++) {
				String end = patterns[j].substring(patterns[j].indexOf("*") + 1);
				if (end.length() > endingPattern.length()) {
					if (end.contains(endingPattern)) {
						endingPattern = end;
					} else {
						solution = "*";
						break;
					}
				} else {
					if (!endingPattern.contains(end)) {
						solution = "*";
					}
				}
			}
			if (!solution.equals("*")) {
				solution = endingPattern;
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
}
