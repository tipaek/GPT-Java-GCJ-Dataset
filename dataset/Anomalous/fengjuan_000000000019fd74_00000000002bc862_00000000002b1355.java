import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            Node[][] grid = new Node[rows][cols];
            List<Node> nodes = new ArrayList<>();
            long totalSum = 0;
            long result = 0;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int value = scanner.nextInt();
                    totalSum += value;
                    Node node = new Node(row, col, value);
                    grid[row][col] = node;
                    nodes.add(node);
                }
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (row > 0) grid[row][col].up = grid[row - 1][col];
                    if (col > 0) grid[row][col].left = grid[row][col - 1];
                    if (col < cols - 1) grid[row][col].right = grid[row][col + 1];
                    if (row < rows - 1) grid[row][col].down = grid[row + 1][col];
                }
            }

            while (!nodes.isEmpty()) {
                result += totalSum;
                List<Node> toEliminate = new ArrayList<>();

                for (Node node : nodes) {
                    if (grid[node.row][node.col] != null) {
                        double neighborCount = 0;
                        long neighborSum = 0;

                        if (node.up != null) {
                            neighborCount++;
                            neighborSum += node.up.value;
                        }
                        if (node.left != null) {
                            neighborCount++;
                            neighborSum += node.left.value;
                        }
                        if (node.right != null) {
                            neighborCount++;
                            neighborSum += node.right.value;
                        }
                        if (node.down != null) {
                            neighborCount++;
                            neighborSum += node.down.value;
                        }

                        if (neighborSum / neighborCount > node.value) {
                            toEliminate.add(node);
                            totalSum -= node.value;
                            grid[node.row][node.col] = null;
                        }
                    }
                }

                nodes.clear();
                for (Node node : toEliminate) {
                    if (node.up != null) {
                        nodes.add(node.up);
                        node.up.down = node.down;
                    }
                    if (node.left != null) {
                        nodes.add(node.left);
                        node.left.right = node.right;
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                        node.right.left = node.left;
                    }
                    if (node.down != null) {
                        nodes.add(node.down);
                        node.down.up = node.up;
                    }
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    private static class Node {
        private Node up, left, right, down;
        private int row, col, value;

        private Node(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}