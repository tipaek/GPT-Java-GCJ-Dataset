import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String result = solveProblem(in);
		System.out.println(result);
	}

	public static String solveProblem(Scanner scanner) {
		String result = "";
		int t = scanner.nextInt();
		for (int i = 1; i <= t; ++i) {
			int n = scanner.nextInt();
			String[] patterns = new String[n];
			for (int j = 0; j < n; j++) {
				patterns[j] = scanner.next();
			}
			result += "Case #" + i + ": " + solveCase(patterns) + "\n";
		}

		return result;
	}

	public static String solveCase(String[] patterns) {
		String result = "";
		String debutMax = "";
		String finMax = "";
		boolean debutLock = false;
		boolean finLock = false;
		List<String> tmpResults = new ArrayList<>();
		for (String pattern : patterns) {
			pattern = pattern.replace("**", "*");
			String[] items = split(pattern);
			if (!pattern.startsWith("*")) {
				debutLock = true;
				String debut = items[0];
				if (debutMax.length() >= debut.length()) {
					if (!debutMax.startsWith(debut)) {
						return "*";
					}
				} else {
					if (!debut.startsWith(debutMax)) {
						return "*";
					} else {
						debutMax = debut;
					}
				}
			}
			if (!pattern.endsWith("*")) {
				finLock = true;
				String fin = items[items.length - 1];
				if (finMax.length() >= fin.length()) {
					if (!finMax.endsWith(fin)) {
						return "*";
					}
				} else {
					if (!fin.endsWith(finMax)) {
						return "*";
					} else {
						finMax = fin;
					}
				}
			}
		}
		if (debutMax.length() > 0) {
			tmpResults.add(debutMax);
		}
		if (finMax.length() > 0) {
			tmpResults.add(finMax);
		}
		for (String pattern : patterns) {
			String[] items = split(pattern);
			for (int i = 0; i < items.length; i++) {
				String item = items[i];
				if (tmpResults.size() > 0) {
					tmpResults.add(tmpResults.size() - 1, item);
				} else {
					tmpResults.add(item);
				}
			}
		}
		for (String tmpResult : tmpResults) {
			result += tmpResult;
		}
		return result;
	}

	public static String[] split(String str) {
		List<String> result = new ArrayList<String>();
		String tmpStr = str;
		while (tmpStr.contains("*")) {
			String sub = tmpStr.substring(0, tmpStr.indexOf("*"));
			if (sub.length() > 0) {
				result.add(sub);
			}
			tmpStr = tmpStr.substring(tmpStr.indexOf("*") + 1);
		}
		if (tmpStr.length() > 0) {
			result.add(tmpStr);
		}
		String[] realResult = new String[result.size()];
		for (int i = 0; i < result.size(); i++) {
			realResult[i] = result.get(i);
		}
		return realResult;
	}

}
