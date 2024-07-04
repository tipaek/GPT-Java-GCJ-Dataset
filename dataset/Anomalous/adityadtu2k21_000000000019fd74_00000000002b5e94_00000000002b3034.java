import java.util.*;
import java.io.*;

public class Solution {
    static boolean possible;
    static StringBuilder result;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            possible = true;
            result = new StringBuilder();
            String[] strings = new String[n];
            TrieNode prefixRoot = new TrieNode('.');
            TrieNode suffixRoot = new TrieNode('.');

            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }

            for (String s : strings) {
                boolean switched = false;
                TrieNode currentNode = prefixRoot;
                int asteriskIndex = -1;

                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);

                    if (c == '*' && !switched) {
                        switched = true;
                        asteriskIndex = j;
                        currentNode = suffixRoot;
                    } else if (!switched) {
                        currentNode = currentNode.childs.computeIfAbsent(c, k -> new TrieNode(k));
                    } else {
                        c = s.charAt(s.length() - j + asteriskIndex);
                        currentNode = currentNode.childs.computeIfAbsent(c, k -> new TrieNode(k));
                    }
                }
            }

            traverseTrie(prefixRoot, true);
            traverseTrie(suffixRoot, false);

            if (possible) {
                System.out.println("Case #" + t + ": " + result.toString());
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }

    public static void traverseTrie(TrieNode node, boolean isPrefix) {
        if (node.childs.isEmpty()) {
            return;
        }

        if (node.childs.size() > 1) {
            possible = false;
            return;
        }

        Map.Entry<Character, TrieNode> entry = node.childs.entrySet().iterator().next();
        char c = entry.getKey();
        TrieNode child = entry.getValue();

        if (isPrefix) {
            result.append(c);
        }

        traverseTrie(child, isPrefix);

        if (!isPrefix) {
            result.append(c);
        }
    }

    private static class TrieNode {
        char character;
        Map<Character, TrieNode> childs;

        public TrieNode(char character) {
            this.character = character;
            this.childs = new HashMap<>();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}