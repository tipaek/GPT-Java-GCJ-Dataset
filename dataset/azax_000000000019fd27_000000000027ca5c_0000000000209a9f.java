import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(sc.nextLine());
		for (int index = 0; index < numCases; index++) {
			String line = sc.nextLine();
			int[] intLine = new int[line.length()];
			for (int i = 0; i < intLine.length; i++) {
				intLine[i] = Character.getNumericValue(line.charAt(i));
			}
			System.out.println(
					"Case #" + (index + 1) + ": " + parenthesize(intLine)
			);
		}
		sc.close();
	}
	
	private static String parenthesize(int[] input) {
		if (input.length == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input[0]; i++) {
			sb.append("(");
		}
		for (int index = 0; index < input.length - 1; index++) {
			int current = input[index];
			int next = input[index + 1];
			sb.append(current);
			
			if (next > current) {
				for (int i = current; i < next; i++) {
					sb.append("(");
				}
			} else if (next < current) {
				for (int i = next; i < current; i++) {
					sb.append(")");
				}
			}
		}
		sb.append(input[input.length - 1]);
		for (int i = 0; i < input[input.length - 1]; i++) {
			sb.append(")");
		}
		return sb.toString();
	}
}