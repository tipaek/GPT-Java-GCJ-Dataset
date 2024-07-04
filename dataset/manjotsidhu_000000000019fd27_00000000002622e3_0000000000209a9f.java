import java.util.ArrayList;
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
			ArrayList<String> strs = new ArrayList<>();

			while (matcher.find()) {
				strs.add(matcher.group());
			}

			int tP = 0;
			int prevDigit = -1;
			for (int i = 0; i < strs.size(); i++) {
				int digit = Integer.parseInt(String.valueOf(strs.get(i).charAt(0)));

				if (i == 0) {
					tP = digit;
					for (int j = 0; j < digit; j++)
						output += "(";
				} else {
					if (prevDigit < digit)
						for (int j = 0; j < tP; j++)
							output += "(";
				}

				output += strs.get(i);

				if (i == strs.size() - 1) {
					for (int j = 0; j < digit; j++) {
						output += ")";
					}
				} else {
					int nextDigit = Integer.parseInt(String.valueOf(strs.get(i+1).charAt(0)));

					if (nextDigit > digit) {
						tP = nextDigit - digit;
					} else {
						tP = digit - nextDigit;
						for (int j = 0; j < tP; j++) {
							output += ")";
						}
					}
				}

				prevDigit = digit;
			}

			System.out.println(String.format("Case #%d: %s", c, output));
		}
    }
}
