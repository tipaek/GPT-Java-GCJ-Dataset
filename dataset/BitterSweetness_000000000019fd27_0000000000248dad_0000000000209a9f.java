import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine());
		for (int i = 0; i < t; ++i) {
			String binary = in.nextLine();
			Pattern pattern = Pattern.compile("0+|1+");
			Matcher matcher = pattern.matcher(binary);
			String output = "";
			while (matcher.find()) {
				if (matcher.group(0).charAt(0) == '1') {
					output += "(";
					output += matcher.group(0);
					output += ")";
				} else {
					output += matcher.group(0);
				}
				
			}
			System.out.println("Case #"+Integer.toString((i+1))+": " + output);
		}
	}

}
