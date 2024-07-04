import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int cases = Integer.parseInt(String.valueOf(sc.nextLine().charAt(0)));
	    for (int c = 1; c <= cases; c++) {
			String input = sc.nextLine();
			String output = "";
			String regex = "(\\d)\\1*";

			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(input);
			while (matcher.find()) {
				String m = matcher.group();
				int d = Integer.parseInt(String.valueOf(m.charAt(0)));

				for (int i = 0; i < d; i++) {
					m = "(" + m + ")";
				}

				output += m;
			}

			System.out.println(String.format("Case #%d: %s", c, output));
		}
    }
}