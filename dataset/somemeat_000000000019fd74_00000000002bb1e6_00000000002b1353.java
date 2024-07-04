import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] tri = new int[50][50];
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j <= i; j++)
				if (j == 0 || j == i) {
					tri[i][j] = 1;
				} else {
					tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
				}
		}
		// System.out.println(Arrays.deepToString(a));
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			int r = 1;
			int k = 1;
			boolean onetime = false;
			System.out.println("Case #" + (i + 1) + ": ");
			// System.out.println("1 1");
			while (sum < N) {
				if (onetime) {
					boolean update = false;
					if (r % 2 == 0) {
						k = 1;
					} else {
						k = r;
						update = true;
					}
					while (sum != N) {
						if (update) {
							k = r;
						}
						sum++;
						System.out.println(r + " " + k);
						r++;
					}
					break;
				} else {
					if (sum + Math.pow(2, r - 1) > N) {
						onetime = true;
						continue;
					}
					sum += Math.pow(2, r - 1);
					if (r % 2 == 0) {
						for (int j = 1; j <= r; j++) {
							System.out.println(r + " " + j);
						}
					} else {
						for (int j = r; j > 0; j--) {
							System.out.println(r + " " + j);
						}
					}
					r++;
				}
			}
		}
	}

}
