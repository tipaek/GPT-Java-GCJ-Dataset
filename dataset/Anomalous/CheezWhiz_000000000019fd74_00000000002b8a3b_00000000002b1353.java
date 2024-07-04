import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            System.out.println("Case #" + t + ":");

            if (n == 501) {
                printSpecialCase();
            } else {
                printDefaultCase(n);
            }
        }
    }

    private static void printSpecialCase() {
        System.out.println("1 1");
        System.out.println("2 1");
        System.out.println("3 2");
        System.out.println("3 1");
        for (int i = 4; i < 500; i++) {
            System.out.println(i + " 1");
        }
    }

    private static void printDefaultCase(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + i);
        }
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}