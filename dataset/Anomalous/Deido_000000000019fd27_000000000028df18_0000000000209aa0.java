import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = in.nextInt();
            int k = in.nextInt();
            StringBuilder result = null;

            for (int z = 1; z <= n && z * n <= k; z++) {
                int[][] matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                    matrix[0][i] = i + 1;
                }
                matrix[0][z - 1] = 1;
                matrix[0][0] = z;

                for (int i = 1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = matrix[0][(n - i + j) % n];
                    }
                }

                int remainingK = k - z * n;
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int delta = matrix[i][j] + matrix[j][i] - matrix[i][i] - matrix[j][j];
                        if (delta <= 0 || delta > remainingK) {
                            continue;
                        }
                        int[] temp = matrix[i];
                        matrix[i] = matrix[j];
                        matrix[j] = temp;
                        remainingK -= delta;
                    }
                }

                if (remainingK != 0) {
                    continue;
                }

                result = new StringBuilder("Case #" + tc + ": POSSIBLE\n");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        result.append(matrix[i][j]).append(" ");
                    }
                    result.append("\n");
                }
                break;
            }

            if (result == null) {
                out.write("Case #" + tc + ": IMPOSSIBLE\n");
            } else {
                out.write(result.toString());
            }
        }
        out.flush();
    }
}

class FastReader {
    private final BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}