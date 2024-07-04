import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        
        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = sc.nextLine();
            }
            String result = solvePattern(n, patterns);
            out.println("Case #" + tt + ": " + result);
        }
        
        out.close();
    }

    private static String solvePattern(int n, String[] patterns) {
        String prefix = "", suffix = "";
        List<String> middleParts = new ArrayList<>();
        boolean fault = false;

        for (String pattern : patterns) {
            int firstStar = pattern.indexOf("*");
            int lastStar = pattern.lastIndexOf("*");

            String tmpPrefix = pattern.substring(0, firstStar);
            String tmpMiddle = pattern.substring(firstStar, lastStar).replace("*", "");
            String tmpSuffix = pattern.substring(lastStar + 1);

            if (!isValidPrefix(prefix, tmpPrefix) || !isValidSuffix(suffix, tmpSuffix)) {
                fault = true;
                break;
            }

            if (tmpPrefix.length() > prefix.length()) {
                prefix = tmpPrefix;
            }
            if (tmpSuffix.length() > suffix.length()) {
                suffix = tmpSuffix;
            }
            if (!tmpMiddle.isEmpty()) {
                middleParts.add(tmpMiddle);
            }
        }

        if (fault) {
            return "*";
        } else {
            return prefix + String.join("", middleParts) + suffix;
        }
    }

    private static boolean isValidPrefix(String prefix, String tmpPrefix) {
        return (tmpPrefix.length() <= prefix.length() && prefix.startsWith(tmpPrefix)) ||
               (tmpPrefix.length() > prefix.length() && tmpPrefix.startsWith(prefix));
    }

    private static boolean isValidSuffix(String suffix, String tmpSuffix) {
        return (tmpSuffix.length() <= suffix.length() && suffix.endsWith(tmpSuffix)) ||
               (tmpSuffix.length() > suffix.length() && tmpSuffix.endsWith(suffix));
    }

    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
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