import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {

    private static final String NO_MATCH = "*";
    private static final char NO_CHAR = '-';
    private static final char ANY_CHAR = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int t = 1; t <= tests; t++) { // 1..100
            int patternsCount = Integer.parseInt(reader.readLine()); // 2..50
            List<String> patterns = nextStrings(reader, patternsCount); // length 2..100
            String matchingWord = findMatchingWord(patterns); // length 1..10000
            System.out.println(String.format("Case #%d: %s", t, matchingWord));
        }
    }

    private static String findMatchingWord(List<String> patterns) {
        String longestCommonBeginning = longestCommonBeginning(patterns);
        if (longestCommonBeginning == null) {
            return NO_MATCH;
        }
        String longestCommonEnding = reverse(longestCommonBeginning(reverse(patterns)));
        if (longestCommonEnding == null) {
            return NO_MATCH;
        }
        return longestCommonBeginning + longestCommonEnding;
    }

    private static String longestCommonBeginning(List<String> patterns) {
        StringBuilder res = new StringBuilder();
        Set<Integer> patternCandidates = IntStream.range(0, patterns.size()).boxed().collect(Collectors.toSet());
        for (int i = 0; ; i++) {
            char candidate = ANY_CHAR;

            for (Iterator<Integer> pIterator = patternCandidates.iterator(); pIterator.hasNext(); ) {
                int p = pIterator.next();
                String pattern = patterns.get(p);
                char c = pattern.charAt(i);
                if (c == '*') {
                    pIterator.remove();
                } else {
                    if (candidate == ANY_CHAR) {
                        candidate = c;
                    } else if (c != candidate) {
                        return null;
                    }
                }
            }
            if (candidate != ANY_CHAR) {
                res.append(candidate);
            } else {
                return res.toString();
            }
        }
    }

    private static List<String> reverse(List<String> patterns) {
        return patterns.stream().map(Solution::reverse).collect(Collectors.toList());
    }

    private static List<String> nextStrings(BufferedReader reader, int patternsCount) throws IOException {
        List<String> res = new ArrayList<>(patternsCount);
        for (int i = 0; i < patternsCount; i++) {
            res.add(reader.readLine());
        }
        return res;
    }

    private static String reverse(String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }
}
