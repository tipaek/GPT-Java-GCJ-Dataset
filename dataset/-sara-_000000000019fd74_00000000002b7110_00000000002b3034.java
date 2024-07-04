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
			}
			String startingPattern = "";
			for (int j = 0; j < n; j++) {
				String start = patterns[j].substring(0, patterns[j].indexOf("*"));
				if (start.length() > startingPattern.length()) {
					if (start.contains(startingPattern)) {
						startingPattern = start;
					} else {
						solution = "*";
						break;
					}
				} else {
					if (!startingPattern.contains(start)) {
						solution = "*";
					}
				}
			}
			if (solution.equals("*")) {
				System.out.println("Case #" + i + ": " + solution);
				break;
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
				solution = startingPattern + endingPattern;
			}
			if (solution.isEmpty()) {
				solution = "X";
			}
			System.out.println("Case #" + i + ": " + solution);
		}
		in.close();
	}
}
