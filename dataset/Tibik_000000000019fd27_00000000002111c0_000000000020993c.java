import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solve {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        run();
        pw.close();
    }

    private static void run() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            int[][] matrix = new int[n][n];
            int a = n;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = nextInt() - 1;
                }
            }
            for (int j = 0; j < n; j++) {
                a += matrix[j][j];
            }
            int b = 0;
            int c = 0;
            boolean[] used = new boolean[n];
            for (int j = 0; j < n; j++) {
                Arrays.fill(used, false);
                for (int k = 0; k < n; k++) {
                    if (used[matrix[j][k]]) {
                        b++;
                        break;
                    }
                    used[matrix[j][k]] = true;
                }
            }

            for (int j = 0; j < n; j++) {
                Arrays.fill(used, false);
                for (int k = 0; k < n; k++) {
                    if (used[matrix[k][j]]) {
                        c++;
                        break;
                    }
                    used[matrix[k][j]] = true;
                }
            }
            pw.println("Case #" + i + ": " + a + " " + b + " " + c);
        }
    }

}
