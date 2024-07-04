import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int row, col;
    long value;

    public Node(int row, int col, long value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public int compareTo(Node other) {
        return Long.compare(this.value, other.value);
    }
}

class Solution {

    public static ArrayList<Node> nodeList = new ArrayList<>();

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int caseCount = scanner.nextInt();
        final int MAGIC_NUMBER = 32;
        long[][] triangle = new long[MAGIC_NUMBER][MAGIC_NUMBER];
        boolean[][] visited = new boolean[MAGIC_NUMBER][MAGIC_NUMBER];

        // Initialize the triangle array
        triangle[0][0] = 1;
        for (int i = 0; i < MAGIC_NUMBER; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        for (int i = 1; i <= caseCount; i++) {
            System.out.printf("Case #%d:%n", i);
            int targetSum = scanner.nextInt();
            nodeList = new ArrayList<>();
            visited = new boolean[MAGIC_NUMBER][MAGIC_NUMBER];
            findPath(triangle, visited, 1, 1, targetSum);
            for (Node node : nodeList) {
                System.out.println((node.row + 1) + " " + (node.col + 1));
            }
        }
    }

    public static ArrayList<Node> findPath(long[][] triangle, boolean[][] visited, int row, int col, long remainingSum) {
        if (remainingSum < 0) return null;

        int[] rowOffsets = { -1, -1, 0, 0, 1, 1 };
        int[] colOffsets = { -1, 0, -1, 1, 1, 0 };
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];
            if (newRow >= 0 && newCol >= 0 && newRow < triangle.length && newCol < triangle[0].length 
                && !visited[newRow][newCol] && triangle[newRow][newCol] != 0) {
                priorityQueue.add(new Node(newRow, newCol, triangle[newRow][newCol]));
            }
        }

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            if (remainingSum - currentNode.value < 0) continue;
            if (remainingSum - currentNode.value == 0) {
                nodeList.add(currentNode);
                return nodeList;
            }
            nodeList.add(currentNode);
            visited[currentNode.row][currentNode.col] = true;
            ArrayList<Node> result = findPath(triangle, visited, currentNode.row, currentNode.col, remainingSum - currentNode.value);
            if (result != null) return result;
        }

        return nodeList;
    }
}