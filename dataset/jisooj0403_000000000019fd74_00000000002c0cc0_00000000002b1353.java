package B;

import java.util.*;

public class Solution {
    static int[][] tri = build();
    public static final int N = 1000000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int target = in.nextInt();
            List<Node> path = getPath(target);
            System.out.println("Case #" + (i + 1) + ":");
            for (Node node : path) {
                System.out.println(node);
            }
        }
        in.close();
    }

    static int[][] build() {
        int[][] tri = new int[N][N];
        for (int i = 1; i < N; i++) {
            tri[i][1] = 1;
            tri[1][i] = 1;
        }

        for (int i = 2; i < N; i++) {
            for (int j = 2; j < N; j++) {
                tri[i][j] = tri[i - 1][j] + tri[i][j - 1];
            }
        }
        return tri;
    }

    static List<Node> getPath(int target) {
        List<Node> path = new ArrayList<>();
        Node start = new Node(1, 1, 1);
        path.add(start);
        getPath(target, 1, start, path);
        return path;
    }

    private static boolean getPath(int target, int sum, Node curr, List<Node> path) {
        if (sum > target) {
            return false;
        }
        if (sum == target) {
            return true;
        }

        for (Node n : curr.getNeighbors()) {
            if (!path.contains(n)) {
                path.add(n);
                boolean found = getPath(target, sum + n.val, n, path);
                if (found) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    static class Node implements Comparable<Node> {
        int i;
        int j;
        int val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        public int compareTo(Node other) {
            return other.val - this.val;
        }

        public String toString() {
            return (this.i + this.j - 1) + " " + this.j;
        }

        // (ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1),
        // (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1)
        public List<Node> getNeighbors() {
            int[][] neighbors = { { i, j + 1 }, { i - 1, j }, { i + 1, j - 1 }, { i - 1, j + 1 }, { i + 1, j },
                    { i, j + 1 } };

            List<Node> result = new ArrayList<>();
            for (int[] neighbor : neighbors) {
                int ii = neighbor[0];
                int jj = neighbor[1];
                if (ii > 0 && ii < N && jj > 0 && jj < N) {
                    result.add(new Node(ii, jj, tri[ii][jj]));
                }
            }
            Collections.sort(result);

            return result;
        }
    }
}