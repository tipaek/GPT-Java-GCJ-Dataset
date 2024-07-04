
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        main(in, System.out);
    }

    public static void main(Scanner in, PrintStream out) {
        int testCases = in.nextInt();
        for (int i = 1; i <= testCases; i++) {
            long x = in.nextLong();
            long y = in.nextLong();
            String result = bfs(x, y);
            out.printf("Case #%d: %s%n", i, result);
        }
    }

    public static String bfs(long targetX, long targetY) {
        Deque<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, new StringBuilder()));
        long totalDistance = Math.abs(targetX) + Math.abs(targetY);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == targetX && node.y == targetY) {
                return node.path.toString();
            }
            if (node.distance > totalDistance * 2) {
                return "IMPOSSIBLE";
            }
            queue.add(jumpNode(node, 'N'));
            queue.add(jumpNode(node, 'S'));
            queue.add(jumpNode(node, 'W'));
            queue.add(jumpNode(node, 'E'));
        }
        return "IMPOSSIBLE";
    }

    private static Node jumpNode(Node node, char direction) {
        long x = node.x;
        long y = node.y;
        switch (direction) {
            case 'N':
                y += node.distance;
                break;
            case 'S':
                y -= node.distance;
                break;
            case 'E':
                x += node.distance;
                break;
            case 'W':
                x -= node.distance;
        }
        long newDistance = node.distance * 2;
        StringBuilder newPath = new StringBuilder(node.path);
        newPath.append(direction);
        Node newNode = new Node(x, y, newDistance, newPath);
        return newNode;
    }

    static class Node {
        long x, y, distance;
        StringBuilder path;
        Node (long x, long y, long distance, StringBuilder path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }
    }
}
