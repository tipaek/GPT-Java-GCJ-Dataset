import java.util.*;
import java.io.*;

public class Solution {
    public void run() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int t = 0; t < testCases; t++) {
            long number = reader.nextLong();
            System.out.println("Case #" + (t + 1) + ":");
            if (number <= 500) {
                for (long i = 1; i <= number; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                System.out.println("1 1");
                long currentSum = 1;
                long increment = 1;
                int row = 2, col = 1;
                while (currentSum + increment <= number) {
                    System.out.println(row + " " + col);
                    row++;
                    col++;
                    currentSum += increment;
                    increment++;
                }
                long remaining = number - currentSum;
                if (remaining != 0) {
                    System.out.println((row - 1) + " " + col);
                    col = row;
                    remaining--;
                }
                while (remaining > 0) {
                    System.out.println(row + " " + col);
                    row++;
                    col++;
                    remaining--;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
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