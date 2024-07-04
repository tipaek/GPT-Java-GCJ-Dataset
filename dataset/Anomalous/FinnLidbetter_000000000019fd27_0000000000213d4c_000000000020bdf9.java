import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int nTests = Integer.parseInt(br.readLine());
        for (int test = 0; test < nTests; test++) {
            int n = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[n];
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                pairs[i] = new Pair(start, end);
                nodes[i] = new Node(i);
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (overlap(pairs[i], pairs[j])) {
                        nodes[i].adj.add(j);
                        nodes[j].adj.add(i);
                    }
                }
            }
            boolean possible = true;
            int[] color = new int[n];
            for (int i = 0; i < n; i++) {
                if (color[i] == 0) {
                    possible = possible && dfs(i, nodes, color);
                }
            }
            if (!possible) {
                sb.append(String.format("Case #%d: IMPOSSIBLE\n", test + 1));
            } else {
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb2.append(color[i] == 1 ? 'J' : 'C');
                }
                sb.append(String.format("Case #%d: %s\n", test + 1, sb2.toString()));
            }
        }
        System.out.print(sb);
    }

    static boolean dfs(int curr, Node[] nodes, int[] color) {
        int colored = 0;
        for (int neighbor : nodes[curr].adj) {
            colored |= color[neighbor];
        }
        if (colored == 0 || colored == 2) {
            color[curr] = 1;
        } else if (colored == 1) {
            color[curr] = 2;
        } else {
            color[curr] = 3;
            return false;
        }
        boolean possible = true;
        for (int neighbor : nodes[curr].adj) {
            if (color[neighbor] == 0) {
                possible = possible && dfs(neighbor, nodes, color);
            }
        }
        return possible;
    }

    static boolean overlap(Pair p1, Pair p2) {
        return !(p1.end <= p2.start || p1.start >= p2.end);
    }
}

class Node {
    int id;
    List<Integer> adj = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }
}

class Pair {
    int start, end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}