import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            processTestCases(scanner, System.out);
        }
    }

    private static void processTestCases(Scanner scanner, PrintStream out) {
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            String result = findPathToTarget(x, y);
            out.printf("Case #%d: %s%n", i, result);
        }
    }

    private static String findPathToTarget(long targetX, long targetY) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1, new StringBuilder()));
        long maxDistance = Math.abs(targetX) + Math.abs(targetY);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.x == targetX && currentNode.y == targetY) {
                return currentNode.path.toString();
            }
            if (currentNode.distance > maxDistance * 2) {
                return "IMPOSSIBLE";
            }
            queue.offer(createNextNode(currentNode, 'N'));
            queue.offer(createNextNode(currentNode, 'S'));
            queue.offer(createNextNode(currentNode, 'E'));
            queue.offer(createNextNode(currentNode, 'W'));
        }
        return "IMPOSSIBLE";
    }

    private static Node createNextNode(Node node, char direction) {
        long newX = node.x;
        long newY = node.y;
        switch (direction) {
            case 'N': newY += node.distance; break;
            case 'S': newY -= node.distance; break;
            case 'E': newX += node.distance; break;
            case 'W': newX -= node.distance; break;
        }
        long newDistance = node.distance * 2;
        StringBuilder newPath = new StringBuilder(node.path).append(direction);
        return new Node(newX, newY, newDistance, newPath);
    }

    static class Node {
        long x, y, distance;
        StringBuilder path;

        Node(long x, long y, long distance, StringBuilder path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }
    }
}