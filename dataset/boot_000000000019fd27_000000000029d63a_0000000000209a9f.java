import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private Scanner scanner;
	private String digits;

	public Solution(Scanner scanner) {
		this.scanner = scanner;
	}

	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {

			Solution solution = new Solution(scanner);

			int testCases = scanner.nextInt();

			for (int tc = 1; tc <= testCases; tc++) {

				solution.processInput();

				System.out.printf("Case #%d:", tc);
				solution.solve();
				System.out.println();
			}
		}
	}

	void processInput() {
		digits = scanner.next();
	}

	void solve() {
		System.out.printf(" %s", addBrackets(splitSegments(digits), 0));
	}
	
	private List<String> splitSegments(String s) {
		List<String> segments = new ArrayList<>();
		int lastIdx = 0;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(lastIdx)) {
				segments.add(s.substring(lastIdx, i));
				lastIdx = i;
			}
		}
		
		if (lastIdx < s.length()) {
			segments.add(s.substring(lastIdx, s.length()));
		}
		
		return segments;
	}
	
	private String addBrackets(List<String> segments, int depth) {
		if (segments.size() == 0) {
			return "";
		}
		if (segments.get(0).charAt(0) - '0' == depth) {
			String rightPad = "";
			if (segments.size() == 1) {
				for (int i = 0; i < segments.get(0).charAt(0) - '0'; i++) {
					rightPad += ")";
				}
			}
			return segments.get(0) + addBrackets(segments.subList(1, segments.size()), depth) + rightPad;
		}
		if (segments.get(0).charAt(0) - '0' > depth) {
			return "(" + addBrackets(segments, depth + 1);
		}
		if (segments.get(0).charAt(0) - '0' < depth) {
			return ")" + addBrackets(segments, depth - 1);
		}
		
		throw new IllegalStateException("Invalid state");
	}
}