import java.util.Scanner;

public class Solution {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int test = sc.nextInt();
		int op = 1;
		while (op <= test) {

			String n = sc.next();
			int[] arr = new int[n.length()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = (int) (n.charAt(i)) - 48;
			}
			System.out.print("Case #" + op + ": ");
			answer(arr);
			System.out.println();
			op++;
		}
	}

	public static void answer(int[] arr) {

		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				counter = arr[i];
				for (int j = 0; j < counter; j++)
					System.out.print("(");
				System.out.print(arr[i]);
			} else {
				if (counter < arr[i]) {
					for (int j = 0; j < arr[i] - counter; j++)
						System.out.print("(");
					System.out.print(arr[i]);
					counter = arr[i];
				} else if (counter == arr[i]) {
					System.out.print(arr[i]);

				} else {
					for (int j = 0; j < counter - arr[i]; j++)
						System.out.print(")");
					System.out.print(arr[i]);

					counter = arr[i];
				}
			}
			if (i == arr.length - 1) {
				for (int j = 0; j < counter; j++)
					System.out.print(")");
			}
		}

	}
}