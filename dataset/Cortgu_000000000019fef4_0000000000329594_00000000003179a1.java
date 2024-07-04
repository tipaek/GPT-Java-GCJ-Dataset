import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			final int numberOfCases = in.nextInt(); // Number of cases
			for (int caseNo = 1; caseNo <= numberOfCases; caseNo++) {
				final int U = in.nextInt();
				SortedMap<Long, Set<String>> map = new TreeMap<>();
				Map<Integer, String> found = new HashMap<>();
				Set<String> available = new HashSet<>();
				for (int i = 0; i < 10000; i++) {
					final long Q = in.nextLong();
					final String R = in.next();
					available.addAll(R.chars().mapToObj(e -> String.valueOf((char) e)).collect(Collectors.toSet()));
					if (map.containsKey(Q)) {
						map.get(Q).add(R);
					} else {
						Set<String> set = new HashSet<>();
						set.add(R);
						map.put(Q, set);
					}
				}

				// Get digits
				for (int j = 0; j < 10; j++) {
					for (Map.Entry<Long, Set<String>> entry : map.entrySet()) {
						final Long i = entry.getKey();
						if (String.valueOf(i).endsWith(String.valueOf(j))) {
							final Set<String> strings = map.get(i);
							if (strings != null) {
								strings.removeAll(found.values());
								for (String string : strings) {
									final int length = String.valueOf(i).length();
									if (string.length() == length) {
										final String letter = String.valueOf(string.charAt(length - 1));
										if (j == 10) {
											found.put(0, letter);
										} else {
											found.put(j, letter);
										}
										break;
									}
								}
							}
							if (found.containsKey(j % 10)) {
								break;
							}
						}
					}
				}

				StringBuilder result = new StringBuilder();
				for (int i = 0; i < 10; i++) {
					String letter = found.get(i);
					if (letter != null) {
						result.append(letter);
					} else {
						if (found.size() == 9) {
							available.removeAll(found.values());
							letter = available.iterator().next();
							result.append(letter);
						} else {
							result.append("X"); // Shouldn't happen
						}
					}
				}
				System.out.println("Case #" + caseNo + ": " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}