import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int ncases = sc.nextInt();
		for (int ncase = 1; ncase <= ncases; ncase++) {
			int size = sc.nextInt();
			int[][] m1 = new int[size][size];
			int[][] m2 = new int[size][size];
			int trace = 0;
			for (int i=0; i<size; i++) {
				for (int j=0; j<size; j++) {
					m1[i][j] = sc.nextInt();
					m2[j][i] = m1[i][j];
					if (i == j) trace += m1[i][j];
				}	
			}
			int rrows = 0;
			int rcols = 0;
			for (int i=0; i<size; i++) {
				rrows += Arrays.stream(m1[i])
						.distinct()
						.count() < size? 1: 0;
				rcols += Arrays.stream(m2[i])
					.distinct()
					.count() < size? 1: 0;
			}
			System.out.println(String.format("Case #%s: %d %d %d", ncase, trace, rrows, rcols));
		}
	}
}
