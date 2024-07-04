import java.util.ArrayList;
import java.util.Scanner;

 class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int dummy = 0;
		int t = scanner.nextInt();
		int n, r, c, trace;
		for (int i = 0; i < t; i++) {
			n = scanner.nextInt();
			c = r = trace = 0;
			int[][] arr = new int[n][n];
//			for (int j = 0; j < n; j++) {
//				for (int j2 = 0; j2 < n; j2++) {
//					arr[j][j2] = scanner.nextInt();
//				}
//			}

			boolean rowOnce = true, colOnce = true;
			for (int j = 0; j < n; j++) {
				ArrayList<Integer> listRow = new ArrayList<Integer>();
				ArrayList<Integer> listCol = new ArrayList<Integer>();
				rowOnce = colOnce = true;
				for (int j2 = 0; j2 < n; j2++) {
					arr[j][j2] = scanner.nextInt();
					int x = arr[j][j2];
//					if (listRow.contains(x) && rowOnce) {
//						r++;
//						rowOnce = false;
//					} else {
//						listRow.add(arr[j][j2]);
//					}
//
//					if (listCol.contains(arr[j2][j]) && colOnce && j2 >= j) {
//						c++;
//						colOnce = false;
//					} else {
//						listCol.add(arr[j2][j]);
//					}
//
//					if (j == j2) {
//						trace += arr[j][j2];
//					}
				}
			}
			dummy = i + 1;
			System.out.println("Case #" + dummy + ": " + trace + " " + r + " " + c + "\n");
		}

	}

}
