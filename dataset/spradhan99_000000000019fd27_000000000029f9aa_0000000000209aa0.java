import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());

		String[][] inputs = new String[t][2];

		for (int i = 0; i < t; i++) {
			String[] n_k = br.readLine().trim().split(" ");
			inputs[i] = n_k;
		}

		br.close();

		for (int i = 0; i < t; i++) {
			String[] n_k = inputs[i];
			int n = Integer.valueOf(n_k[0]);
			int k = Integer.valueOf(n_k[1]);
			Integer q = isPossible(n, k);

			if (q != null) {
				System.out.println("Case #" + (i + 1) + ": POSSIBLE");
				int[][] latinMatrix = createLatinMatrix(n, q);
				for (int[] row : latinMatrix) {
					String rowStr = Arrays.toString(row);
					rowStr = rowStr.replaceAll(",", " ").replace("[", "").replace("]", "");
					System.out.println(rowStr);
				}
			} else {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
		}
	}

	private static int[][] createLatinMatrix(int n, int q) {
		int[][] magicMatrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = (q - i + j+n)%n;
				if(num == 0) {
					num = n;
				}
				magicMatrix[i][j] = num;
			}
		}

		return magicMatrix;
	}

	private static Integer isPossible(int n, int k) {
		int q = k / n;
		int r = k % n;
		if (r == 0 && q >= 1 && q <= n) {
			return q;
		}
		return null;
	}

}
