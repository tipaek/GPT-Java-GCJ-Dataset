import java.util.*;
import java.io.*;

class Solution {
    public static String patternMatch(List<String> list, TrieNode root) {
        String longestPattern = findLongestPattern(list);
        addWordToTrie(longestPattern, root);
        return findMatchingPattern(list, root, longestPattern);
    }

    private static String findLongestPattern(List<String> list) {
        String longestPattern = "";
        int maxLength = 0;
        for (String pattern : list) {
            String cleanedPattern = pattern.replaceAll("\\*", "");
            if (cleanedPattern.length() >= maxLength) {
                maxLength = cleanedPattern.length();
                longestPattern = cleanedPattern;
            }
        }
        return longestPattern;
    }

    private static void addWordToTrie(String word, TrieNode root) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (c == '*') continue;
            if (node.children[c - 'A'] == null) {
                node.children[c - 'A'] = new TrieNode();
            }
            node = node.children[c - 'A'];
        }
        node.item = word;
    }

    private static String findMatchingPattern(List<String> list, TrieNode root, String longestPattern) {
        for (String pattern : list) {
            if (isPatternInTrie(pattern, root)) {
                return longestPattern.replaceAll("\\*", "");
            }
        }
        return "*";
    }

    private static boolean isPatternInTrie(String pattern, TrieNode root) {
        return matchPattern(pattern.toCharArray(), 0, root);
    }

    private static boolean matchPattern(char[] patternChars, int index, TrieNode node) {
        if (index == patternChars.length) return !node.item.equals("*");
        if (patternChars[index] != '*') {
            return node.children[patternChars[index] - 'A'] != null
                    && matchPattern(patternChars, index + 1, node.children[patternChars[index] - 'A']);
        } else {
            for (TrieNode child : node.children) {
                if (child != null && matchPattern(patternChars, index + 1, child)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            TrieNode root = new TrieNode();
            int n = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scanner.next());
            }
            System.out.println("Case #" + i + ": " + patternMatch(patterns, root));
        }
    }
}