import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 0; t < testCases; t++) {
            String input = reader.nextLine();
            System.out.print("Case #" + (t + 1) + ": ");
            processString(input);
            System.out.println();
        }
    }

    private static void processString(String s) {
        int currentDepth = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i) - '0';

            while (value > currentDepth) {
                System.out.print("(");
                currentDepth++;
            }
            
            while (value < currentDepth) {
                System.out.print(")");
                currentDepth--;
            }
            
            System.out.print(value);
        }

        while (currentDepth > 0) {
            System.out.print(")");
            currentDepth--;
        }
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
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}