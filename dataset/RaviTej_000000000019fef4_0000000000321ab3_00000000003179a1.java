
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	public static void main(String[] args) {

		Integer range = 10000;

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int x = 1; x <= t; x++) {

			Integer u = sc.nextInt();

			List<String> intList = new ArrayList<>();
			List<String> stringList = new ArrayList<>();

			Map<Character, Character> charMap = new HashMap<>();

			IntStream.range(0, range).forEach(s -> {
				intList.add(sc.next().trim());
				stringList.add(sc.next().trim());
			});

			Set<Character> chars = new HashSet<>();

			for (String st : stringList) {
				for (Character c : st.toCharArray()) {
					chars.add(c);
				}
				if (chars.size() == 10)
					break;
			}

			Character junk = '9' + 1;

			chars.forEach(s -> charMap.put(s, junk));

			for (int i = 0; i < range; i++) {

				String intVal = intList.get(i);
				String strVal = stringList.get(i);

				if (strVal.length() != u)
					continue;

				Character c = strVal.charAt(0);
				Character val = intVal.charAt(0);

				charMap.put(c, val < charMap.get(c) ? val : charMap.get(c));

			}

			for (Entry<Character, Character> entry : charMap.entrySet()) {
				if (entry.getValue().equals(junk)) {
					entry.setValue('0');
				}
			}

			List<Entry<Character, Character>> finalList = charMap.entrySet().stream().collect(Collectors.toList());

			Collections.sort(finalList, (a, b) -> a.getValue().compareTo(b.getValue()));

			String res = finalList.stream().map(s -> s.getKey()).map(s -> s.toString()).collect(Collectors.joining());

			System.out.println("Case #" + x + ": " + res);

		}
	}

}
