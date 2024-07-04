import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			int n = Integer.parseInt(reader.readLine());
			String[] array = new String[n];
			for (int i = 0; i < n; i++) {
				array[i] = reader.readLine();
			}

			String[] prefixes = new String[n];
			String[] suffices = new String[n];
			StringBuilder middle = new StringBuilder();
			for (int i = 0; i < n; i++) {
				int x = array[i].indexOf('*');
				int y = array[i].lastIndexOf('*');
				prefixes[i] = array[i].substring(0, x);
				suffices[i] = array[i].substring(y + 1);
				// add everything in the middle
				for (int j = x + 1; j < y; j++) {
					char c = array[i].charAt(j);
					if (c != '*') {
						middle.append(c);
					}
				}
			}
			int maxPrefixLength = 0;
			String maxPrefix = "";
			int maxSuffixLength = 0;
			String maxSuffix = "";
			for (int i = 0; i < n; i++) {
				if (prefixes[i].length() > maxPrefixLength) {
					maxPrefixLength = prefixes[i].length();
					maxPrefix = prefixes[i];
				}
				if (suffices[i].length() > maxSuffixLength) {
					maxSuffixLength = suffices[i].length();
					maxSuffix = suffices[i];
				}
			}
			//System.out.println(maxPrefix + " - " + maxSuffix);
			boolean possible = true;
			for (int i = 0; i < n; i++) {
				if (!maxPrefix.startsWith(prefixes[i])) {
					//System.out.println("\"" + prefixes[i] + "\" \"" + maxPrefix + "\"");
					//System.out.println("COCONUTS".endsWith("CONUTS"));
					possible = false;
					break;
				}
				if (!maxSuffix.endsWith(suffices[i])) {
					//System.out.println(suffices[i]);
					possible = false;
					break;
				}
			}
			if (possible) {
				writer.printf("Case #%d: %s\n", tt + 1, maxPrefix + middle.toString() + maxSuffix);
			} else {
				writer.printf("Case #%d: *\n", tt + 1);
			}
		}

		reader.close();
		writer.close();
	}
}
