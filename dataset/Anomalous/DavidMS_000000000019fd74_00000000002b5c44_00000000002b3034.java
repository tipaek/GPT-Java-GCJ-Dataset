import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	private static String findMatch(String current, String newString, boolean isPrefix) {
		if (current.isEmpty()) return newString;
		if (newString.isEmpty()) return current;
		if (isPrefix && current.startsWith(newString)) return current;
		if (isPrefix && newString.startsWith(current)) return newString;
		if (!isPrefix && current.endsWith(newString)) return current;
		if (!isPrefix && newString.endsWith(current)) return newString;
		return null;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());

		for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
			int patternsCount = Integer.parseInt(reader.readLine());
			String leftPart = "", rightPart = "";
			boolean isPossible = true;

			for (int i = 0; i < patternsCount; i++) {
				String[] parts = reader.readLine().split("\\*");
				if (isPossible) {
					rightPart = findMatch(rightPart, parts.length > 0 ? parts[0] : "", true);
					leftPart = findMatch(leftPart, parts.length > 1 ? parts[1] : "", false);
					if (rightPart == null || leftPart == null) {
						isPossible = false;
					}
				}
			}

			String result = rightPart + leftPart;
			if (!isPossible) {
				System.out.println("Case #" + caseNumber + ": *");
			} else if (result.isEmpty()) {
				System.out.println("Case #" + caseNumber + ": A");
			} else {
				System.out.println("Case #" + caseNumber + ": " + result);
			}
		}
	}
}