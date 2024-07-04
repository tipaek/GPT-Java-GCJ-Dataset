import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = scan.nextInt();
		scan.nextLine();
		for (int c = 1; c <= numCases; c++) {
			String current = scan.nextLine();
			solution(c, current);
		}
		scan.close();
	}
	public static void solution(int caseNum, String s) {
		StringBuilder sb = new StringBuilder(s);
		char[] sAsChars = s.toCharArray();
		int[] sAsInts = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			sAsInts[i] = Character.getNumericValue(sAsChars[i]);
		}
//		System.out.println(sAsInts.toString());
		int offset = sAsInts[0];
		addParens(sAsInts[0], 0, '(', sb);
		for (int i = 1; i < s.length(); i++) {
			if (sAsInts[i] < sAsInts[i - 1]) {
				addParens(sAsInts[i - 1] - sAsInts[i], i + offset, ')', sb);
				offset += sAsInts[i - 1] - sAsInts[i];
			} else if (sAsInts[i] > sAsInts[i - 1]) {
				addParens(sAsInts[i] - sAsInts[i - 1], i + offset, '(', sb);
				offset += sAsInts[i] - sAsInts[i - 1];
			}
		}
		addParens(sAsInts[s.length() - 1], s.length() + offset, ')', sb);
		System.out.printf("Case #%d: %s\n", caseNum, sb.toString());
	}
	
	public static void addParens(int n, int position, char paren, StringBuilder sb) {
		for (int i = 0; i < n; i++) {
			sb.insert(position, paren);
		}
	}
	
}
