import java.io.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int N = Integer.parseInt(in.nextLine());
            String[] strs = new String[N];
            for (int j = 0; j < N; j++) {
                strs[j] = in.nextLine();
            }
            processStrings(strs, i, w);
        }
        w.flush();
        w.close();
    }

    private static void processStrings(String[] strs, int caseNumber, PrintWriter w) {
        int l = strs.length;
        int[][] indices = new int[l][2];
        String prefix = "", suffix = "";

        for (int i = 0; i < l; i++) {
            String s = strs[i];
            int len = s.length(), left = 0, right = len - 1;

            while (left <= right && s.charAt(left) != '*') left++;
            while (left <= right && s.charAt(right) != '*') right--;

            if (left > right) {
                validateString(s, strs, w, caseNumber);
                return;
            }

            if (left <= prefix.length() && !prefix.contains(s.substring(0, left)) ||
                left > prefix.length() && !s.substring(0, left).contains(prefix)) {
                w.println("Case #" + caseNumber + ": *");
                return;
            }

            if (left > prefix.length()) prefix = s.substring(0, left);

            int suffixLen = len - right - 1;
            if (suffixLen <= suffix.length() && !suffix.contains(s.substring(right + 1)) ||
                suffixLen > suffix.length() && !s.substring(right + 1).contains(suffix)) {
                w.println("Case #" + caseNumber + ": *");
                return;
            }

            if (suffixLen > suffix.length()) suffix = s.substring(right + 1);

            indices[i][0] = left + 1;
            indices[i][1] = right - 1;
        }

        StringBuilder result = new StringBuilder(prefix);
        for (int i = 0; i < l; i++) {
            for (int j = indices[i][0]; j <= indices[i][1]; j++) {
                if (strs[i].charAt(j) != '*') {
                    result.append(strs[i].charAt(j));
                }
            }
        }
        result.append(suffix);
        w.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static void validateString(String s, String[] strs, PrintWriter w, int caseNumber) {
        for (String str : strs) {
            if (!isMatch(s, str)) {
                w.println("Case #" + caseNumber + ": *");
                return;
            }
        }
        w.println("Case #" + caseNumber + ": " + s);
    }

    private static boolean isMatch(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;

        for (int j = 1; j <= l2; j++) {
            if (s2.charAt(j - 1) == '*') dp[0][j] = true;
            else break;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                char c1 = s1.charAt(i - 1), c2 = s2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    dp[i][j] |= dp[i - 1][j];
                }
            }
        }

        return dp[l1][l2];
    }

    static class InputReader {
        private BufferedReader reader;
        private String line;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() {
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}