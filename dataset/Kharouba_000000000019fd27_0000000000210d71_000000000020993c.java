import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            int trace = 0;
            HashSet<Integer>[] hashR = new HashSet[n];
            HashSet<Integer>[] hashC = new HashSet[n];
            for (int i = 0; i < n; i++) {
                hashR[i] = new HashSet<>();
                hashC[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                    if (i == j)
                        trace += a[i][j];
                    hashR[i].add(a[i][j]);
                    hashC[j].add(a[i][j]);
                }
            int r = 0, c = 0;
            for (int i = 0; i < n; i++) {
                if (hashR[i].size() != n)
                    r++;
                if (hashC[i].size() != n)
                    c++;
            }
            pw.printf("Case #%d: %d %d %d\n", tc, trace, r, c);
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