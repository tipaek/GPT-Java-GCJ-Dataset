import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();

        int numberOfTest = Integer.parseInt(sc.nextToken());

        for (int t = 0; t < numberOfTest; t++) {
            long U = Integer.parseInt(sc.nextToken()); // up to U decimal digits

            char[] res = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

            // We collected some data that we believe we can use to recover the secret digit string D from each server.
            // We sent 104 queries to each server.
            for (int i = 0; i < 10000; i++) {
                int Q = sc.nextInt(); // i-th query
                String R = sc.nextToken(); // i-th response

                if (digitCount(Q) != R.length())
                    continue;

                int count = 0;
                while (Q != 0) {
                    int digit = Q % 10;
                    Q = Q / 10;

                    if (res[digit] == R.charAt(count)) {
                        // Seem valid
                    } else {
                        if (!contains(res, R.charAt(count))) {
                            res[digit] = R.charAt(count);
                        }
                    }

                    count++;
                }
            }

            System.out.println("Case #" + (t + 1) + ": " + String.valueOf(res));
        }
    }

    private static int digitCount(int number) {
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }

        return count;
    }

    private static boolean contains(char[] res, char c) {
        for (int i = 0; i < res.length; i++) {
            if (res[i] == c)
                return true;
        }
        return false;
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
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
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}
