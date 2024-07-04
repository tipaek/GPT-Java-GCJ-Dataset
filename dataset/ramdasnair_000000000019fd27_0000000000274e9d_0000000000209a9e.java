import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int t = input.nextInt();

		for (int x = 0; x < t; x++ ) {
			int b = input.nextInt();

			StringBuilder result = new StringBuilder();
			for(int i = 1; i <= 10; i++) {
				System.out.println(i);
				String out = input.next();
				result.append(out);
			}

			System.out.println(result);

			String output = input.next();
			if ("Y".equals(output)) {
				continue;
			} else {
				return;
			}
		}

	}

	
}
