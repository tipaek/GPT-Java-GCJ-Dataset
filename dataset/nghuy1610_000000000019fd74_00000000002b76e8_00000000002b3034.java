import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    static class TrieNode {
        char endString;
        TrieNode[] next = new TrieNode[26];
    }

    static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        String[] pattern = new String[n];
        for (int i = 0; i < n; i++) {
            pattern[i] = scanner.next();
        }

        TrieNode root = new TrieNode();
        TrieNode trav;
        for (String pat : pattern) {
            trav = root;
            int len = pat.length();
            for (int i = 1; i <= len; i++) {
                char c = pat.charAt(len - i);
                if (c == '*') {
                    continue;
                }
                if (trav.next[c - 'A'] == null) {
                    trav.next[c - 'A'] = new TrieNode();
                }
                trav = trav.next[c - 'A'];
            }
        }
        StringBuilder sb = new StringBuilder();
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TrieNode current = stack.pop();
            int count = 0;
            for (int i = 0; i < 26; i++) {
                TrieNode node = current.next[i];
                if (node != null) {
                    count++;
                    stack.push(node);
                    sb.append((char)(i + 'A'));
                }
            }
            if (count > 1) {
                return "*";
            }
        }
        return sb.reverse().toString();

    }

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner scanner = new Scanner(new BufferedReader(new FileReader("test_case.txt")));
        int nr = scanner.nextInt();
        for (int i = 0; i < nr; i++) {
            System.out.printf("Case #%d: %s\n", i+1, solve(scanner));
        }
    }
}
