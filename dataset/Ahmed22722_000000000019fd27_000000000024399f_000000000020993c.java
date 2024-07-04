
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Solution {
    private final static FastReader in = new FastReader();
    private final static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = in.nextInt();
        int arrayofN[][];
        int N, k = 0, r = 0, c = 0, current;
        for (int i1 = 1; i1 <= t; i1++) {
            N = in.nextInt();
            arrayofN = new int[N][N];

            for (int i2 = 0; i2 < N; i2++) {
                for (int i3 = 0; i3 < N; i3++) {
                    arrayofN[i2][i3] = in.nextInt();
                }
            }

            for (int i2 = 0; i2 < N; i2++) {
                k += arrayofN[i2][i2];
            }
            for (int i2 = 0; i2 < N; i2++) {
                row:
                for (int i3 = 0; i3 < N; i3++) {
                    current = arrayofN[i2][i3];
                    for (int i4 = i3 + 1; i4 < N; i4++) {
                        if (current == arrayofN[i2][i4]) {
                            r++;
                            break row;
                        }
                    }
                }
            }

            for (int i2 = 0; i2 < N; i2++) {
                columns:
                for (int i3 = 0; i3 < N; i3++) {
                    current = arrayofN[i3][i2];
                    for (int i4 = i3 + 1; i4 < N; i4++) {
                        if (current == arrayofN[i4][i2]) {
                            c++;
                            break columns;
                        }
                    }
                }
            }

            out.printf("Case #%d: %d %d %d \n", i1, k, r, c);
            r = c = k = 0;
        }
        out.flush();
    }

    private static final class FastReader {
        private static BufferedReader BF;
        private static StringTokenizer ST;

        public FastReader() {
            BF = new BufferedReader(new InputStreamReader(System.in));
            ST = null;
        }

        public final String next() {
            while (ST == null || !ST.hasMoreTokens()) {
                try {
                    ST = new StringTokenizer(BF.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return ST.nextToken();
        }

        final int nextInt() {
            return Integer.parseInt(next());
        }

    }


}