import java.util.Scanner;

public class Solution {

	public static Scanner scanner = new Scanner(System.in);

	public static int testCases;
	public static int arraySize;

	public static boolean running = true;

	public static int testPassed = 0;

	public static void main(String[] args) {

		testCases = scanner.nextInt();
		arraySize = scanner.nextInt();

		while (running) {
			running = guess();
			if (testPassed == testCases) {
				return;
			}
		}

	}

	public static boolean guess() {
		String[] array = new String[arraySize];
		int bits = 0;
		for (int i = 0; i < 5; i++) {
			System.out.print(i);
			System.out.flush();
			array[i] = scanner.next().trim();
			bits++;
		}
		for (int i = 0; i < 5; i++) {
			System.out.print(arraySize - i - 1);
			System.out.flush();
			array[arraySize - i - 1] = scanner.next().trim();
		}
		String firstChange = checkChange(array, bits);
		arrange(array, firstChange, bits);

		while(bits < arraySize / 2) {
			askForMore(array, bits);
			String change = checkChange(array, bits);
			arrange(array, change, bits);
		}

		print(array);
		String answer = scanner.next().trim();
		if ("Y".equals(answer)) {
			testPassed++;
			return true;
		} else {
			return false;
		}

	}

	public static String checkChange(String[] array, int bits) {
		String a;
		String b;
		if (isSymmetric(array, bits) || isOpposite(array, bits)) {
			System.out.print(0);
			System.out.flush();
			a = scanner.next().trim();
			System.out.print(0);
			System.out.flush();
			a = scanner.next().trim();
			if (a.equals(array[0])) {
				return "none";
			} else {
				return "opposite";
			}
		} else {
			int same = firstEqual(array, bits);
			int diff = firstDiff(array, bits);
			System.out.print(same);
			System.out.flush();
			a = scanner.next().trim();
			System.out.print(diff);
			System.out.flush();
			b = scanner.next().trim();
			if (a.equals(array[same])) {
				if (b.equals(array[diff])) {
					return "none";
				} else {
					return "reverse";
				}
			} else {
				if (b.equals(array[diff])) {
					return "reverse and opposite";
				} else {
					return "opposite";
				}
			}
		}
	}

	public static boolean isSymmetric(String[] array, int bits) {
		for (int i = 0; i < bits; i++) {
			if (!array[i].equals(array[arraySize - i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isOpposite(String[] array, int bits) {
		for (int i = 0; i < bits; i++) {
			if (array[i].equals(array[arraySize - i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static int firstEqual(String[] array, int bits) {
		for (int i = 0; i < bits; i++) {
			if (array[i].equals(array[arraySize - i - 1])) {
				return i;
			}
		}
		return -1;
	}

	public static int firstDiff(String[] array, int bits) {
		for (int i = 0; i < bits; i++) {
			if (!array[i].equals(array[arraySize - i - 1])) {
				return i;
			}
		}
		return -1;
	}

	public static void arrange(String[] array, String change, int bits) {
		switch (change) {
			case "none":
				break;
			case "reverse":
				reverse(array, bits);
				break;
			case "opposite":
				opposite(array, bits);
				break;
			case "reverse and opposite":
				reverse(array, bits);
				opposite(array, bits);
				break;
			default:
				return;
		}
	}

	public static void reverse(String[] array, int bits) {
		String[] newArray = new String[arraySize];
		for (int i = 0; i < bits; i++) {
			newArray[i] = array[arraySize - i - 1];
			newArray[arraySize - i - 1] = array[i];
		}
		array = newArray;
	}

	public static void opposite(String[] array, int bits) {
		String[] newArray = new String[arraySize];
		for (int i = 0; i < bits; i++) {
			if ("1".equals(array[i])) {
				newArray[i] = "0";
			} else {
				newArray[i] = "1";
			}
			if ("1".equals(array[arraySize - i - 1])) {
				newArray[arraySize - i - 1] = "0";
			} else {
				newArray[arraySize - i - 1] = "1";
			}
		}
		array = newArray;
	}

	public static void askForMore(String[] array, int bits) {
		int ask = Integer.min(8, arraySize - bits * 2) / 2;
		for (int i = 0; i < ask; i++) {
			System.out.print(i);
			System.out.flush();
			array[i] = scanner.next().trim();
			bits++;
		}
		for (int i = 0; i < ask; i++) {
			System.out.print(arraySize - i - 1);
			System.out.flush();
			array[arraySize - i - 1] = scanner.next().trim();
		}
	}

	public static void print(String[] array) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < arraySize; i++) {
			result.append(array[i]);
		}
		System.out.print(result.toString());
		System.out.flush();
	}

}