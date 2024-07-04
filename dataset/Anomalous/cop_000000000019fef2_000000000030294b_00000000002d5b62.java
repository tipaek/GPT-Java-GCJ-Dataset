import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();

            for (int t = 1; t <= testCases; t++) {
                long x = scanner.nextLong();
                long y = scanner.nextLong();

                Queue<Node> queue = new LinkedList<>();
                queue.offer(Node.create(0, 0));
                int steps = 1;
                boolean found = false;

                while (!queue.isEmpty()) {
                    int size = queue.size();

                    for (int i = 0; i < size; i++) {
                        Node current = queue.poll();

                        if (current.x == x && current.y == y) {
                            System.out.printf("Case #%d: %s\n", t, current.path);
                            found = true;
                            break;
                        }

                        queue.offer(current.move(steps, 'E', steps, 0));
                        queue.offer(current.move(steps, 'W', -steps, 0));
                        queue.offer(current.move(steps, 'N', 0, steps));
                        queue.offer(current.move(steps, 'S', 0, -steps));
                    }

                    if (found) break;
                    steps++;
                }

                if (!found) {
                    System.out.printf("Case #%d: IMPOSSIBLE\n", t);
                }
            }
        }
    }

    private static class Node {
        private static final Map<String, Node> nodes = new HashMap<>();
        private final long x, y;
        private final String path;

        private Node(long x, long y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        public static Node create(long x, long y) {
            return nodes.computeIfAbsent(x + ":" + y, key -> new Node(x, y, ""));
        }

        public Node move(int steps, char direction, long dx, long dy) {
            long newX = x + dx;
            long newY = y + dy;
            String newPath = path + direction;
            Node newNode = create(newX, newY);
            if (newNode.path.isEmpty() || newNode.path.length() > newPath.length()) {
                nodes.put(newX + ":" + newY, new Node(newX, newY, newPath));
            }
            return nodes.get(newX + ":" + newY);
        }
    }
}