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

public class Solution {

    private static final int MAGIC_NUMBER = 32;
    private static ArrayList<Node> nodeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        long[][] triangle = new long[MAGIC_NUMBER][MAGIC_NUMBER];
        boolean[][] visited;

        // Initialize Pascal's triangle
        for (int i = 0; i < MAGIC_NUMBER; i++) {
            triangle[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= testCases; i++) {
            System.out.printf("Case #%d:%n", i);
            int targetSum = scanner.nextInt();
            nodeList.clear();
            visited = new boolean[MAGIC_NUMBER][MAGIC_NUMBER];
            findPath(triangle, visited, 0, 0, targetSum);

            for (Node node : nodeList) {
                System.out.println((node.row + 1) + " " + (node.col + 1));
            }
        }
    }

    private static boolean findPath(long[][] triangle, boolean[][] visited, int row, int col, long remainingSum) {
        if (remainingSum < 0) return false;
        if (remainingSum == 0) return true;

        int[] dRow = {-1, -1, 0, 0, 1, 1};
        int[] dCol = {-1, 0, -1, 1, 1, 0};
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < dRow.length; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];
            if (newRow >= 0 && newCol >= 0 && newRow < MAGIC_NUMBER && newCol < MAGIC_NUMBER
                    && !visited[newRow][newCol] && triangle[newRow][newCol] != 0) {
                pq.add(new Node(newRow, newCol, triangle[newRow][newCol]));
            }
        }

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            if (remainingSum - currentNode.value < 0) continue;
            nodeList.add(currentNode);
            visited[currentNode.row][currentNode.col] = true;
            if (findPath(triangle, visited, currentNode.row, currentNode.col, remainingSum - currentNode.value)) {
                return true;
            }
            nodeList.remove(nodeList.size() - 1);
            visited[currentNode.row][currentNode.col] = false;
        }

        return false;
    }
}