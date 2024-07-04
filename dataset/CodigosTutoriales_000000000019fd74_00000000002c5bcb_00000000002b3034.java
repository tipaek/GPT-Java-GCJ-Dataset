import java.lang.*;
import java.util.*;

/**
 * Solved successfully by the Prodigy Programmer
 * @author Julian Paniagua
 */
public class Solution  {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testCases = scanner.nextInt();
		for (int t = 1; t <= testCases; t++) {
			int numberPatterns = scanner.nextInt();
			List<String> startPatterns = new ArrayList<>();
			List<String> middlePatterns = new ArrayList<>();
			List<String> mixedPatterns = new ArrayList<>();
			List<String> endPatterns = new ArrayList<>();
			String jackpot = null;
			for (int i = 0; i < numberPatterns; i++) {
				String pattern = scanner.next();
				if (!pattern.contains("*"))
					jackpot = pattern;
				else if (pattern.startsWith("*") && pattern.endsWith("*") && !mixedPatterns.contains(pattern))
					mixedPatterns.add(pattern);
				else if (pattern.endsWith("*") && !startPatterns.contains(pattern))
					startPatterns.add(pattern);
				else if (pattern.startsWith("*") && !endPatterns.contains(pattern))
					endPatterns.add(pattern);
				else if (!pattern.startsWith("*") && !pattern.endsWith("*") && !middlePatterns.contains(pattern))
					middlePatterns.add(pattern);
			}

			//Lucky I don't have to do the result
			if (jackpot != null) {
				System.out.println("Case #" + t + ": " + jackpot);
				continue;
			}

			startPatterns.sort(Comparator.comparingInt(String::length));
			middlePatterns.sort(Comparator.comparingInt(String::length));
			mixedPatterns.sort(Comparator.comparingInt(String::length));
			endPatterns.sort(Comparator.comparingInt(String::length));

			if (isListInvalid(startPatterns) || isListInvalid(endPatterns) || isListInvalid(middlePatterns) || isListInvalid(mixedPatterns)) {
				System.out.println("Case #" + t + ": *");
				continue;
			}

			String start = null, middle = null, mixed = null, end = null;
			if (startPatterns.size() > 0) start = startPatterns.get(startPatterns.size() - 1);
			if (middlePatterns.size() > 0) middle = middlePatterns.get(middlePatterns.size() - 1);
			if (mixedPatterns.size() > 0) mixed = mixedPatterns.get(mixedPatterns.size() - 1);
			if (endPatterns.size() > 0) end = endPatterns.get(endPatterns.size() - 1);

			String result = "None";
			if (middle != null) {
				if (start != null && !middle.startsWith(start)) {
					System.out.println("Case #" + t + ": *");
					continue;
				}
				if (end != null && !middle.endsWith(end)) {
					System.out.println("Case #" + t + ": *");
					continue;
				}
				result = middle.replace("*", "");
			} else if (start != null && end != null) {
				StringBuilder a = new StringBuilder();
				a.append(start.replace("*", ""));
				if (mixed != null) a.append(mixed.replace("*", ""));
				a.append(end.replace("*", ""));
				result = a.toString();
			} else if (start != null) {
				result = start.replace("*", "");
			} else if (end != null) {
				result = end.replace("*", "");
			}
			System.out.println("Case #" + t + ": " + result);
		}
	}

	public static boolean isListInvalid(List<String> list) {
		for (int i = 1; i < list.size(); i++) {
			String current = list.get(i);
			String previous = list.get(i - 1).replace("*", "(.*)");
			if (!current.matches(previous)) return true;
		}
		return false;
	}

	/*public static boolean isStartListValid(List<String> list) {
		for (int i = 1; i < list.size(); i++) {
			String current = list.get(i).substring(0, list.get(i).length() - 1);
			String previous = list.get(i - 1).substring(0, list.get(i - 1).length() - 1);

			//Same length aren't allowed as it inherently can't meet the conditions
			if (current.length() == previous.length()) return false;

			//If the current line doesn't start with the previous, something's wrong
			if (!current.startsWith(previous)) return false;
		}
		return true;
	}

	public static boolean isMiddleListValid(List<String> list) {
		for (int i = 1; i < list.size(); i++) {
			String current = list.get(i);
			String previous = list.get(i - 1);

			//Same length aren't allowed as it inherently can't meet the conditions
			if (current.length() == previous.length()) return false;


		}
		return true;
	}

	public static boolean isEndListValid(List<String> list) {
		for (int i = 1; i < list.size(); i++) {
			String current = list.get(i).substring(1);
			String previous = list.get(i - 1).substring(1);

			//Same length aren't allowed as it inherently can't meet the conditions
			if (current.length() == previous.length()) return false;

			//If the current line doesn't end with the previous, something's wrong
			if (!current.endsWith(previous)) return false;
		}
		return true;
	}

	public static boolean containsInsideList(List<String> list, String fragment) {
		for (String string : list) {
			if (string.contains(fragment)) return true;
		}
		return false;
	}*/

}