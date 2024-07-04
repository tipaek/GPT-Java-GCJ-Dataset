import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//ROUND 1B
public class Solution {

    public static void main(String[] args) {
        solveProblem1(System.in, System.out);
    }

    public static Node root;
    public static HashMap<Integer, Node> reachables = new HashMap<>(1000);
    public static int MAXI = 10;

    public static void solveProblem1(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
        int T = s.nextInt();
        initNode();
        for (int t = 1; t <= T; t++) {
            int x = s.nextInt();
            int y = s.nextInt();
            Node r = new Node(x, y, null, 0);
            StringBuilder sol = new StringBuilder("IMPOSSIBLE");
            Node found = reachables.get(r.hashCode());
            if (found != null) {
                sol = new StringBuilder("");
                Node p = found.parent;
                while (p != null) {
                    if (p.x < found.x) {
                        sol.insert(0, "E");
                    } else if (p.x > found.x) {
                        sol.insert(0, "W");
                    } else if (p.y < found.y) {
                        sol.insert(0, "N");
                    } else if (p.y > found.y) {
                        sol.insert(0, "S");
                    } else {
                        throw new RuntimeException("Should never happen, where was it going?");
                    }
                    found = p;
                    p = p.parent;
                }
            }
            if (t != T) sol.append("\n");
            ps.print("Case #" + t + ": " + sol.toString());
        }
    }

    private static void initNode() {
        root = new Node(0, 0, null, 0);
        rec(root, 0);
    }

    private static void rec(Node d, int i) {
        if (i > MAXI) return;

        int c = (int) Math.pow(2, i);

        Node ne = new Node(d.x + c, d.y, d, i);
        Node nw = new Node(d.x - c, d.y, d, i);
        Node nn = new Node(d.x, d.y + c, d, i);
        Node ns = new Node(d.x, d.y - c, d, i);

        handleNewNode(d, i, ne);
        handleNewNode(d, i, nw);
        handleNewNode(d, i, nn);
        handleNewNode(d, i, ns);

        for (Node ad : d.adj) {
            rec(ad, i + 1);
        }
    }

    private static void handleNewNode(Node d, int i, Node ne) {
        if (!reachables.containsKey(ne.hashCode())) {
            d.adj.add(ne);
            reachables.put(ne.hashCode(), ne);
        } else {
            if (reachables.get(ne.hashCode()).i < i) {
                d.adj.add(ne);
            } else if (reachables.get(ne.hashCode()).i > i) {
                reachables.put(ne.hashCode(), ne);
                d.adj.add(ne);
            } else {
                //identici non faccio niente
            }
        }
    }

    public static void solveProblem2(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
    }

    public static void solveProblem3(InputStream is, PrintStream ps) {
        Scanner s = new Scanner(new BufferedInputStream(is));
    }

    static class Node {
        int x;
        int y;
        int i;
        Node parent;
        List<Node> adj = new ArrayList<>();

        Node(int x, int y, Node parent, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Node) {
                Node p = (Node) o;
                return p.x == x && p.y == y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(x).hashCode() * 26053 + Integer.valueOf(y).hashCode();
        }
    }
}
