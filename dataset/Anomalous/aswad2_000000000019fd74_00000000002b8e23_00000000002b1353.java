import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void run() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            long number = reader.nextLong();
            System.out.println("Case #" + testCase + ":");
            if (number <= 500) {
                for (long i = 1; i <= number; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                System.out.println("1 1");
                long currentSum = 1;
                long increment = 1;
                int row = 2, col = 2;
                while (currentSum + increment <= number) {
                    System.out.println(row + " " + col);
                    row++;
                    col++;
                    currentSum += increment;
                    increment++;
                }
                long remaining = number - currentSum;
                if (remaining != 0) {
                    System.out.println(row + " " + col);
                    row++;
                    col++;
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