import java.util.Map.Entry;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tests = input.nextInt();

        for(int i = 1; i <= tests; i++){
            int N = input.nextInt();
            String[] words = new String[N]; 
            
            for(int j = 0; j < N; j++){
                words[j] = input.next();
            }
            String result = Solve(N, words);

            System.out.println( String.format("Case #%d: %s", i, result) );
        }
    }

    static String Solve(int N, String[] words){
        for(int i = 0; i < N; i++){
            String a = words[i];

            if (a.charAt(a.length() - 1) == '*') { continue;}

            for(int j = i + 1; j < N; j++){
                String b = words[j];
    
                if (b.charAt(b.length() - 1) == '*') { continue;}

                if (b.charAt(b.length() - 1) != a.charAt(a.length() - 1)) {
                    return "*";
                }
            }
        }
        ArrayList<List<String>> tokens = new ArrayList<>();

        for(String w: words) {
            String[] tt = w.split("\\*");
            List<String> list = new ArrayList<>();

            for(int i = 0; i < tt.length; i++){
                String t = tt[i];
                list.add(t);
                if (!t.equals("") && i != tt.length - 1) list.add("");
            }            

            tokens.add(list);
        }
        

        StringBuilder builder = new StringBuilder();

        int index = 0;
        boolean cont = true;
        while(cont) {
            List<String> s = new ArrayList();
            cont = false;
            for(List<String> tok: tokens) {
                if (index < tok.size()){
                    cont = true;
                    if (tok.get(index).length() > 0) s.add(tok.get(index));
                }
            }
            s.sort((x, y) -> y.length() - x.length());

            for(int i = 1; i < s.size(); i++) {
                if (s.get(0).indexOf(s.get(i)) == -1){
                    return "*";
                }
            }

            index++;
            if (s.size() > 0) {
                builder.append(s.get(0));
            }
        }

        return builder.toString();
    }

    static String Solve1(int N, String[] words){
        Trie root = new Trie();
        
        for(String w: words){
            root.add(w);            
        }

        String res = dfs(root, new StringBuilder());

        return res;
    }

    static String dfs(Trie node, StringBuilder builder){
        if (node == null) {
            return "*";
        }

        if (node.children.size() > 2) {
            return "*";
        }

        if (node.children.size() == 2 && !node.children.containsKey('*')) {
            return "*";
        }

        Trie starNode = null;

        if (node.children.size() == 2 && node.children.containsKey('*')) {
            starNode = node.children.get('*');
            Trie otherNode = null;
            char key = '_';
            for(Entry<Character, Trie> entry: node.children.entrySet()) {
                if (entry.getKey() != '*'){
                    otherNode = entry.getValue();
                    key = entry.getKey();
                }
            }

            otherNode.merge(starNode);
            
            node.children.remove('*');
        }
        
        for(Entry<Character, Trie> entry: node.children.entrySet()) {
            char key = entry.getKey();
            
            if (key == '*') {
                builder.append("");
            } else {
                builder.append(key);
            }

            String res = dfs(entry.getValue(), builder);

            if ("*".equals(res)) {
                return "*";
            }
        }

        return builder.reverse().toString();
    }
    
    static class Trie {
        Map<Character, Trie> children = new HashMap();
        Character key;
        void merge(Trie other) {
            if (other == null) {
                return;
            }

            if (!this.children.containsKey(other.key)) {
                this.children.put(other.key, other);
            } else {
                for(Entry<Character, Trie> ch: other.children.entrySet()) {
                    this.children.get(other.key).merge(ch.getValue());
                }                
            }            
        }
    
        boolean startsWith(String prefix) {
            Trie node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
    
            return true;
        }
    
        void add(String word) {
            Trie node = this;
    
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Trie());
                }
    
                node = node.children.get(c);
                node.key = c;
            }
        }
    }
}