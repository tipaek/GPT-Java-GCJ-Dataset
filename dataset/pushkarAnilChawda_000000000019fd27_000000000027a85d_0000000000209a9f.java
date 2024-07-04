import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String s = sc.next();
			String result = perform(s);

			System.out.println("Case #" + i + ": " + result);

		}
		
		sc.close();
	}

	private static String perform(String s) {
		String result = "";
		int difference = 0, count = 0, curr = 0;
		char ch[] = s.toCharArray();
		curr = ch[0];
		curr = curr - '0';

		if (curr > 0) {
			for (int j = 1; j <= curr; j++) {
				result += '(';
				count++;
			}

		}
		result += curr;

		for (int k = 1; k < s.length(); k++) {
			curr = ch[k] - '0';
			int prev = ch[k - 1] - '0';
			if (prev < curr) {
				difference = curr - prev;
				for (int j = 1; j <= difference; j++) {
					result += '(';
					count++;
				}

			} else if (prev > curr) {
				difference = prev - curr;
				for (int j = 1; j <= difference; j++) {
					result += ')';
					count--;
				}
			}

			result += curr;

		}

		for (int j = 1; j <= count; j++) {
			result += ')';
		}

		return result;
	}

}