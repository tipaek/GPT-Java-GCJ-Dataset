import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private void solve() throws IOException {
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
            if (x.length > i) X[i] = x[x.length - i - 1] == '1';
            if (y.length > i) Y[i] = y[y.length - i - 1] == '1';
            if (i > 0) pows[i] = pows[i - 1] * 2;
        }

        for (int max = Math.max(x.length, y.length); max < Math.max(x.length, y.length) + 3; max++) {
            for (int mask = 0; mask < 1 << 16; mask++) {
                boolean[] takeX = new boolean[33];
                char[] res = new char[33];
                int length = 0;
                int id = 0;

                for (int i = 0; i < max; i++) {
                    if (X[i]) {
                        length++;
                    } else {
                        if (length == 0) continue;
                        if ((mask & (1 << id)) > 0) {
                            for (int j = i - length; j < i; j++) {
                                takeX[j] = true;
                                res[j] = sx == 1 ? 'E' : 'W';
                            }
                        } else {
                            takeX[i] = true;
                            res[i] = sx == 1 ? 'E' : 'W';
                            takeX[i - length] = true;
                            res[i - length] = sx == 1 ? 'W' : 'E';
                        }
                        id++;
                        length = 0;
                    }
                }
                if (X[max - 1]) {
                    for (int j = max - length; j < max; j++) {
                        takeX[j] = true;
                        res[j] = sx == 1 ? 'E' : 'W';
                    }
                }

                boolean[] takeY = new boolean[33];
                boolean bad = false;
                long ans = 0;
                length = 0;

                for (int i = 0; i < max; i++) {
                    if (ans == yy) break;
                    takeY[i] = !takeX[i];
                    if (Y[i]) {
                        length++;
                    } else {
                        if (takeY[i]) {
                            if (length == 0) bad = true;
                            if (!takeY[i - length]) bad = true;
                            res[i] = sy == 1 ? 'N' : 'S';
                            res[i - length] = sy == 1 ? 'S' : 'N';
                            ans += pows[i] - pows[i - length];
                        } else {
                            for (int j = i - length; j < i; j++) {
                                if (!takeY[j]) bad = true;
                                ans += pows[j];
                                res[j] = sy == 1 ? 'N' : 'S';
                            }
                        }
                        length = 0;
                    }
                }

                if (Y[max - 1]) {
                    for (int j = max - length; j < max; j++) {
                        if (!takeY[j]) bad = true;
                        ans += pows[j];
                        res[j] = sy == 1 ? 'N' : 'S';
                    }
                }

                for (int i = 0; i < max; i++) {
                    if (takeX[i] == takeY[i]) bad = true;
                }

                if (bad || ans != yy) continue;

                StringBuilder r = new StringBuilder();
                for (int i = 0; i < max; i++) {
                    r.append(res[i]);
                }
                out.println(r);
                return;
            }
        }
        out.println("IMPOSSIBLE");
    }

    private void run() {
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