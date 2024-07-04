import java.util.*;

public class Solution {
    private static class Node {
        Position position;
        Node previous;
        char direction;

        public Node(Position position, Node previous, char direction) {
            this.position = position;
            this.previous = previous;
            this.direction = direction;
        }
    }

    private static class Position {
        int x, y, jumpSize;

        public Position(int x, int y, int jumpSize) {
            this.x = x;
            this.y = y;
            this.jumpSize = jumpSize;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Position other = (Position) obj;
            return x == other.x && y == other.y && jumpSize == other.jumpSize;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, jumpSize);
        }
    }

    public String jump(int goalX, int goalY) {
        Set<Position> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(new Position(0, 0, 1), null, 'X'));
        visited.add(new Position(0, 0, 1));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.position.x == goalX && current.position.y == goalY) {
                return buildPath(current);
            }

            for (Node child : generateChildren(current)) {
                if (!visited.contains(child.position) && isViable(child, goalX, goalY)) {
                    queue.offer(child);
                    visited.add(child.position);
                }
            }
        }

        return "IMPOSSIBLE";
    }

    private boolean isViable(Node node, int goalX, int goalY) {
        return (node.position.x - goalX) % node.position.jumpSize == 0
                && (node.position.y - goalY) % node.position.jumpSize == 0;
    }

    private String buildPath(Node node) {
        StringBuilder path = new StringBuilder();
        while (node.previous != null) {
            path.append(node.direction);
            node = node.previous;
        }
        return path.reverse().toString();
    }

    private List<Node> generateChildren(Node current) {
        List<Node> children = new ArrayList<>();
        int jumpSize = current.position.jumpSize;
        int x = current.position.x;
        int y = current.position.y;

        children.add(new Node(new Position(x + jumpSize, y, jumpSize * 2), current, 'E'));
        children.add(new Node(new Position(x - jumpSize, y, jumpSize * 2), current, 'W'));
        children.add(new Node(new Position(x, y + jumpSize, jumpSize * 2), current, 'N'));
        children.add(new Node(new Position(x, y - jumpSize, jumpSize * 2), current, 'S'));

        return children;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(String.format("Case #%d: %s", testCase, solution.jump(x, y)));
        }
    }
}