
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int g[][] = new int[n][n];
            ArrayList<Node> d = new ArrayList<>();

            for (int j2 = 0; j2 < n; j2++) {
                Node m = new Node(j2, in.nextInt(), in.nextInt());
                d.add(m);
                checkOverLap(m, d, g);
            }
            System.out.println(isBipartite(g));
        }
    }

    public static void checkOverLap(Node m, ArrayList<Node> d, int[][] g) {
        for (int j = 0; j < g.length; j++) {
            if (d.size() > j) {
                if (d.get(j).idx != m.idx && isOverLap(m, d.get(j))) {
                    g[j][m.idx] = 1;
                    g[m.idx][j] = 1;

                }
            }
        }

    }

    public static boolean isOverLap(Node m, Node p) {

        if (m.s > p.s && m.s < p.e) {
            return true;
        }
        if (m.e > p.s && m.e < p.e) {
            return true;
        }

        if (p.s > m.s && p.s < m.e) {
            return true;
        }
        if (p.e > m.s && p.e < m.e) {
            return true;
        }

        if (m.e == p.e && m.s == p.s)
            return true;

        return false;
    }

    static boolean colorGraph(int G[][], int color[], int pos, int c) {
        if (color[pos] != -1 && color[pos] != c)
            return false;

        color[pos] = c;
        boolean ans = true;
        for (int i = 0; i < G.length; i++) {
            if (G[pos][i] == 1) {
                if (color[i] == -1)
                    ans &= colorGraph(G, color, i, 1 - c);

                if (color[i] != -1 && color[i] != 1 - c)
                    return false;
            }
            if (!ans)
                return false;
        }

        return true;
    }

    static String isBipartite(int G[][]) {
        int[] color = new int[G.length];
        for (int i = 0; i < G.length; i++)
            color[i] = -1;

        int pos = 0;

        if (!colorGraph(G, color, pos, 1))
            return "IMPOSSIBLE";

        char c = 'C';
        String res = "C";
        for (int i = 1; i < color.length; i++) {
            if (color[i - 1] != color[i]) {
                if (c == 'C')
                    c = 'J';
                else
                    c = 'C';

            }
            res += c;
        }

        return res;
    }
}

class Node implements Comparable<Node> {
    int idx = -1;
    int s = 0;
    int e = 0;
    byte type = -1;

    public Node(int idx, int s, int e) {
        this.idx = idx;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Node f) {
        return this.idx - f.idx;
    }

    @Override
    public String toString() {

        return "" + idx;
    }
}