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
            int totalCases = scanner.nextInt();

            for (int caseNumber = 1; caseNumber <= totalCases; caseNumber++) {
                long targetX = scanner.nextLong();
                long targetY = scanner.nextLong();

                String result = findShortestPath(targetX, targetY);
                System.out.format("Case #%d: %s\n", caseNumber, result);
            }
        }
    }

    private static String findShortestPath(long targetX, long targetY) {
        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(Node.getOrCreate(0, 0));
        int steps = 1;
        int iteration = 0;

        while (iteration < (Math.abs(targetX) + Math.abs(targetY)) * 2 && !nodesQueue.isEmpty()) {
            int currentQueueSize = nodesQueue.size();

            for (int i = 0; i < currentQueueSize; i++) {
                Node currentNode = nodesQueue.poll();

                addNodeIfShorter(nodesQueue, currentNode.west(steps), currentNode, 'W');
                addNodeIfShorter(nodesQueue, currentNode.east(steps), currentNode, 'E');
                addNodeIfShorter(nodesQueue, currentNode.south(steps), currentNode, 'S');
                addNodeIfShorter(nodesQueue, currentNode.north(steps), currentNode, 'N');
            }

            Node targetNode = Node.getOrCreate(targetX, targetY);
            if (!targetNode.path.isEmpty()) {
                return targetNode.path;
            }

            steps *= 2;
            iteration++;
        }

        Node targetNode = Node.getOrCreate(targetX, targetY);
        return targetNode.path.isEmpty() ? "IMPOSSIBLE" : targetNode.path;
    }

    private static void addNodeIfShorter(Queue<Node> queue, Node newNode, Node currentNode, char direction) {
        if (newNode.isShorter(currentNode)) {
            queue.add(newNode.withPath(currentNode.path + direction));
        }
    }

    private static final class Node {
        private static final Map<String, Node> NODES = new HashMap<>();
        private final long x;
        private final long y;
        private String path = "";

        private Node(long x, long y) {
            this.x = x;
            this.y = y;
        }

        public static Node getOrCreate(long x, long y) {
            return NODES.computeIfAbsent(x + ":" + y, key -> new Node(x, y));
        }

        public boolean isShorter(Node node) {
            return path.isEmpty() || path.length() > node.path.length() + 1;
        }

        public Node withPath(String path) {
            this.path = path;
            return this;
        }

        public Node east(int steps) {
            return getOrCreate(x + steps, y);
        }

        public Node west(int steps) {
            return getOrCreate(x - steps, y);
        }

        public Node south(int steps) {
            return getOrCreate(x, y - steps);
        }

        public Node north(int steps) {
            return getOrCreate(x, y + steps);
        }

        @Override
        public String toString() {
            return x + ":" + y + " - " + path;
        }
    }
}