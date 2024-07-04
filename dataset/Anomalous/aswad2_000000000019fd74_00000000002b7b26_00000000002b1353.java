import java.util.*;
import java.io.*;

public class Solution {
    public void execute() throws Exception {
        InputReader input = new InputReader();
        int testCases = input.nextInt();
        for (int t = 0; t < testCases; t++) {
            int value = input.nextInt();
            System.out.println("Case #" + (t + 1) + ":");
            if (value <= 500) {
                for (int i = 1; i <= value; i++) {
                    System.out.println(i + " " + 1);
                }
            } else {
                System.out.println("1 1\n2 1\n3 2");
                for (int i = 4; i <= 500; i++) {
                    System.out.println(i + " " + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().execute();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
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
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}