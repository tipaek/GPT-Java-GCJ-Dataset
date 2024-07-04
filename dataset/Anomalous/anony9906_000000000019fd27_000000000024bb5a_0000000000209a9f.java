import java.io.*;
import java.util.*;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * 
 */
public class Solution {
    public static void main(String[] args) {
        FastReader in = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        CodeJam solver = new CodeJam();
        solver.solve(in, out);
        out.close();
    }
}

class CodeJam {
    public void solve(FastReader sc, PrintWriter out) {
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            char[] s = sc.next().toCharArray();
            int n = s.length;
            int openParentheses = 0;
            StringBuilder result = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                int currentDigit = s[i] - '0';
                if (currentDigit > openParentheses) {
                    for (int j = 0; j < currentDigit - openParentheses; j++) {
                        result.append('(');
                    }
                } else if (currentDigit < openParentheses) {
                    for (int j = 0; j < openParentheses - currentDigit; j++) {
                        result.append(')');
                    }
                }
                result.append(s[i]);
                openParentheses = currentDigit;
            }
            
            for (int i = 0; i < openParentheses; i++) {
                result.append(')');
            }
            
            out.println("Case #" + t + ": " + result);
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader(InputStream stream) {
        br = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}