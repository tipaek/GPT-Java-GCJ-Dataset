import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int num = sca.nextInt();
		for (int q = 0; q < num; q++) {
			int n = sca.nextInt();
			int[][] unit = new int[n][2];
			int[]id=new int[n];
			for (int i = 0; i < n; i++) {
				unit[i][0] = sca.nextInt();
				unit[i][1] = sca.nextInt();
				id[i]=i;
			}
			boolean isDone = true;
			int m=n;
			do {
				for (int i = 0; i < m - 1; i++) {
					if (unit[i][0] > unit[i + 1][0]) {
						id[i]+=id[i+1]-(id[i+1]=id[i]);
						unit[i][0] += unit[i + 1][0] - (unit[i + 1][0] = unit[i][0]);
						unit[i][1] += unit[i + 1][1] - (unit[i + 1][1] = unit[i][1]);
						isDone = false;
					}
				}
				m--;
			} while (isDone == false && m > 1);
			
			boolean isImpossible = false;
			int c = 0, j = 0;
			for (int i = 0; i < n; i++) {
				if (unit[i][0] >= c) {
					c = unit[i][1];
					unit[i][0] = 0;
				} else if (unit[i][0] >= j) {
					j = unit[i][1];
					unit[i][0] = 1;
				} else {
					isImpossible = true;
					break;
				}
			}

			if (isImpossible) {
				System.out.println("Case #" + (q + 1) + ": IMPOSSIBLE");
			} else {
				System.out.print("Case #" + (q + 1) + ": ");
				for (int i = 0; i < n; i++) {
					if (unit[id[i]][0] == 0) {
						System.out.print("C");
					} else {
						System.out.print("J");
					}
				}
				System.out.println();

			}
		}
	}
}