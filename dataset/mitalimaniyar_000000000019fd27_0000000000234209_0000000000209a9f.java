import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		String open = "(";
		String close = ")";

		int t = s.nextInt();

		List<String> answers = new ArrayList<>();

		for (int count = 1; count <= t; count++) {
			String newStr = "";

			int prev = 0;
			int index = 0;

			String str = s.next();

			for (int i = 0; i < str.length(); i++) {

				char c = str.charAt(i);
				int number = Character.getNumericValue(c);
				String subStr = "";

				if (number > prev) {
					int missing = number - prev;
					for (int k = 1; k <= missing; k++)
						subStr += open;
					subStr += number;
					for (int k = 1; k <= missing; k++)
						subStr += close;
					
					index = newStr.length() - prev;
					newStr = newStr.substring(0, index) + subStr + newStr.substring(index);
					
					prev = number;
				} else {
					index = newStr.length() - number;
					newStr = newStr.substring(0, index) + number + newStr.substring(index);
					prev = number;
				}

			}

			answers.add(newStr);
		}

		int cc = 1;
		for (String answer : answers) {
			System.out.println("Case #" + cc + ": " + answer);
			cc++;
		}

//		s.close();
	}

}