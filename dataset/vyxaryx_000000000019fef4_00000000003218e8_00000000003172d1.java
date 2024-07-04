import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution implements Runnable {
    public static void main(String[] args) {
        new Thread(new Solution()).start();
    }

    @Override
    public void run() {
        try {
            solve();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader rd;
    private PrintWriter wr;
    private StringTokenizer tok;

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(rd.readLine());
        }
        return tok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private void solve() throws IOException {
        rd = new BufferedReader(new InputStreamReader(System.in));
        wr = new PrintWriter(System.out);

        int t = nextInt();
        for (int i = 0; i < t; ++i) {
            wr.print(String.format("Case #%d: ", i + 1));
            int res = subsolve();
            wr.println(String.format("%d", res));
        }

        rd.close();
        wr.close();
    }

    private int subsolve() throws IOException {
        int n = nextInt();
        int d = nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; ++i) {
            a[i] = nextLong();
        }

        int best = d - 1;
        int[] cnt = new int[d + 1];
        int[] dyn = new int[d + 1];
        for (long den = 1; den <= d; ++den) {
            for (int i = 0; i < n; ++i) {
                long partial = 0;
                Arrays.fill(cnt, 0);

                for (int j = 0; j < n; ++j) {
                    long lhv = a[j] * den;
                    long rhv = a[i];
                    long q = lhv / rhv;
                    long rem = lhv - q * rhv;
                    if (rem == 0) {
                        if (q > d) {
                            partial += q;
                        } else if (q > 0) {
                            cnt[(int)q] += 1;
                        }
                    } else {
                        partial += q;
                    }
                }

                Arrays.fill(dyn, Integer.MAX_VALUE);
                dyn[0] = 0;
                for (int k = 1; k <= d; ++k) {
                    for (int f = d; f >= 0; --f) {
                        for (int l = 1; l <= Math.min(d, cnt[k]); ++l) {
                            if (f - l * k < 0) {
                                break;
                            }
                            int prev = dyn[f - l * k];
                            if (prev != Integer.MAX_VALUE) {
                                dyn[f] = Math.min(dyn[f], prev + l * (k - 1));
                            }
                        }
                    }
                }
                for (int k = 0; k <= d; ++k) {
                    int rem = d - k;
                    if (dyn[k] != Integer.MAX_VALUE && partial >= rem) {
                        best = Math.min(best, dyn[k] + rem);
                    }
                }
            }
        }

        return best;
    }
}
