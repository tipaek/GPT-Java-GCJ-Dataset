
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static class Rand {
		String input;
		String result;

		Rand(String input, String result) {
			this.input = input;
			this.result = result;
		}
	}

	static class Combinations {

		Map<Integer, Set<Character>> options;
		List<StringBuilder> combinations = new ArrayList<>();
		int idx = 0;

		public Combinations(Map<Integer, Set<Character>> options) {
			this.options = options;
			combinations.add(new StringBuilder());
			for (int i = 0; i < 10; ++i) {
				Set<Character> chars = options.get(i);
				if (chars.size() == 1) {
					for (StringBuilder sb : combinations) {
						sb.append(chars.iterator().next());
					}
				} else {
					List<StringBuilder> newCombinations = new ArrayList<>();
					for (char c : chars) {
						for (StringBuilder sb : combinations) {
							StringBuilder newSb = new StringBuilder(sb.toString());
							newSb.append(c);
							newCombinations.add(newSb);
						}
					}
					combinations = newCombinations;
				}
			}
		}

		public boolean hasNext() {
			return idx < combinations.size();
		}

		public String next() {
			return combinations.get(idx++).toString();
		}

	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
			int numOfTestCases = scan.nextInt();
			for (int i = 1; i <= numOfTestCases; ++i) {
				int numOfDigits = scan.nextInt();
				List<Rand> results = new LinkedList<>();
				for (int j = 1; j < 10_000; ++j) {
					String input = scan.next();
					String result = scan.next();
					results.add(new Rand(input, result));
				}
				System.out.println("Case #" + i + ": " + solve(results));
			}
		}
	}

	private static String solve(List<Rand> results) {
		Map<Integer, Set<Character>> options = initCharMap(results);

		// remove first character from impossible options
		for (Rand line : results) {
			char firstChar = line.result.charAt(0);
			options.get(0).remove(firstChar);
			if (line.result.length() == line.input.length()) {
				for (int i = Integer.valueOf(line.input.substring(0, 1)) + 1; i < 10; ++i) {
					options.get(i).remove(firstChar);
				}
			}
		}

		// remove mapped characters from other options
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 0; i < 10; ++i) {
				if (options.get(i).size() == 1) {
					char c = options.get(i).iterator().next();
					for (int j = 0; j < 10; ++j) {
						if (i != j) {
							changed = options.get(j).remove(c) || changed; 
						}
					}
				}
			}
		}

		// try remaining combinations
		if (isSolved(options)) {
			return toResult(options);
		} else {
			Combinations comb = new Combinations(options);
			while (comb.hasNext()) {
				String next = comb.next();
				if (isValid(results, next)) {
					return next;
				}
			}
		}
		return "";
	}

	private static Map<Integer, Set<Character>> initCharMap(List<Rand> results) {
		Set<Character> chars = new HashSet<>();
		for (Rand line : results) {
			for (Character c : line.result.toCharArray()) {
				chars.add(c);
			}
		}

		Map<Integer, Set<Character>> options = new HashMap<>();
		for (int i = 0; i < 10; ++i) {
			options.put(i, new HashSet<>(chars));
		}
		return options;
	}

	private static String toResult(Map<Integer, Set<Character>> options) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; ++i) {
			sb.append(options.get(i).iterator().next());
		}
		return sb.toString();
	}

	private static boolean isSolved(Map<Integer, Set<Character>> options) {
		for (int i = 0; i < 10; ++i) {
			if (options.get(i).size() != 1) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValid(List<Rand> results, String mapping) {
		for (Rand line : results) {
			int result = toInt(line.result, mapping);
			if (Integer.valueOf(line.input) > result) {
				return false;
			}
		}
		return true;
	}

	private static int toInt(String result, String mapping) {
		StringBuilder sb = new StringBuilder();
		for (char c : result.toCharArray()) {
			sb.append(mapping.indexOf(c));
		}
		return Integer.valueOf(sb.toString());
	}

}
