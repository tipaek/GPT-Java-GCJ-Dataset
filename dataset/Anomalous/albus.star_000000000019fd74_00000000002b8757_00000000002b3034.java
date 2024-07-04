import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (PrintWriter pw = new PrintWriter(System.out);
             Scanner sc = new Scanner(System.in)) {
            int testCases = sc.nextInt();
            for (int t = 1; t <= testCases; t++) {
                pw.print("Case #" + t + ": ");
                solve(pw, sc);
                pw.println();
            }
        }
    }

    private static void solve(PrintWriter pw, Scanner sc) throws IOException {
        int n = sc.nextInt();
        String[] array = new String[n];
        int[] asteriskCount = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.next();
            asteriskCount[i] = (int) array[i].chars().filter(ch -> ch == '*').count();
        }

        List<String> prefix = new ArrayList<>();
        List<String> postfix = new ArrayList<>();
        List<String> mid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int len = array[i].length();
            int aster = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len; j++) {
                char c = array[i].charAt(j);

                if (aster < 1) {
                    if (c == '*') {
                        aster++;
                        if (sb.length() >= 1) {
                            prefix.add(sb.toString());
                        }
                        sb = new StringBuilder();
                    } else {
                        sb.append(c);
                    }
                } else if (aster < asteriskCount[i]) {
                    if (c == '*') {
                        aster++;
                        if (sb.length() >= 1) {
                            mid.add(sb.toString());
                        }
                        sb = new StringBuilder();
                    } else {
                        sb.append(c);
                    }
                } else {
                    if (c != '*') {
                        sb.append(c);
                    }
                }
            }

            if (sb.length() >= 1) {
                postfix.add(sb.toString());
            }
        }

        Comparator<String> lengthComparator = Comparator.comparingInt(String::length).reversed();
        StringBuilder result = new StringBuilder();

        if (!prefix.isEmpty()) {
            prefix.sort(lengthComparator);
            result.append(prefix.get(0));

            if (!isValidPattern(prefix)) {
                pw.print("*");
                return;
            }
        }

        mid.forEach(result::append);

        if (!postfix.isEmpty()) {
            postfix.sort(lengthComparator);
            result.append(postfix.get(0));

            if (!isValidPattern(postfix)) {
                pw.print("*");
                return;
            }
        }

        pw.print(result.toString());
    }

    private static boolean isValidPattern(List<String> patterns) {
        long mod = 113131313133L;
        long base = 1313;
        long[] hashes = new long[patterns.get(0).length() + 1];
        long max = 1;
        
        for (int i = 0; i <= patterns.get(0).length(); i++) {
            hashes[i] = max;
            max *= base;
        }

        for (int j = 1; j < patterns.size(); j++) {
            long v = hash(patterns.get(j), base);
            long start = 0;

            for (int k = 0; k < patterns.get(j).length(); k++) {
                start = (start * base + patterns.get(0).charAt(k));
            }

            if (v == start) continue;

            boolean flag = false;
            for (int k = patterns.get(j).length(); k < patterns.get(0).length(); k++) {
                start = ((start - hashes[patterns.get(j).length() - 1] * patterns.get(0).charAt(k - patterns.get(j).length())) * base + patterns.get(0).charAt(k));
                if (v == start) {
                    flag = true;
                    break;
                }
            }

            if (!flag) return false;
        }

        return true;
    }

    private static long hash(String s, long base) {
        long hash = 0;
        for (char c : s.toCharArray()) {
            hash = hash * base + c;
        }
        return hash;
    }

    public static class Scanner {
        private final BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public Scanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return tokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }
}