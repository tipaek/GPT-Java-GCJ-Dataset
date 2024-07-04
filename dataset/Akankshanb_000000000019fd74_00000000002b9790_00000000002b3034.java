import java.util.*;
import java.io.*;
class Solution{
    public static String patternMatch(List<String> list, TrieNode root) {
        int max_len = 0;
        String max = "";
        for (String str : list) {
            str = str.replaceAll("\\*", "");
            if (str.length() >= max_len) {
                max_len = str.length();
                max = str;
            }
        }
        addWord(max, root);
        for(String word: list){
            if(search(word, root)){
                return max.replaceAll("\\*","");
            }
        }
        return "*";
    }

    public static boolean search(String word, TrieNode root) {
        return match(word.toCharArray(), 0, root);
    }

    public static boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("*");
        if (chs[k] != '*') {
            return node.children[chs[k] - 'A'] != null && match(chs, k + 1, node.children[chs[k] - 'A']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void addWord(String word, TrieNode root) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if(c == '*') continue;
            if (node.children[c - 'A'] == null) {
                node.children[c - 'A'] = new TrieNode();
            }
            node = node.children[c - 'A'];
        }
        node.item = word;
    }

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            TrieNode root = new TrieNode();
            List<String> list = new ArrayList<>();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                String S = in.next();
                list.add(S);
            }
            System.out.println("Case #" + i + ": " + patternMatch(list, root));
        }
    }
}
