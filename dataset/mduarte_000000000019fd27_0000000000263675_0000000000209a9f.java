import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int testCase = 1; testCase <= t; ++testCase) {
			String line = in.next();

			String ans = parse(line.toCharArray());
			
			System.out.println("Case #" + testCase + ": " + ans);
		}
		in.close();

	}

	private static String parse(char[] line) {
		StringBuffer sb = new StringBuffer();
		int cur = 0;
		
		for (int i =0 ; i < line.length; i++) {
			int num = line[i] - '0';
			if (cur == 0) {
				for (int j = 0; j < num; j++) {
					sb.append("(");
					cur++;
				}
				sb.append(num);
			} else if (line[i] == line[i-1]) {
				sb.append(num);
			} else if (line[i] < line[i-1] ) {
				int diff = cur - num;
				for (int j = 0; j < diff; j++) {
					sb.append(")");
					cur--;
				}
				sb.append(num);
			} else { // bigger
				int diff = num - cur;
				// open new ones
				for (int j = 0; j < diff; j++) {
					sb.append("(");
					cur++;
				}
				sb.append(num);
			}
			//cur = num;
		}
		for (int j = 0; j < cur; j++) {
			sb.append(")");
		}
		
		
		return sb.toString();
	}

	
	
}
