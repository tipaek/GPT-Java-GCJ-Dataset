import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        for (int m = 0; m < t; m++) {
            int n = reader.nextInt();
            ArrayList<String> patterns = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                patterns.add(reader.next());
            }
            String result = findCommonPattern(patterns);
            System.out.println("Case #" + (m + 1) + ": " + result);
        }
    }

    private static String findCommonPattern(ArrayList<String> patterns) {
        String currentPattern = patterns.get(0);
        for (int i = 1; i < patterns.size(); i++) {
            currentPattern = mergePatterns(currentPattern, patterns.get(i));
            if (currentPattern.isEmpty()) {
                return "*";
            }
        }
        return currentPattern.replace("*", "");
    }

    private static String mergePatterns(String pattern1, String pattern2) {
        int n = pattern1.length() + 1;
        int m = pattern2.length() + 1;
        int[][] dp = new int[n][m];
        int[] current = new int[m];
        int[] previous = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    current[j] = 1;
                } else if (j == 0) {
                    current[j] = (pattern1.charAt(i - 1) == '*' && previous[j] == 1) ? 1 : 0;
                } else if (i == 0) {
                    current[j] = (pattern2.charAt(j - 1) == '*' && current[j - 1] == 1) ? 1 : 0;
                } else {
                    if (pattern1.charAt(i - 1) == pattern2.charAt(j - 1) && pattern1.charAt(i - 1) != '*') {
                        current[j] = (previous[j - 1] == 1) ? 1 : 0;
                    } else if (pattern2.charAt(j - 1) == '*' && pattern1.charAt(i - 1) != '*') {
                        current[j] = (previous[j] == 1) ? 1 : 0;
                    } else if (pattern2.charAt(j - 1) != '*' && pattern1.charAt(i - 1) == '*') {
                        current[j] = (current[j - 1] == 1) ? 1 : 0;
                    } else if (pattern2.charAt(j - 1) == '*' && pattern1.charAt(i - 1) == '*') {
                        current[j] = (previous[j] == 1 || current[j - 1] == 1) ? 1 : 0;
                    } else {
                        current[j] = 0;
                    }
                }
            }
            previous = current.clone();
            for (int j = 0; j < m; j++) {
                dp[i][j] = previous[j];
            }
        }
        return buildPattern(dp, pattern1, pattern2);
    }

    private static String buildPattern(int[][] dp, String pattern1, String pattern2) {
        int i = pattern1.length();
        int j = pattern2.length();
        StringBuilder result = new StringBuilder();
        if (dp[i][j] == 0) return "";

        while (i > 0 && j > 0) {
            if (pattern1.charAt(i - 1) == pattern2.charAt(j - 1) && pattern1.charAt(i - 1) != '*') {
                result.insert(0, pattern1.charAt(i - 1));
                i--;
                j--;
            } else if (pattern2.charAt(j - 1) == '*' && pattern1.charAt(i - 1) != '*') {
                result.insert(0, pattern1.charAt(i - 1));
                i--;
            } else if (pattern2.charAt(j - 1) != '*' && pattern1.charAt(i - 1) == '*') {
                result.insert(0, pattern2.charAt(j - 1));
                j--;
            } else if (pattern2.charAt(j - 1) == '*' && pattern1.charAt(i - 1) == '*') {
                if (dp[i][j - 1] == 1) {
                    result.insert(0, pattern2.charAt(j - 1));
                    j--;
                } else {
                    result.insert(0, pattern2.charAt(j - 1));
                    i--;
                }
            }
        }
        return result.toString();
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