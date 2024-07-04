import java.io.*;
import java.util.*;

public class Solution {
    public static class Trie {
        Trie[] children;
        int count;
        int maxLength;

        Trie() {
            children = new Trie[26];
            count = 0;
            maxLength = 0;
        }
    }

    static void insert(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'A';
            if (root.children[index] == null) {
                root.children[index] = new Trie();
            }
            root = root.children[index];
            root.maxLength = Math.max(root.maxLength, word.length());
            root.count++;
        }
    }

    static boolean insertOther(Trie root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'A';
            if (root.children[index] == null) {
                return false;
            }
            root = root.children[index];
            root.maxLength = Math.max(root.maxLength, word.length());
            root.count++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());
            List<String> patterns = new ArrayList<>();
            int maxLeftLength = 0;
            int maxRightLength = 0;
            StringBuilder leftPattern = new StringBuilder();
            StringBuilder rightPattern = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String input = reader.readLine();
                String[] parts = input.replace('*', ' ').split(" ");
                String leftPart = parts[0];

                patterns.add(input);
                if (maxLeftLength < leftPart.length()) {
                    leftPattern = new StringBuilder(leftPart);
                    maxLeftLength = leftPart.length();
                }

                if (parts.length == 2) {
                    String rightPart = parts[1];
                    if (maxRightLength < rightPart.length()) {
                        rightPattern = new StringBuilder(rightPart);
                        maxRightLength = rightPart.length();
                    }
                }
            }

            Trie leftTrie = new Trie();
            insert(leftTrie, leftPattern.toString());
            Trie rightTrie = new Trie();
            insert(rightTrie, rightPattern.reverse().toString());

            int i;
            for (i = 0; i < n; i++) {
                String[] parts = patterns.get(i).split(" ");
                StringBuilder leftSegment = new StringBuilder(parts[0]);
                StringBuilder rightSegment = parts.length == 2 ? new StringBuilder(parts[1]) : new StringBuilder();

                boolean leftMatch = insertOther(leftTrie, leftSegment.toString());
                boolean rightMatch = insertOther(rightTrie, rightSegment.reverse().toString());

                if (!leftMatch || !rightMatch) {
                    System.out.println("Case #" + testCase + ": *");
                    break;
                }
            }

            if (i == n) {
                System.out.println("Case #" + testCase + ": " + leftPattern.toString() + rightPattern.reverse().toString());
            }
        }
    }
}