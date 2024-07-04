import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			final int numberOfCases = in.nextInt(); // Number of cases
			for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
				final int U = in.nextInt();
				SortedMap<Integer, Set<String>> map = new TreeMap<>();
				Map<Integer, String> found = new HashMap<>();
				for (int i = 0; i < 10000; i++) {
					final int Q = in.nextInt();
					final String R = in.next();
					if (map.containsKey(Q)) {
						map.get(Q).add(R);
					} else {
						Set<String> set = new HashSet<>();
						set.add(R);
						map.put(Q, set);
					}
				}

				// Get digits 1 to 9
				Set<Integer> notFound = new HashSet<>();
				for (int i = 1; i < 10; i++) {
					final Set<String> strings = map.get(i);
					if (strings != null) {
						strings.removeAll(found.values());
						found.put(i, strings.iterator().next());
					} else {
						notFound.add(i);
					}
				}

				// Get digit 0
				final Set<String> strings = map.get(10);
				if (strings != null) {
					strings.removeAll(found.values());
					found.put(0, String.valueOf(strings.iterator().next().charAt(1)));
				}
				
				StringBuilder result = new StringBuilder();
				for (int i = 0; i < 10; i++) {
					result.append(found.get(i));
				}
				System.out.println("Case #" + caseNo + ": " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
