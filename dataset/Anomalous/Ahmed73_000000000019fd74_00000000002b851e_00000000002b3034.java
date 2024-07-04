class GFG {

    static final int ALPHABET_SIZE = 26;

    // Trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }
    }

    // Insert a key into the trie
    static void insert(TrieNode root, String key) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search for a key in the trie
    static boolean search(TrieNode root, String key) {
        TrieNode node = root;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node != null && node.isEndOfWord;
    }

    // Find and print all word breaks
    static void wordBreakAll(TrieNode root, String word, String result) {
        int n = word.length();
        for (int i = 1; i <= n; i++) {
            String prefix = word.substring(0, i);
            if (search(root, prefix)) {
                if (i == n) {
                    System.out.println(result + prefix);
                    return;
                }
                wordBreakAll(root, word.substring(i), result + prefix + " ");
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        TrieNode root = new TrieNode();

        String[] dictionary = {"sam", "sung", "samsung"};
        for (String word : dictionary) {
            insert(root, word);
        }

        for (String word : dictionary) {
            System.out.println(word + ":");
            wordBreakAll(root, word, "");
        }
    }
}