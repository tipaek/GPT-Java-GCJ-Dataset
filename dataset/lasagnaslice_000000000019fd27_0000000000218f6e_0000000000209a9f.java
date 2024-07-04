import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int d;
		int times = input.nextInt();
		input.nextLine();
		for (d = 0; d < times; d++) {
//
		String givenstring = input.nextLine();
		int[] given = new int[givenstring.length()];
		int i;
		int j;
		for (i = 0; i < givenstring.length(); i++)
			given[i] = Character.getNumericValue(givenstring.charAt(i));
		int[] differences = new int[given.length + 1];
		differences[0] = given[0];
		for (i = 1; i < given.length; i++)
			differences[i] = given[i] - given[i - 1];
		differences[given.length] = -given[given.length - 1];
		System.out.print("Case #" + (d + 1) + ": ");
		for (j = 0; j < differences[0]; j++)
			System.out.print("(");
		System.out.print(given[0]);
		for (i = 1; i < differences.length - 1; i++) {
			if (differences[i] > 0) {
				for (j = 0; j < differences[i]; j++)
					System.out.print("(");
			}
			else if (differences[i] < 0) {
				for (j = 0; j < -(differences[i]); j++)
					System.out.print(")");
			}
			System.out.print(given[i]);
		}
		for (j = 0; j < -(differences[given.length]); j++)
			System.out.print(")");
		System.out.println();
//
		}
	}
}