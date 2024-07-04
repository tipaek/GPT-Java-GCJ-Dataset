import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private static final String NO_MATCH = "*";
    private static final char ANY_CHAR = '*';

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int patternCount = Integer.parseInt(reader.readLine());
            List<String> patterns = readPatterns(reader, patternCount);
            String result = findMatchingPattern(patterns);
            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }

    private static List<String> readPatterns(BufferedReader reader, int count) throws IOException {
        List<String> patterns = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            patterns.add(reader.readLine());
        }
        return patterns;
    }

    private static String findMatchingPattern(List<String> patterns) {
        String commonPrefix = findLongestCommonPrefix(patterns);
        if (commonPrefix == null) {
            return NO_MATCH;
        }
        String commonSuffix = reverse(findLongestCommonPrefix(reversePatterns(patterns)));
        if (commonSuffix == null) {
            return NO_MATCH;
        }
        return commonPrefix + commonSuffix;
    }

    private static String findLongestCommonPrefix(List<String> patterns) {
        StringBuilder prefix = new StringBuilder();
        Set<Integer> candidates = IntStream.range(0, patterns.size()).boxed().collect(Collectors.toSet());

        for (int i = 0; ; i++) {
            char currentChar = ANY_CHAR;

            for (Iterator<Integer> iterator = candidates.iterator(); iterator.hasNext(); ) {
                int index = iterator.next();
                String pattern = patterns.get(index);
                if (i >= pattern.length() || pattern.charAt(i) == ANY_CHAR) {
                    iterator.remove();
                } else {
                    char c = pattern.charAt(i);
                    if (currentChar == ANY_CHAR) {
                        currentChar = c;
                    } else if (c != currentChar) {
                        return null;
                    }
                }
            }

            if (currentChar != ANY_CHAR) {
                prefix.append(currentChar);
            } else {
                return prefix.toString();
            }
        }
    }

    private static List<String> reversePatterns(List<String> patterns) {
        return patterns.stream().map(Solution::reverse).collect(Collectors.toList());
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}