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

    public static void solve(PrintWriter pw, CustomScanner sc) throws IOException {
        int n = sc.nextInt();
        String[] patterns = new String[n];
        int[] asteriskCounts = new int[n];
        
        for (int i = 0; i < n; i++) {
            patterns[i] = sc.next();
            asteriskCounts[i] = (int) patterns[i].chars().filter(ch -> ch == '*').count();
        }

        List<String> prefixes = new ArrayList<>();
        List<String> postfixes = new ArrayList<>();
        List<String> middles = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String pattern = patterns[i];
            int len = pattern.length();
            int asterCount = 0;
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < len; j++) {
                char c = pattern.charAt(j);
                if (asterCount < 1) {
                    if (c == '*') {
                        asterCount++;
                        if (sb.length() > 0) {
                            prefixes.add(sb.toString());
                        }
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                } else if (asterCount < asteriskCounts[i]) {
                    if (c == '*') {
                        asterCount++;
                        if (sb.length() > 0) {
                            middles.add(sb.toString());
                        }
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                } else {
                    if (c != '*') {
                        sb.append(c);
                    }
                }
            }
            if (sb.length() > 0) {
                postfixes.add(sb.toString());
            }
        }

        Comparator<String> lengthComparator = Comparator.comparingInt(String::length).reversed();
        StringBuilder result = new StringBuilder();

        if (!prefixes.isEmpty()) {
            prefixes.sort(lengthComparator);
            String longestPrefix = prefixes.get(0);
            result.append(longestPrefix);
            
            if (!isValidPattern(prefixes, longestPrefix)) {
                pw.print("*");
                return;
            }
        }

        for (String mid : middles) {
            result.append(mid);
        }

        if (!postfixes.isEmpty()) {
            postfixes.sort(lengthComparator);
            String longestPostfix = postfixes.get(0);
            result.append(longestPostfix);
            
            if (!isValidPattern(postfixes, longestPostfix)) {
                pw.print("*");
                return;
            }
        }

        pw.print(result.toString());
    }

    private static boolean isValidPattern(List<String> patterns, String reference) {
        long mod = 113131313133L;
        long[] hashPowers = new long[reference.length() + 1];
        long base = 1313;
        hashPowers[0] = 1;

        for (int i = 1; i <= reference.length(); i++) {
            hashPowers[i] = hashPowers[i - 1] * base % mod;
        }

        long referenceHash = computeHash(reference, base, mod);

        for (int i = 1; i < patterns.size(); i++) {
            String pattern = patterns.get(i);
            long patternHash = computeHash(pattern, base, mod);

            if (!isSubstringHash(reference, referenceHash, pattern, patternHash, hashPowers, base, mod)) {
                return false;
            }
        }

        return true;
    }

    private static long computeHash(String s, long base, long mod) {
        long hash = 0;
        for (char c : s.toCharArray()) {
            hash = (hash * base + c) % mod;
        }
        return hash;
    }

    private static boolean isSubstringHash(String reference, long referenceHash, String pattern, long patternHash, long[] hashPowers, long base, long mod) {
        if (patternHash == referenceHash) {
            return true;
        }

        long currentHash = 0;
        for (int i = 0; i < pattern.length(); i++) {
            currentHash = (currentHash * base + reference.charAt(i)) % mod;
        }

        if (currentHash == patternHash) {
            return true;
        }

        for (int i = pattern.length(); i < reference.length(); i++) {
            currentHash = ((currentHash - hashPowers[pattern.length() - 1] * reference.charAt(i - pattern.length())) % mod + mod) % mod;
            currentHash = (currentHash * base + reference.charAt(i)) % mod;
            if (currentHash == patternHash) {
                return true;
            }
        }

        return false;
    }

    public static class CustomScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokens();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokens();
            return tokenizer.nextToken();
        }

        private void ensureTokens() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        }
    }
}