
import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			Solution obj = new Solution();

			int test = Integer.parseInt(br.readLine());
			for (int t = 0; t < test; t++) {
				int N = Integer.parseInt(br.readLine());
				ArrayList<String> patterns = new ArrayList<String>();
				for (int n = 0; n < N; n++) {
					patterns.add(br.readLine());
				}
				String reult = obj.patternMatching2(patterns);
				if (reult.length()>10000)
					System.out.println("Case #" + (t + 1) + ": *");
				else
					System.out.println("Case #" + (t + 1) + ": " + reult);
			}

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String patternMatching2(ArrayList<String> patterns) {
		// String finalPattern = "";
		// ArrayList<String> pat = new ArrayList<String>();
		String startsWith = "";
		String endsWith = "";
		Boolean canGenerate = true;
		for (String p : patterns) {
			// System.out.println(p.indexOf("*"));
			if (startsWith.length() <= p.substring(0, p.indexOf("*")).length()) {
				if (startsWith == "" || p.substring(0, p.indexOf("*")).startsWith(startsWith))
					startsWith = p.substring(0, p.indexOf("*"));
				else {
					canGenerate = false;
					break;
				}
			} else {
				if (!startsWith.startsWith(p.substring(0, p.indexOf("*")))) {
					canGenerate = false;
					break;
				}
			}
			if (endsWith.length() <= p.substring(p.indexOf("*") + 1, p.length()).length()) {
				if (endsWith == "" || p.substring(p.indexOf("*") + 1, p.length()).endsWith(endsWith))
					endsWith = p.substring(p.indexOf("*") + 1, p.length());
				else {
					canGenerate = false;
					break;
				}

			} else {
				if (!endsWith.endsWith(p.substring(p.indexOf("*") + 1, p.length()))) {
					canGenerate = false;
					break;
				}
			}

		}
		if (canGenerate)
			if (startsWith.endsWith(endsWith))
				return (startsWith);
			else if (endsWith.startsWith(startsWith))
				return (endsWith);
			else
				return (startsWith + endsWith);
		else
			return ("*");
		// return null;
	}

}