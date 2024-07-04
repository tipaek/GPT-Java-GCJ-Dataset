

import java.util.HashSet;
import java.util.Scanner;

class Vestigium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;
		while (T-- > 0) {
			int N = sc.nextInt();
			int a[][] = new int[N][N];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			int k = 0, r = 0, c = 0;
			for (int i = 0; i < a.length; i++) {
				k += a[i][i];

				HashSet<Integer> checkRow = new HashSet<>();
				for (int j = 0; j < a.length; j++) {
					if (checkRow.contains(a[i][j])) {
						r++;
						break;
					} else {
						checkRow.add(a[i][j]);
					}
				}
				
				HashSet<Integer> checkCol = new HashSet<>();
				for (int j = 0; j < a.length; j++) {
					if (checkCol.contains(a[j][i])) {
						c++;
						break;
					} else {
						checkCol.add(a[j][i]);
					}
				}
			}
			System.out.printf("Case #%d: %d %d %d\n", tc++, k, r, c);
		}


	}
}
