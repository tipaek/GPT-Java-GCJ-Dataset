import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		//System.setIn(new FileInputStream(new File("src/codeJam2020/round1/nestingDepths/test.txt")));

		try(Scanner sc = new Scanner(System.in)) {
			int testCases = sc.nextInt();

			for (int i = 0; i < testCases; i++) {
				String s = sc.next();
				String[] digits = s.split("");
				StringBuilder sb = new StringBuilder();

				int toClose = 0;
				int lastDigit = 0;
				for (int j = 0; j < digits.length; j++) {
					int digit = Integer.parseInt(digits[j]);

					if(digit == lastDigit) {
						sb.append(digit);
					} else {
						if (digit > toClose) {
							int openingNow = digit - toClose;
							for (int k = 0; k < openingNow; k++) {
								sb.append("(");
							}
							sb.append(digit);
							toClose = digit;
						} else if (digit < toClose) {
							int closingNow = toClose - digit;
							for (int k = 0; k < closingNow; k++) {
								sb.append(")");
							}
							sb.append(digit);
							toClose = digit;
						} else {
							sb.append(digit);
						}
					}

					lastDigit = digit;
				}

				for (int j = 0; j < toClose; j++) {
					sb.append(")");
				}

				System.out.println("Case #" +  (i + 1) + ": " + sb.toString());
			}
		}
	}
}