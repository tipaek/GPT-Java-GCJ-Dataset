import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * 
 * Author: Bhavy Seth
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParenthesesSolver solver = new ParenthesesSolver();
        solver.solve(1, in, out);
        out.close();
    }

    static class ParenthesesSolver {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int t = sc.nextInt();
            for (int test = 1; test <= t; test++) {
                String s = sc.nextLine();
                int n = s.length();
                StringBuilder ans = new StringBuilder();
                int openBrackets = 0;

                for (int i = 0; i < n; i++) {
                    int currentDigit = Character.getNumericValue(s.charAt(i));
                    while (openBrackets < currentDigit) {
                        ans.append('(');
                        openBrackets++;
                    }
                    while (openBrackets > currentDigit) {
                        ans.append(')');
                        openBrackets--;
                    }
                    ans.append(s.charAt(i));
                }
                while (openBrackets > 0) {
                    ans.append(')');
                    openBrackets--;
                }
                out.println("Case #" + test + ": " + ans);
            }
        }
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
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

        public String nextLine() {
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