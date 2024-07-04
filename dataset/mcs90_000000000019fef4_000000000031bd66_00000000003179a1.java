import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OverRandom solver = new OverRandom();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OverRandom {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = 10000;
            long[] q = new long[n];
            String[] code = new String[n];

            String secret = getInput(q, code, in);
            if (q[0] == -1) {
                // Not sure how to solve this case.
                out.println("Case #" + testNumber + ": ABCDEFGHIJ");
                return;
            }

            String ans = solve(q, code);

            if (!secret.equals("") && !secret.equals(ans)) {
                System.err.println("WA");
            }

            if (secret.equals(""))
                out.println("Case #" + testNumber + ": " + ans);
        }

        private String solve(long[] query, String[] code) {
            int n = query.length;
            int[] letters = new int[26];
            Arrays.fill(letters, (1 << 10) - 1);

            int there = 0;
            int nonZero = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < code[i].length(); j++) {
                    there |= (1 << (code[i].charAt(j) - 'A'));
                }

                long q = query[i];
                char c = code[i].charAt(0);
                nonZero |= (1 << (c - 'A'));

                int d = 0;
                int cnt = 0;
                while (q > 0) {
                    ++cnt;
                    d = (int) (q % 10);
                    q /= 10;
                }
                if (code[i].length() != cnt) {
                    continue;
                }
                for (int j = d + 1; j < 10; j++) {
                    letters[c - 'A'] &= ~(1 << j);
                }
            }

            char[] ans = new char[10];

            // find 0
            for (int i = 0; i < 26; i++) {
                if ((there & ~nonZero) == (1 << i)) {
                    ans[0] = (char) ('A' + i);
                    there &= ~(1 << i);
                    break;
                }
            }

            // find 1-8
            for (int i = 1; i < 9; i++) {
                for (int j = 0; j < 26; j++) {
                    if (Integer.highestOneBit(letters[j]) == (1 << i)) {
                        ans[i] = (char) (j + 'A');
                        there &= ~(1 << j);
                        break;
                    }
                }
            }

            // last remaining is 9
            for (int i = 0; i < 26; i++) {
                if (there == (1 << i)) {
                    ans[9] = (char) ('A' + i);
                    break;
                }
            }

            return String.valueOf(ans);
        }

        private String getInput(long[] q, String[] code, Scanner in) {
            for (int i = 0; i < 10000; i++) {
                q[i] = in.nextLong();
                code[i] = in.next();
            }
            return "";
/*        Random r = new Random(System.currentTimeMillis());
        int[] C = new int[26];
        char[] secret = new char[10];
        Arrays.fill(C, -1);

        int k = 0;
        while (k < 10) {
            int d = r.nextInt(26);
            if (C[d] != -1) {
                continue;
            }
            secret[k] = (char) ('A' + d);
            C[d] = k++;
        }

        for (int i = 0; i < 10000; i++) {
            long m = Math.abs(r.nextLong()) % 10000000000000000L + 1;
            long n = Math.abs(r.nextLong()) % m + 1;
            q[i] = m;
            code[i] = "";
            while (n > 0) {
                int d = (int) (n % 10);
                code[i] = secret[d] + code[i];
                n /= 10;
            }
        }

        return String.valueOf(secret);*/
        }

    }
}

