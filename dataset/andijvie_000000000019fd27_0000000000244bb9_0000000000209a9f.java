import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rows = scanIntLine(scanner);
		for(int i = 0; i < rows; i++) {
			String input = scanner.nextLine();
			System.out.println(shortestDepth(input));
		}
	}
	public static int scanIntLine(Scanner scanner) {
		int output = scanner.nextInt();
		scanner.nextLine();
		return output;
	}
	public static String shortestDepth(String input) {
		String output = "";
		int depth = 0;
		for(int i = 0; i < input.length(); i++) {
			int diff = depth - Character.getNumericValue(input.charAt(i));
			depth = Character.getNumericValue(input.charAt(i));
			String dir;
			if(diff > 0)
				dir = "close";
			else {
				diff *= -1;
				dir = "open";
			}
			for(int j = 0; j < diff; j++) {
				if(dir.contentEquals("open")) 
					output += "(";
				else
					output += ")";
			}
			output += input.charAt(i);
		}
		for(int i = 0; i < depth; i++) {
			output+=")";
		}
		return output;
	}
}
