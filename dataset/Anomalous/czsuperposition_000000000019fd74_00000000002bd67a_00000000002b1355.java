import java.util.Scanner;

public class Solution {
    public static class Node {
        private int skill;
        private Node left, right, up, down;

        public Node(int skillLevel) {
            this.skill = skillLevel;
        }

        public double getAverage() {
            int sum = 0, count = 0;
            if (left != null) { sum += left.skill; count++; }
            if (right != null) { sum += right.skill; count++; }
            if (up != null) { sum += up.skill; count++; }
            if (down != null) { sum += down.skill; count++; }
            return count > 0 ? (double) sum / count : 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            Node[][] grid = new Node[R][C];

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    grid[r][c] = new Node(scanner.nextInt());
                }
            }

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (r > 0) grid[r][c].left = grid[r - 1][c];
                    if (r < R - 1) grid[r][c].right = grid[r + 1][c];
                    if (c > 0) grid[r][c].up = grid[r][c - 1];
                    if (c < C - 1) grid[r][c].down = grid[r][c + 1];
                }
            }

            int totalInterest = 0;
            while (true) {
                int totalSum = 0, eliminations = 0;
                int[][] toEliminate = new int[R][C];

                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        Node node = grid[r][c];
                        if (node != null) {
                            totalSum += node.skill;
                            if (node.skill < node.getAverage()) {
                                toEliminate[r][c] = 1;
                                eliminations++;
                            }
                        }
                    }
                }

                totalInterest += totalSum;
                if (eliminations == 0) break;

                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (toEliminate[r][c] == 1) {
                            Node node = grid[r][c];
                            if (node.left != null) node.left.right = node.right;
                            if (node.right != null) node.right.left = node.left;
                            if (node.up != null) node.up.down = node.down;
                            if (node.down != null) node.down.up = node.up;
                            grid[r][c] = null;
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + totalInterest);
        }
        scanner.close();
    }
}