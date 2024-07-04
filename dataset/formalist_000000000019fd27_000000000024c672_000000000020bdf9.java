import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskParentingPartneringReturns solver = new TaskParentingPartneringReturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            int num = 0;
            while (t > 0) {
                t--;
                num++;
                int n = in.nextInt();
                int max = 24 * 60 + 1;
                int[] cnt = new int[max];
                Pair[] ar = new Pair[n];
                for (int i = 0; i < n; i++) {
                    int s = in.nextInt();
                    int f = in.nextInt();
                    ar[i] = new Pair(s, f, i);
                    for (int j = s; j < f; j++)
                        cnt[j]++;
                }
                Arrays.sort(ar, (o1, o2) -> {
                    if (o1.s != o2.s)
                        return Integer.compare(o1.s, o2.s);
                    else
                        return Integer.compare(o1.f, o2.f);
                });
                boolean ok = true;
                for (int el : cnt)
                    if (el > 2) {
                        ok = false;
                        break;
                    }
                if (!ok)
                    out.println("Case #" + num + ": IMPOSSIBLE");
                else {
                    int[] ans = new int[n];
                    ans[ar[0].w] = 1;
                    int free1 = ar[0].f;
                    int free2 = 0;
                    ok = true;
                    for (int i = 1; i < n; i++)
                        if (free1 <= ar[i].s && free2 <= ar[i].s) {
                            ans[ar[i].w] = 1;
                            free1 = ar[i].f;
                        } else {
                            if (free1 <= ar[i].s && free2 > ar[i].s) {
                                ans[ar[i].w] = 1;
                                free1 = ar[i].f;
                            } else {
                                if (free2 <= ar[i].s) {
                                    ans[ar[i].w] = 2;
                                    free2 = ar[i].f;
                                } else {
                                    ok = false;
                                    break;
                                }
                            }
                        }
                    if (!ok)
                        out.println("Case #" + num + ": IMPOSSIBLE");
                    else {
                        out.print("Case #" + num + ": ");
                        for (int el : ans)
                            out.print(el == 1 ? "C" : "J");
                        out.println();
                    }
                }
            }
        }

        private class Pair {
            private int s;
            private int f;
            private int w;

            public Pair(int s, int f, int w) {
                this.s = s;
                this.f = f;
                this.w = w;
            }

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

