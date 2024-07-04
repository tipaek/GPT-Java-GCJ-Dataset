import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            String str = sc.next();
            out.println("Case #" + i + ": " + solve(str));
        }
        out.close();
    }

    public static String solve(String str) {
        StringBuilder result = new StringBuilder();
        int open = 0, close = 0;

        if (str.length() == 1) {
            int n = Integer.parseInt(str);
            result.append("(".repeat(n)).append(str).append(")".repeat(n));
            return result.toString();
        }

        if (str.isEmpty()) {
            return "";
        }

        int firstDigit = Integer.parseInt(str.substring(0, 1));
        result.append("(".repeat(firstDigit)).append(firstDigit);
        open += firstDigit;

        for (int i = 1; i < str.length(); i++) {
            int currentDigit = Integer.parseInt(str.substring(i, i + 1));
            int previousDigit = Integer.parseInt(str.substring(i - 1, i));
            int diff = currentDigit - previousDigit;

            if (diff > 0) {
                result.append("(".repeat(diff));
                open += diff;
            } else if (diff < 0) {
                result.append(")".repeat(-diff));
                close += -diff;
            }
            result.append(currentDigit);
        }

        result.append(")".repeat(open - close));
        return result.toString();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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