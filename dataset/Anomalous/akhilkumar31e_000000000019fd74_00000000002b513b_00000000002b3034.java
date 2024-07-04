import java.io.*;
import java.util.*;

public class Solution {
    static class Trie {
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
        for (int i = 0; i < word.length() - 1; i++) {
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
        for (int i = 0; i < word.length() - 1; i++) {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(br.readLine());
            List<String> words = new ArrayList<>();
            int maxLength = 0;
            int maxIndex = 0;

            for (int i = 0; i < n; i++) {
                StringBuilder reversedWord = new StringBuilder(br.readLine()).reverse();
                String word = reversedWord.toString();
                words.add(word);

                if (maxLength < word.length()) {
                    maxIndex = i;
                    maxLength = word.length();
                }
            }

            Trie trie = new Trie();
            insert(trie, words.get(maxIndex));

            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                if (i != maxIndex) {
                    if (!insertOther(trie, words.get(i))) {
                        System.out.println("Case #" + testCase + ": *");
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                String result = new StringBuilder(words.get(maxIndex)).reverse().substring(1);
                System.out.println("Case #" + testCase + ": " + result);
            }
        }
    }
}