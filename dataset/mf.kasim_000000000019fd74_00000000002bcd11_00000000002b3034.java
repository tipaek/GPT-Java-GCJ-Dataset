import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int T = s.nextInt();
//			PrintStream ps = new PrintStream(new File("out.out"));
			for (int i = 1; i <= T; i++) {
				int N = s.nextInt();
				s.nextLine();
				List<String> pList = new ArrayList<String>(N);

				for (int j = 0; j < N; j++) {
					pList.add(s.nextLine());
				}
				String result = solve(N, pList);
				System.out.println("Case #" + i + ": " + result);
			}
		}
	}

	private static String solve(int N, List<String> pList) {
		String result = "";

//		Collections.sort(pList, new StringLengthComparator());

		String longest = "";
		List<List<String>> d = new ArrayList<List<String>>(2);
		d.add(new ArrayList<String>());
		d.add(new ArrayList<String>());

		for (int i = 0; i < pList.size(); i++) {

			String[] splitList = pList.get(i).split("\\*");
//			System.out.println("spl=" + Arrays.toString(splitList));
			if (splitList.length == 2) {
				if (!splitList[0].equals(""))
					d.get(0).add(splitList[0]);
				if (!splitList[1].equals(""))
					d.get(1).add(splitList[1]);
			} else {
				if (pList.get(i).charAt(0) == '*') {
					d.get(1).add(splitList[0]);
				} else {
					d.get(0).add(splitList[0]);
				}

			}
		}

		Collections.sort(d.get(0), Collections.reverseOrder(new StringLengthComparator()));
		Collections.sort(d.get(1), Collections.reverseOrder(new StringLengthComparator()));

//		System.out.print(d.get(0) + " " + d.get(1));
		longest = "";
		if (!d.get(0).isEmpty())
			longest += d.get(0).get(0);
		if (!d.get(1).isEmpty())
			longest += d.get(1).get(0);
//		System.out.println("longest="+longest);

		for (int i = 0; i < pList.size(); i++) {

			if (!Pattern.matches(pList.get(i).replace("*", ".*"), longest)) {

				return "*";

			}

		}

		return longest;
	}

//	private static char getDigit(Scanner s, int j) {
//		System.out.println(j);
//		System.out.flush();
//		char val = Character.forDigit(s.nextInt(), 2);
//		return val;
//	}

	static class StringLengthComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {

			return o1.length() < o2.length() ? -1 : o1.length() == o2.length() ? 0 : 1;
		}

	}

}
