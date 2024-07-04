import java.util.*;
import java.io.*;
class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int n, size;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		for (int k = 0; k < n; k++) {
			size = s.nextInt();
			int arr[][] = new int[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					arr[i][j] = s.nextInt();
				}
			}
			int finalNumber = 0;
			int rowNumber = 0;
			int colunmNumber = 0;
			for (int j = 0; j < size; j++) {
				for (int m = 0; m < size; m++) {
					if (j == m) {
						finalNumber = finalNumber + arr[j][m];
					}
				}
			}
			for (int t = 0; t < size; t++) {
				int rowArr[] = new int[size];
				for (int j = 0; j < size; j++) {
					rowArr[j] = arr[t][j];
				}
				if (checkDuplicate(rowArr)) {
					rowNumber = ++rowNumber;
				}
			}
			for (int t = 0; t < size; t++) {
				int colArr[] = new int[size];
				for (int j = 0; j < size; j++) {
					colArr[j] = arr[j][t];
				}
				if (checkDuplicate(colArr)) {
					colunmNumber = ++colunmNumber;
				}	
			}
			System.out.println("Case #" + (k + 1) + ": " + finalNumber + " " + rowNumber + " " + colunmNumber);
		}
	}

	private static boolean checkDuplicate(int[] value) {

		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value.length; j++) {
				if ((i != j) && value[i] == value[j]) {
					return true;
				}
			}
		}
		return false;
	}

}