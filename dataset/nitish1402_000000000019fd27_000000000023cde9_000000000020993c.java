import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

    public void solve() {
        int T = nextInt();
        int index = 1;

        while (T-- > 0) {
            int N = nextInt();
            int mat[][] = new int[N][N];

            for (int r = 0; r < N; r ++) {
                for (int c = 0; c < N; c++) {
                    mat[r][c] = nextInt();
                }
            }

            int trace = 0;

            for (int i = 0; i < N; i++) {
                trace += mat[i][i];
            }

            int repc = 0 , repr = 0;

            //rows
            for (int i = 0; i < N; i++) {
                int[] uniq = new int[N];

                for (int c = 0; c < N; c++) {
                    if (uniq[mat[i][c] - 1] == 1) {
                        repr++;
                        break;
                    } else {
                        uniq[mat[i][c] - 1] = 1;
                    }
                }
            }


            //cols
            for (int i = 0; i < N; i++) {
                int[] uniq = new int[N];

                for (int r = 0; r < N; r++) {
                    if (uniq[mat[r][i] - 1] == 1) {
                        repc++;
                        break;
                    } else {
                        uniq[mat[r][i] - 1] = 1;
                    }
                }
            }

            System.out.println("Case #"+index+": "+trace+" "+repr+" "+repc);
            index++;
        }
    }

    Solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    static final Random rng = new Random();

    static int rand(int l, int r) {
        return l + rng.nextInt(r - l + 1);
    }

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }
}

    