import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    class Trie {


        class TrieNode {
            char c;
            HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
            boolean isLeaf;

            public TrieNode() {}

            public TrieNode(char c){
                this.c = c;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            HashMap<Character, TrieNode> children = root.children;

            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);

                TrieNode t;
                if(children.containsKey(c)){
                    t = children.get(c);
                }else{
                    t = new TrieNode(c);
                    children.put(c, t);
                }

                children = t.children;

                //set leaf node
                if(i==word.length()-1)
                    t.isLeaf = true;
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode t = searchNode(word);

            if(t != null && t.isLeaf)
                return true;
            else
                return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if(searchNode(prefix) == null)
                return false;
            else
                return true;
        }

        public TrieNode searchNode(String str){
            Map<Character, TrieNode> children = root.children;
            TrieNode t = null;
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(children.containsKey(c)){
                    t = children.get(c);
                    children = t.children;
                }else{
                    return null;
                }
            }

            return t;
        }

    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    public Solution() throws IOException {}

    private void run() throws IOException {
        solve();
        out.close();
    }

    private void solve() throws IOException {
        int t = nextInt();
        for (int it = 0; it < t; it++) {

            int numPatterns = nextInt();
            int idx = 0;
            String[] patterns = new String[numPatterns];
            int maxStrLen = 0;
            for (int i = 0; i < numPatterns; i++) {
                String p = next();
                if (p.length() > maxStrLen) {
                    idx = i;
                    maxStrLen = p.length();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(p.split("\\*")[1]);
                patterns[i] = sb.reverse().toString();
            }

            Trie trie = new Trie();
//            System.out.println("longest: " + patterns[idx]);
            trie.insert(patterns[idx]);

            String result = "A" + new StringBuilder(patterns[idx]).reverse().toString();
            for (int i = 0; i < numPatterns; i++) {
                if (!trie.startsWith(patterns[i])) {
                    result = "*";
                    break;
                }
//                System.out.println("patterns: "+ patterns[i] + ", i: " + trie.startsWith(patterns[i]));
            }
            printCase(it+1, result);
//            printCase(it+1, "result");
        }
    }

    private void printCase(int caseNum, String result) {
        System.out.println("Case #" + caseNum + ": " + result);
    }

    String next() throws IOException  {
        while (st == null || !st.hasMoreTokens())  {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException  {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException  {
        return Long.parseLong(next());
    }


}
