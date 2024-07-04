import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    static class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    static boolean addPrefixWord(TrieNode root, String word) {
        TrieNode current = root;
        int i = 0;
        while (i < word.length() && word.charAt(i) != '*') {
            int index = word.charAt(i) - 'A';
            if (current.children[index] == null) {
                if (current.count > 0) return false;
                current.count++;
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            i++;
        }
        return true;
    }

    static boolean addSuffixWord(TrieNode root, String word) {
        TrieNode current = root;
        int i = word.length() - 1;
        while (i >= 0 && word.charAt(i) != '*') {
            int index = word.charAt(i) - 'A';
            if (current.children[index] == null) {
                if (current.count > 0) return false;
                current.count++;
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            i--;
        }
        return true;
    }

    static StringBuilder buildString(TrieNode root, boolean reverse) {
        TrieNode current = root;
        StringBuilder result = new StringBuilder();

        while (true) {
            boolean foundChild = false;
            for (int i = 0; i < current.children.length; i++) {
                if (current.children[i] != null) {
                    result.append((char) ('A' + i));
                    current = current.children[i];
                    foundChild = true;
                    break;
                }
            }
            if (!foundChild) break;
        }

        return reverse ? result.reverse() : result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = scanner.next();
            }

            TrieNode prefixRoot = new TrieNode();
            TrieNode suffixRoot = new TrieNode();

            boolean isValid = true;
            for (String word : words) {
                isValid = isValid && addPrefixWord(prefixRoot, word);
                isValid = isValid && addSuffixWord(suffixRoot, word);
            }

            if (!isValid) {
                System.out.println("Case #" + t + ": *");
            } else {
                StringBuilder result = buildString(prefixRoot, false);

                for (String word : words) {
                    int startIndex = 0;
                    while (word.charAt(startIndex) != '*') startIndex++;
                    int endIndex = word.length() - 1;
                    while (word.charAt(endIndex) != '*') endIndex--;

                    for (int i = startIndex; i <= endIndex; i++) {
                        if (word.charAt(i) != '*') {
                            result.append(word.charAt(i));
                        }
                    }
                }

                result.append(buildString(suffixRoot, true));
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
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

        String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        String nextLine() {
            int c = read();
            while (isEndline(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return result.toString();
        }
    }
}