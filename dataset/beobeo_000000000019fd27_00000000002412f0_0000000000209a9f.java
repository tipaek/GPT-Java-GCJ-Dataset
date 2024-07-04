import java.util.Scanner;


public class Solution {
	
	public static String getResult(String original) {
		int previous = 0;
		String result = "";
		for (int i = 0; i < original.length(); i++) {
			int current = Integer.parseInt(original.substring(i, i+1));
			if (current == previous) {
				result += current;
				continue;
			}
			if (current > previous) {
				for (int j = previous; j < current; j++) {
					result += "(";
				}
				result += current;
				previous = current;
				continue;
			}
			if (current < previous) {
				for (int j = previous; j > current; j--) {
					result += ")";
				}
				result += current;
				previous = current;
				continue;
			}
		}
		for (int i = previous; i > 0; i--) {
			result += ")";
		}
		return result;
	}
	
	 public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int testCases = scanner.nextInt();
			scanner.nextLine();
			for (int i = 0; i < testCases; i++) {
				System.out.println("Case #" + (i + 1) + ": " + getResult(scanner.nextLine()));
			}
		}

}