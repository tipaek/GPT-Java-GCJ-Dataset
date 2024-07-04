import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numberOfCases = in.nextInt();
		in.nextLine();
		for (int i = 0; i < numberOfCases; i++) {
			int score = 0;
			String output = "";
			for (char c : in.nextLine().toCharArray()) {
				int n = Character.getNumericValue(c);

				while (n - score > 0) {
					score++;
					output += "(";
				}

				while (n - score < 0) {
					score--;
					output += ")";
				}
				output += c;
			}

			while (score > 0) {
				score--;
				output += ")";
			}
			System.out.println("Case #" + (i + 1) + ": " + output);
		}
	}
}
