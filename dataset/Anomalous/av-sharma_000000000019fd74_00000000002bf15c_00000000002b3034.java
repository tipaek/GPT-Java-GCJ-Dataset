import java.io.*;
import java.util.*;

/**
 * PatternMatching
 * Author: av-sharma
 */

public class Solution {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = fr.nextInt();
            String[] patterns = new String[n];
            String longestPattern = "";
            int testCase = -1;

            for (int i = 0; i < n; i++) {
                patterns[i] = fr.nextLine();
                if (patterns[i].length() > longestPattern.length()) {
                    longestPattern = patterns[i];
                }
                if (patterns[i].replace("*", "").length() < patterns[i].length() - 1) {
                    testCase = 3;
                } else if (testCase == -1 && patterns[i].contains("*")) {
                    testCase = 2;
                }
            }

            if (testCase == -1) {
                testCase = 1;
            }

            if (testCase == 1) {
                boolean isValid = true;
                for (int i = 0; i < n && isValid; i++) {
                    String subPattern = patterns[i].substring(1);
                    if (!longestPattern.contains(subPattern)) {
                        isValid = false;
                    } else {
                        int startIndex = longestPattern.indexOf(subPattern);
                        int endIndex = startIndex + subPattern.length();
                        if (endIndex != longestPattern.length()) {
                            isValid = false;
                        }
                    }
                }
                System.out.println("Case #" + t + ": " + (isValid ? longestPattern.substring(1) : "*"));
            } else if (testCase == 2) {
                boolean isValid = true;
                String longestLeft = "", longestRight = "";

                for (String pattern : patterns) {
                    String[] splitPattern = pattern.split("\\*");
                    if (splitPattern.length == 1) {
                        if (pattern.startsWith("*") && splitPattern[0].length() > longestRight.length()) {
                            longestRight = splitPattern[0];
                        } else if (pattern.endsWith("*") && splitPattern[0].length() > longestLeft.length()) {
                            longestLeft = splitPattern[0];
                        }
                        continue;
                    }
                    if (splitPattern[0].length() > longestLeft.length()) {
                        longestLeft = splitPattern[0];
                    }
                    if (splitPattern[1].length() > longestRight.length()) {
                        longestRight = splitPattern[1];
                    }
                }

                for (String pattern : patterns) {
                    String[] splitPattern = pattern.split("\\*");
                    if (splitPattern.length == 1) {
                        if ((pattern.startsWith("*") && !longestRight.contains(splitPattern[0])) ||
                            (pattern.endsWith("*") && !longestLeft.contains(splitPattern[0]))) {
                            isValid = false;
                            break;
                        }
                    } else {
                        if (!longestLeft.contains(splitPattern[0]) || !longestRight.contains(splitPattern[1])) {
                            isValid = false;
                            break;
                        }
                    }
                }
                System.out.println("Case #" + t + ": " + (isValid ? longestLeft + longestRight : "*"));
            }
        }
    }
}

// FastReader Util Class
class FastReader {
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

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
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
}