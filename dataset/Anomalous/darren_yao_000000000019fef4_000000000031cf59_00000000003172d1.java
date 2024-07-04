import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
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
    }

    static FastReader reader = new FastReader(System.in);
    static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = reader.nextInt();
        for (int q = 1; q <= t; q++) {
            int n = reader.nextInt();
            int d = reader.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = reader.nextLong();
            }
            Arrays.sort(arr);

            if (d == 2) {
                boolean found = false;
                for (int i = 0; i < n - 1; i++) {
                    if (arr[i] == arr[i + 1]) {
                        found = true;
                        break;
                    }
                }
                writer.println("Case #" + q + ": " + (found ? 0 : 1));
            } else {
                boolean threeEqual = false;
                boolean twoEqual = false;
                for (int i = 0; i < n - 2; i++) {
                    if (arr[i] == arr[i + 1] && arr[i + 1] == arr[i + 2]) {
                        threeEqual = true;
                        break;
                    }
                }
                for (int i = 0; i < n - 1; i++) {
                    if (Arrays.binarySearch(arr, 2 * arr[i]) >= 0) {
                        twoEqual = true;
                        break;
                    }
                }
                if (threeEqual) {
                    writer.println("Case #" + q + ": " + 0);
                } else if (twoEqual) {
                    writer.println("Case #" + q + ": " + 1);
                } else {
                    writer.println("Case #" + q + ": " + 2);
                }
            }
        }
        writer.close();
    }
}