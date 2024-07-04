import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author ducbm
 */
public class Solution {

    public static void main(String[] args) {
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                int T = Integer.valueOf(reader.readLine());

                int N, k, r, c;
                String line;
                String[] tokens;

                int i, j, u;
                for (i = 0; i < T; i++) {
                    N = Integer.valueOf(reader.readLine());

                    k = 0;
                    r = 0;
                    c = 0;

                    int[][] map1 = new int[N + 1][N + 1];
                    boolean[] incC = new boolean[N + 1];

                    for (j = 0; j < N; j++) {
                        line = reader.readLine();
                        tokens = line.split(" ");

                        int[] map2 = new int[N + 1];
                        boolean incR = false;

                        for (u = 0; u < N; u++) {
                            int val = Integer.valueOf(tokens[u]);
                            if (u == j) {
                                k += val;
                            }

                            map2[val]++;
                            if (map2[val] >= 2 && !incR) {
                                r++;
                                incR = true;
                            }

                            map1[u][val]++;
                            if (map1[u][val] >= 2 && !incC[u]) {
                                c++;
                                incC[u] = true;
                            }
                        }

                    }

                    System.out.println(String.format("Case #%d: %d %d %d", i + 1, k, r, c));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
