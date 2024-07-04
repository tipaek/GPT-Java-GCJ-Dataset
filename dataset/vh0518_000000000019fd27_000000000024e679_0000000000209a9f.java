import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		int tc = 1;
		sc.nextLine();
		while (tc <= t) {

			String str = sc.nextLine();
			calculate(str.toCharArray(), tc);
			tc++;

		}

	}

	private static void calculate(char[] str, int tc) {
		String ans = "";
		boolean check = false;

		for (int i = 0; i < str.length; i++) {
			if (str[i] == '1') {
				if (!check) {
					ans += "(";
					check = true;
				}
				ans += str[i];

			} else {
				if (check) {
					ans += ")";
					check = false;
				}
				ans += str[i];

			}

		}
		if (str[str.length - 1] == '1') {
			ans += ")";
		}
		System.out.println("Case #" + tc + ":" + " " + String.valueOf(ans));

	}

}
