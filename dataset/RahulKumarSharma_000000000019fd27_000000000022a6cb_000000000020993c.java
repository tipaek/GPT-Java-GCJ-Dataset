import java.util.HashSet;
import java.util.Scanner;	
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int cs = 1; cs <= cases; cs++) {

			int n = sc.nextInt();

			int mat[][] = new int[n][n];

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					mat[i][j] = sc.nextInt();
				}

			int trace = 0;
			int dupRows = 0;
			int dupCols = 0;

			for (int i = 0; i < n; i++) {

				trace += mat[i][i];

				Set<Integer> dupes = new HashSet<>();

				for (int j = 0; j < n; j++) {
					if (!dupes.add(mat[i][j])) {
						dupRows++;
						break;
					}
				}

				dupes = new HashSet<>();

				for (int j = 0; j < n; j++) {
					if (!dupes.add(mat[j][i])) {
						dupCols++;
						break;
					}
				}
			}

			System.out.println("Case #" + cs + ": " + trace + " " + dupRows + " " + dupCols);
		}
		
		sc.close();
	}
}