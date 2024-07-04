import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();
		int temp = 1;
		while (temp <= t) {

			String s = scn.next();
			boolean check = SameOrNot(s);
			if (check == true) {
				if (s.charAt(0) == '0') {
					System.out.println("Case #" + temp + ": " + s);
					temp++;
				} else {

					System.out.println("Case #" + temp + ": " + "(" + s + ")");
					temp++;
				}

			} else {
				ArrayList<Integer> list = new ArrayList<>();
				char first = s.charAt(0);
				int one = 0;
				int zeroes = 0;
				for (int i = 0; i < s.length() - 1; i++) {
					char ch = s.charAt(i);
					if (ch == '1') {
						if (s.charAt(i + 1) == '0') {
							one++;
							list.add(one);
							one = 0;
						}
						if (s.charAt(i + 1) == '1')
							one++;
					} else if (ch == '0') {
						if (s.charAt(i + 1) == '1') {
							zeroes++;
							list.add(zeroes);
							zeroes = 0;
						}
						if (s.charAt(i + 1) == '0')
							zeroes++;
					} else {
					}
				}
				int last = 0;
				for (int i = s.length() - 1; i >= 0; i--) {
					char ch = s.charAt(i);
					if (ch == '1') {
						if (s.charAt(i - 1) == '0') {
							last++;
							list.add(last);
							break;

						}
						if (s.charAt(i - 1) == '1')
							last++;
					} else if (ch == '0') {
						if (s.charAt(i - 1) == '1') {
							last++;
							list.add(last);
							break;

						}
						if (s.charAt(i - 1) == '0')
							last++;
					} else {
					}
				}
//		System.out.println(last);
//		list.add(last);
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(list.get(i) + " ");
//			}
				String ans = "";
				if (first == '0') {

					int p = 0;
					int i = 0;
					for (int val : list) {
						if (i % 2 == 0) {
							for (int j = 0; j < val; j++) {
								ans = ans + "0";
							}
						} else {
							ans = ans + "(";
							for (int k = 0; k < val; k++) {
								ans = ans + "1";
							}
							ans = ans + ")";

						}
						i++;

					}

				} else if (first == '1') {

					int p = 0;
					int i = 0;
					for (int val : list) {
						if (i % 2 == 1) {
							for (int j = 0; j < val; j++) {
								ans = ans + "0";
							}
						} else {
							ans = ans + "(";
							for (int k = 0; k < val; k++) {
								ans = ans + "1";
							}
							ans = ans + ")";

						}
						i++;

					}

				}
				System.out.println("Case #" + temp + ": " + ans);
				temp++;
			}

		}
	}

	public static boolean SameOrNot(String s) {
		int len = s.length();

		char ch = s.charAt(0);

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != ch) {
				return false;
			}
		}
		return true;
	}
}