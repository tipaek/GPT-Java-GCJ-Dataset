import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        for (int p1 = 0; p1 < t; p1++) {
            int n = sc.nextInt();
            if (n <= 501) {
                System.out.println("Case #" + (p1 + 1) + ":");
                handleCase(n);
            }
        }
    }

    private static void handleCase(int n) {
        if (n == 1) {
            System.out.println("1 1");
        } else if (n == 2) {
            System.out.println("1 1");
            System.out.println("2 2");
        } else {
            for (int i = 1; i < n; i++) {
                if (i == 2) {
                    System.out.println("2 1");
                    System.out.println("2 2");
                } else {
                    System.out.println(i + " " + i);
                }
            }
        }
    }

    static class FastScanner {
        private BufferedReader br;
        private StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
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