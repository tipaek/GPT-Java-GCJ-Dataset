import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created by vaksenov on 04.04.2020.
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    BufferedReader br;
    StringTokenizer st;
    PrintWriter out;

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public void solve() throws IOException {
        int xx = nextInt();
        int yy = nextInt();
        int sx = xx < 0 ? -1 : 1;
        int sy = yy < 0 ? -1 : 1;
        xx = Math.abs(xx);
        yy = Math.abs(yy);

        char[] x = Integer.toBinaryString(xx).toCharArray();
        char[] y = Integer.toBinaryString(yy).toCharArray();

        boolean[] X = new boolean[33];
        boolean[] Y = new boolean[33];
        long[] pows = new long[33];

        pows[0] = 1;
        for (int i = 0; i < X.length; i++) {
            if (x.length > i)
                X[i] = x[x.length - i - 1] == '1';
            if (y.length > i)
                Y[i] = y[y.length - i - 1] == '1';
            if (i > 0) {
                pows[i] = pows[i - 1] * 2;
            }
        }

        for (int mask = 0; mask < 1 << 3; mask++) {
            boolean[] takeX = new boolean[33];

            int max = 0;

            char[] res = new char[33];
            int length = 0;
            int id = 0;
            for (int i = 0; i < X.length; i++) {
                if (X[i]) {
                    length++;
                    continue;
                }
                if (!X[i]) {
                    if (length == 0)
                        continue;
                    if ((mask & (1 << id)) > 0) {
                        for (int j = i - length; j < i; j++) {
                            takeX[j] = true;
                            res[j] = sx == 1 ? 'E' : 'W';
                        }
                        max = Math.max(max, i);
                    } else {
                        takeX[i] = true;
                        res[i] = sx == 1 ? 'E' : 'W';
                        takeX[i - length] = true;
                        res[i - length] = sx == 1 ? 'W' : 'E';
                        max = Math.max(max, i + 1);
                    }
                    id++;
                    length = 0;
                }
            }


            boolean[] takeY = new boolean[33];
            boolean bad = false;
            long ans = 0;
            length = 0;
            for (int i = 0; i < Y.length; i++) {
                if (ans == yy)
                    break;
                takeY[i] = !takeX[i];
                if (Y[i]) {
                    length++;
                    continue;
                }
                if (!Y[i]) {
                    if (takeY[i]) {
                        if (length == 0) {
                            bad = true;
                        }
                        if (!takeY[i - length]) {
                            bad = true;
                        }
                        res[i] = sy == 1 ? 'N' : 'S';
                        res[i - length] = sy == 1 ? 'S' : 'N';
                        ans += pows[i] - pows[i - length];
                        max = Math.max(max, i + 1);
                    } else {
                        for (int j = i - length; j < i; j++) {
                            if (!takeY[j]) {
                                bad = true;
                            }
                            ans += pows[j];
                            res[j] = sy == 1 ? 'N' : 'S';
                        }
                        max = Math.max(max, i);
                    }
                    length = 0;
                }
            }

            for (int i = 0; i < max; i++) {
                if (takeX[i] == takeY[i]) {
                    bad = true;
                }
            }

            if (bad) {
                continue;
            }
            if (ans != yy) {
                continue;
            }

            String r = "";
            for (int i = 0; i < X.length; i++) {
                if (res[i] != 0) {
                    r += res[i];
                }
            }
            out.println(r);
            return;
        }
        out.println("IMPOSSIBLE");
    }

    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
