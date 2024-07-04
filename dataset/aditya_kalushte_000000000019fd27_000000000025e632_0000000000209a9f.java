
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testcases = sc.nextInt();
		for (int t = 0; t < testcases; t++) {
			String digitStr = sc.next();
			StringBuilder outputStr = new StringBuilder();

			char digitCharArr[] = digitStr.toCharArray();
			int digitArr[] = new int[digitCharArr.length];

			for (int i = 0; i < digitCharArr.length; i++) {
				digitArr[i] = Integer.parseInt(digitCharArr[i] + "");
			}

			int prevDigit = 0;
			int currDigit = 0;
			int paraCount = 0;
			char paraChar = '(';

			for (int i = 0; i < digitArr.length; i++) {

				currDigit = digitArr[i];
				paraCount = (currDigit - prevDigit);

				if (paraCount < 0) {
					paraChar = ')';
					paraCount = Math.abs(paraCount);
				} else {
					paraChar = '(';
				}

				for (int j = 0; j < paraCount; j++) {
					outputStr.append(paraChar);
				}
				outputStr.append(currDigit);
				prevDigit = currDigit;
			}

			paraChar = ')';
			for (int j = 0; j < currDigit; j++) {
				outputStr.append(paraChar);
			}

			System.out.println("Case #" + (t + 1) + ": " + outputStr);

		}
		sc.close();
	}

}
