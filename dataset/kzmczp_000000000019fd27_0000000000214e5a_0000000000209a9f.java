import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			String s = sc.next();
			StringBuilder builder = new StringBuilder();
			int bracketsSoFar = 0;
			for (int j = 0; j < s.length(); j++) {
				int num = Character.getNumericValue(s.charAt(j));
				int bracketsToAdd = num - bracketsSoFar;
				char bracket = bracketsToAdd > 0 ? '(' : ')';
				repeat(bracket, Math.abs(bracketsToAdd), builder);
				builder.append(num);
				bracketsSoFar += bracketsToAdd;
			}
			repeat(')', bracketsSoFar, builder);
			System.out.println(builder.toString());
		}
	}

	private static void repeat(char c, int times, StringBuilder builder) {
		for (int i = 0; i < times; i++) {
			builder.append(c);
		}
	}
}