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
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][][] matrix = new int[rows + 2][cols + 2][5];
            ArrayList<Node> queue = new ArrayList<>(rows * cols);
            long totalSum = 0;

            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    matrix[i][j][0] = scanner.nextInt();
                    matrix[i][j][1] = j - 1;
                    matrix[i][j][2] = i - 1;
                    matrix[i][j][3] = j + 1;
                    matrix[i][j][4] = i + 1;
                    queue.add(new Node(i, j));
                    totalSum += matrix[i][j][0];
                }
            }

            long result = 0;
            boolean continueProcess = true;

            while (continueProcess) {
                continueProcess = false;
                ArrayList<Node> updateList1 = new ArrayList<>();
                ArrayList<Node> updateList2 = new ArrayList<>();
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
                            continueProcess = true;
                            matrix[row][col][0] = 0;
                            updateList1.add(new Node(row, left));
                            updateList1.add(new Node(above, col));
                            updateList1.add(new Node(row, right));
                            updateList1.add(new Node(below, col));
                            updateList2.add(new Node(row, col));
                        }
                    }
                }

                for (Node node : updateList2) {
                    int row = node.row;
                    int col = node.col;
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

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}