import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int[][] pascal = new int[505][505];
        pascal[1][1] = 1;
        for (int i = 2; i <= 504; i++) {
            pascal[i][1] = pascal[i][i] = 1;
            for (int j = 2; j < i; j++)
                pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
        }

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {

            pw.printf("Case #%d:\n", tc);
            int n = sc.nextInt();
            int i = 1, j = 1;
            pw.println(i + " " + j);
            if (n > 1) {
                i++;
                pw.println(i + " " + j);
                n -= 2;
                while (true) {
                    if (pascal[i + 1][j + 1] <= n) {
                        i++;
                        j++;
                        n -= pascal[i][j];
                        pw.println(i + " " + j);
                    } else {
                        if (n > 1) {
                            j++;
                            n--;
                            pw.println(i + " " + j);
                        }
                        while (n-- > 0) {
                            i--;
                            j--;
                            pw.println(i + " " + j);
                        }
                        break;
                    }
                }
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