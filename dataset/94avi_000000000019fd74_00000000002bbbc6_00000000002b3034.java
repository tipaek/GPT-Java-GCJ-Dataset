import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class Solution {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int testCase = Integer.valueOf(br.readLine());

		for (int test = 1; test <= testCase; test++) {

			int n = Integer.valueOf(br.readLine());
			List<String> words = new ArrayList<>();
			List<String> patterns = new ArrayList<>();
			String result = "";
			for (int i = 1; i <= n; i++) {
				String word = br.readLine();
				words.add(word);
				if (result.length() < word.replace("*", "").length())
					result = word.replace("*", "");
				StringBuilder pattern = new StringBuilder();
				for (String string : word.split("")) {
					if (string.equals("*"))
						pattern.append("." + string);
					else
						pattern.append(string);
				}
				patterns.add(pattern.toString());
			}
			if (doesMatch(result, patterns)) {
				System.out.println("Case #" + test + ": " + result);
			} else {
				System.out.println("Case #" + test + ": *");
			}

		}
	}

	private static boolean doesMatch(String result, List<String> patterns) {
		for (String pattern : patterns) {
			if (!Pattern.matches(pattern, result))
				return false;
		}
		return true;
	}

}