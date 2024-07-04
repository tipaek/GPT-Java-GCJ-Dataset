import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String inputString = reader.next();
            System.out.print("Case #" + t + ": ");
            processString(inputString);
            System.out.println();
        }
    }

    private static void processString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (shouldOpenBracket(s, i)) {
                System.out.print("(");
            }
            System.out.print(s.charAt(i));
            if (shouldCloseBracket(s, i)) {
                System.out.print(")");
            }
        }
    }

    private static boolean shouldOpenBracket(String s, int i) {
        return (s.charAt(i) == '1' && (i == 0 || s.charAt(i - 1) == '0'));
    }

    private static boolean shouldCloseBracket(String s, int i) {
        return (s.charAt(i) == '1' && (i == s.length() - 1 || s.charAt(i + 1) == '0'));
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
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