import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int cases = sc.nextInt();

		for (int cs = 1; cs <= cases; cs++) {

			int x = sc.nextInt();

			int y = sc.nextInt();

			boolean found = false;
			
			StringBuffer res = new StringBuffer();
			
			for (int i = 1; i < 10; i++) {
				
				if(found) {
					break;
				}

				int[][] combs = getCombinations(4, i);

				for (int[] comb : combs) {

					int x1 = 0, y1 = 0;

					res = new StringBuffer();
					
					for (int j = 0; j < comb.length; j++) {

						if (comb[j] == 0) {
							x1 += (1 << j);
							res.append("E");
						} else if (comb[j] == 1) {
							x1 -= (1 << j);
							res.append("W");
						} else if (comb[j] == 2) {
							y1 += (1 << j);
							res.append("N");
						} else if (comb[j] == 3) {
							y1 -= (1 << j);
							res.append("S");
						}
					}
					
					if((x1 == x) && (y1 == y)) {
						found = true;
						break;
					}
				}
			}
			
			System.out.println("Case #" + cs + ": " + (found ? res.toString() : "IMPOSSIBLE"));
		}

	}

	public static int[][] getCombinations(int p, int q) {

		int pow = (int) Math.pow(p, q);
		int[][] res = new int[pow][q];

		for (int i = 0; i < pow; i++) {
			int m = i;
			int k = q;
			while (m != 0) {
				res[i][--k] = m % p;
				m = m / p;
			}
		}
		return res;
	}

}
