import java.util.*;
import java.io.*;
public class Solution {
    
    static class Trie {
        class TrieNode {
            TrieNode[] children;
            boolean isWordEnd;
            public TrieNode() {
                children = new TrieNode[27];
                isWordEnd = false;
            }
        }
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void add(String word) {
            int i = -1;
            TrieNode node = root;
            while (node.children[26] != null) {
                node = node.children[26];
            }
            for (char c: word.toCharArray()) {
                i++;
                int index = c - 'A';
                if (c == '*') {
                    index = 26;
                } else {
                    if (index < 0) {
                        continue;
                    }
                }
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                if (i == word.length() - 1) {
                    node.children[index].isWordEnd = true;
                }
                node = node.children[index];
            }
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(in.nextLine());
            String[] a = new String[n];
            for (int j = 0; j <n; j++) {
                String s = in.nextLine();
                a[j] = s;
            }
            findSolution(i, a);
        }
    }

    public static void findSolution(int index, String[] a) {
        String s = a[0];
        for (int i = 1; i < a.length; i++) {
            String tmp = "";
            int j = 0;
            int k = 0;
            while (j < s.length() && k < a[i].length()) {
                if (a[i].charAt(k) == '*' && s.charAt(j) == '*') {
                    if (k + 1 < a[i].length()) {
                        k++;
                    }
                    j++;
                    continue;
                }
                if (a[i].charAt(k) == s.charAt(j)) {
                    tmp = tmp + a[i].charAt(k);
                    j++;
                    k++;
                    continue;
                }
                if (a[i].charAt(k) == '*') {
                    tmp = tmp + s.charAt(j);
                    j++;
                    k++;
                    continue;
                }
                if (s.charAt(j) == '*') {
                    tmp = tmp + a[i].charAt(k);
                    j++;
                    k++;
                    continue;
                }
                if (k-1 >= 0 && a[i].charAt(k-1) == '*') {
                    tmp = tmp + s.charAt(j);
                    j++;
                    continue;
                }
                if (j-1 >= 0 && s.charAt(j - 1) == '*') {
                    tmp = tmp + a[i].charAt(k);
                    k++;
                    continue;
                }
                j++;
            }
            if (a[i].charAt(k - 1) =='*') {
                while (j < s.length()) {
                    tmp = tmp + s.charAt(j);
                    j++;
                }
            }
            if (j < s.length() && s.charAt(j) != '*') {
                System.out.println("Case #" + index + ": " + "*");
                return;
            }
            if (s.charAt(j - 1) =='*') {
                while (k < a[i].length()) {
                    tmp = tmp + a[i].charAt(k);
                    k++;
                }
            }
            s = tmp;
        }
        System.out.println("Case #" + index + ": " + s);
    }
    
}
