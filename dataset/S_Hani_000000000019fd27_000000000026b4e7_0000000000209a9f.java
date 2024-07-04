import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			int nestedDepth = 0;
			String input = sc.nextLine();
			String output = "";
			for (int pos = 0; pos < input.length(); pos++) {
				int digit = Integer.parseInt(input.substring(pos, pos + 1));
				if (digit > nestedDepth) {
					for (int k = 0; k < digit - nestedDepth; k++) {
						output = output + "(";
					}
					output = output + digit;
					nestedDepth = digit;
				} else if (digit == nestedDepth) {
					output = output + digit;
				} else {
					for (int k = 0; k < nestedDepth - digit; k++) {
						output = output + ")";
					}
					output = output + digit;
					nestedDepth = digit;
				}
			}
			String op = "";
			for (int p = 0; p < Integer.parseInt(input.substring(input.length() - 1)); p++) {
				op = op + ")";
			}
			
			System.out.println("Case #" + i + ": " + output+op);
		}
		sc.close();
	}
}
