
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {

	static HashMap<Integer, String> output = new HashMap<Integer, String>();

	public static void main(String[] args) {
		int T, N, K;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			T = Integer.valueOf(br.readLine().trim());
			for (int t = 0; t < T; t++) {
				String NK[] = br.readLine().split("\\s+");
				N = Integer.valueOf(NK[0]);
				K = Integer.valueOf(NK[1]);
				if (K % N == 0 && K <= (N * N)) {
					// print all normal
					Solver solver = new Solver(t, N, K);
					new Thread(solver).start();
				} else {
					/// imposible
					output.put(t, "IMPOSSIBLE");
				}
			}
			br.close();
			// wait for process
			while (output.size() != T) {

			}
			// output
			for (int i = 0; i < T; i++) {
				System.out.println("Case #" + (i + 1) + ": " + output.get(i));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	static class Solver implements Runnable {
		int N, K, i;

		public Solver(int index, int n, int k) {
			i = index;
			N = n;
			K = k;

		}

		@Override
		public void run() {
			output.put(i, solve(N, K));
		}

	}

	static String solve(int N, int K) {
		String result = "POSSIBLE\n";
		int factor = K / N;
		for (int i = 0; i < N; i++) {
			int j = factor - i, c = 0;
			while (c < N) {
				if (j <= 0)
					j += N;
				else if (j > N)
					j = 1;

				result += (j++) + " ";
				c++;
			}
			result = result.substring(0, result.length() - 1);
			result += "\n";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

}
