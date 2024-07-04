import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int b = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            reader.next();
            StringBuilder result = new StringBuilder();
            
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                System.out.flush();
                result.append(reader.next());
            }
            
            System.out.println(result.toString());
            if (reader.next().equals("N")) {
                return;
            }
        }
    }

    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer tokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(bufferedReader.readLine());
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
            String str = "";
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}