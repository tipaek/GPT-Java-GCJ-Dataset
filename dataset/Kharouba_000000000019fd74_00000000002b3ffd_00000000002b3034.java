import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            String[] a = new String[n];
            for (int i = 0; i < n; i++)
                a[i] = "$" + sc.next() + "$";
            String[][] sa = new String[n][];
            String maxPrefix = "";
            String maxSuffix = "";
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                sa[i] = a[i].split("\\*");
                if (sa[i][0].length() > maxPrefix.length())
                    maxPrefix = sa[i][0];
                if (sa[i][sa[i].length - 1].length() > maxSuffix.length())
                    maxSuffix = sa[i][sa[i].length - 1];
            }
            for (int i = 0; i < n; i++) {
                if (!maxPrefix.startsWith(sa[i][0]))
                    ok = false;
                if (!maxSuffix.endsWith(sa[i][sa[i].length - 1]))
                    ok = false;
            }
            String ans = "*";
            if (ok) {
                StringBuilder sb = new StringBuilder(maxPrefix);
                for (int i = 0; i < n; i++)
                    for (int j = 1; j < sa[i].length - 1; j++)
                        sb.append(sa[i][j]);
                sb.append(maxSuffix);
                ans = sb.toString();
                ans = ans.substring(1, ans.length() - 1);
            }
            pw.printf("Case #%d: %s\n", tc, ans);
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