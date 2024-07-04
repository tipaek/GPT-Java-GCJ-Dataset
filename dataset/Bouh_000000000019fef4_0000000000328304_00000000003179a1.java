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
			int U = scanner.nextInt();
			List<String> strs = new ArrayList<>();
			for (int j = 0; j < 10000; j++) {
				scanner.nextInt();
				strs.add(scanner.next());
			}
			result+="Case #" + i + ": " + solveCase(strs) + "\n";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public static String solveCase(List<String> strs) {
		String ALPH = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Map<String, Integer> chars = new HashMap<>();
		for(int i = 0; i < 26; i++) {
			chars.put(ALPH.substring(i, i + 1), 0);
		}
		for(String str : strs) {
			for(int i = 0; i < str.length(); i++) {
				String letter = str.substring(i, i + 1);
				chars.put(str.substring(i, i + 1), chars.get(letter) + 1);
			}
		}
		List<Integer> values = new ArrayList<>(chars.values());
		List<Integer> newValues = new ArrayList<>();
		for(Integer value : values) {
			if (value != 0) {
				newValues.add(value);
			}
		}
		if (newValues.size() != 10) {
			throw new RuntimeException("Il faut 10 chiffres");
		}
		Collections.sort(newValues);
		String result = "";
		result+=findValue(newValues.get(0), chars);
		result+=findValue(newValues.get(9), chars);
		result+=findValue(newValues.get(8), chars);
		result+=findValue(newValues.get(7), chars);
		result+=findValue(newValues.get(6), chars);
		result+=findValue(newValues.get(5), chars);
		result+=findValue(newValues.get(4), chars);
		result+=findValue(newValues.get(3), chars);
		result+=findValue(newValues.get(2), chars);
		result+=findValue(newValues.get(1), chars);
		return result;
	}
	
	public static String findValue(Integer value, Map<String, Integer> chars) {
		for(String str : chars.keySet()) {
			if (chars.get(str).equals(value)) {
				return str;
			}
		}
		throw new RuntimeException("Impossible");
	}
	
	
}
