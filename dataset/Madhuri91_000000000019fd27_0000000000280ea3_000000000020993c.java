import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {

		int n;
		int c = 1;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while (c <= n) {
			int l = sc.nextInt();
			int i, j, k = 0, rn = 0, cn = 0;
			Set<Integer> rs = new HashSet<Integer>();
			Set<Integer> cs = new HashSet<Integer>();
			int input[][] = new int[l][l];

			for (i = 0; i < l; i++) {
				for (j = 0; j < l; j++) {
					input[i][j] = sc.nextInt();
				}
			}

			for (i = 0; i < l; i++) {
				k = k + input[i][i];
			}

			for (i = 0; i < l; i++) {
				boolean br = false, bc = false;
				rs.clear();
				cs.clear();
				for (j = 0; j < l; j++) {
					if (!br) {
						if (rs.contains(input[i][j])) {
							rn++;
							br = true;
						}
						rs.add(input[i][j]);

					}
					if (!bc) {
						if (cs.contains(input[j][i])) {
							cn++;
							bc = true;
						}
						cs.add(input[j][i]);
					}
				}
			}
			System.out.println("Case #" + c + ": " + k + " " + rn + " " + cn);
			c++;
		}

	}

}
