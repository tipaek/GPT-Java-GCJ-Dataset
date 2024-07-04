import java.util.Scanner;

class Solution {

	private static final int UNKNOWN = -1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testAmount = scan.nextInt();
		int bitsAmount = scan.nextInt();

		for (int test = 1; test <= testAmount; test++) {
			int[] bits = new int[bitsAmount+1];

			for (int i = 0; i <= bitsAmount; i++) {
				bits[i] = UNKNOWN;
			}

			int indexSame = UNKNOWN;
			int indexDifferent = UNKNOWN;
			int currentIndex = 1;

			for (int query = 0; query < 150; query++) {
				if (query == 0) {
					System.out.println("1");
					scan.nextInt();
					continue;
				}

				if (query == 1 || query % 10 != 1) {
					if (currentIndex > bitsAmount / 2) {
						break;
					} else if (bits[currentIndex] == UNKNOWN) {
						System.out.println(currentIndex);
						bits[currentIndex] = scan.nextInt();
					} else {
						System.out.println(bitsAmount - currentIndex + 1);
						bits[bitsAmount - currentIndex + 1] = scan.nextInt();

						if (bits[currentIndex] == bits[bitsAmount - currentIndex + 1]) {
							indexSame = currentIndex;
						} else {
							indexDifferent = currentIndex;
						}
						currentIndex++;
					}
				} else { //quantum fluctation happened after the last turn
					if (indexDifferent == UNKNOWN || indexSame == UNKNOWN) {
						System.out.println("1");
						int queryResult = scan.nextInt();

						if (queryResult != bits[1]) { //array is complemented or reversed and complemented
							complementArray(bits);
						}
					} else {
						System.out.println(indexSame);
						int queryResult1 = scan.nextInt();
						System.out.println(indexDifferent);
						int queryResult2 = scan.nextInt();

						if (queryResult1 != bits[indexSame]) { //complemented or reversed and complemented
							if (queryResult2 == bits[indexDifferent]) {
								reverseArray(bits);
							}
							complementArray(bits);
						} else { //nothing or reversed
							if (queryResult2 != bits[indexDifferent]) { //reversed
								reverseArray(bits);
							}
						}
						query++;
					}
				}
			}

			outputArr(bits);
			boolean isCorrect = scan.next().equals("Y");

			if (!isCorrect) {
				return;
			}
		}
	}

	private static void outputArr(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	private static void reverseArray(int[] arr) {
		for (int i = 1; i <= arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length - i];
			arr[arr.length - i] = tmp;
		}
	}

	private static void complementArray(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				arr[i] = 1;
			} else if (arr[i] == 1){
				arr[i] = 0;
			}
		}
	}
}