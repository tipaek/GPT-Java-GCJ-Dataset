import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; ++i) {
			String binary = in.nextLine();
			Pattern pattern = Pattern.compile("0+|1+|2+|3+|4+|5+|6+|7+|8+|9");
			Matcher matcher = pattern.matcher(binary);
			String output = "";
			int b = 0; // Number of brackets
			while (matcher.find()) {
				// Case 0
				String res = new String(matcher.group(0));
				if (res.charAt(0) == '0') {
					output += ")".repeat(b) + res;
				}

				// No active bracket
				else if (b == 0) {
					b = Integer.parseInt(String.valueOf(res.charAt(0)));
					output += "(".repeat(b) + res;

				} else if (b != 0) {
					if (Integer.parseInt(String.valueOf(res.charAt(0))) >= b) {
						output += "(".repeat(Integer.parseInt(String.valueOf(res.charAt(0))) - b) + res;
					} else {
						b = b - Integer.parseInt(String.valueOf(res.charAt(0)));
						output += ")".repeat(b) + res;
					}
				}
				b = Integer.parseInt(String.valueOf(res.charAt(0)));
			}
			output = output + ")".repeat(b);
			System.out.println("Case #" + Integer.toString((i + 1)) + ": " + output);
		}
	}

}