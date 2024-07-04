
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            ArrayList<Node> d = new ArrayList<>();
            int G[][] = new int[n][n];
            for (int j2 = 0; j2 < n; j2++) {

                d.add(new Node(j2, in.nextInt(), in.nextInt()));
                for (int j = 0; j < j2; j++) {
                    if (isOverLap(d.get(j), d.get(j2))) {
                        G[j][j2] = 1;
                        G[j2][j] = 1;
                    }

                }

            }
            // for (int j = 0; j < G.length; j++) {
            // System.out.println(Arrays.toString(G[j]));
            // }
            System.out.println("Case #" + (i + 1) + ": " + checkBipartite(G));

        }

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

    static String checkBipartite(int G[][]) {
        int[] color = new int[G.length];
        for (int i = 0; i < G.length; i++)
            color[i] = -1;

        int pos = 0;

        String res = "IMPOSSIBLE";
        boolean isBipartite = colorGraph(G, color, pos, 1);
        if (isBipartite) {
            res = "C";
            char h = 'C';
            for (int i = 1; i < color.length; i++) {
                if (color[i] != color[i - 1]) {
                    if (h == 'C')
                        h = 'J';
                    else
                        h = 'C';
                }
                res += h;
            }
        }

        // System.out.println(Arrays.toString(color));
        return res;

    }

    public static boolean isOverLap(Node m, Node p) {
        int w1 = Math.abs(m.s - m.e);
        int w2 = Math.abs(p.s - p.e);
        int min = Math.min(m.s, p.s);
        int max = Math.max(m.e, p.e);
        int dis = Math.abs(max - min);

        if (w1 + w2 > dis)
            return true;
        return false;
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

        return "| " + idx + "   " + s + "   " + e + " " + type + " |";
    }
}