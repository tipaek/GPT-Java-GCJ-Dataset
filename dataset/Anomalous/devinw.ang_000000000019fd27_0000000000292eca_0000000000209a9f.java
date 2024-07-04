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
            int n = Character.getNumericValue(str.charAt(0));
            for (int j = 0; j < n; j++) {
                result.append("(");
            }
            result.append(str.charAt(0));
            for (int j = 0; j < n; j++) {
                result.append(")");
            }
            return result.toString();
        }

        if (str.length() == 0) {
            return "";
        }

        int firstDigit = Character.getNumericValue(str.charAt(0));
        for (int j = 0; j < firstDigit; j++) {
            result.append("(");
            open++;
        }
        result.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            int currentDigit = Character.getNumericValue(str.charAt(i));
            int previousDigit = Character.getNumericValue(str.charAt(i - 1));
            int diff = currentDigit - previousDigit;

            if (diff > 0) {
                for (int j = 0; j < diff; j++) {
                    result.append("(");
                    open++;
                }
            } else if (diff < 0) {
                for (int j = 0; j < -diff; j++) {
                    result.append(")");
                    close++;
                }
            }
            result.append(str.charAt(i));
        }

        for (int j = 0; j < (open - close); j++) {
            result.append(")");
        }

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