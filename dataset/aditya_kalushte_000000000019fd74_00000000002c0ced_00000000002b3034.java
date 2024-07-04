
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = sc.nextInt();
		for (int t = 0; t < testcases; t++) {
			int N = sc.nextInt();
			boolean match = true;
			String finalPattern = sc.next();
			outer: for (int line = 2; line <= N; line++) {
				String pattern = sc.next();

				String[] finalPatternArr = finalPattern.split("\\*");
				if (finalPattern.indexOf('*') == 0) {
					finalPatternArr = new String[2];
					finalPatternArr[0] = "";
					finalPatternArr[1] = finalPattern.replaceAll("\\*", "");
				} else if (finalPattern.indexOf('*') == (finalPattern.length() - 1)) {
					finalPatternArr = new String[2];
					finalPatternArr[0] = finalPattern.replaceAll("\\*", "");
					finalPatternArr[1] = "";
				}

				String[] patternArr = pattern.split("\\*");
				if (pattern.indexOf('*') == 0) {
					patternArr = new String[2];
					patternArr[0] = "";
					patternArr[1] = pattern.replaceAll("\\*", "");
				} else if (pattern.indexOf('*') == (pattern.length() - 1)) {
					patternArr = new String[2];
					patternArr[0] = pattern.replaceAll("\\*", "");
					patternArr[1] = "";
				}

				for (int index = 0; index < finalPatternArr.length; index++) {
					
					if(index>=patternArr.length) {
						break;
					}
					String partFinalPatternStr = finalPatternArr[index];
					String partPaterrnStr = patternArr[index];

					String longer = partFinalPatternStr;
					String shorter = partPaterrnStr;

					if (partFinalPatternStr.length() < partPaterrnStr.length()) {
						longer = partPaterrnStr;
						shorter = partFinalPatternStr;
					} else if ((partFinalPatternStr.length() == partPaterrnStr.length())
							&& partFinalPatternStr.length() == 0) {
						continue;
					}

					if (index == 0) {
						for (int i = 0; i < shorter.length(); i++) {
							if (shorter.charAt(i) != longer.charAt(i)) {
								match = false;
								break outer;
							}
						}
					} else {
						for (int i = 0; i < shorter.length(); i++) {
							if (shorter.charAt((shorter.length() - i) - 1) != longer
									.charAt((longer.length() - i) - 1)) {
								match = false;

								break outer;
							}
						}
					}
				}

				if ((finalPattern.indexOf('*') == finalPattern.length() - 1) && (pattern.indexOf('*') == 0)) {
					finalPattern = finalPattern.replaceAll("\\*", "") + "*" + pattern.replaceAll("\\*", "");
				} else if ((pattern.indexOf('*') == pattern.length() - 1) && (finalPattern.indexOf('*') == 0)) {
					finalPattern = pattern.replaceAll("\\*", "") + "*" + finalPattern.replaceAll("\\*", "");
				} else if (finalPattern.length() < pattern.length()) {
					String temp = finalPattern;
					finalPattern = pattern;
					pattern = temp;
				}
			}

			if (!match) {
				System.out.println("Case #" + (t + 1) + ": *");
			} else {
				String answer = finalPattern.replaceAll("\\*", "");
				System.out.println("Case #" + (t + 1) + ": " + answer);
			}
		}
		sc.close();
	}

}
