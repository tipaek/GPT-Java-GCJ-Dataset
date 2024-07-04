import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author masterbios
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class PatternMatching {
        final int MAX = 26;
        Node trieroot;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            trieroot = new Node();
            int n = in.nextInt();
            String s[] = new String[n];
            for (int i = 0; i < n; i++) {
                String x = in.next();
                StringBuilder sb = new StringBuilder(x);
                s[i] = sb.reverse().toString();
            }
            for (String word : s) {
                insert(word);
            }

            out.println("Case #" + testNumber + ": " + search());

        }

        public String search() {
            StringBuilder sb = new StringBuilder();
            Node cur = trieroot;
            boolean flag = true;
            if (cur.count > 1) flag = false;
            while (cur.count == 1) {
                for (int i = 0; i < 26; i++) {
                    char c = (char) ('A' + i);
                    if (cur.child[i] != null) {
                        sb.append(c);
                        cur = cur.child[i];
                        break;
                    }
                }
                if (cur.count > 1) {
                    flag = false;
                    break;
                }
                if (cur.count == 0) break;
            }
            if (flag) return sb.reverse().toString();
            return "*";
        }

        public void insert(String key) {
            Node cur = trieroot;
            int n = key.length();
            for (int i = 0; i < n; i++) {
                if (key.charAt(i) == '*') continue;
                int idx = (int) (key.charAt(i) - 'A');
//            System.out.println(key.charAt(i) + " " + idx);
                if (cur.child[idx] == null) {
                    cur.child[idx] = new Node();
                    cur.count++;
                }
                cur = cur.child[idx];
            }
            cur.isLeaf = true;
        }

        class Node {
            Node child[] = new Node[MAX];
            boolean isLeaf;
            int count;

        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

