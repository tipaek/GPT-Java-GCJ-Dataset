import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		List<String> l = new ArrayList<>();
		String str;

		while (t >= 1 && t <= 100 && t-- > 0) {
			str = s.next();
			if (str.length() >= 1 & str.length() <= 100)
				l.add(str);
		}
		s.close();

		// solve Problem
		if (l.size() > 0) {
			for (int i = 0; i < l.size(); i++) {
				System.out.println("Case #" + (i + 1) + ": "
						+ calculateNewString(l.get(i)));
			}
		}
	}

	private static List<Character> stoL(StringBuilder s) {

		List<Character> l = new ArrayList<>();
		char[] arr = s.toString().toCharArray();
		for (char c : arr) {
			l.add(c);
		}
		return l;
	}

	private static int cob(StringBuilder s) {
		int count = 0;
		List<Character> l = stoL(s);
		if (l.size() > 0) {
			count = Collections.frequency(l, '(')
					- Collections.frequency(l, ')');
		}
		return count >= 0 ? count : -1;
	}

	private static StringBuilder addInStartTo(StringBuilder newString,
			String addWith, int count, char val) {

		for (int i = 0; i < count; i++) {
			newString.append(addWith);
		}
		newString.append(val);
		newString.toString().trim();

		return newString;
	}

	private static String calculateNewString(String s) {
		StringBuilder newString = new StringBuilder("");
		int times = 0;
		for (int i = 0; i < s.length(); i++) {

			int n = Integer.parseInt(String.valueOf(s.charAt(i)));

			if (i == 0) {
				newString = addInStartTo(newString, "(", n, s.charAt(i));
			}

			if (i != 0) {
				int a = Integer.parseInt(String.valueOf(s.charAt(i)));
				int aminus = Integer.parseInt(String.valueOf(s.charAt(i - 1)));
				times = cob(newString);
				if (a < aminus) {
					newString = addUpAs("sub", newString, ")", times - a,
							s.charAt(i));
				} else if (a == aminus) {
					addUpAs("nothing", newString, "", 0, s.charAt(i));
				} else {
					newString = addUpAs("add", newString, "(", a - times,
							s.charAt(i));
				}
			}
			if (i == (s.length() - 1)) {
				times = cob(newString);
				newString = addUpAs("sub", newString, ")", times, ' ');
			}
		}

		return newString.toString();
	}

	private static StringBuilder addUpAs(String action,
			StringBuilder newString, String opr, int times, char AddTo) {

		if (action.equalsIgnoreCase("add")) {

			newString = addInStartTo(newString, opr, times, AddTo);

		} else if (action.equalsIgnoreCase("sub")) {
			newString = addInStartTo(newString, opr, times, AddTo);
		} else if (action.equalsIgnoreCase("nothing")) {
			newString = addInStartTo(newString, opr, times, AddTo);
		} else {
		}

		return newString;
	}
}
