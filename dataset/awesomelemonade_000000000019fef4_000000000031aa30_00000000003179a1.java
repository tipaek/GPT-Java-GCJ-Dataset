import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		int numLines = 10000;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);

		// https://en.wikipedia.org/wiki/Benford%27s_law
		int t = Integer.parseInt(reader.readLine());
		for (int tt = 0; tt < t; tt++) {
			int u = Integer.parseInt(reader.readLine());

			TreeSet<Character> allLetters = new TreeSet<Character>();
			TreeMap<Character, Integer> counts = new TreeMap<Character, Integer>();
			for (int i = 0; i < numLines; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				int q = Integer.parseInt(tokenizer.nextToken());
				String r = tokenizer.nextToken();
				char start = r.charAt(0);
				counts.put(start, counts.getOrDefault(start, 0) + 1);
				for (char c : r.toCharArray()) {
					allLetters.add(c);
				}
			}
			// add 0 entry
			for (char c : allLetters) {
				if (!counts.containsKey(c)) {
					counts.put(c, 0);
				}
			}
			//writer.println("Counts: " + counts);
			List<Map.Entry<Character, Integer>> list = new ArrayList<>(counts.entrySet());
			list.sort(Map.Entry.comparingByValue());
			if (list.size() != 10) {
				throw new IllegalStateException("Not 10!");
			}
			StringBuilder builder = new StringBuilder();
			for (Map.Entry<Character, Integer> entry : list) {
				builder.append(entry.getKey());
			}
			String answer =  builder.charAt(0) + builder.reverse().substring(0, 9);
			writer.printf("Case #%d: %s\n", tt + 1, answer);
		}

		reader.close();
		writer.close();
	}
}
