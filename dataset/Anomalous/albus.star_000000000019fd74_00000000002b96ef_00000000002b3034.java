import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        CustomScanner sc = new CustomScanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    private static void solve(PrintWriter pw, CustomScanner sc) throws IOException {
        int n = sc.nextInt();
        String[] patterns = new String[n];
        int[] asteriskCounts = new int[n];

        for (int i = 0; i < n; i++) {
            patterns[i] = sc.next();
            asteriskCounts[i] = countAsterisks(patterns[i]);
        }

        List<String> prefixes = new ArrayList<>();
        List<String> midParts = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            extractParts(patterns[i], asteriskCounts[i], prefixes, midParts, suffixes);
        }

        StringBuilder result = new StringBuilder();
        if (!prefixes.isEmpty()) {
            if (!validateParts(prefixes, result)) {
                pw.print("*");
                return;
            }
        }
        for (String mid : midParts) {
            result.append(mid);
        }
        if (!suffixes.isEmpty()) {
            if (!validateParts(suffixes, result)) {
                pw.print("*");
                return;
            }
        }
        pw.print(result.toString());
    }

    private static int countAsterisks(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '*') {
                count++;
            }
        }
        return count;
    }

    private static void extractParts(String pattern, int asteriskCount, List<String> prefixes, List<String> midParts, List<String> suffixes) {
        int len = pattern.length();
        int asterisksSeen = 0;
        StringBuilder currentPart = new StringBuilder();

        for (int j = 0; j < len; j++) {
            char c = pattern.charAt(j);
            if (c == '*') {
                asterisksSeen++;
                if (asterisksSeen == 1 && currentPart.length() > 0) {
                    prefixes.add(currentPart.toString());
                    currentPart = new StringBuilder();
                } else if (asterisksSeen == asteriskCount && currentPart.length() > 0) {
                    suffixes.add(currentPart.toString());
                    currentPart = new StringBuilder();
                }
            } else {
                currentPart.append(c);
            }
        }
        if (currentPart.length() > 0) {
            suffixes.add(currentPart.toString());
        }
    }

    private static boolean validateParts(List<String> parts, StringBuilder result) {
        parts.sort((o1, o2) -> o2.length() - o1.length());
        result.append(parts.get(0));
        long mod = 113131313133L;
        long[] hashes = computeHashes(parts.get(0), mod);

        for (int j = 1; j < parts.size(); j++) {
            long hashValue = computeHash(parts.get(j), mod);
            if (!isValidPrefix(parts.get(0), parts.get(j), hashValue, hashes, mod)) {
                return false;
            }
        }
        return true;
    }

    private static long[] computeHashes(String s, long mod) {
        long[] hashes = new long[s.length() + 1];
        long multiplier = 1;
        for (int i = 0; i <= s.length(); i++) {
            hashes[i] = multiplier;
            multiplier *= 1313;
        }
        return hashes;
    }

    private static long computeHash(String s, long mod) {
        long hash = 0;
        for (char c : s.toCharArray()) {
            hash = hash * 1313 + c;
        }
        return hash;
    }

    private static boolean isValidPrefix(String base, String part, long partHash, long[] hashes, long mod) {
        long currentHash = 0;
        int k = 0;
        for (; k < part.length(); k++) {
            currentHash = currentHash * 1313 + base.charAt(k);
        }
        if (partHash == currentHash) {
            return true;
        }
        for (; k < base.length(); k++) {
            currentHash = ((currentHash - hashes[part.length() - 1] * base.charAt(k - part.length())) * 1313 + base.charAt(k));
            if (partHash == currentHash) {
                return true;
            }
        }
        return false;
    }

    private static class CustomScanner {
        private BufferedReader bufferedReader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureToken();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureToken();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureToken();
            return tokenizer.nextToken();
        }

        private void ensureToken() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
            }
        }
    }
}