import java.io.*;
import java.util.*;

class SolutionGCJ {
    public void solve(FastReader in, PrintWriter out) {
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String s = in.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char c : s.toCharArray()) {
                int digit = c - '0';
                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }
                result.append(digit);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            out.printf("Case #%d: %s%n", t, result);
        }
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        new SolutionGCJ().solve(in, out);
        out.flush();
        out.close();
    }
}

class FastReader {
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
            System.exit(0);
        }
        return str;
    }
}