import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int x = 1; x <= T; x++) {
			int N = Integer.parseInt(br.readLine());
			int xor = 0;
			String[][] M = new String[N][N];
			int[] colSum = new int[N];
			int k = 0, r = 0, c = 0;

			for (int i = 0; i < N; i++) {
				xor ^= (i + 1);
				M[i] = br.readLine().split(" ");
			}

			for (int i = 0; i < N; i++) {
				int rowSum = 0;
				for (int j = 0; j < N; j++) {
					int val = Integer.parseInt(M[i][j]);
					rowSum ^= val;
					colSum[j] ^= val;
					if (i == j)
						k += val;

					if (i == N - 1) {
						if ((colSum[j] ^ xor) != 0)
							c++;
					}
				}
				if ((rowSum ^ xor) != 0)
					r++;
			}

			System.out.println("Case #" + x + ": " + k + " " + r + " " + c);
		}
	}

}
