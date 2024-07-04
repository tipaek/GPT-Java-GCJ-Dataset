import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=1;i<=t;i++) {

			int n = sc.nextInt();
			int[][] square = new int[n][n];
			for (int j=0;j<n;j++) {
				for (int k=0;k<n;k++) {
					square[j][k]=sc.nextInt();
				}
			}
			
			int trace = 0;
			for (int j=0;j<n;j++) {
				trace += square[j][j];
			}
			
			int repeatedRows = 0;
			for (int j=0;j<n;j++) {
				HashSet<Integer> set = new HashSet<>();
				for (int k=0;k<n;k++) {
					if (set.contains(square[j][k])) {
						repeatedRows++;
						break;
					} else {
						set.add(square[j][k]);
					}
				}
			}

			int repeatedColumns = 0;
			for (int k=0;k<n;k++) {
				HashSet<Integer> set = new HashSet<>();
				for (int j=0;j<n;j++) {
					if (set.contains(square[j][k])) {
						repeatedColumns++;
						break;
					} else {
						set.add(square[j][k]);
					}
				}
			}
			
			System.out.println("Case #"+i+": "+trace + " " + repeatedRows + " " + repeatedColumns);
		}
	}

}
