import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }

    public void execute() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            int number = reader.nextInt();
            System.out.println("Case #" + (t + 1) + ":");

            if (number <= 500) {
                for (int i = 1; i <= number; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                System.out.println("1 1\n2 1\n3 2");
                for (int i = 3; i < 500; i++) {
                    System.out.println("1 " + i);
                }
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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