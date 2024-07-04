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

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    grid[j][k] = new Node(scanner.nextInt());
                }
            }

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    if (j > 0) grid[j][k].up = grid[j - 1][k];
                    if (j < R - 1) grid[j][k].down = grid[j + 1][k];
                    if (k > 0) grid[j][k].left = grid[j][k - 1];
                    if (k < C - 1) grid[j][k].right = grid[j][k + 1];
                }
            }

            long totalInterest = 0;

            while (true) {
                long roundSum = 0;
                int eliminations = 0;
                int[][] toEliminate = new int[R][C];

                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        Node currentNode = grid[j][k];
                        if (currentNode != null) {
                            roundSum += currentNode.skill;
                            if (currentNode.skill < currentNode.getAverage()) {
                                toEliminate[j][k] = 1;
                                eliminations++;
                            }
                        }
                    }
                }

                totalInterest += roundSum;
                if (eliminations == 0) break;

                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (toEliminate[j][k] == 1) {
                            Node currentNode = grid[j][k];
                            if (currentNode.left != null) currentNode.left.right = currentNode.right;
                            if (currentNode.right != null) currentNode.right.left = currentNode.left;
                            if (currentNode.up != null) currentNode.up.down = currentNode.down;
                            if (currentNode.down != null) currentNode.down.up = currentNode.up;
                            grid[j][k] = null;
                        }
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + totalInterest);
        }
    }
}