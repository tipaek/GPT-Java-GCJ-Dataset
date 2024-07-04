import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Van Hanh Pham <skyvn97> <vanhanh.pham@gmail.com>
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
        private static final String noAnswer = "IMPOSSIBLE";

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int numChannel = in.nextInt();
            Pair<Integer, Integer>[] channels = new Pair[numChannel];
            for (int i = 0; i < numChannel; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                channels[i] = new Pair<Integer, Integer>(x, y);
            }

            TwoSat twoSat = new TwoSat(numChannel);
            for (int i = 0; i < numChannel; i++)
                for (int j = i + 1; j < numChannel; j++)
                    if (overlap(channels[i], channels[j])) twoSat.addDifferentCondition(i, j);

            boolean[] solution = twoSat.findSolution();
            if (solution == null) {
                out.printf("Case #%d: %s\n", testNumber, noAnswer);
                return;
            }

            out.printf("Case #%d: ", testNumber);
            for (int i = 0; i < numChannel; i++) out.printf("%c", solution[i] ? 'C' : 'J');
            out.println();
        }

        private static boolean overlap(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
            return Math.max(a.first, b.first) < Math.min(a.second, b.second);
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String nextString() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String next() {
            return nextString();
        }

        public int nextInt() {
            return Integer.parseInt(nextString());
        }

    }

    static class Pair<First, Second> {
        public First first;
        public Second second;

        public Pair() {
        }

        public Pair(First first, Second second) {
            this.first = first;
            this.second = second;
        }

        public Pair(Map.Entry<First, Second> entry) {
            first = entry.getKey();
            second = entry.getValue();
        }

        public String toString() {
            return "{ " + first.toString() + " " + second.toString() + " }";
        }

    }

    static class TwoSat {
        public static final TwoSat.VariableType POSITIVE = new TwoSat.VariableType(true);
        public static final TwoSat.VariableType NEGATIVE = new TwoSat.VariableType(false);
        private int n;
        private int cnt;
        private int numComp;
        private TwoSat.Node[] nodes;
        private Stack<TwoSat.Node> stack;
        private TwoSat.Component[] components;

        public TwoSat(int n) {
            this.n = n;
            cnt = numComp = 0;
            nodes = new TwoSat.Node[2 * n];
            for (int i = 0; i < 2 * n; i++) nodes[i] = new TwoSat.Node();
            stack = new Stack<TwoSat.Node>();
        }

        private TwoSat.Node negativeNode(int x) {
            return nodes[(x + n) % (2 * n)];
        }

        public void addCondition(int var1, TwoSat.VariableType type1, int var2, TwoSat.VariableType type2) {
            int u = type1 == POSITIVE ? var1 : (var1 + n) % (2 * n);
            int v = type2 == POSITIVE ? var2 : (var2 + n) % (2 * n);

            negativeNode(u).adj.add(nodes[v]);
            negativeNode(v).adj.add(nodes[u]);
        }

        public void addDifferentCondition(int x, int y) {
            addCondition(x, POSITIVE, y, POSITIVE);
            addCondition(x, NEGATIVE, y, NEGATIVE);
        }

        private void dfs(TwoSat.Node node) {
            node.low = node.num = ++cnt;
            stack.push(node);
            for (TwoSat.Node next : node.adj)
                if (next.compID == -1) {
                    if (next.num == 0) {
                        dfs(next);
                        node.low = Math.min(node.low, next.low);
                    } else node.low = Math.min(node.low, next.num);
                }

            if (node.low == node.num) {
                while (true) {
                    TwoSat.Node top = stack.peek();
                    stack.pop();
                    top.compID = numComp;
                    if (top == node) break;
                }
                numComp++;
            }
        }

        public boolean haveSolution() {
            for (int i = 0; i < 2 * n; i++) if (nodes[i].num == 0) dfs(nodes[i]);
            for (int i = 0; i < n; i++)
                if (nodes[i].compID == negativeNode(i).compID) return false;
            return true;
        }

        private void dfsTopo(TwoSat.Component component) {
            for (TwoSat.Component comp : component.adj)
                if (comp.topo == 0) dfsTopo(comp);
            component.topo = cnt--;
        }

        private void assignValue(TwoSat.Component component, int value) {
            if (component.value >= 0) {
                if (component.value != value) throw new RuntimeException("Conflict assigned value");
                return;
            }

            component.value = value;
            for (TwoSat.Component comp : component.negativeComp) assignValue(comp, 1 - value);

            if (value == 1) {
                for (TwoSat.Component comp : component.adj) assignValue(comp, value);
            }

        }

        public boolean[] findSolution() {
            if (!haveSolution()) return null;

            components = new TwoSat.Component[numComp];
            for (int i = 0; i < numComp; i++) components[i] = new TwoSat.Component();
            for (int i = 0; i < 2 * n; i++) {
                TwoSat.Component cur = components[nodes[i].compID];
                cur.negativeComp.add(components[negativeNode(i).compID]);
                for (TwoSat.Node node : nodes[i].adj)
                    if (components[node.compID] != cur)
                        cur.adj.add(components[node.compID]);
            }

            cnt = 2 * n;
            for (int i = 0; i < numComp; i++) if (components[i].topo == 0) dfsTopo(components[i]);

            ArrayList<TwoSat.Component> comps = new ArrayList<TwoSat.Component>();
            for (int i = 0; i < numComp; i++) comps.add(components[i]);
            Comparator<TwoSat.Component> topoCompare = new Comparator<TwoSat.Component>() {
                public int compare(TwoSat.Component c1, TwoSat.Component c2) {
                    return c1.topo - c2.topo;
                }
            };
            Collections.sort(comps, topoCompare);

            for (int i = 0; i < numComp; i++) {
                TwoSat.Component cur = comps.get(i);
                if (cur.value >= 0) continue;
                assignValue(cur, 0);
            }

            boolean[] res = new boolean[n];
            for (int i = 0; i < n; i++) res[i] = components[nodes[i].compID].value == 1;
            return res;
        }

        private static class VariableType {
            boolean info;

            private VariableType(boolean info) {
                this.info = info;
            }

        }

        private static class Node {
            public int low;
            public int num;
            public int compID;
            public ArrayList<TwoSat.Node> adj;

            public Node() {
                low = num = 0;
                compID = -1;
                adj = new ArrayList<TwoSat.Node>();
            }

        }

        private static class Component {
            public int topo;
            public int value;
            public ArrayList<TwoSat.Component> adj;
            public ArrayList<TwoSat.Component> negativeComp;

            public Component() {
                topo = 0;
                value = -1;
                adj = new ArrayList<TwoSat.Component>();
                negativeComp = new ArrayList<TwoSat.Component>();
            }

        }

    }
}

