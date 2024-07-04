import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int[][] pascal = new int[505][505];
        pascal[0][0] = 1;
        for (int i = 1; i <= 504; i++) {
            pascal[i][0] = pascal[i][i] = 1;
            for (int j = 1; j < i; j++)
                pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
        }

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {

            pw.printf("Case #%d:\n", tc);
            int n = sc.nextInt();
            boolean[] pow = new boolean[35];
            int maxPow = 0;
            for (int i = 0; i <= 30; i++)
                if (i + (1 << i) <= n)
                    maxPow = i;
            pow[maxPow] = true;
            n -= (maxPow + (1 << maxPow));
            int rem = 0;
            for (int i = 0; i < maxPow; i++)
                if ((n & (1 << i)) != 0) {
                    pow[i] = true;
                    n -= (1 << i);
                    rem++;
                }
            rem += n;
            boolean right = true;
            int i = 0, j = 0;
            while (i <= maxPow) {
                if (pow[i]) {
                    if (right) {
                        while (j >= 0) {
                            pw.println((i + 1) + " " + (j + 1));
                            j--;
                        }
                        j++;
                    } else {
                        while (j <= i) {
                            pw.println((i + 1) + " " + (j + 1));
                            j++;
                        }
                        j--;
                    }
                    right = !right;
                } else {
                    pw.println((i + 1) + " " + (j + 1));
                }
                i++;
                if (right)
                    j++;
            }
            while (rem-- > 0) {
                pw.println((i + 1) + " " + (j + 1));
                i++;
                if (right)
                    j++;
            }

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