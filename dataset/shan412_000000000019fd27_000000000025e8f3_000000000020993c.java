import java.util.*;
class Matrix {
	static int trace(int ar[][]) {
		int trace = 0;
		for (int i = 0; i < ar.length; i++) {
			trace += ar[i][i];
		}
		return trace;
	}

	static int countrows(int ar[][]) {
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length - 1; j++) {
				if (ar[i][j] == ar[i][j + 1]) {
					flag = true;
				}
			}
			if (flag)
				count++;
			else
				count = 0;
		}
		return count;
	}

	static int countcolumns(int ar[][]) {
		int count = 0;
		boolean flag = false;
		int arr[] = new int[ar.length];
		for (int k = 0; k < ar.length; k++) {
			for (int j = 0; j < ar.length; j++) {
				arr[j] = ar[j][k];
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length - 1; j++) {
					if (arr[i] == arr[j + 1] && i != j + 1) {
						flag = true;
					}
				}
			}
			if (flag)
				count++;
			flag = false;

		}
		return count;
	}

	public static void main(String args[]) throws NumberFormatException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int no = 1; no <= n; no++) {
			int m = sc.nextInt();

			sc.nextLine();
			int[][] myArray = new int[m][m];
			for (int i = 0; i < myArray.length; i++) {
				String[] line = sc.nextLine().trim().split(" ");
				for (int j = 0; j < myArray.length; j++) {
					myArray[i][j] = Integer.parseInt(line[j]);
				}
			}
			System.out.println("Case #" + no + ": " + trace(myArray) + " " + countrows(myArray) + " "
					+ countcolumns(myArray) + " ");
		}
	}
}
