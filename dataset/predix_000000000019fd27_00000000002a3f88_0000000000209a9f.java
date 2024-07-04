import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int T;
		Scanner scanner = new Scanner(System.in);

		T = scanner.nextInt();
		scanner.nextLine();
		
		

		for (int i = 1; i < (T+1); i++) {
			boolean open = false;
			String line = scanner.nextLine();
			StringBuilder result = new StringBuilder();

			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '1') {
					if (!open) {
						result.append('(');
						open = true;
					}
					result.append('1');

				}

				if (line.charAt(j) == '0') {
					if (open) {
						result.append(')');
						open = false;
					}
					result.append('0');

				}

			}
			if (open)
				result.append(')');

			System.out.println("Case #" + i + ": " + result);

		}
		scanner.close();
		
	}

}
