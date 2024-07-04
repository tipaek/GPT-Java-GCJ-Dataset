import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String ans = solve(in, out);

            out.printf("Case #%d: %s\n", testNumber, ans);
        }

        private String solve(InputReader in, PrintWriter out) {
            int n = in.nextInt();

            ArrayList<Node> nodes = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                nodes.add(new Node(in.nextInt(), in.nextInt(), i));
            }

            ArrayList<Character> letters = new ArrayList<>(Collections.nCopies(n, '*'));

            int k = 2;
            ArrayList<Node> slots = new ArrayList<>(Collections.nCopies(k, null));
            Character[] slotNames = new Character[]{'C', 'J'};


            Collections.sort(nodes);

            for (int i = 0; i < n; i++) {
                int j = 0;
                Node node = nodes.get(i);
                for (; j < k; j++) {
                    Node slot = slots.get(j);
                    if (slot == null || slot.end <= node.start) {
                        slots.set(j, node);
                        break;
                    }
                }
                if (j == k) {
                    return "IMPOSSIBLE";
                }
                letters.set(node.index, slotNames[j]);
            }

            StringBuffer sb = new StringBuffer(n);

            for (int i = 0; i < n; i++) {
                sb.append(letters.get(i));
            }

            return sb.toString();
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
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
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

    static class Node implements Comparable<Node> {
        public int start;
        public int end;
        public int index;

        public Node(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int compareTo(Node o) {
            return this.start - o.start;
        }

    }
}

