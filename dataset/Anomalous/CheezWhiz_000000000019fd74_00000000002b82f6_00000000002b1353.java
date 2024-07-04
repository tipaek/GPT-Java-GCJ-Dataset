import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();
            System.out.println("Case #" + t + ":");
            if (n == 501) {
                printSpecialCase();
                for (int i = 4; i <= n - 2; i++) {
                    printCoordinates(i, i);
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    printCoordinates(i, i);
                }
            }
        }
    }

    private static void printSpecialCase() {
        printCoordinates(1, 1);
        printCoordinates(2, 1);
        printCoordinates(3, 2);
        printCoordinates(3, 1);
        printCoordinates(4, 3);
    }

    private static void printCoordinates(int x, int y) {
        System.out.println(x + " " + y);
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