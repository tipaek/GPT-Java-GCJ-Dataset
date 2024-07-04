import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCases; tc++) {
			int n = Integer.parseInt(br.readLine());
			List<Pattern> patternList = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				String patternString = br.readLine();
				String[] splitPattern = patternString.split("\\*");
				Pattern pattern = new Pattern();
				if (splitPattern.length == 1) {
					pattern.single = true;
					pattern.start = splitPattern[0];
				} else {
					pattern.start = splitPattern[0];
					pattern.end = splitPattern[splitPattern.length - 1];
					if(patternString.charAt(patternString.length()-1) == '*'){
						pattern.end = "";
					}
					if (splitPattern.length > 2) {
						pattern.middle = Arrays.asList(splitPattern);
						if(patternString.charAt(patternString.length()-1) == '*') {
							pattern.middle = pattern.middle.subList(1, pattern.middle.size());
						}else {
							pattern.middle = pattern.middle.subList(1, pattern.middle.size() - 1);
						}
					}
				}

				patternList.add(pattern);
			}

			//comparing start
			boolean startMatches = true;
			for (int i = 1; i < patternList.size(); i++) {
				if (!(matchStart(patternList.get(i - 1).start, patternList.get(i).start))) {
					startMatches = false;
					break;
				}
			}

			//compare end if start matches
			boolean endMatches = true;
			if (startMatches) {
				for (int i = 1; i < patternList.size(); i++) {
					if (!(matchEnd(patternList.get(i - 1).end, patternList.get(i).end))) {
						endMatches = false;
						break;
					}
				}
			} else {
				endMatches = false;
			}

			//Genearate string if start and end match
			StringBuilder stringBuilder = new StringBuilder();
			if (startMatches && endMatches) {
				stringBuilder.append(patternList.stream().reduce((p, q) -> p.start.length() > q.start.length() ? p : q).get().start);
				int maxSize = patternList.stream().reduce((p, q) -> p.middle.size() > q.middle.size() ? p : q).get().middle.size();
				for (int i = 0; i < maxSize; i++) {
					for (Pattern p : patternList) {
						if (p.middle.size() > i) {
							stringBuilder.append(p.middle.get(i));
						}
					}
				}
				stringBuilder.append(patternList.stream().reduce((p, q) -> p.end.length() > q.end.length() ? p : q).get().end);
			} else {
				stringBuilder.append("*");
			}

			System.out.println("Case #" + tc + ": " + stringBuilder.toString());
		}
	}

	public static boolean matchEnd(String a, String b) {
		if (a.length() == b.length()) {
			return a.equals(b);
		}

		String smaller = a.length() < b.length() ? a : b;
		String bigger = a.length() > b.length() ? a : b;
		bigger = bigger.substring(bigger.length() - smaller.length());
		return bigger.equals(smaller);
	}

	public static boolean matchStart(String a, String b) {
		if (a.length() == b.length()) {
			return a.equals(b);
		}

		String smaller = a.length() < b.length() ? a : b;
		String bigger = a.length() > b.length() ? a : b;
		bigger = bigger.substring(0, smaller.length());
		return bigger.equals(smaller);
	}
}

class Pattern {
	boolean single;
	String start = "";
	String end = "";
	List<String> middle = new LinkedList<>();
}
