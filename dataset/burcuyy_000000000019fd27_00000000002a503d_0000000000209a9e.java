import java.io.*;
import java.util.Scanner;
class Solution {
	public static int[] reverse (int[] arr, int n) {
		for(int i = 0; i < n/2; i++) {
			int tmp =  arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = tmp;
		}
		return arr;
	}
	public static int[] complete (int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			if (arr[i] == 0) arr[i] = 1;
			else arr[i] = 0;
		}
		return arr;
	}
	public static void answer (int[] arr) {
		for(int i: arr) {
			System.out.print(i);
		}
		System.out.println();
		System.out.flush();
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int number_of_test_cases = scan.nextInt();
		int b = scan.nextInt();
		for(int n = 1; n <= number_of_test_cases; n++) {
			int[] arr = new int[b];
			int last = -1;
			int recent = b;
			int different = -1;
			int same = -1;
			int same_value = -1;
			int different_value = -1;
			boolean cont = true;
			boolean differentIsChecked = true;
			boolean sameIsChecked = true;
			boolean differentIsChanged = false;
			boolean sameIsChanged = false;
			boolean answered = false;
			for (int i = 1; i <= 150; i++) {
			    if (i != 1 && 10%i == 1) {
					cont = false;
					if (different != -1) differentIsChecked = false;
					if (same != -1) sameIsChecked = false;
					differentIsChanged = false;
					sameIsChanged = false;
				}
				if (!cont) {
					if (!differentIsChecked) {
						differentIsChecked = true;
						System.out.println(different+1);
						System.out.flush();
						int a = scan.nextInt();
						if (a != different_value) {
							differentIsChanged = true;
							different_value = a;
						}
					} else if (!sameIsChecked) {
						sameIsChecked = true;
						System.out.println(same+1);
						System.out.flush();
						int a = scan.nextInt();
						if (a != same_value) {
							sameIsChanged = true;
							same_value = a;
						}
					} else {
						if (!differentIsChanged && sameIsChanged) {
							arr = complete(arr, b);
							arr = reverse(arr, b);
						} else if (differentIsChanged && !sameIsChanged) {
							arr = reverse(arr, b);
						}
						else if (differentIsChanged && sameIsChanged)
							arr = complete(arr, b);
						cont = true;
					}
				} 
				if (cont) {
					if (recent == last) {
						recent = b - 1 - last;
						System.out.println(recent+1);
						System.out.flush();
						arr[recent] = scan.nextInt();
						if (different == -1 && arr[last] != arr[recent]) {
							different = last;
							different_value = arr[different];
						}
						if (same == -1 && arr[last] == arr[recent]) {
							same = last;
							same_value = arr[same];
						}
					} else if (recent == b - 1 - last) {
						last ++;
						recent = last;
						System.out.println(recent+1);
						System.out.flush();
						arr[recent] = scan.nextInt();
					}
				}
				if (cont && recent == b/2) {
					answer(arr);
					answered = true;
					break;
				}

			}
			if (!answered) answer(arr);
			String str = scan.next();
			if (str.equals("N")) break;
		}

	}
}