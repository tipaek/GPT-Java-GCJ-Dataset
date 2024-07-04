import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public  static void  main(String[]  args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testNum = scanner.nextInt();
        for (int i = 0; i < testNum; i++)  {
            new Solution().solve(scanner, i);
        }
    }

    private void solve(Scanner scanner, int testNum) {
        int n = scanner.nextInt();

        String[] w = new String[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.next();
        }

        String[] pes = new String[n];
        String[] sss = new String[n];

        int[] pei = new int[n];
        int[] ssi = new int[n];

        Trie pt = new Trie();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = 0;
            while(true) {
                if (w[i].charAt(j) != '*') {
                    sb.append(w[i].charAt(j));
                    j++;
                } else {
                    break;
                }
            }
            j++;
            String s = sb.toString();
            pes[i] = s;
            pei[i] = j;

            pt.insert(s);
        }
        if (!pt.hasOnlyOnePath()) {
            System.out.println("Case #" + (testNum + 1) +  ": " + "*");
            return;
        }

        Trie st = new Trie();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int j = w[i].length() - 1;
            while(true) {
                if (w[i].charAt(j) != '*') {
                    sb.append(w[i].charAt(j));
                    j--;
                } else {
                    break;
                }
            }
            j--;
            String s = sb.toString();
            sss[i] = s;
            ssi[i] = j;

            st.insert(s);
        }
        if (!st.hasOnlyOnePath()) {
            System.out.println("Case #" + (testNum + 1) +  ": " + "*");
            return;
        }

        StringBuilder result = new StringBuilder();

        String mP = pes[0];
        for (int i = 1; i < n; i++) {
            if (mP.length() < pes[i].length()) {
                mP = pes[i];
            }
        }
        result.append(mP);

        for (int i = 0; i < n; i++) {
            for (int j  = pei[i]; j <= ssi[i]; j++) {
                char c = w[i].charAt(j);
                if (c != '*') {
                    result.append(c);
                }
            }
        }

        String mS = sss[0];
        for (int i = 1; i < n; i++) {
            if (mS.length() < sss[i].length()) {
                mS = sss[i];
            }
        }
        for (int i = mS.length() - 1; i >= 0; i--) {
            result.append(mS.charAt(i));
        }

        System.out.println("Case #" + (testNum + 1) +  ": " + result.toString());
    }

    class Trie {
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode('$');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.nodes.containsKey(c)) {
                    node.nodes.put(c, new TrieNode(c));
                }
                node = node.nodes.get(c);
            }
            node.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchLastNode(word);
            return node != null && node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchLastNode(prefix);
            return node != null;
        }

        public TrieNode searchLastNode(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!node.nodes.containsKey(c)) {
                    return null;
                }
                node = node.nodes.get(c);
            }
            return node;
        }

        public boolean hasOnlyOnePath() {
            TrieNode node = root;
            while (node != null) {
                if (node.nodes.size() > 1) {
                    return false;
                }
                if (node.nodes.size() == 0) {
                    return true;
                }
                node = node.nodes.values().stream().findFirst().orElseThrow(() -> new RuntimeException("hasOnlyOnePath error"));
            }

            return true;
        }

        private class TrieNode {
            Map<Character, TrieNode> nodes;
            boolean isEnd;
            char value;

            TrieNode(char value) {
                nodes = new HashMap<>();
                this.value = value;
            }

            void addNode(TrieNode node) {
                nodes.put(node.value, node);
            }

            @Override
            public int hashCode() {
                return Character.hashCode(value);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TrieNode) {
                    TrieNode node = (TrieNode) obj;
                    return this.value == node.value;
                }
                return false;
            }
        }
    }
}

