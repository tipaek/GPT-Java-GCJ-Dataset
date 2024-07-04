import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int N;
		String s, prev;
		ArrayList<String[]> patterns = new ArrayList<>(100);
		ArrayList<String> start = new ArrayList<>(100);
		ArrayList<String> end = new ArrayList<>(100);
		ArrayList<String> middle = new ArrayList<>(100);
		String[] field;
		int maxLen = 0;
		for (int i = 1; i <= T; i++) {
			N = in.nextInt();
			in.nextLine();
			for (int j = 0; j < N; j++) {
				s = in.nextLine().trim();
				if (s.endsWith("*"))
					s += " ";
				field = s.split("\\*");
				patterns.add(field);

				if (!field[0].trim().isEmpty())
					start.add(field[0]);

				if (!field[field.length - 1].trim().isEmpty())
					end.add(field[field.length - 1]);

				maxLen = Math.max(maxLen, field.length);
			}
			String startS = commonPattern(start, 1);
			String endS = commonPattern(end, 3);
			String middleS;
			String commonString = startS;

			if (startS.equals("*") || endS.equals("*")) {
				System.out.println("Case #" + i + ": *");
				continue;
			}

			for (int j = 1; j < maxLen - 1; j++) {
				middle.clear();
				for (String[] pattern : patterns) {
					if (j < pattern.length - 1)
						middle.add(pattern[j]);
				}
				middleS = commonPattern(middle, 2);
				if (middleS.equals("*")) {
					commonString = "*";
					break;
				}
				commonString += middleS;

			}
			if (!commonString.equals("*"))
				commonString += endS;

			System.out.println("Case #" + i + ": " + commonString);

		}
	}

	static String commonPattern(ArrayList<String> patternList, int position) {
		String common = "";
		int size = patternList.size();
		if (patternList.isEmpty())
			return common;

		if (size == 1)
			return patternList.get(0);

		common = patternList.get(0);
		String pattern;
		for (int i = 1; i < size; i++) {
			pattern = patternList.get(i);

			if (common.length() > pattern.length()) {
				if (position == 1)
					common = commonStartPattern(common, pattern);
				if (position == 2)
					common = commonMiddlePattern(common, pattern);
				if (position == 3)
					common = commonEndPattern(common, pattern);
			} else {
				if (position == 1)
					common = commonStartPattern(pattern, common);
				if (position == 2)
					common = commonMiddlePattern(pattern, common);
				if (position == 3)
					common = commonEndPattern(pattern, common);
			}

			if (common.equals("*"))
				break;
		}

		return common;
	}

	static String commonStartPattern(String pattern1, String pattern2) {
		if (pattern1.startsWith(pattern2))
			return pattern1;

		return "*";
	}

	static String commonMiddlePattern(String pattern1, String pattern2) {
		if (pattern1.contains(pattern2))
			return pattern1;

		return pattern1 + pattern2;
	}

	static String commonEndPattern(String pattern1, String pattern2) {
		if (pattern1.endsWith(pattern2))
			return pattern1;

		return "*";
	}
}