import java.util.*;
import java.io.*;

public class Solution {
    static class FastIO {
        private BufferedReader br;
        private StringTokenizer st;
        private BufferedWriter bw;

        public FastIO() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
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

        void print(String s) {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void println(String s) {
            try {
                bw.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();
        int t = io.nextInt();
        for (int testCase = 1; testCase <= t; ++testCase) {
            String input = io.next();
            io.print("Case #" + testCase + ": ");
            StringBuilder result = new StringBuilder();
            int openParens = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                while (openParens < currentDigit) {
                    result.append("(");
                    openParens++;
                }
                while (openParens > currentDigit) {
                    result.append(")");
                    openParens--;
                }
                result.append(ch);
            }

            while (openParens > 0) {
                result.append(")");
                openParens--;
            }

            io.println(result.toString());
        }
        io.close();
    }
}