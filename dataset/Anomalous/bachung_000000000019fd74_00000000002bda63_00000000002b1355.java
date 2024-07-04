import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            solve(reader, i + 1);
        }
    }

    static void solve(BufferedReader reader, int caseNum) throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());

        Node[][] nodes = new Node[R][C];
        int idx = 0;

        for (int i = 0; i < R; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < C; j++) {
                nodes[i][j] = new Node(Integer.parseInt(tokenizer.nextToken()), idx++);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i > 0) nodes[i][j].top = nodes[i - 1][j];
                if (i < R - 1) nodes[i][j].bottom = nodes[i + 1][j];
                if (j > 0) nodes[i][j].left = nodes[i][j - 1];
                if (j < C - 1) nodes[i][j].right = nodes[i][j + 1];
            }
        }

        TreeSet<Node> Q = new TreeSet<>((a, b) -> {
            int cmp = Integer.compare(a.skillDiff(), b.skillDiff());
            return (cmp != 0) ? cmp : Integer.compare(a.id, b.id);
        });

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                Q.add(nodes[i][j]);
            }
        }

        long result = 0;
        int round = 1;
        List<Node> removed = new ArrayList<>();

        while (!Q.isEmpty()) {
            while (!Q.isEmpty() && Q.first().skillDiff() < 0) {
                Node n = Q.pollFirst();
                n.removed = true;
                removed.add(n);
            }

            if (removed.isEmpty()) {
                for (Node cur : Q) {
                    result += round * cur.skill;
                }
                break;
            }

            for (Node n : removed) {
                result += round * n.skill;

                if (n.left != null) {
                    Q.remove(n.left);
                    n.left.right = n.right;
                    if (!n.left.removed) Q.add(n.left);
                }
                if (n.right != null) {
                    Q.remove(n.right);
                    n.right.left = n.left;
                    if (!n.right.removed) Q.add(n.right);
                }
                if (n.top != null) {
                    Q.remove(n.top);
                    n.top.bottom = n.bottom;
                    if (!n.top.removed) Q.add(n.top);
                }
                if (n.bottom != null) {
                    Q.remove(n.bottom);
                    n.bottom.top = n.top;
                    if (!n.bottom.removed) Q.add(n.bottom);
                }
            }

            removed.clear();
            round++;
        }

        System.out.printf("Case #%d: %d%n", caseNum, result);
    }

    static class Node {
        Node top, bottom, left, right;
        boolean removed = false;
        int id, skill;

        Node(int skill, int id) {
            this.skill = skill;
            this.id = id;
        }

        int skillDiff() {
            int diff = 0;
            if (top != null) diff += skill - top.skill;
            if (bottom != null) diff += skill - bottom.skill;
            if (left != null) diff += skill - left.skill;
            if (right != null) diff += skill - right.skill;
            return diff;
        }
    }
}