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
        int openBrackets = 0;
        int closeBrackets = 0;

        if (str.length() == 1) {
            int n = Integer.parseInt(str);
            for (int j = 0; j < n; j++) {
                result.append("(");
            }
            result.append(str);
            for (int k = 0; k < n; k++) {
                result.append(")");
            }
            return result.toString();
        }

        if (str.length() == 0) {
            return "";
        }

        int firstDigit = Integer.parseInt(str.substring(0, 1));
        for (int j = 0; j < firstDigit; j++) {
            result.append("(");
            openBrackets++;
        }
        result.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            int currentDigit = Integer.parseInt(str.substring(i, i + 1));
            int previousDigit = Integer.parseInt(str.substring(i - 1, i));
            int difference = currentDigit - previousDigit;

            if (difference > 0) {
                for (int m = 0; m < difference; m++) {
                    result.append("(");
                    openBrackets++;
                }
            } else if (difference < 0) {
                for (int l = 0; l < Math.abs(difference); l++) {
                    result.append(")");
                    closeBrackets++;
                }
            }
            result.append(str.charAt(i));
        }

        while (openBrackets != closeBrackets) {
            result.append(")");
            closeBrackets++;
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