import java.io.*;
import java.util.*;
import java.lang.*;
public class Solution {
    static class Node {
        Node prev, next, up, down;
        int r, c;
        boolean remove;
        public Node(int i, int j) { r = i; c = j; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nt = Integer.parseInt(br.readLine());
        for (int t = 1; t <= nt; ++t) {
            String[] data = br.readLine().split("\\s+");
            int row = Integer.parseInt(data[0]), col = Integer.parseInt(data[1]);
            int[][] mat = new int[row][col];
            for (int i = 0; i < row; ++i) {
                data = br.readLine().split("\\s+");
                for (int j = 0; j < col; ++j) mat[i][j] = Integer.parseInt(data[j]);
            }
            System.out.format("Case #%d: %d\n", t, solve(mat));
        }
        br.close();
    }
    private static long solve(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        long res = 0;
        List<Node> nodes = new LinkedList<Node>();
        Node[] colNodes = new Node[n];
        for (int i = 0; i < m; ++i) {
            Node prev = null;
            for (int j = 0; j < n; ++j) {
                if (0 == mat[i][j]) continue;
                Node cur = new Node(i, j);
                if (null != prev) {
                    prev.next = cur;
                    cur.prev = prev;
                }
                prev = cur;
                if (null != colNodes[j]) {
                    colNodes[j].down = cur;
                    cur.up = colNodes[j];
                }
                colNodes[j] = cur;
                nodes.add(cur);
            }
        }
        boolean done = false;
        while (!done) {
            done = true;
            for (Node node : nodes) {
                res += mat[node.r][node.c];
                int sum = 0, cnt = 0;
                if (null != node.up) {
                    sum += mat[node.up.r][node.up.c];
                    cnt++;
                }
                if (null != node.down) {
                    sum += mat[node.down.r][node.down.c];
                    cnt++;
                }
                if (null != node.prev) {
                    sum += mat[node.prev.r][node.prev.c];
                    cnt++;
                }
                if (null != node.next) {
                    sum += mat[node.next.r][node.next.c];
                    cnt++;
                }
                if (sum > mat[node.r][node.c] * cnt) {
                    node.remove = true;
                    done = false;
                }
            }
            if (!done) {
                Iterator<Node> iter = nodes.iterator();
                while (iter.hasNext()) {
                    Node node = iter.next();
                    if (!node.remove) continue;
                    if (null != node.prev) node.prev.next = node.next;
                    if (null != node.next) node.next.prev = node.prev;
                    if (null != node.up) node.up.down = node.down;
                    if (null != node.down) node.down.up = node.up;
                    iter.remove();
                }
            }
        }
        return res;
    }
}
