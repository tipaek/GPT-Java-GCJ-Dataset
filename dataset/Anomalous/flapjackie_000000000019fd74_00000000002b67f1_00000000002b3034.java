import java.util.*;
import java.io.*;

public class Solution {
    static boolean isValid;
    static int numberOfWords;

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            isValid = true;
            numberOfWords = scanner.nextInt();
            String[] words = new String[numberOfWords];

            for (int i = 0; i < numberOfWords; i++) {
                words[i] = scanner.next();
            }

            String beginning = extractBeginning(words);
            String end = extractEnd(words);
            StringBuilder middle = new StringBuilder();

            if (!isValid) {
                out.printf("Case #%d: *\n", caseNum);
            } else {
                for (String word : words) {
                    int lastStarIndex = 0;
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) == '*') lastStarIndex = j;
                    }
                    int firstStarIndex = word.indexOf('*');
                    for (int j = firstStarIndex; j < lastStarIndex; j++) {
                        if (word.charAt(j) != '*') {
                            middle.append(word.charAt(j));
                        }
                    }
                }
                out.printf("Case #%d: %s%s%s\n", caseNum, beginning, middle.toString(), end);
            }
        }
        out.close();
    }

    static String extractBeginning(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (c == '*') break;
                if (sb.length() > j) {
                    if (c != sb.charAt(j)) {
                        isValid = false;
                    }
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    static String extractEnd(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                if (c == '*') break;
                if (sb.length() > word.length() - j - 1) {
                    if (c != sb.charAt(sb.length() - 1 - (word.length() - 1 - j))) {
                        isValid = false;
                    }
                } else {
                    sb.insert(0, c);
                }
            }
        }
        return sb.toString();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}