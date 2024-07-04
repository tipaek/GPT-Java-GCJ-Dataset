
import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            char[] s = sc.next().toCharArray();
            StringBuilder ans = new StringBuilder();
            int open = 0;
            for (char c : s) {
                int x = c - '0';
                while (open > x) {
                    ans.append(")");
                    open--;
                }
                while (open < x) {
                    ans.append("(");
                    open++;
                }
                ans.append(c);
            }
            while (open-- > 0) {
                ans.append(")");
            }
            pw.printf("Case #%d: %s\n", tc, ans.toString());
        }

        pw.close();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String s) throws Throwable {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() throws Throwable {
            if (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws Throwable {
            return Integer.parseInt(next());
        }

        long nextLong() throws Throwable {
            return Long.parseLong(next());
        }

    }

}