import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int caseNo = in.nextInt();
		in.nextLine();
		for (int x = 0; x < caseNo; x++) {
			StringBuilder out = new StringBuilder();
			String s = in.nextLine();
			
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				int curr = Character.getNumericValue(chars[i]);
				int prev = (i == 0) ? 0 : Character.getNumericValue(chars[i - 1]);
				int next = (i == (chars.length - 1)) ? 0 :  Character.getNumericValue(chars[i + 1]);
				
				int open = Math.max(curr - prev, 0);
				for (int j = 0; j < open; j++) {
					out.append("(");
				}
				
				out.append(curr);
				
				int close = Math.max(curr - next, 0);
				for (int j = 0; j < close; j++) {
					out.append(")");
				}
			}
			
			System.out.println(String.format("Case #%d: %s", x + 1, out.toString()));
		}
	}

}