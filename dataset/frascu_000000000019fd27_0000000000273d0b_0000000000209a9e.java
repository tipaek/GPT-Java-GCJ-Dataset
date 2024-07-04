import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int t = scanner.nextInt();
			int b = scanner.nextInt();

			for (int j = 0; j < t; j++) {

				char[] result = new char[b];
				for (int i = 0; i < b; i++) {
					System.out.println(i + 1);
					result[i] = scanner.next().charAt(0);
				}

				System.out.println(new String(result));
			
				char response = scanner.next().charAt(0);
				if (response == 'N') {
					break;
				}
			}
		}
	}
}
