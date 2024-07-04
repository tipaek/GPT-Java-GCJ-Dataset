import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testAmount = scanner.nextInt();

		for (int testId = 1; testId <= testAmount; testId++) {
			int n = scanner.nextInt();
			String binary = Integer.toBinaryString(n);
			int binaryLength = binary.length();
			System.out.println(binary);

			int newN = n - binaryLength + 1;
			String newNBinary = Integer.toBinaryString(newN);
			System.out.println(newNBinary);
			int amountZerosNBinary = getAmountZeros(newNBinary);
			int stepsLeft = n - newN - amountZerosNBinary;

			boolean isLeft = true;
			int currentRow = 0;

			for (int i = newNBinary.length() - 1; i >= 0; i--) {
				currentRow++;
				if (newNBinary.charAt(i) == '0') {
					int c = 1;
					if (!isLeft) {
						c = currentRow;
					}
					System.out.println(currentRow + " " + c);
				} else {
					//whole Row
					if (isLeft) {
						for (int c = 1; c <= currentRow; c++) {
							System.out.println(currentRow + " " + c);
						}
					} else {
						for (int c = currentRow; c >= 1; c--) {
							System.out.println(currentRow + " " + c);
						}
					}
					isLeft = !isLeft;
				}
			}
			currentRow++;

			if (isLeft) {
				for (int i = 0; i < stepsLeft; i++) {
					System.out.println(currentRow + " 1");
				}
			} else {
				for (int i = 0; i < stepsLeft; i++) {
					System.out.println(currentRow + " " + currentRow);
				}
			}

			System.out.println("Case #" + testId + ": ");
		}
	}

	private static int getAmountZeros(String newNBinary) {
		int result = 0;
		for (char c: newNBinary.toCharArray()) {
			if (c == '0') {
				result++;
			}
		}
		return result;
	}
}
