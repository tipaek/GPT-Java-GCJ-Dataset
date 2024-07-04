import java.util.*;
import java.io.*;

public class Solution{
	public static final int limit = 150;
	public static int sameIndex;
	public static int diffIndex;

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int b = in.nextInt();
		for (int i = 1; i <= t; i++) {
			solve(b, i, in);
		}
	}

	public static void solve(int b, int num, Scanner in) {
		sameIndex = -1;
		diffIndex = -1;
		int[] array = new int[b];
		if (b <= 10) {
			for (int i = 0; i < b; i++) {
				System.out.println(i + 1);
				array[i] = in.nextInt();
			}
			for (int i = 0; i < b; i++) {
				System.out.print(array[i]);
			}
			return;
		}
		int index = 0;
		while (!criteriaAreMet(array, index, b)) {
			for (int i = 0; i < b; i++) {
				array[i] = -1;
			}
			fillArray(index, array, b, in);
			index += 5;
		}
		boolean workToDo = true;
		while (workToDo) {

			System.out.println(sameIndex + 1);
			int res = in.nextInt();
			if (res == array[sameIndex]) {
				System.out.println(diffIndex + 1);
				res = in.nextInt();
				if (res == array[diffIndex]) {
					// same
				} else {
					// reversed
					reverse(array);
				}
			} else {
				System.out.println(diffIndex + 1);
				res = in.nextInt();
				if (res == array[diffIndex]) {
					// comp & reversed
					reverse(array);
					complement(array);
				} else {
					// comp
					complement(array);
				}
			}

			for (int i = 0; i < 8; i++) {
				int ind = giveIndex(array);
				if (ind == -1) {
					workToDo = false;
					break;
				}

				System.out.println(ind + 1);
				array[ind] = in.nextInt();
			}
		}
		
		for(int i = 0; i < b; i++) {
			System.out.print(array[i]);
		}
	}
	
	public static void reverse(int[] arr) {
		int[] oldarray = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			oldarray[i] = arr[i];
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = oldarray[arr.length - 1 - i];
		}
	}
	
	public static void complement(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = 1;
			} else if(arr[i] == 1) {
				arr[i] = 0;
			}
		}
	}

	public static boolean criteriaAreMet(int[] arr, int index, int b) {
		boolean same = false;
		boolean diff = false;
		for (int i = 0; i < index; i++) {
			if (arr[i] == arr[b - 1 - i]) {
				same = true;
				if (sameIndex == -1)
					sameIndex = i;
			} else {
				diff = true;
				if (diffIndex == -1)
					diffIndex = i;
			}
		}
		return same && diff;
	}

	public static void fillArray(int index, int[] arr, int b, Scanner in) {
		for (int i = index; i < index + 5; i++) {
			System.out.println(i + 1);
			arr[i] = in.nextInt();
			System.out.println(b - i);
			arr[b - 1 - i] = in.nextInt();
		}
	}

	public static int giveIndex(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1)
				return i;
		}
		return -1;
	}
}