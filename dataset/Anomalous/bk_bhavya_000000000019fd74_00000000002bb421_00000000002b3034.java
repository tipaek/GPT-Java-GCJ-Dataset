import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int caseNumber = t;

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            List<String> cleanedPatterns = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                patterns[i] = sc.nextLine();
                cleanedPatterns.add(patterns[i].replace("*", ""));
            }

            int maxLength = 0;
            String longestPattern = cleanedPatterns.get(0);

            for (String pattern : cleanedPatterns) {
                if (pattern.length() > maxLength) {
                    maxLength = pattern.length();
                    longestPattern = pattern;
                }
            }

            boolean isMatch = true;

            for (String pattern : cleanedPatterns) {
                if (!pattern.equals(longestPattern)) {
                    StringBuilder regexBuilder = new StringBuilder();
                    for (char ch : pattern.toCharArray()) {
                        if (ch == '*') {
                            regexBuilder.append("[A-Z]+");
                        } else {
                            regexBuilder.append(ch);
                        }
                    }
                    Pattern regexPattern = Pattern.compile(regexBuilder.toString());
                    Matcher matcher = regexPattern.matcher(longestPattern);

                    if (!matcher.find()) {
                        isMatch = false;
                        break;
                    }
                }
            }

            if (isMatch) {
                System.out.println("Case #" + (caseNumber - t) + ": " + longestPattern);
            } else {
                System.out.println("Case #" + (caseNumber - t) + ": *");
            }
        }
    }
}

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