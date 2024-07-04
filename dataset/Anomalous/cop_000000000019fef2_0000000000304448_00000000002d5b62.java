import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int i = 0; i < testCases; i++) {
                long targetX = scanner.nextLong();
                long targetY = scanner.nextLong();

                Queue<Node> queue = new LinkedList<>();
                queue.add(Node.getOrCreate(0, 0));
                int stepSize = 1;

                while (!queue.isEmpty()) {
                    if (queue.peek().path.length() > Math.abs(targetX) + Math.abs(targetY)) {
                        break;
                    }

                    int currentLevelSize = queue.size();

                    for (int j = 0; j < currentLevelSize; j++) {
                        Node currentNode = queue.poll();

                        Node westNode = currentNode.moveWest(stepSize);
                        if (westNode.isShorterPath(currentNode)) {
                            queue.add(westNode.updatePath(currentNode.path + 'W'));
                        }

                        Node eastNode = currentNode.moveEast(stepSize);
                        if (eastNode.isShorterPath(currentNode)) {
                            queue.add(eastNode.updatePath(currentNode.path + 'E'));
                        }

                        Node southNode = currentNode.moveSouth(stepSize);
                        if (southNode.isShorterPath(currentNode)) {
                            queue.add(southNode.updatePath(currentNode.path + 'S'));
                        }

                        Node northNode = currentNode.moveNorth(stepSize);
                        if (northNode.isShorterPath(currentNode)) {
                            queue.add(northNode.updatePath(currentNode.path + 'N'));
                        }
                    }

                    Node destinationNode = Node.getOrCreate(targetX, targetY);

                    if (!destinationNode.path.isEmpty()) {
                        break;
                    }

                    stepSize *= 2;
                }

                Node destinationNode = Node.getOrCreate(targetX, targetY);
                String result = destinationNode.path.isEmpty() ? "IMPOSSIBLE" : destinationNode.path;
                System.out.printf("Case #%d: %s\n", i + 1, result);
            }
        }
    }

    private static final class Node {

        private static final Map<String, Node> NODES = new HashMap<>();

        private final long x;
        private final long y;
        private String path = "";

        public static Node getOrCreate(long x, long y) {
            return NODES.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public boolean isShorterPath(Node node) {
            return path.isEmpty() || path.length() > node.path.length() + 1;
        }

        public Node updatePath(String newPath) {
            this.path = newPath;
            return this;
        }

        public Node moveEast(int steps) {
            return getOrCreate(x + steps, y);
        }

        public Node moveWest(int steps) {
            return getOrCreate(x - steps, y);
        }

        public Node moveSouth(int steps) {
            return getOrCreate(x, y - steps);
        }

        public Node moveNorth(int steps) {
            return getOrCreate(x, y + steps);
        }

        @Override
        public String toString() {
            return x + ":" + y + " - " + path;
        }
    }
}