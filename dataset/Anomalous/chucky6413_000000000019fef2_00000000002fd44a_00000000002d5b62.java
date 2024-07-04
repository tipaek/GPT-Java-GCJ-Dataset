import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter writer = new PrintWriter(System.out);
    private static final StringBuilder resultBuilder = new StringBuilder();

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int targetX = scanner.nextInt();
            int targetY = scanner.nextInt();

            resultBuilder.append(String.format("Case #%d: ", caseNumber))
                         .append(findPath(targetX, targetY))
                         .append(NEW_LINE);
        }
        writer.print(resultBuilder.toString());
        writer.close();
    }

    private static final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private static final String[] directionSymbols = {"S", "N", "E", "W"};

    private static String findPath(int targetX, int targetY) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, ""));

        int stepSize = 1;
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Node currentNode = queue.poll();

                if (currentNode.x == targetX && currentNode.y == targetY) {
                    return currentNode.path;
                }

                for (int j = 0; j < 4; j++) {
                    int[] direction = directions[j];
                    int newX = currentNode.x + stepSize * direction[0];
                    int newY = currentNode.y + stepSize * direction[1];
                    String newPath = currentNode.path + directionSymbols[j];

                    if (isValidPosition(newX, newY)) {
                        queue.offer(new Node(newX, newY, newPath));
                    }
                }
            }
            stepSize *= 2;
        }

        return "IMPOSSIBLE";
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= -200 && x <= 200 && y >= -200 && y <= 200;
    }

    private static class Node {
        int x;
        int y;
        String path;

        Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}