import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int[][] solve(int dim, int trace) {
        if (trace % dim != 0) {
            return new int[0][0];
        }

        int diag = trace / dim;
        int[][] retMatrix = new int[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                retMatrix[i][j] = (diag + i - j) % (dim);
                retMatrix[i][j] = (retMatrix[i][j] == 0) ? dim : retMatrix[i][j];
            }
        }
        return retMatrix;
    }
    
    public static void main(String... args) {
        try {
            // BufferedReader in = new BufferedReader(new InputStreamReader (System.in));
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int n = in.nextInt();
            int[] dim = new int[n];
            int[] traces = new int[n];
			for (int i = 0; i < n; i++) {
                dim[i] = in.nextInt();
                traces[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++) {
                int[][] result = solve(dim[i], traces[i]);
                if (result.length == 0) {
                    System.out.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
                } else {
                    System.out.println(String.format("Case #%d: POSSIBLE", i + 1));
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < result.length; j++) {
                        for (int k = 0; k < result[0].length; k++) {
                            sb.append(result[j][k]);  // 1st idx=row idx, 2nd idx=col idx
                            sb.append((k == result[0].length - 1) ? ((j == result.length - 1) ? "" : '\n') : ' ');
                        }
                    }
                    System.out.println(sb.toString());
                }
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
}