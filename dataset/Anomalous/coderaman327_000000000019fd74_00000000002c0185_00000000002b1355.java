import java.util.ArrayList;
import java.util.Scanner;

class Node {
    int row;
    int col;

    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][][] matrix = new int[rows + 2][cols + 2][5];
            ArrayList<Node> queue = new ArrayList<>(rows * cols);
            long totalSum = 0;

            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    matrix[i][j][0] = sc.nextInt();
                    matrix[i][j][1] = j - 1;
                    matrix[i][j][2] = i - 1;
                    matrix[i][j][3] = j + 1;
                    matrix[i][j][4] = i + 1;
                    queue.add(new Node(i, j));
                    totalSum += matrix[i][j][0];
                }
            }

            long result = 0;
            boolean hasChanges = true;

            while (hasChanges) {
                hasChanges = false;
                ArrayList<Node> newQueue = new ArrayList<>();
                ArrayList<Node> eliminationQueue = new ArrayList<>();
                int queueSize = queue.size();
                result += totalSum;

                for (int i = 0; i < queueSize; i++) {
                    Node currentNode = queue.get(i);
                    int row = currentNode.row;
                    int col = currentNode.col;

                    if (matrix[row][col][0] != 0) {
                        double neighborSum = 0;
                        int neighborCount = 0;

                        int left = matrix[row][col][1];
                        int above = matrix[row][col][2];
                        int right = matrix[row][col][3];
                        int below = matrix[row][col][4];

                        if (left != 0) {
                            neighborCount++;
                            neighborSum += matrix[row][left][0];
                        }
                        if (above != 0) {
                            neighborCount++;
                            neighborSum += matrix[above][col][0];
                        }
                        if (right != cols + 1) {
                            neighborCount++;
                            neighborSum += matrix[row][right][0];
                        }
                        if (below != rows + 1) {
                            neighborCount++;
                            neighborSum += matrix[below][col][0];
                        }

                        if (matrix[row][col][0] < (neighborSum / neighborCount)) {
                            totalSum -= matrix[row][col][0];
                            hasChanges = true;
                            matrix[row][col][0] = 0;
                            newQueue.add(new Node(row, left));
                            newQueue.add(new Node(above, col));
                            newQueue.add(new Node(row, right));
                            newQueue.add(new Node(below, col));
                            eliminationQueue.add(new Node(row, col));
                        }
                    }
                }

                queue = newQueue;
                int eliminationQueueSize = eliminationQueue.size();
                for (int i = 0; i < eliminationQueueSize; i++) {
                    Node currentNode = eliminationQueue.get(i);
                    int row = currentNode.row;
                    int col = currentNode.col;

                    int left = matrix[row][col][1];
                    int above = matrix[row][col][2];
                    int right = matrix[row][col][3];
                    int below = matrix[row][col][4];

                    matrix[row][left][3] = right;
                    matrix[above][col][4] = below;
                    matrix[row][right][1] = left;
                    matrix[below][col][2] = above;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }
    }
}