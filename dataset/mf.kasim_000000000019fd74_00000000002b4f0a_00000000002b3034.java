import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {

	public static void main(String[] args) {

		try (Scanner s = new Scanner(System.in)) {

			int T = s.nextInt();
			PrintStream ps = new PrintStream(new File("out.out"));
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String solve(int N, List<String> pList) {
		String result = "";

//		Collections.sort(pList, new StringLengthComparator());

		String longest = "";

		for (int i = 0; i < pList.size(); i++) {
			int x = pList.get(i).charAt(0) == '*' ? 1 : 0;

			if (longest.length() < pList.get(i).substring(x).length()) {
				longest = pList.get(i).substring(x);
			}

		}

		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).charAt(0) == '*') {

				if (!Pattern.matches("." + pList.get(i), longest)) {

					return "*";

				}
			}

		}

		return longest;
	}

	private static char getDigit(Scanner s, int j) {
		System.out.println(j);
		System.out.flush();
		char val = Character.forDigit(s.nextInt(), 2);
		return val;
	}

	/*
	 * static class StringLengthComparator implements Comparator<String> {
	 * 
	 * @Override public int compare(String o1, String o2) {
	 * 
	 * return o1.length() < o2.length() ? -1 : o1.length()== o2.length() ? 0 : 1; }
	 * 
	 * }
	 * 
	 */
}
