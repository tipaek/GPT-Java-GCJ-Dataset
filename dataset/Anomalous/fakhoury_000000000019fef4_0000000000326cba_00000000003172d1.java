import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader();

        int T = in.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            System.out.print("Case #" + cs + ": ");

            BigInteger factor = new BigInteger("310853026593002220559793640539460000");

            int n = in.nextInt();
            int d = in.nextInt();

            BigInteger[] a = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                a[i] = new BigInteger(in.next()).multiply(factor);
            }

            long ans = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                BigInteger current = BigInteger.ONE;
                for (int it = 1; it <= 50; it++, current = current.add(BigInteger.ONE)) {
                    BigInteger x = a[i].divide(current);

                    ArrayList<Long> all = new ArrayList<>();
                    long currentSum = 0L;

                    for (int j = 0; j < n; j++) {
                        if (a[j].mod(x).equals(BigInteger.ZERO)) {
                            all.add(a[j].divide(x).longValue());
                        } else {
                            currentSum += a[j].divide(x).longValue();
                        }
                    }

                    Collections.sort(all);

                    long currentAns = 0;
                    int D = d;
                    for (Long cc : all) {
                        if (D >= cc) {
                            D -= cc;
                            currentAns += cc - 1;
                        }
                    }

                    if (currentSum >= D) {
                        currentAns += D;
                        ans = Math.min(ans, currentAns);
                    }
                }
            }

            System.out.println(ans);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}