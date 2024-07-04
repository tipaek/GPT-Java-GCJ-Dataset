
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	static Scanner scan;

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		long t = scan.nextInt();
		for (long it = 1; it <= t; ++it) {
			int u = scan.nextInt();
			String nums[] = new String[10000];
			String strs[] = new String[10000];
			Set<Character> charSet = new HashSet<>();
			for (int i = 0; i < 10000; ++i) {
				String num = scan.next("[0-9]+");
				nums[i] = num;
				String str = scan.next("[A-Z]+");
				charSet.add(str.charAt(0));
				if (str.length() > 1)
					charSet.add(str.charAt(1));
				strs[i] = str;
			}
			String res = cal(u, nums, strs, charSet);
			System.out.println("Case #" + it + ": " + res);
		}
		scan.close();
	}

	private static String cal(int u, String[] nums, String[] strs, Set<Character> charSet) {
		Map<Character, Integer> maxDigitMap = new HashMap<>();
		Map<Character, Boolean> can0Map = new HashMap<>();
		for (Character character : charSet) {
			maxDigitMap.put(character, 99);
			can0Map.put(character, true);
		}
		for (int i = 0; i < 10000; ++i) {
			String str = strs[i];
			String num = nums[i];
			char firstChar = str.charAt(0);
			can0Map.put(firstChar, false);
			if (str.length() > 1) {
				Integer firstDigit = Integer.valueOf(String.valueOf(num.charAt(0)));
				int min = Math.min(firstDigit, maxDigitMap.get(firstChar));
				maxDigitMap.put(firstChar, min);
			}
		}
		Character char0 = can0Map.entrySet().stream().filter(e -> e.getValue() == true).findFirst().get().getKey();
		String char1 = maxDigitMap.entrySet().stream().sorted(Comparator.comparingInt(e -> e.getValue()))
				.map(e -> e.getKey().toString()).collect(Collectors.joining());
		char1 = char1.substring(0, 9);
		return char0 + char1;
	}

}