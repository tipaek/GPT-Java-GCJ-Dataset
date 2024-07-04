

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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

				Solver solver = new Solver(t, N, K);
				new Thread(solver).start();

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
		String result = "";
		if (K % N == 0) {
			result = "POSSIBLE\n";
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
		} else {
			int[][] trialMatrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				int start = i + 1;
				for (int j = 0; j < N; j++) {
					if (start > N)
						start = 1;
					trialMatrix[i][j] = start++;
				}
			}
			// compute diagonal -- if yes return string
			if (computeDiagonal(trialMatrix) == K) {
				result = "POSSIBLE\n";
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						result += trialMatrix[i][j] + " ";
					}
					result = result.substring(0, result.length() - 1);
					result += "\n";
				}
				result = result.substring(0, result.length() - 1);
				return result;
			} else {
				int[][] orgMatrix = copy(trialMatrix);
				for (int i = 0; i < N; i++) {
					for (int swapped = i + 1; swapped < N; swapped++) {
						int[] temp = new int[N];
						temp = trialMatrix[i];
						trialMatrix[i] = trialMatrix[swapped];
						trialMatrix[swapped] = temp;
						// compute diagonal -- if yes return string
						if (computeDiagonal(trialMatrix) == K) {
							return getMatrixString(trialMatrix);
						} else {
							int[][] orgMatrix2 = copy(trialMatrix);
							for (int col = 0; col < trialMatrix.length; col++) {
								for (int swappedCol = col + 1; swappedCol < trialMatrix.length; swappedCol++) {
									for (int row = 0; row < trialMatrix.length; row++) {
										int temp2 = trialMatrix[row][col];
										trialMatrix[row][col] = trialMatrix[row][swappedCol];
										trialMatrix[row][swappedCol] = temp2;
									}
									if (computeDiagonal(trialMatrix) == K) {
										return getMatrixString(trialMatrix);
									}
								}
								trialMatrix = copy(orgMatrix2);
							}
						}
					}
					trialMatrix = copy(orgMatrix);
				}
			}
			result = "IMPOSSIBLE";
		}
		return result;
	}

	private static int computeDiagonal(int[][] trialMatrix) {
		int trace = 0;
		for (int i = 0; i < trialMatrix.length; i++) {
			trace += trialMatrix[i][i];
		}
		//System.out.println(trace);
		return trace;
	}

	private static int[][] copy(int[][] org) {

		final int[][] result = new int[org.length][];
		for (int i = 0; i < org.length; i++) {
			result[i] = Arrays.copyOf(org[i], org[i].length);
		}
		return result;
	}

	private static String getMatrixString(int[][] trialMatrix) {
		String result = "POSSIBLE\n";
		for (int w = 0; w < trialMatrix.length; w++) {
			for (int z = 0; z < trialMatrix.length; z++) {
				result += trialMatrix[w][z] + " ";
			}
			result = result.substring(0, result.length() - 1);
			result += "\n";
		}
		result = result.substring(0, result.length() - 1);
		//System.out.println(result);
		return result;
	}
}
