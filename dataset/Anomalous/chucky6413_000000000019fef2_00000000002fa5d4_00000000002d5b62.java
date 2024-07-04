import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter writer = new PrintWriter(System.out);
    private static final StringBuilder resultString = new StringBuilder();

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int xCoordinate = scanner.nextInt();
            int yCoordinate = scanner.nextInt();

            resultString.append(String.format("Case #%d: ", i))
                         .append(findPath(xCoordinate, yCoordinate))
                         .append(NEW_LINE);
        }
        writer.print(resultString.toString());
        writer.close();
    }

    private static final int[][] directions = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    private static final String[] directionSymbols = {"S", "N", "E", "W"};

    private static String findPath(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, ""));

        int distance = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                Node currentNode = queue.poll();

                if (currentNode.x == x && currentNode.y == y) {
                    return currentNode.path;
                }

                for (int j = 0; j < 4; j++) {
                    int[] direction = directions[j];
                    int newX = (distance * direction[0]) + currentNode.x;
                    int newY = (distance * direction[1]) + currentNode.y;
                    String newPath = currentNode.path + directionSymbols[j];

                    if (Math.abs(newX) <= Math.abs(x) && Math.abs(newY) <= Math.abs(y)) {
                        queue.offer(new Node(newX, newY, newPath));
                    }
                }
            }
            distance *= 2;
        }

        return "IMPOSSIBLE";
    }

    private static class Node {
        int x;
        int y;
        String path;

        public Node(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}