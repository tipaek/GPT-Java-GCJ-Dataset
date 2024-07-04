import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseCount = 1;

		while (t > 0) {
			t--;
			int n = sc.nextInt();
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int k = 0, r = 0, c = 0;
			for (int x = 0; x < n; x++) {
				k += arr[x][x];
				boolean rowFlag = true, colFlag = true;
				Set<Integer> tempRow = new HashSet<Integer>();
				Set<Integer> tempCol = new HashSet<Integer>();

				for (int i = 0; i < n; i++) {
					if (rowFlag) {
						rowFlag = tempRow.add(arr[x][i]);
						if (!rowFlag)
							r++;
					}

					if (colFlag) {
						colFlag = tempCol.add(arr[i][x]);
						if (!colFlag)
							c++;
					}
				}
			}

			System.out.println("Case #" + caseCount + ": " + k + " " + r + " " + c);
			caseCount++;
		}
	}

}