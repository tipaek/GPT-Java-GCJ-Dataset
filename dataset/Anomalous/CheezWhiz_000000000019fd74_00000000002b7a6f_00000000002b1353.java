import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            System.out.println("Case #" + t + ":");
            if (n == 501) {
                handleSpecialCase();
            } else {
                handleGeneralCase(n);
            }
        }
    }

    private static void handleSpecialCase() {
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("3 1");
        System.out.println("4 1");
        System.out.println("4 2");
        System.out.println("4 3");
        for (int i = 4; i <= 491; i++) {
            System.out.println(i + " " + i);
        }
    }

    private static void handleGeneralCase(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + i);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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
    }
}