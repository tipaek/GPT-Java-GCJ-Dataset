import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int count = reader.nextInt();
        for (int test = 1; test <= count; test++) {
            int N = reader.nextInt();
            String[] P = new String[N];
            StringBuilder sb = new StringBuilder();
            Trie trie = new Trie();
            String max = "";
            for (int i = 0; i < N; i++) {
                P[i] = reader.nextLine();
                max = max.length() > P[i].length() ? max : P[i];
            }
            trie.insert(max);
            boolean notFound = false;
            for (int i = 0; i < N; i++) {
                if (!trie.startsWith(P[i])) {
                    notFound = true;
                    break;
                }
            }
            if (notFound)
                System.out.println("Case #" + test + ": *");
            else
                System.out.println("Case #" + test + ": " + max.substring(1));
        }
    }

    static class Trie {

        /**
         * Initialize your data structure here.
         */
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode t = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (word.charAt(i) == '*')
                    break;
                if (!t.children.containsKey(word.charAt(i)))
                    t.children.put(word.charAt(i), new TrieNode());
                t = t.children.get(word.charAt(i));
            }
            t.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode t = root;
            for (int i = 0; i < word.length(); i++) {
                if (t.children.containsKey(word.charAt(i)))
                    return false;
                t = t.children.get(word.charAt(i));
            }
            return t.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode t = root;
            for (int i = prefix.length() - 1; i >= 0; i--) {
                if (prefix.charAt(i) == '*')
                    return true;
                if (!t.children.containsKey(prefix.charAt(i)))
                    return false;
                t = t.children.get(prefix.charAt(i));
            }
            return true;
        }

        class TrieNode {
            public boolean isWord;
            HashMap<Character, TrieNode> children;

            TrieNode() {
                isWord = false;
                children = new HashMap<>();
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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