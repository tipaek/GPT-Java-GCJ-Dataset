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
        BigInteger factor = new BigInteger("203693490000");

        int T = in.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            System.out.print("Case #" + cs + ": ");

            int n = in.nextInt();
            int d = in.nextInt();

            BigInteger[] a = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                a[i] = new BigInteger(in.next()).multiply(factor);
            }

            long ans = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                BigInteger current = BigInteger.ONE;
                for (int it = 1; it <= 20; it++, current = current.add(BigInteger.ONE)) {
                    BigInteger x = a[i].divide(current);

                    ArrayList<Long> all = new ArrayList<>();
                    long currentSum = 0;

                    for (BigInteger value : a) {
                        if (value.mod(x).equals(BigInteger.ZERO)) {
                            all.add(value.divide(x).longValue());
                        } else {
                            currentSum += value.divide(x).longValue();
                        }
                    }

                    Collections.sort(all);

                    long currentAns = 0;
                    int remainingD = d;
                    for (Long cc : all) {
                        if (remainingD >= cc) {
                            remainingD -= cc;
                            currentAns += cc - 1;
                        }
                    }

                    if (currentSum >= remainingD) {
                        currentAns += remainingD;
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
            while (st == null || !st.hasMoreTokens()) {
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